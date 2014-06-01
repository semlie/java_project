/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;

import backeddaoadapters.BackendWSAdapter;

/**
 *
 * @author Dell
 */
public class GUIclinic {

    public static BackendWSAdapter Controler;

    static {
        Controler = new BackendWSAdapter();
    }

    public static void init() throws Exception {
        toolsRandoData t = new toolsRandoData();
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
      enterForm MainForm = new enterForm();
      MainForm.setVisible(true);
    }

}
