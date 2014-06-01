/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package java5774_5605_4375_controlerdb;

import TreatmentD.Patient;

/**
 *
 * @author Admin
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Java5774_5605_4375_ControlerDB j = new  Java5774_5605_4375_ControlerDB();
        Patient p = new Patient(new Long("2"), "moshe", "05271463333");
        j.AddPatiant(p);
        System.out.println(j.GetAllPatient().toString());
        
    }
    
}
