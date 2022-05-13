package Menu.DiscountOutcomes;

import Menu.MenuItem;
import Ordering.*;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class FreeItem implements IDiscountOutcome {

  public FreeItem(ArrayList<MenuItem> itemsToAdd) {
    this.itemsToAdd = itemsToAdd;
  }

  ArrayList<MenuItem> itemsToAdd = new ArrayList<>();

  /**
   * Add itemsToAdd to order
   */
  @Override
  public Order modifyOrder(Order order) {
    for (MenuItem menuItem : itemsToAdd) {
      order.addMenuItemToOrder(menuItem);
    }
    return order;
  }
}
