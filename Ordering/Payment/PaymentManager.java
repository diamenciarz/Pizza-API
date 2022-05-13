package Ordering.Payment;

import Ordering.Order;
import Ordering.Order.OrderState;
import Ordering.OrderQueue;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class PaymentManager {
  static ArrayList<IPayment> paymentMethods = new ArrayList<>();

  /**
   * The user can choose an available payment method. After the payment has occured, the order is added to the "OrderQueue"
   * @param order
   */
  public static boolean askForPayment(Order order) {
    IPayment method = letUserChoosePaymentMethod();
    double payment = order.getFinalPrice();

    //TODO: waitUntil(method.paymentSucceded(payment));

    return true;
  }

  /**
   * This function opens a window that allows the user to pick a payment methods
   * @return the chosen method
   */
  private static IPayment letUserChoosePaymentMethod() {
    return null;
  }
}
