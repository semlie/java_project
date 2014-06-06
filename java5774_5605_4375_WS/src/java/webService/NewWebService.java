/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;
import Interface.Backend;
import TreatmentD.Meeting;
import TreatmentD.Patient;
import TreatmentD.Services;
import java.util.ArrayList;
import java.util.logging.Logger;
import java5774_5605_4375_controlerdb.Java5774_5605_4375_ControlerDB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "NewWebService")
public class NewWebService implements Backend {

    private Backend backend = new Java5774_5605_4375_ControlerDB();
    static Logger log = Logger.getLogger(NewWebService.class.getCanonicalName());

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @Override
    @WebMethod(operationName = "changePatient")
    public void changePatient(@WebParam(name = "PL") ArrayList<Patient> PL) throws Exception {
        try {
            backend.changePatient(PL);
        } catch (Exception e) {
            log.severe("An error in changePatient " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "changeMeeting")
    public void changeMeeting(@WebParam(name = "ML") ArrayList<Meeting> ML) throws Exception {
        try {
            backend.changeMeeting(ML);
        } catch (Exception e) {
            log.severe("An error in changeMeeting " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "changeServices")
    public void changeServices(@WebParam(name = "SL") ArrayList<Services> SL) throws Exception {
        try {
            backend.changeServices(SL);
        } catch (Exception e) {
            log.severe("An error in changeServices " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "AddPatiant")
    public void AddPatiant(@WebParam(name = "p") Patient p) throws Exception {
        try {
            backend.AddPatiant(p);
        } catch (Exception e) {
            log.severe("An error in AddPatiant " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "DelPatient")
    public void DelPatient(@WebParam(name = "p") Patient p) throws Exception {
        try {
            backend.DelPatient(p);
        } catch (Exception e) {
            log.severe("An error in DelPatient " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "AddMeeting")
    public void AddMeeting(@WebParam(name = "m") Meeting m) throws Exception {
        try {
            backend.AddMeeting(m);
        } catch (Exception e) {
            log.severe("An error in AddMeeting " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "DelMeeting")
    public void DelMeeting(@WebParam(name = "m") Meeting m) throws Exception {
        try {
            backend.DelMeeting(m);
        } catch (Exception e) {
            log.severe("An error in DelMeeting " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "AddService")
    public void AddService(@WebParam(name = "s") Services s) throws Exception {
        try {
            backend.AddService(s);
        } catch (Exception e) {
            log.severe("An error in AddService " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "DelService")
    public void DelService(@WebParam(name = "s") Services s) throws Exception {
        try {
            backend.DelService(s);
        } catch (Exception e) {
            log.severe("An error in DelService " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "GetAllPatient")
    public ArrayList<Patient> GetAllPatient() throws Exception {
        try {
            return backend.GetAllPatient();
        } catch (Exception e) {
            log.severe("An error in GetAllPatient " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "GetAllServices")
    public ArrayList<Services> GetAllServices() throws Exception {
        try {
            return backend.GetAllServices();
        } catch (Exception e) {
            log.severe("An error in GetAllServices " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "GetAllMeetings")
    public ArrayList<Meeting> GetAllMeetings() throws Exception {
        try {
            return backend.GetAllMeetings();
        } catch (Exception e) {
            log.severe("An error in GetAllMeetings " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "GetPatientMeeting")
    public ArrayList<Meeting> GetPatientMeeting(@WebParam(name = "p") Patient p) throws Exception {
        try {
            return backend.GetPatientMeeting(p);
        } catch (Exception e) {
            log.severe("An error in GetPatientMeeting " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "CalcPatientUnpaidMeeting")
    public double CalcPatientUnpaidMeeting(@WebParam(name = "p") Patient p) throws Exception {
        try {
            return backend.CalcPatientUnpaidMeeting(p);
        } catch (Exception e) {
            log.severe("An error in GetPatientMeeting " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "CalcPatientPaid")
    public double CalcPatientPaid(@WebParam(name = "p") Patient p) throws Exception {
        try {
            return backend.CalcPatientPaid(p);
        } catch (Exception e) {
            log.severe("An error in CalcPatientPaid " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "CalcPatientTotalCost")
    public double CalcPatientTotalCost(@WebParam(name = "p") Patient p) throws Exception {
           try {
            return backend.CalcPatientTotalCost(p);
        } catch (Exception e) {
            log.severe("An error in CalcPatientTotalCost " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "CalcAllPatientTotalCost")
    public double CalcAllPatientTotalCost(@WebParam(name = "metting") ArrayList<Meeting> metting) throws Exception {
         try {
            return backend.CalcAllPatientTotalCost(metting);
        } catch (Exception e) {
            log.severe("An error in CalcAllPatientTotalCost " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "counselingType")
    public ArrayList<String> counselingType() throws Exception {
           try {
            return backend.counselingType();
        } catch (Exception e) {
            log.severe("An error in counselingType " + e);
            throw new Exception("Server Error");
        }
    }

    @Override
    @WebMethod(operationName = "treatmentType")
    public ArrayList<String> treatmentType() throws Exception {
          try {
            return backend.treatmentType();
        } catch (Exception e) {
            log.severe("An error in treatmentType " + e);
            throw new Exception("Server Error");
        }
    }
}
