package Menu.DiscountOutcomes;

import Ordering.*;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class MoneyReduction implements IDiscountOutcome {

  public MoneyReduction(double value) {
    reduction = value;
  }

  public double reduction;

  /**
   * lowers the price of the order by "reduction"
   */
  @Override
  public Order modifyOrder(Order order) {
    order.clone().modifyPrice(-reduction);
    return order;
  }
}
