package APIs;

import Menu.*;
import Menu.Ingredient.Allergen;
import Ordering.MenuManager;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
/**
 * This is a list of public mutator and accessor methods that can be used to
 * change the state of the menu.
 * It's meant for inside use only, not public access.
 */
public class ClosedAPI {

  // region Modify Ingredient
  public ClosedAPI setIngredientInStock(Ingredient ingredient) {
    ingredient.isInStock = true;
    recalculateAllStock();
    return this;
  }

  public ClosedAPI setIngredientOutOfStock(Ingredient ingredient) {
    ingredient.isInStock = false;
    recalculateAllStock();
    return this;
  }

  public ClosedAPI setIngredientCost(Ingredient ingredient, double cost) {
    ingredient.cost = cost;
    recalculateAllPrices();
    return this;
  }

  public ClosedAPI setIngredientCalories(Ingredient ingredient, double calories) {
    ingredient.calories = calories;
    recalculateAllCalories();
    return this;
  }

  public ClosedAPI changeIngredientName(Ingredient ingredient, String newName) {
    ingredient.name = newName;
    return this;
  }

  public ClosedAPI addIngredientAllergen(Ingredient ingredient, Allergen allergen) {
    ingredient.allergens.add(allergen);
    recalculateAllAllergens();
    return this;
  }
  // endregion

  // region Modify Dish
  public ClosedAPI changeDishName(Dish dish, String newName) {
    dish.name = newName;
    return this;
  }

  public ClosedAPI addDishIngredient(Dish dish, Ingredient ingredient) {
    dish.addIngredient(ingredient);
    recalculateAllAllergens();
    recalculateAllPrices();
    recalculateAllCalories();
    return this;
  }
  // endregion

  // region Modify Menu Item
  public ClosedAPI changeMenuItemName(MenuItem menuItem, String newName) {
    menuItem.name = newName;
    return this;
  }

  public ClosedAPI changeMenuItemCategory(MenuItem menuItem, MenuItem.MenuCategory category) {
    menuItem.category = category;
    return this;
  }

  public ClosedAPI changeMenuItemDescription(MenuItem menuItem, String newDescription) {
    menuItem.description = newDescription;
    return this;
  }

  public ClosedAPI changeMenuItemAdditionalPrice(MenuItem menuItem, double addPrice) {
    menuItem.setAdditionalPrice(addPrice);
    return this;
  }

  public ClosedAPI addMenuItemDish(MenuItem menuItem, Dish dish) {
    menuItem.addDish(dish);
    recalculateAllAllergens();
    recalculateAllCalories();
    recalculateAllPrices();
    return this;
  }
  // endregion

  // region Modify Menu
  public ClosedAPI changeMenuDishOfTheDay(Menu menu, MenuItem menuItem) {
    menu.dishOfTheDay = menuItem;
    return this;
  }

  public ClosedAPI addMenuItemToMenu(Menu menu, MenuItem menuItem) {
    menu.addMenuItem(menuItem);
    return this;
  }

  public ClosedAPI addMenuItemFromMenu(Menu menu, MenuItem menuItem) {
    menu.removeMenuItem(menuItem);
    return this;
  }

  public ClosedAPI addDiscountToMenu(Menu menu, Discount discount) {
    menu.addDiscount(discount);
    return this;
  }

  public ClosedAPI addDiscountFromMenu(Menu menu, Discount discount) {
    menu.removeDiscount(discount);
    return this;
  }
  // endregion

  // region add elements
  public ClosedAPI addIngredient(Ingredient ingredient) {
    MenuManager.ingredients.add(ingredient);
    return this;
  }

  public ClosedAPI removeIngredient(Ingredient ingredient) {
    MenuManager.ingredients.remove(ingredient);
    return this;
  }

  public ClosedAPI addDish(Dish dish) {
    MenuManager.dishes.add(dish);
    return this;
  }

  public ClosedAPI removeDish(Dish dish) {
    MenuManager.dishes.remove(dish);
    return this;
  }

  public ClosedAPI addMenuItem(Menu menu, MenuItem menuItem) {
    menu.addMenuItem(menuItem);
    return this;
  }

  public ClosedAPI removeMenuItem(Menu menu, MenuItem menuItem) {
    menu.removeMenuItem(menuItem);
    return this;
  }

  public ClosedAPI addDiscount(Menu menu, Discount discount) {
    menu.addDiscount(discount);
    return this;
  }

  public ClosedAPI removeDiscount(Menu menu, Discount discount) {
    menu.removeDiscount(discount);
    return this;
  }

  public ClosedAPI addMenu(Menu menu) {
    MenuManager.addMenu(menu);
    return this;
  }

  public ClosedAPI removeMenu(Menu menu) {
    MenuManager.menus.remove(menu);
    return this;
  }
  // endregion

  // region Helper methods
  private void recalculateAllPrices() {
    for (MenuItem menuItem : MenuManager.menuItems) {
      menuItem.recalculatePrice();
    }
  }

  private void recalculateAllAllergens() {
    for (MenuItem menuItem : MenuManager.menuItems) {
      menuItem.recalculateAllergens();
    }
  }

  private void recalculateAllCalories() {
    for (MenuItem menuItem : MenuManager.menuItems) {
      menuItem.recalculateCalories();
    }
  }

  private void recalculateAllStock() {
    for (MenuItem menuItem : MenuManager.menuItems) {
      menuItem.recalculateIsInStock();
    }
  }
  // endregion
}
