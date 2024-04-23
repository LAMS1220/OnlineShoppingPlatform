package onlineshoppingplatform;

import java.util.*;


public class Gadgets {
    public static void main(String[]args){
        
    
     //will be using this way temporarily   
    //source code for appliances category
        
    String[] gadgets= new String[5];
    gadgets[0] = "Mobile Phones";
    gadgets[1] = "Personal Computers";
    gadgets[2] = "Tablets";
    gadgets[3] = "Smart Watch";
    gadgets[4] = "Peripherals";
        System.out.println("Your selected order is "+gadgets[3]);
    
    //more good way to show our list of products is ArrayList
    
    ArrayList gadgetsList = new ArrayList();
    gadgetsList.add("Mobile Phones");
    gadgetsList.add("PC");
    gadgetsList.add("Tablets");
    gadgetsList.add("Smart Watch");
    gadgetsList.add("Peripherals");
        System.out.println("kindly select your order  "+gadgetsList);
    
}
}