/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java5774_5605_4375_controlerdb;

import java.util.Date;

import TreatmentD.Counseling;
import TreatmentD.CounselingJpaController;
import TreatmentD.Meeting;
import TreatmentD.Patient;
import TreatmentD.Services;
import java.util.ArrayList;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class Java5774_5605_4375_ControlerDBTest {

    public Java5774_5605_4375_ControlerDBTest() {
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
     * Test of main method, of class Java5774_5605_4375_ControlerDB.
     */
    /**
     * Test of AddPatiant method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testAddPatiant() throws Exception {
        System.out.println("AddPatiant");
        Patient p = new Patient(Long.parseLong("7"), "name", "052777");

        Java5774_5605_4375_ControlerDB j = new Java5774_5605_4375_ControlerDB();
        int s = j.GetAllPatient().size();
        j.AddPatiant(p);
//         PatientJpaController instance = new PatientJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));

//        j.AddPatiant(p);
        assertTrue(j.GetAllPatient().size() == s + 1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DelPatient method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testDelPatient() throws Exception {
        System.out.println("DelPatient");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        Patient p = instance.GetAllPatient().get(1);
        System.out.println(p);
        instance.DelPatient(p);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(!instance.GetAllPatient().contains(p));

    }

    /**
     * Test of AddMeeting method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testAddMeeting() throws Exception {
        System.out.println("AddMeeting");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        int size = instance.GetAllMeetings().size();
        Patient p = instance.GetAllPatient().get(1);
        Services s = new Services(new Long("1"), new Date(), "semli", 390);
        Meeting m = new Meeting(new Long("2"), p, true, s, new Date());
        instance.AddMeeting(m);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.GetAllMeetings().size() == size + 1);
    }

    /**
     * Test of DelMeeting method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testDelMeeting() throws Exception {
        System.out.println("DelMeeting");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        Meeting m = instance.GetAllMeetings().get(0);

        instance.DelMeeting(m);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(!instance.GetAllMeetings().contains(m));
    }

    /**
     * Test of AddService method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testAddService() throws Exception {
        System.out.println("AddService");
        Services s = new Services(new Long("1"), new Date(), "semli2", 390);
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        int size = instance.GetAllServices().size();
        instance.AddService(s);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(instance.GetAllServices().size() == size + 1);
    }

    /**
     * Test of DelService method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testDelService() throws Exception {
        System.out.println("DelService");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        Services s = instance.GetAllServices().get(1);
        instance.DelService(s);

        // TODO review the generated test code and remove the default call to fail.
        assertFalse(instance.GetAllServices().contains(s));
    }

    /**
     * Test of GetAllPatient method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testGetAllPatient() throws Exception {
        System.out.println("GetAllPatient");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        ArrayList<Patient> expResult = null;
        ArrayList<Patient> result = instance.GetAllPatient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllServices method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testGetAllServices() throws Exception {
        System.out.println("GetAllServices");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        ArrayList<Services> expResult = null;
        ArrayList<Services> result = instance.GetAllServices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetAllMeetings method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testGetAllMeetings() throws Exception {
        System.out.println("GetAllMeetings");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        ArrayList<Meeting> expResult = null;
        ArrayList<Meeting> result = instance.GetAllMeetings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetPatientMeeting method, of class
     * Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testGetPatientMeeting() throws Exception {
        System.out.println("GetPatientMeeting");
        Patient p = null;
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        ArrayList<Meeting> expResult = null;
        ArrayList<Meeting> result = instance.GetPatientMeeting(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcPatientUnpaidMeeting method, of class
     * Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testCalcPatientUnpaidMeeting() throws Exception {
        System.out.println("CalcPatientUnpaidMeeting");
        Patient p = null;
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        double expResult = 0.0;
        double result = instance.CalcPatientUnpaidMeeting(p);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcPatientPaid method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testCalcPatientPaid() throws Exception {
        System.out.println("CalcPatientPaid");
        Patient p = null;
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        double expResult = 0.0;
        double result = instance.CalcPatientPaid(p);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcPatientTotalCost method, of class
     * Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testCalcPatientTotalCost() throws Exception {
        System.out.println("CalcPatientTotalCost");
        Patient p = null;
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        double expResult = 0.0;
        double result = instance.CalcPatientTotalCost(p);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CalcAllPatientTotalCost method, of class
     * Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testCalcAllPatientTotalCost() throws Exception {
        System.out.println("CalcAllPatientTotalCost");
        ArrayList<Meeting> metting = null;
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        double expResult = 0.0;
        double result = instance.CalcAllPatientTotalCost(metting);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of counselingType method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testCounselingType() throws Exception {
        System.out.println("counselingType");
        CounselingJpaController CounselingCtrl = new CounselingJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));

        ArrayList<String> expResult = null;
        ArrayList<Counseling> result = (ArrayList<Counseling>) CounselingCtrl.findCounselingEntities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of treatmentType method, of class Java5774_5605_4375_ControlerDB.
     */
    @Test
    public void testTreatmentType() throws Exception {
        System.out.println("treatmentType");
        Java5774_5605_4375_ControlerDB instance = new Java5774_5605_4375_ControlerDB();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.treatmentType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
