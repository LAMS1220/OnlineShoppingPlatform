
package onlineshoppingplatform;
import java.util.*;
public class Furnitures {
   
    public static void main(String[] args) {
        
        String[] furnitures= new String[5];
        furnitures[0] = "Bed";
        furnitures[1] = "Table";
        furnitures[2] = "Chair";
        furnitures[3] = "Lamp";
        furnitures[4] = "Cabinet";
               System.out.println("Your selected order is "+furnitures[3]);
               
               
               
        ArrayList furnituresList = new ArrayList();       
               furnituresList.add("Bed");
               furnituresList.add("Table");
               furnituresList.add("Chair");
               furnituresList.add("Lamp");
               furnituresList.add("Cabinet");
                  System.out.println("Kindly select your order "+furnituresList);
}
}