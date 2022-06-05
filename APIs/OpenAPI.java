package APIs;

import Menu.*;
import Ordering.MenuManager;
import Ordering.Order;

import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
/**
 * This is a list of public mutator and accessor methods that can be used to
 * change the state of the order.
 * It's meant for public access.
 */
public abstract class OpenAPI {
  
  public OpenAPI(Order order) {
    this.order = order;
}
  
  Order order;

  //region Accessor methods
  public ArrayList<MenuItem> getAvailableMenuItems() {
    return MenuManager.getCurrentMenu().getAvailableMenuItems();
  }

  public ArrayList<Discount> getAvailableMenuDiscounts() {
    return MenuManager.getCurrentMenu().getActiveDiscounts();
  }

  public MenuItem getDishOfTheDay() {
    return MenuManager.getCurrentMenu().dishOfTheDay;
  }
  //endregion

  //region Mutator methods
  public void addMenuItemToOrder(MenuItem menuItem){
    order.addMenuItemToOrder(menuItem);
  }

  public void setCouponCode(String code){
    order.couponCode = code;
  }
  
  public void setDeliveryMethod(Order.DeliveryMethod method){
    order.deliveryMethod = method;
  }

  public void setDeliveryAddress(String address){
    order.deliveryAddress = address;
  }
  public void setTableNr(int nr){
    order.tableNR = nr;
  }
  public void setTakeawayNr(int nr){
    order.takeawayNR = nr;
  }
  //endregion
}
