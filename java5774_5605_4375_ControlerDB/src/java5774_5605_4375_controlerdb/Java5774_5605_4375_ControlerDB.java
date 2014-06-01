/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java5774_5605_4375_controlerdb;

import Interface.Backend;
import TreatmentD.CounselingJpaController;
import TreatmentD.Meeting;
import TreatmentD.MeetingJpaController;
import TreatmentD.Patient;
import TreatmentD.PatientJpaController;
import TreatmentD.Services;
import TreatmentD.ServicesJpaController;
import TreatmentD.TreatmentJpaController;
import java.util.ArrayList;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Admin
 */
public class Java5774_5605_4375_ControlerDB implements Backend {
    
    private final CounselingJpaController CounselingCtrl;
    private final MeetingJpaController MeetingCtrl;
    private final PatientJpaController PatientCtrl;
    private final ServicesJpaController ServicesCtrl;
    private final TreatmentJpaController TreatmentCtrl;

    public Java5774_5605_4375_ControlerDB() {
        this.TreatmentCtrl = new TreatmentJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));
        this.ServicesCtrl = new ServicesJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));
        this.PatientCtrl = new PatientJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));
        this.MeetingCtrl = new MeetingJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));
        this.CounselingCtrl = new CounselingJpaController(Persistence.createEntityManagerFactory("java5774_5605_4375_modelDBPU"));
    }
    public void changePatient(ArrayList<Patient> PL) {
        for (Patient patient : PL) {
            this.PatientCtrl.create(patient);
        }
    }

    /**
     * for esay test get list of Meeting
     *
     * @param ML
     */
    public void changeMeeting(ArrayList<Meeting> ML) {
        for (Meeting meeting : ML) {
         this.MeetingCtrl.create(meeting);
        }
    }

    /**
     * for esay test get list of Services;
     *
     * @param SL
     */
    public void changeServices(ArrayList<Services> SL) {
        for (Services services : SL) {
            this.ServicesCtrl.create(services);
        }
    }
    /**
     * @param args the command line arguments
     */

    @Override
    public void AddPatiant(Patient p) throws Exception {
        PatientCtrl.create(p);
        
    }
    
    @Override
    public void DelPatient(Patient p) throws Exception {
        PatientCtrl.destroy(p.getId());
    }
    
    @Override
    public void AddMeeting(Meeting m) throws Exception {
        MeetingCtrl.create(m);
    }
    
    @Override
    public void DelMeeting(Meeting m) throws Exception {
        MeetingCtrl.destroy(m.getId());
    }
    
    @Override
    public void AddService(Services s) throws Exception {
        ServicesCtrl.create(s);
    }
    
    @Override
    public void DelService(Services s) throws Exception {
        ServicesCtrl.destroy(s.getId());
    }
    
    @Override
    public ArrayList<Patient> GetAllPatient() throws Exception {
        return (ArrayList<Patient>) PatientCtrl.findPatientEntities();
    }
    
    @Override
    public ArrayList<Services> GetAllServices() throws Exception {
        return (ArrayList<Services>) ServicesCtrl.findServicesEntities();
    }
    
    @Override
    public ArrayList<Meeting> GetAllMeetings() throws Exception {
        return (ArrayList<Meeting>) MeetingCtrl.findMeetingEntities();
    }
    
    @Override
    public ArrayList<Meeting> GetPatientMeeting(Patient p) throws Exception {
        ArrayList<Meeting> _meeting = GetAllMeetings();
        ArrayList<Meeting> _ret = new ArrayList<>();
        
        for (Meeting meeting : _meeting) {
            if (meeting.getPatient() == p) {
                _ret.add(meeting);
            }
        }
        return _ret;
    }
    
    @Override
    public double CalcPatientUnpaidMeeting(Patient p) throws Exception {
        ArrayList<Meeting> _meeting = GetPatientMeeting(p);
        double sum = 0;
        for (Meeting meeting : _meeting) {
            if (!meeting.isPayed()) {
                sum += meeting.getService().getPrice();
            }
        }
        return sum;
    }
    
    @Override
    public double CalcPatientPaid(Patient p) throws Exception {
        ArrayList<Meeting> _meeting = GetPatientMeeting(p);
        double sum = 0;
        for (Meeting meeting : _meeting) {
            if (meeting.isPayed()) {
                sum += meeting.getService().getPrice();
            }
        }
        return sum;
    }
    
    @Override
    public double CalcPatientTotalCost(Patient p) throws Exception {
        return CalcPatientPaid(p) + CalcPatientUnpaidMeeting(p);
    }
    
    @Override
    public double CalcAllPatientTotalCost(ArrayList<Meeting> metting) throws Exception {
                ArrayList<Meeting> _meeting = metting;
        double sum = 0;
        for (Meeting meet : _meeting) {
                sum += meet.getService().getPrice();
            
        }
        return sum;
        
    }
    
    @Override
    public ArrayList<String> counselingType() throws Exception {
              ArrayList<String> v = new ArrayList<>();

        for (Object o : TreatmentD.Services.TypesTret.values()) {
            v.add(o.toString());
        }
        return v;
    }
    
    @Override
    public ArrayList<String> treatmentType() throws Exception {
            ArrayList<String> v = new ArrayList<>();
        for (Object o : TreatmentD.Services.TypesCons.values()) {
            v.add(o.toString());
        }
        return v;
    }
    
}
