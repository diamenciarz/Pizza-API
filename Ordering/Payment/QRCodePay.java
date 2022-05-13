package Ordering.Payment;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class QRCodePay implements IPayment {

  /**
   * returns true when the payment has been finalized through an outside authority
   */
  @Override
  public boolean paymentSucceded(double amount) {
    return false;
  }
}
