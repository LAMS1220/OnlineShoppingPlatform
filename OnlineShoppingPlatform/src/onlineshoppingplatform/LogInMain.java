/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineshoppingplatform;

import java.awt.EventQueue;

/**
 *
 * @author ACER
 */
public class LogInMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                LogIn login = new LogIn();
                login.setVisible(true);
            }
        });
    
    }
}
