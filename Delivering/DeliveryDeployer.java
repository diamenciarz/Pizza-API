package Delivering;

import Ordering.Order;
import java.util.ArrayList;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class DeliveryDeployer {
  /**
   * A list of orders that have been prepared and are waiting for available
   * deliverers.
   */
  public static ArrayList<Order> ordersToDeliver = new ArrayList<>();

  /**
   * A list of currently available deliverers
   */
  public static ArrayList<Deliverer> availableDeliverers = new ArrayList<>();

  public static void checkForDeliveries() {
    if (availableDeliverers.size() == 0) {
      return;
    }

    Deliverer availabDeliverer = availableDeliverers.get(0);
    if (availabDeliverer == null) {
      return;
    }
    
    fillCargo(availabDeliverer);
  }

  public static void addAvailableDeliverer(Deliverer deliverer) {
    availableDeliverers.add(deliverer);
    checkForDeliveries();
  }

  /**
   * This is called whenever a deliverers checks in after a successful delivery.
   * Their cargo is filled with orders in such a way to minimize the travel
   * distance.
   * The orders are then removed from the "ordersToDeliver" list
   * 
   * @param deliverer
   */
  public static void fillCargo(Deliverer deliverer) {
    int freeSpots = deliverer.CARGO_SIZE - deliverer.cargoState;
    for (int i = 0; i < freeSpots; i++) {
      if (ordersToDeliver.size() == 0) {
        return;
      }

      Order order = ordersToDeliver.get(0);
      if (order == null) {
        return;
      }

      ordersToDeliver.remove(0);
      deliverer.addOrder(order);
      deliverer.deploy();
    }
  }

}
