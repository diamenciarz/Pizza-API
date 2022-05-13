package Menu.DiscountConditions;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class Location implements IDiscountCondition {
  private Location(){

  }
  //public Location locationMiddle
  public double maxDistanceFromMiddle;

  /**
   * Checks whether the order location is within range "maxDistanceFromMiddle" from "locationMiddle"
   */
  @Override
  public boolean discountApplies(Order order) {
    // TODO Auto-generated method stub
    return false;
  }
}
