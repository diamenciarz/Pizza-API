package Ordering;

import Menu.Menu;
import Menu.MenuItem;
import java.util.ArrayList;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class Order implements Cloneable {

  public Order(Menu menu){
    savedMenu = menu;
  }

  public static enum DeliveryMethod {
    OnSite,
    Takeaway,
    DeliverToAddress,
  }

  public static enum OrderState {
    AwaitingPreparation,
    AwaitingDelivery,
    Delivering,
  }

  public ArrayList<MenuItem> orderedItems = new ArrayList<>();
  /**
   * the menu is saved, so that we can check the list of discounts that apply to
   * this order
   */
  public Menu savedMenu;

  private double finalPrice;

  public DeliveryMethod deliveryMethod;
  // One of the variables below will be applicable to the delivery method - others
  // can have no value.
  public String deliveryAddress;
  public int tableNR;
  public int takeawayNR;
  public String couponCode;

  /**
   * The current state of this order. It will be updated throughout the process.
   * It is used by online apps to display the information to the user.
   */
  public OrderState orderState;

  /**
   * Returns the total price of the order with discounts applied
   * 
   * @return
   */
  public double getFinalPrice() {
    return finalPrice;
  }

  public void calculatePriceSum() {
    finalPrice = 0;
    for (MenuItem menuItem : orderedItems) {
      finalPrice += menuItem.getPrice();
    }
  }

  public void modifyPrice(double change) {
    finalPrice += change;
  }

  public void multiplyPrice(double mult) {
    finalPrice *= mult;
  }

  public Order addMenuItemToOrder(MenuItem menuItem) {
    orderedItems.add(menuItem);
    return this;
  }

  @Override
  public Order clone() {
    Order copy = new Order(savedMenu.clone());
    copy.orderState = orderState;
    copy.finalPrice = finalPrice;
    copy.orderedItems = (ArrayList<MenuItem>) orderedItems.clone();
    copy.deliveryAddress = deliveryAddress;
    copy.tableNR = tableNR;
    copy.takeawayNR = takeawayNR;
    copy.calculatePriceSum();
    return copy;
  }
}
