
package onlineshoppingplatform;

//to know if the product is added successfully or not.
public class Product {
 
        public String Product (int product){
            
            String message;

                if (product>=1){
                    message = "Product successfully added to Cart.";
                }
                else{
                    message = "";
                    
                }
                
                return message;
            
        }
    
}
