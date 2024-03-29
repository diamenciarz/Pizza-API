package Ordering;

import Menu.*;
import Ordering.Order.DeliveryMethod;
import Ordering.Payment.PaymentManager;

import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
/**
 * A new orderer is created per ordering session of the customer.
 * Each orderer is responsible for adding "MenuItems" to one "Order".
 * Depending on the way in which the ordering service was accessed,
 * a different implementation of this class will be instantiated.
 */
public abstract class Orderer {
  protected ArrayList<MenuItem> availableItems = new ArrayList<>();
  protected ArrayList<Discount> activeDiscounts = new ArrayList<>();

  protected Orderer(Menu menu) {
    Menu currentMenu = MenuManager.getCurrentMenu();
    availableItems = currentMenu.getAvailableMenuItems();
    activeDiscounts = currentMenu.getActiveDiscounts();
    orderToEdit = new Order(menu);
  }

  protected Order orderToEdit;

  /**
   * The order manager that acts as a memory for all the ordered items.
   */

  public Orderer addItemToOrder(MenuItem item) {
    if (item.isInStock) {
      orderToEdit.orderedItems.add(item);
      System.out.println("Added item to order: " + item.name);
    } else {
      System.out.println("Item not in stock anymore");
    }
    return this;
  }

  public Orderer removeItemFromOrder(MenuItem item) {
    orderToEdit.orderedItems.remove(item);
    return this;
  }

  /**
   *
   */
  public abstract Orderer setDeliveryMethod();

  /**
   * This method is called
   */
  public void finalizeOrder() {
    checkIfDataSufficient(orderToEdit);
    Order orderWithDiscountsApplied = DiscountApplier.applyDiscounts(orderToEdit);

    if (PaymentManager.askForPayment(orderWithDiscountsApplied)) {
      OrderQueue.addOrder(orderWithDiscountsApplied);
    }
  }

  private void checkIfDataSufficient(Order order) {
    if (order.deliveryMethod == DeliveryMethod.DeliverToAddress) {
      if (order.deliveryAddress == null) {
        throw new NullPointerException("Delivery address was null");
      }
    }
    if (order.deliveryMethod == DeliveryMethod.OnSite) {
      if (order.tableNR == 0) {
        throw new NullPointerException("Table number was unassigned");
      }
    }
    if (order.deliveryMethod == DeliveryMethod.Takeaway) {
      if (order.takeawayNR == 0) {
        throw new NullPointerException("Takeaway number was unassigned");
      }
    }
  }
}
