package Menu.DiscountOutcomes;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public interface IDiscountOutcome {
  /**
   * Applies its effects to the given order and returns a modified order
   * @param order
   * @return an order with properties modified by the effects of this discount
   */
  public abstract Order modifyOrder(Order order);
}
