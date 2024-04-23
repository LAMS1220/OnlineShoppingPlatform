
package onlineshoppingplatform;
import java.util.*;
public class Hygiene {
     public static void main(String[] args) {
        
        String[] hygiene= new String[5];
        hygiene[0] = "Shaving";
        hygiene[1] = "Foot care";
        hygiene[2] = "Deodorant";
        hygiene[3] = "Skin care";
        hygiene[4] = "Shower";
               System.out.println("Your selected order is "+hygiene[3]);
               
               
               
        ArrayList hygieneList = new ArrayList();       
               hygieneList.add("Shaving");
               hygieneList.add("Foot care");
               hygieneList.add("Deodorant");
               hygieneList.add("Skin care");
               hygieneList.add("Shower");
                  System.out.println("Kindly select your order "+hygieneList);
}
}