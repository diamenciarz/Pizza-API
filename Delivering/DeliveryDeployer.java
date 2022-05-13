package Delivering;

import Ordering.Order;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class DeliveryDeployer {
  /**
   * A list of orders that have been prepared and are waiting for available deliverers.
   */
  public static ArrayList<Order> ordersToDeliver = new ArrayList<>();

  /**
   * A list of currently available deliverers
   */
  public static ArrayList<Deliverer> availableDeliverers = new ArrayList<>();

  /**
   * This is called whenever a deliverers checks in after a successful delivery.
   * Their cargo is filled with orders in such a way to minimize the travel distance.
   * The orders are then removed from the "ordersToDeliver" list
   * @param deliverer
   */
  public static void fillCargo(Deliverer deliverer) {}

  public static void orderDelivered(Order order){

  }
}
