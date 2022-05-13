package Ordering;

import Menu.*;

import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */

/**
 * It stores a list of menus that can be changed over time. Only one menu is
 * active at a time. That is the
 */
public class MenuManager {
  public static ArrayList<Menu> menus = new ArrayList<>();
  public static ArrayList<MenuItem> menuItems = new ArrayList<>();
  public static ArrayList<Dish> dishes = new ArrayList<>();
  public static ArrayList<Ingredient> ingredients = new ArrayList<>();
  public static ArrayList<Discount> discounts = new ArrayList<>();
  /**
   * the menu that is currently available
   */
  static Menu currentMenu;

  // region Accessor methods
  public static Menu getCurrentMenu() {
    return currentMenu;
  }

  // endregion

  // region Mutator methods
  public static void setActiveMenuTo(Menu newMenu) {
    currentMenu = newMenu;
  }

  public static void addMenu(Menu menu) {
    if (!menus.contains(menu)) {
      menus.add(menu);
    }
    for (MenuItem menuItem : menu.menuItems) {
      addMenuItem(menuItem);
    }
  }

  public static void addMenuItem(MenuItem menuItem) {
    if (!menuItems.contains(menuItem)) {
      menuItems.add(menuItem);
    }
    for (Dish dish : menuItem.getDishes()) {
      addDish(dish);
    }
  }

  public static void addDish(Dish dish) {
    if (!dishes.contains(dish)) {
      dishes.add(dish);
    }
    for (Ingredient ingredient : dish.getIngredients()) {
      ingredients.add(ingredient);
    }
  }
  // endregion
}
