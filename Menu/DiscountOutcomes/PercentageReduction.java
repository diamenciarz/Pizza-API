package Menu.DiscountOutcomes;

import Ordering.*;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class PercentageReduction implements IDiscountOutcome {
  public PercentageReduction(double reduction) {
    percentageReduction = reduction;
  }

  public double percentageReduction;

  /**
   * lowers the price of the order by a percentage of the total price specified by
   * "percentageReduction"
   */
  @Override
  public Order modifyOrder(Order order) {
    Order clonedOrder = order.clone();
    clonedOrder.multiplyPrice(1 - (double) percentageReduction / 100);
    return order;
  }
}
