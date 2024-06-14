                                    
package onlineshoppingplatform;

public class Payment {
    
    public static void main(String[]args){
    
        //customer 1
        Cart c01 = new Cart ("Appliances");
        c01.productOrder(1);
        
        //customer 2
        Cart c02 = new Cart ("Gadgets");
        c02.productOrder(2);
        
        //customer 3
        Cart c03 = new Cart ("Apparel");
        c03.productOrder(3);
        
        //customer 4
        Cart c04 = new Cart ("Furnitures"); 
        c04.productOrder(4);
        
        //customer 5
        Cart c05 = new Cart ("Hygiene");
        c04.productOrder(5);
           
    }
}
