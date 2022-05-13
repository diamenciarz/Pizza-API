package Menu;

import java.util.ArrayList;

import Menu.Ingredient.Allergen;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class Dish implements Cloneable {

  public Dish(String name) {
    this.name = name;
  }

  public Dish(String name, ArrayList<Ingredient> ingredients) {
    this.name = name;
    this.ingredients = ingredients;
    recalculateAllergens();
  }

  public String name;
  public boolean isInStock;
  
  private ArrayList<Ingredient> ingredients = new ArrayList<>();
  private ArrayList<Allergen> allergens = new ArrayList<>();
  private double calories;

  // region Mutator methods
  public Dish addIngredient(Ingredient ingredient) {
    ingredients.add(ingredient);
    addNewAllergens(ingredient);
    return this;
  }

  public boolean recalculateIsInStock() {
    for (Ingredient ingredient : ingredients) {
      if (ingredient.isInStock == false) {
        isInStock = false;
      }
    }
    isInStock = true;
    return isInStock;
  }

  public void recalculateAllergens() {
    allergens.clear();

    for (Ingredient ingredient : ingredients) {
      addNewAllergens(ingredient);
    }
  }

  public void recalculateCalories(){
    calories =0;
    for (Ingredient ingredient : ingredients) {
      calories += ingredient.calories;
    }
  }
  // endregion

  //region Helper methods
  private void addNewAllergens(Ingredient ingredient) {
    for (Allergen allergen : ingredient.allergens) {
      if (!allergens.contains(allergen)) {
        allergens.add(allergen);
      }
    }
  }
  // endregion

  // region Accessor methods
  public ArrayList<Allergen> getAllergens() {
    return allergens;
  }

  public ArrayList<Ingredient> getIngredients() {
    return ingredients;
  }

  public double getCalories(){
    return calories;
  }

  @Override
  public Dish clone() {
    Dish copy = new Dish(name, ingredients);
    return copy;
  }
  // endregion
}
