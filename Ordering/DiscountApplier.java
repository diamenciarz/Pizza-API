package Ordering;

import java.util.ArrayList;

import Menu.Discount;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class DiscountApplier {
  public boolean doDiscountsStack;

  /**
   * Applies applicable discounts to a copy of the {@code order}
   * If all of the discount conditions are met, then it applies the discounts to the menu one by one.
   *
   * If {@code doDiscountsStack} is true, then all the discounts are applied at once.
   *
   * if {@code doDiscountsStack} is false, then a copy of the order is created after every modification and the order with the lowest price is returned
   * @param menu
   * @param order
   * @return a copy of this {@code order} with applied discounts
   */
  public static Order applyDiscounts(Order order) {
    Order copy = order.clone();
    copy.calculatePriceSum();
    ArrayList<Discount> applicableDiscounts = copy.savedMenu.getActiveDiscounts();
    for (Discount discount : applicableDiscounts) {
      discount.applyDiscount(copy);
    }
    return copy;
  }
}
