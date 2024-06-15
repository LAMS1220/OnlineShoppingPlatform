
package onlineshoppingplatform;

public class Cart{
    
    String Appliances;
    String Gadgets;
    String Apparel;
    String Furnitures;
    String Hygiene;
    
   Cart(String Appliances){
       this.Appliances = Appliances;
}   
   Cart(String Gadgets, String Appliances){
       this.Gadgets = Gadgets;;
       this.Appliances = Appliances;
   }
   Cart(String Gadgets, String Appliances, String Apparel){
       this.Gadgets = Gadgets;
       this.Appliances = Appliances;
       this.Apparel = Apparel;
   }
   Cart(String Gadgets, String Appliances, String Apparel, String Furniture){
       this.Gadgets = Gadgets;
       this.Appliances = Appliances;
       this.Apparel = Apparel;
       this.Furnitures = Furnitures;
   }
   Cart(String Gadgets, String Appliances, String Apparel, String Furniture, String Hygiene){
       this.Gadgets = Gadgets;
       this.Appliances = Appliances;
       this.Apparel = Apparel;
       this.Furnitures = Furnitures;
       this.Hygiene = Hygiene;
   }
        public void productOrder(){
        System.out.println("Your order is "+Appliances+  "\nlance"+Gadgets + "\nlance"+Apparel+ "\nlance"+Furnitures+ "\nlance"+Hygiene);
      
}

    void productOrder(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main (String[]args){
        Product pro = new Product ();
        System.out.println(pro.Product(1)); //example of number of product 
    }
    
    
}