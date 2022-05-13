package Menu;

import java.util.ArrayList;

import Menu.Ingredient.Allergen;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class MenuItem {
  public MenuItem(String name, MenuCategory menuCategory) {
    this.name = name;
    this.category = menuCategory;
    recalculatePrice();
    recalculateAllergens();
  }

  public MenuItem(String name, MenuCategory menuCategory, ArrayList<Dish> dishes) {
    this.name = name;
    this.category = menuCategory;
    this.dishes.addAll(dishes);
    recalculatePrice();
    recalculateAllergens();
  }

  /**
   * This an simplify menu searching for clients. This could be a filter in the
   * ordering app
   */
  public static enum MenuCategory implements Cloneable {
    DRINK,
    MAIN_DISH,
    DESSERT,
    SALAD,
    SOUP,
    SAUCE,
    SIDE_DISH,
  }

  public MenuCategory category;
  public String name;
  public String description;

  private ArrayList<Ingredient.Allergen> allergens = new ArrayList<>();
  private ArrayList<Dish> dishes = new ArrayList<>();
  public boolean isInStock;

  private double price;
  private double additionalPrice;
  private double calories;

  // region Mutator methods
  public MenuItem addDish(Dish dish) {
    dishes.add(dish);
    recalculatePrice();
    addNewAllergens(dish);
    return this;
  }

  public MenuItem setAdditionalPrice(double newPrice) {
    additionalPrice = newPrice;
    recalculatePrice();
    return this;
  }

  public boolean recalculateIsInStock() {
    for (Dish dish : dishes) {
      if (!dish.recalculateIsInStock()) {
        isInStock = false;
      }
    }
    isInStock = true;
    return isInStock;
  }

  /**
   * Iterates through all dishes and their ingredients to calculate the new price
   * for this MenuItem
   */
  public void recalculatePrice() {
    price = 0;
    for (Dish dish : dishes) {
      for (Ingredient ingredient : dish.getIngredients()) {
        price += ingredient.cost;
      }
    }
    price += additionalPrice;
  }

  public void recalculateCalories() {
    calories = 0;
    for (Dish dish : dishes) {
      calories += dish.getCalories();
    }
  }

  /**
   * Iterates through all dishes and their Allergens to create a list of Allergens
   * for this MenuItem
   */
  public void recalculateAllergens() {
    allergens.clear();
    for (Dish dish : dishes) {
      addNewAllergens(dish);
    }
  }
  // endregion

  // region helper methods
  private void addNewAllergens(Dish dish) {
    for (Ingredient.Allergen allergen : dish.getAllergens()) {
      if (!allergens.contains(allergen)) {
        allergens.add(allergen);
      }
    }
  }
  // endregion

  // region Accessor methods
  /**
   *
   * @return a list of all allergens of each dish and its ingredients
   */
  public ArrayList<Ingredient.Allergen> getAllergens() {
    return allergens;
  }

  public double getCalories() {
    return calories;
  }

  /**
   * It is calculated once from the {@code prices} of {@code ingredients} plus the
   * {@code additionalPrice} so that the restaurant can apply some margin
   */
  public double getPrice() {
    return price;
  }

  public ArrayList<Dish> getDishes() {
    return dishes;
  }

  @Override
  public MenuItem clone() {
    ArrayList<Dish> clonedDishes = (ArrayList<Dish>) dishes.clone();
    MenuItem copy = new MenuItem(name, category, clonedDishes);
    copy.additionalPrice = additionalPrice;
    copy.description = description;
    copy.price = price;
    copy.allergens = (ArrayList<Allergen>) allergens.clone();

    return copy;
  }
  // endregion
}
