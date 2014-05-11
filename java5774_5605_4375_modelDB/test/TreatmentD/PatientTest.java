/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreatmentD;

import javax.persistence.EntityManagerFactory;
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
public class PatientTest {
    
    public PatientTest() {
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
     * Test of getId method, of class NewEntity.
     */
    @Test
    public void testCreateDB() {
        System.out.println("testCreateDB");
        EntityManagerFactory emf = null; 
        String PERSISTENCE_UNIT_NAME = "java5774_5605_4375_modelDBPU"; 
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
