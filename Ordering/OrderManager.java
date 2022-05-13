package Ordering;

import Menu.MenuItem;
import Ordering.Payment.PaymentManager;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class OrderManager {
  /**
   * The current state of the order that is help in the memory until the order is finalized
   */
  public static ArrayList<Order> orders;

  /**
   * Adds the "menuItem" to the given order
   * @param menuItem
   */
  public static void addItemToOrder(MenuItem menuItem, Order order) {}

  public static void removeItemFromOrder(MenuItem menuItem, Order order) {}

  /**
   * After the user has finalized the order it has to be paid for before it is added to the order queue
   */
  public static void finalizeOrder(Order order) {
    Order orderWithDiscountsApplied = DiscountApplier.applyDiscounts(order);
    PaymentManager.moveToPayment(orderWithDiscountsApplied);
  }
}
