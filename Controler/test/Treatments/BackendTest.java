/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treatments;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dell
 */
public class BackendTest {

    private List<Patient> _patient;
    private List<Services> _services;
    private List<Meeting> _metting;
    private Backend_DAO_List_impl b = new Backend_DAO_List_impl();

    public BackendTest() {
        _patient = new ArrayList<Patient>();
        _services = new ArrayList<Services>();
        _metting = new ArrayList<Meeting>();
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testAddpatient() throws Exception {
        Patient p = new Patient("smuel", 1, "0527146368");
        for (int i = 0; i < 10; i++) {
            _patient.add(p);
            try {
                b.AddPatiant(p);
            } catch (Exception ex) {
                Logger.getLogger(BackendTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setName("smuel" + Integer.toString(i));
            p.setId(i + 2);
            p.setPhone("052715633" + Integer.toString(i));

        }
        System.out.println("check add patient");
        assertArrayEquals(_patient.toArray(), b.GetAllPatient().toArray());
    }

    @Test
    public void testAddService() throws Exception {

        Services s = new Counseling(Services.TypesCons.MESO, 1, new Date(), 280.0, "Shmulik Liebeskind");

        b = new Backend_DAO_List_impl();
        for (int i = 0; i < 10; i++) {
            _services.add(s);
            b.AddService(s);
            s.setDate(new Date());
            s.setId(i + 2);
            s.setNameOfAttendant("Shmulik Liebeskind" + Integer.toString(i + 2));
            s.setPrice(280 / (i + 1) * 2);
        }
        System.out.println("check add service");
        assertArrayEquals(_services.toArray(), b.GetAllServices().toArray());
    }

    @Test
    public void testAdmetting() throws Exception {
        Patient p = new Patient("smuel", 1, "0527146368");
        Services s = new Counseling(Services.TypesCons.MESO, 1, new Date(), 280.0, "Shmulik Liebeskind");
        Meeting m = new Meeting(p, s);
        b = new Backend_DAO_List_impl();
        b.AddMeeting(m);
        assertTrue("if add mitting", b.GetPatientMeeting(p).contains(m));
    }

    @Test
    public void testAGetUnpaidMetting() throws Exception {
        Patient p = new Patient("smuel", 1, "0527146368");
        Services s = new Counseling(Services.TypesCons.MESO, 1, new Date(), 280.0, "Shmulik Liebeskind");

        Meeting m = new Meeting(p, s);
        m.setPayed(Boolean.FALSE);
        b = new Backend_DAO_List_impl();
        b.AddMeeting(m);
        b.AddMeeting(m);
        System.out.println("calc unpaid meeting for specific patient");
        assertEquals(560.0, b.CalcPatientUnpaidMeeting(p), 0);
    }

    @Test
    public void GetAllMeetingCost() throws Exception {
        b = new Backend_DAO_List_impl();
        Patient p = new Patient("smuel", 1, "0527146368");
        Services s = new Counseling(Services.TypesCons.MESO, 1, new Date(), 280.0, "Shmulik Liebeskind");
        Patient p1 = new Patient("israel", 2, "0527146368");
        Services s1 = new Counseling(Services.TypesCons.REFLEXOLOGY, 2, new Date(), 280.0, "Shmulik Liebeskind");

        Meeting m = new Meeting(p, s);
        Meeting m1 = new Meeting(p1, s1);
        m.setPayed(Boolean.FALSE);
        b.AddMeeting(m1);
        m1.setPayed(Boolean.TRUE);
        b.AddMeeting(m);
        b.AddMeeting(m);
        b.AddMeeting(m1);
        System.out.println("check calc all cost for all patient for spesific services");
        assertEquals(1120.0, b.CalcAllPatientTotalCost(b.GetAllMeetings()), 0);
    }
}
