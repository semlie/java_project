/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;

import java5774_5605_4375_controlerdb.Java5774_5605_4375_ControlerDB;


/**
 *
 * @author Dell
 */
public class GUIclinic {
//create like singltone
    public static Java5774_5605_4375_ControlerDB Controler;

    static {
        Controler = new Java5774_5605_4375_ControlerDB();
    }

    public static void init() throws Exception {
        toolsRandoData t = new toolsRandoData();
        //call func to auto genertade patient ' services' meeting
//        Controler.changePatient(t.addListofPatient(100));
//        Controler.changeServices(t.addListOfServices(30));
//        Controler.changeMeeting(t.addListOfMeeting(Controler.GetAllPatient(), 30));
//    Controler.changeServices(t.addListOfServices(Controler.GetAllPatient(), 7));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
      init();
      //run the main form
      enterForm MainForm = new enterForm();
      MainForm.setVisible(true);
    }

}
