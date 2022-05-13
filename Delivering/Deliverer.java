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
  public Deliverer(int cargoSize) {
    CARGO_SIZE = cargoSize;
    cargoState = 0;
  }

  /**
   * A list of orders that are being stored by this deliverer.
   * The delivery person could be taking more than one order at once.
   * Every order has a specified address of delivery
   */
  public ArrayList<Order> ordersInCargo = new ArrayList<>();
  public final int CARGO_SIZE;
  public int cargoState;

  /**
   * The deliverer calls for more orders to deliver after they have arrived back
   * at the restaurant
   */
  public void checkInForNewOrders() {
    DeliveryDeployer.addAvailableDeliverer(this);
  }

  public void addOrder(Order order) {
    ordersInCargo.add(order);
    cargoState++;
  }

  public void orderDelivered(Order order) {
    ordersInCargo.remove(order);
    cargoState--;
  }

  /**
   * This is called when an order is put into the cargo of a deliverer. The state
   * of the order is then updated
   */
  public void deploy() {
    updateOrderState();
    deliverOrders();
    checkInForNewOrders();
  }

  private void updateOrderState() {
    for (Order order : ordersInCargo) {
      order.setOrderState(OrderState.Delivering);
    }
  }

  private void deliverOrders() {
    for (Order order : ordersInCargo) {
      orderDelivered(order);
    }
  }
}
