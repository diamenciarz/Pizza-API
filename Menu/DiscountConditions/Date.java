package Menu.DiscountConditions;

import Ordering.*;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class Date implements IDiscountCondition {

  private Date(){
    
  }
  //public Time startingTime;
  //public Time public endingTime;

  public boolean isConcurring;

  //public Time repeatDelay;

  /**
   * Checks whether the current date and time is within the range specified by "startingTime" and "endingTime"
   */
  @Override
  public boolean discountApplies(Order order) {
    // TODO Auto-generated method stub
    return false;
  }
}
