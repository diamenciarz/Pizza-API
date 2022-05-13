package ExampleInstances;

import Delivering.Deliverer;
import Delivering.DeliveryDeployer;
import Menu.*;
import Menu.DiscountConditions.*;
import Menu.DiscountOutcomes.*;
import Menu.Ingredient.Allergen;
import Menu.MenuItem.MenuCategory;
import Ordering.MenuManager;
import Ordering.OrdererAPI;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class Examples {

  public static void main(String[] args) {
    // Defining ingredients
    Ingredient ingredientOlives = new Ingredient("Olives", 1.2);
    Ingredient ingredientTomatoes = new Ingredient("Tomatos", 1.4);
    Ingredient ingredientOnions = new Ingredient("Onions", 3.7).addAllergen(Allergen.ONION);
    Ingredient ingredientPasta = new Ingredient("Pasta", 0.5).addAllergen(Allergen.CORIANDER);
    Ingredient ingredientCoke = new Ingredient("Coke", 50).addAllergen(Allergen.DEATH);

    // Defining dishes which are a combination of ingredient sets
    Dish pastaWithOlives = new Dish("Pasta With Olives")
        .addIngredient(ingredientPasta).addIngredient(ingredientOlives);
    Dish pastaWithTomatoes = new Dish("Pasta With Olives")
        .addIngredient(ingredientPasta).addIngredient(ingredientTomatoes).addIngredient(ingredientOnions);
    Dish coke = new Dish("Coke").addIngredient(ingredientCoke);

    // Defining menu items which can be ordered from the menu
    MenuItem mainDishPasta = new MenuItem("Main Dish Pasta", MenuCategory.MAIN_DISH)
        .addDish(pastaWithOlives).addDish(coke).setAdditionalPrice(5);
    MenuItem sideDishPasta = new MenuItem("Side Dish Pasta", MenuCategory.SIDE_DISH).addDish(pastaWithTomatoes);

    // Defining a menu
    Menu summerMenu = new Menu().addMenuItem(mainDishPasta).addMenuItem(sideDishPasta);

    // Adding a discount which is combined of a set of conditions and outcomes
    IDiscountCondition condCodeLOL = new CouponCode("Lol");
    IDiscountCondition cond50Bucks = new TotalPrice(50);
    IDiscountOutcome outcome50Percent = new PercentageReduction(50);
    Discount discountHalfPrice = new Discount()
        .addCondition(condCodeLOL).addCondition(cond50Bucks).addOutcome(outcome50Percent);

    // Adding the discount to summerMenu
    summerMenu.addDiscount(discountHalfPrice);
    MenuManager.addMenu(summerMenu);

    //Create a deliverer who can deliver orders
    DeliveryDeployer.addAvailableDeliverer(new Deliverer(3));

    // Let's say that a client ordered something through the UberEats app
    OrdererAPI appOrderer = new OrdererAPI(summerMenu);

    // They add 2 items to their order
    appOrderer.addItemToOrder(summerMenu.getAvailableMenuItems().get(0));
    appOrderer.addItemToOrder(summerMenu.getAvailableMenuItems().get(1));
    // And finalize the order
    appOrderer.finalizeOrder();
    // If they successfully finalize the payment, the order will be added to the
    // OrderQueue
  }
}
