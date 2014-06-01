/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guiclinic;

import TreatmentD.Meeting;
import TreatmentD.Patient;
import TreatmentD.Services;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Dell
 */
public class toolsRandoDataTest {
    
    public toolsRandoDataTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addListofPatient method, of class toolsRandoData.
     */
    @Test
    public void testAddListofPatient() {
        System.out.println("addListofPatient");
        int NumOfPatient = 0;
        toolsRandoData instance = new toolsRandoData();
        ArrayList<Patient> expResult = null;
        ArrayList<Patient> result = instance.addListofPatient(NumOfPatient);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addListOfMeeting method, of class toolsRandoData.
     */
    @Test
    public void testAddListOfMeeting() {
        System.out.println("addListOfMeeting");
        int MaxNumOfMeetingForEach = 10;
        toolsRandoData instance = new toolsRandoData();
        ArrayList<Patient> ps = instance.addListofPatient(100);
        ArrayList<Meeting> expResult = null;
        ArrayList<Meeting> result = instance.addListOfMeeting(ps, MaxNumOfMeetingForEach);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of addListOfServices method, of class toolsRandoData.
     */
    @Test
    public void testAddListOfServices() {
        System.out.println("addListOfServices");
        int NumOfService = 100;
        toolsRandoData instance = new toolsRandoData();
        ArrayList<Services> expResult = null;
        ArrayList<Services> result = instance.addListOfServices(NumOfService);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
