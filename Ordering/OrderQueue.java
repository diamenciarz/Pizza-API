package Ordering;

import Delivering.DeliveryDeployer;
import Ordering.Order.DeliveryMethod;
import Ordering.Order.OrderState;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class OrderQueue {
  /**
   * The queue of orders that need to be prepared in the kitchen
   */
  public static ArrayList<Order> orders = new ArrayList<>();

  public static void addOrder(Order order) {
    order.setOrderState(OrderState.AwaitingPreparation);
    orders.add(order);
    // Some time passes
    orderPrepared(order);
  }

  

  /**
   * Takes the prepared order from the queue and:
   * if the order is to be delivered OnSite or for Takeaway then it is no longer being followed by the system
   * if the order is to be delivered to an address, it is given to the DeliveryDeployer
   * @param order
   */
  public static void orderPrepared(Order order) {
    orders.remove(order);
    order.setOrderState(OrderState.AwaitingDelivery);
    if (order.deliveryMethod == DeliveryMethod.DeliverToAddress) {
      DeliveryDeployer.ordersToDeliver.add(order);
    }
    DeliveryDeployer.ordersToDeliver.add(order);
    DeliveryDeployer.checkForDeliveries();
  }
}
