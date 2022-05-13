package Ordering;

import Menu.MenuItem;
import java.util.ArrayList;

/**
 * Group 1
  Francisco Javier Camacho Perez de Sevilla i6281035
  Stan Ostaszewski i6268633
 */
public class ListCopier {

  public static ArrayList<MenuItem> copy(ArrayList<MenuItem> list){
    ArrayList<MenuItem> newList = new ArrayList<MenuItem>();
    for (MenuItem menuItem : newList) {
      newList.add(menuItem.clone());
    }
    return newList;
  }
}
