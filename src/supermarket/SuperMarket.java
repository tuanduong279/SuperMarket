/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package supermarket;
import DBConnection.DBConnection;
import supermarket.View.*;
import supermarket.View.Admin.ManageCashier;

/**
 *
 * @author Duong
 */
public class SuperMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Login(null, true).show();
        
    }
    
}
