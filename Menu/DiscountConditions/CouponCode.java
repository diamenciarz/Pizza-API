package Menu.DiscountConditions;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class CouponCode implements IDiscountCondition {
  public CouponCode(String code){
    secretCode = code;
  }

  public String secretCode;

  /**
   * Checks whether the order has provided a valid couponCode
   */
  @Override
  public boolean discountApplies(Order order) {
    return order.couponCode.compareTo(secretCode) == 0;
  }
}
