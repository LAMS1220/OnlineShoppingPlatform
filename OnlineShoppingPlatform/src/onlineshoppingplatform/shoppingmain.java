/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package onlineshoppingplatform;
import java.awt.EventQueue;

public class shoppingmain {

    public static void main (String[]args){
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                shopping menu = new shopping();
                menu.setVisible(true);
            }
        });
    }
}