package Menu;

import Menu.DiscountConditions.IDiscountCondition;
import Menu.DiscountOutcomes.IDiscountOutcome;
import Ordering.*;
import java.util.ArrayList;

/**
 * Group 1
 * Francisco Javier Camacho Perez de Sevilla i6281035
 * Stan Ostaszewski i6268633
 */
public class Discount implements Cloneable {
  public Discount(ArrayList<IDiscountCondition> conditions, ArrayList<IDiscountOutcome> outcomes) {
    this.conditions = conditions;
    this.outcomes = outcomes;
  }

  public Discount() {
    
  }

  ArrayList<IDiscountCondition> conditions = new ArrayList<>();
  ArrayList<IDiscountOutcome> outcomes = new ArrayList<>();

  public Discount addCondition(IDiscountCondition condition) {
    conditions.add(condition);
    return this;
  }

  public Discount removeCondition(IDiscountCondition condition) {
    conditions.remove(condition);
    return this;
  }

  public Discount addOutcome(IDiscountOutcome outcome) {
    outcomes.add(outcome);
    return this;
  }

  public Discount removeOutcome(IDiscountOutcome outcome) {
    outcomes.remove(outcome);
    return this;
  }

  /**
   * Returns true if all the conditions are met by the order
   * 
   * @param order
   * @return
   */
  public boolean areConditionsMet(Order order) {
    return false;
  }

  /**
   * Returns a new order modified by the Outcomes
   * 
   * @return
   */
  public void applyDiscount(Order order) {
  }

  @Override
  public Discount clone() {
    ArrayList<IDiscountCondition> clonedConditions = (ArrayList<IDiscountCondition>) conditions.clone();
    ArrayList<IDiscountOutcome> clonedOutcomes = (ArrayList<IDiscountOutcome>) outcomes.clone();
    Discount copy = new Discount(clonedConditions, clonedOutcomes);

    return copy;
  }
}
