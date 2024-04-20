
package onlineshoppingplatform;

import java.util.*;


public class Appliances {
    public static void main(String[]args){
        
    
     //will be using this way temporarily   
    //source code for appliances category
        
    String[] appliances= new String[5];
    appliances[0] = "Refrigerator";
    appliances[1] = "Electric Fan";
    appliances[2] = "TV";
    appliances[3] = "Aircon";
    appliances[4] = "Microwave";
        System.out.println("Your selected order is "+appliances[3]);
    
    //more good way to show our list of products is ArrayList
    
    ArrayList appliancesList = new ArrayList();
    appliancesList.add("Ref");
    appliancesList.add("E fan");
    appliancesList.add("TV");
    appliancesList.add("Aircon");
    appliancesList.add("Microwave");
        System.out.println("kindly select your order "+appliancesList);
    
}
}