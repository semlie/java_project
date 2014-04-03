/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiclinic;

import DataAccessObject.Backend_DAO_List_impl;
import com.github.javafaker.Faker;

/**
 *
 * @author Dell
 */
public class GUIclinic {
public static  Backend_DAO_List_impl Controler;
static {
Controler = new Backend_DAO_List_impl();
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
   Faker f = new Faker();
        System.out.println(f.name());
    }
    
}
