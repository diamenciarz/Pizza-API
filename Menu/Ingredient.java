package Menu;

import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class Ingredient {

  public Ingredient(String name, double cost) {
    this.name = name;
    this.cost = cost;
  }

  public double cost;
  public double calories;
  public boolean isInStock;
  public String name;
  public ArrayList<Allergen> allergens = new ArrayList<>();

  public Ingredient addAllergen(Allergen allergen){
    allergens.add(allergen);
    return this;
  }

  public static enum Allergen {
    NUTS,
    CORIANDER,
    LACTOSE,
    ONION,
    DEATH
  }
}
