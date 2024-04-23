package onlineshoppingplatform;

import java.util.*;


public class Apparel {
    public static void main(String[]args){
        
    
     //will be using this way temporarily   
    //source code for appliances category
        
    String[] apparel= new String[5];
    apparel[0] = "Women's Apparel";
    apparel[1] = "Men's Apparel";
    apparel[2] = "Kid's Apparel";
    apparel[3] = "Accessories";
    apparel[4] = "Shoes";
        System.out.println("Your selected order is "+apparel[3]);
    
    //more good way to show our list of products is ArrayList
    
    ArrayList apparelList = new ArrayList();
    apparelList.add("W Apparel");
    apparelList.add("M Apparel");
    apparelList.add("K Apparel");
    apparelList.add("Accessories");
    apparelList.add("Shoes");
        System.out.println("kindly select your order  "+apparelList);
    
}
}