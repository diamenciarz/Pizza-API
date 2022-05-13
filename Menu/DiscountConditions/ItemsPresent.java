package Menu.DiscountConditions;

import Menu.MenuItem;
import Ordering.*;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class ItemsPresent implements IDiscountCondition {

  public ItemsPresent(ArrayList<MenuItem> itemList) {
    this.itemList = itemList;
  }

  public ArrayList<MenuItem> itemList = new ArrayList<>();

  /**
   * Checks whether the order contains all of the items from "itemList"
   */
  @Override
  public boolean discountApplies(Order order) {
    for (MenuItem menuItem : itemList) {
      if (!order.orderedItems.contains(menuItem)) {
        return false;
      }
    }
    return true;
  }
}
