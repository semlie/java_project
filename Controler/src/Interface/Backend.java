/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Treatments.Meeting;
import Treatments.Patient;
import Treatments.Services;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public interface Backend {
    /**
     * Add Patient to data source
     * @param p
     * @throws Exception 
     */
    void AddPatiant(Patient p) throws Exception;

    /**
     *
     * @param p
     * @throws Exception
     */
    void DelPatient(Patient p) throws Exception;
    
    /**
     * add Meeting to data source
     * @param m
     * @throws Exception 
     */
    void AddMeeting (Meeting m) throws Exception;

    /**
     *
     * @param m
     * @throws Exception
     */
    void DelMeeting (Meeting m) throws Exception;
    
    /**
     *
     * @param s
     * @throws Exception
     */
    void AddService(Services s) throws Exception;

    /**
     *
     * @param s
     * @throws Exception
     */
    void DelService( Services s) throws Exception;
    
    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<Patient> GetAllPatient() throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<Services> GetAllServices() throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<Meeting> GetAllMeetings() throws Exception;

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    ArrayList<Meeting> GetPatientMeeting(Patient p) throws Exception;
    
    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    double CalcPatientUnpaidMeeting(Patient p)throws Exception;

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    double CalcPatientPaid(Patient p)throws Exception;

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    double CalcPatientTotalCost(Patient p)throws Exception;

    /**
     *
     * @param metting
     * @return
     * @throws Exception
     */
    double CalcAllPatientTotalCost(ArrayList<Meeting> metting)throws Exception;
    
    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<String> counselingType() throws Exception;

    /**
     *
     * @return
     * @throws Exception
     */
    ArrayList<String> treatmentType() throws Exception;
    
}
