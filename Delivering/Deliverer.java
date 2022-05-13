package Delivering;

import Ordering.Order;
import Ordering.Order.OrderState;
/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */

import java.util.ArrayList;

public class Deliverer {
  /**
   * A list of orders that are being stored by this deliverer.
   * The delivery person could be taking more than one order at once.
   * Every order has a specified address of delivery
   */
  public static ArrayList<Order> ordersInCargo = new ArrayList<>();

  /**
   * The deliverer calls for more orders to deliver after they have arrived back at the restaurant
   */
  public static void checkInForNewOrders() {}

  /**
   * This is called when an order is put into the cargo of a deliverer. The state of the order is then updated
   */
  public static void OnCargoFilled() {
    for (Order order : ordersInCargo) {
      order.orderState = OrderState.Delivering;
    }
  }
}
