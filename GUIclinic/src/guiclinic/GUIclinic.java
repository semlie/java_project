/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;

import Treatments.Backend_DAO_List_impl;
import com.github.javafaker.Faker;

/**
 *
 * @author Dell
 */
public class GUIclinic {

    public static Backend_DAO_List_impl Controler;

    static {
        Controler = new Backend_DAO_List_impl();
    }

    public static void init() throws Exception {
        toolsRandoData t = new toolsRandoData();
        Controler.changePatient(t.addListofPatient(58));
        Controler.changeMeeting(t.addListOfMeeting(Controler.GetAllPatient(), 7));
        Controler.changeServices(Controler.GetAllServices());
//    Controler.changeServices(t.addListOfServices(Controler.GetAllPatient(), 7));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      init();
    }

}
