package Ordering;

import Menu.Menu;
import Ordering.Order.DeliveryMethod;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class OrdererCashier extends Orderer {

  /**
   * Each way of making an order can have some limitations. These rules should be specified in each of the "Orderer" extensions
   */
  public OrdererCashier(Menu menu, int tableNR) {
    super(menu);
    setDeliveryMethod();
    setTableNR(tableNR);
  }

  public void setTableNR(int tableNR){
    orderToEdit.tableNR = tableNR;
  }
  /**
   * The customer can order their food OnSite or for Takeaway through the cashier, but not as delivery
   */
  @Override
  public Orderer setDeliveryMethod() {
    orderToEdit.deliveryMethod = DeliveryMethod.OnSite;
    return this;
  }
}
