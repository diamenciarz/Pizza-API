package Menu;

import java.util.ArrayList;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class Menu implements Cloneable {
  public ArrayList<MenuItem> menuItems = new ArrayList<>();
  public ArrayList<Discount> activeDiscounts = new ArrayList<>();

  public MenuItem dishOfTheDay;

  // region Mutator methods
  public Menu addMenuItem(MenuItem menuItem) {
    menuItems.add(menuItem);
    return this;
  }

  public Menu removeMenuItem(MenuItem menuItem) {
    menuItems.remove(menuItem);
    return this;
  }

  public Menu addDiscount(Discount discount) {
    activeDiscounts.add(discount);
    return this;
  }

  public Menu removeDiscount(Discount discount) {
    activeDiscounts.remove(discount);
    return this;
  }
  // endregion

  // region Accessor methods
  public boolean menuContainsItem(MenuItem menuItem) {
    if (menuItems.contains(menuItem)) {
      return true;
    }
    return false;
  }

  /**
   * @return a list of all allergens of each dish and its ingredients
   */
  public ArrayList<Discount> getActiveDiscounts() {
    return (ArrayList<Discount>) activeDiscounts.clone();
  }

  /**
   * Only returns those MenuItems which have all required ingredients currently in
   * stock
   * 
   * @return
   */
  public ArrayList<MenuItem> getAvailableMenuItems() {
    return getItemsInStock();
  }

  private ArrayList<MenuItem> getItemsInStock() {
    ArrayList<MenuItem> copy = new ArrayList<>();
    for (MenuItem menuItem : menuItems) {
      if (menuItem.isInStock) {
        copy.add(menuItem);
      }
    }
    return copy;
  }

  /**
   * It is often needed to save a copy of the menu.
   * For example, when an order was started before the menu was changed. The order
   * in progress should not be affected by changes in menu
   * 
   * @return
   */
  @Override
  public Menu clone() {
    Menu copy = new Menu();
    copy.activeDiscounts = (ArrayList<Discount>) activeDiscounts.clone();
    copy.menuItems = (ArrayList<MenuItem>) menuItems.clone();
    copy.dishOfTheDay = dishOfTheDay.clone();

    return copy;
  }
  // endregion
}
