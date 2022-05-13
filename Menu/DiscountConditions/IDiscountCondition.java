package Menu.DiscountConditions;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public interface IDiscountCondition {
  /**
   * Uses a bunch of conditions to see if they are met
   * @param order
   * @return whether the conditions are met
   */
  public abstract boolean discountApplies(Order order);
}
