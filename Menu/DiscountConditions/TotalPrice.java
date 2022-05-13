package Menu.DiscountConditions;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class TotalPrice implements IDiscountCondition {

  public TotalPrice(double price){
    borderPrice = price;
  }
  double borderPrice;

  /**
   * Checks whether the order's price is higher than "borderPrice"
   */
  @Override
  public boolean discountApplies(Order order) {
    return order.getFinalPrice() > borderPrice;
  }
}
