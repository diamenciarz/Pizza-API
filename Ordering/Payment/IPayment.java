package Ordering.Payment;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public interface IPayment {
  /**
   *
   * @param amount
   * @return true, when the payment has been finished
   */
  public abstract boolean paymentSucceded(double amount);
}
