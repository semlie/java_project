/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treatments;

import Interface.Backend;
import Treatments.Counseling;
import Treatments.Meeting;
import Treatments.Patient;
import Treatments.Services;
import Treatments.Treatment;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Dell
 */
public class Backend_DAO_List_impl implements Backend {

    private List<Patient> _patient;
    private List<Services> _services;
    private List<Meeting> _metting;

    /**
     * for esay test get list of patiens
     *
     * @param PL
     */
    public void changePatient(ArrayList<Patient> PL) {
        this._patient = PL;
    }

    /**
     * for esay test get list of Meeting
     *
     * @param ML
     */
    public void changeMeeting(ArrayList<Meeting> ML) {
        this._metting = ML;
    }

    /**
     * for esay test get list of Services;
     *
     * @param SL
     */
    public void changeServices(ArrayList<Services> SL) {
        this._services = SL;
    }

    public Backend_DAO_List_impl() {
        _patient = new ArrayList<Patient>();
        _services = new ArrayList<Services>();
        _metting = new ArrayList<Meeting>();
    }

    @Override
    public void AddPatiant(Patient p) throws Exception {
        _patient.add(p);

    }

    @Override
    public void AddMeeting(Meeting m) throws Exception {
        _metting.add(m);
    }

    /**
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void DelPatient(Patient p) throws Exception {
        _patient.remove(p);
    }

    /**
     *
     * @param m
     * @throws Exception
     */
    @Override
    public void DelMeeting(Meeting m) throws Exception {
        _metting.remove(m);
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    @Override
    public void AddService(Services s) throws Exception {
        _services.add(s);
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    @Override
    public void DelService(Services s) throws Exception {
        _services.remove(s);
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public ArrayList<Patient> GetAllPatient() throws Exception {
        return (ArrayList<Patient>) _patient;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public ArrayList<Services> GetAllServices() throws Exception {
        return (ArrayList<Services>) _services;
    }

    /**
     *
     * @return @throws Exception
     */
    @Override
    public ArrayList<Meeting> GetAllMeetings() throws Exception {
        return (ArrayList<Meeting>) _metting;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Meeting> GetPatientMeeting(Patient p) throws Exception {
        ArrayList<Meeting> ret = new ArrayList<Meeting>();
        for (Meeting meet : _metting) {
            if (meet.getPatient() == p) {
                ret.add(meet);
            }
        }
        return ret;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientUnpaidMeeting(Patient p) throws Exception {
        double ret = 0;
        for (Meeting meet : _metting) {
            if (meet.getPatient() == p) {
                if (!meet.isPayed()) {
                    ret += meet.getService().getPrice();
                }
            }
        }
        return ret;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientPaid(Patient p) throws Exception {
        double ret = 0;
        for (Meeting meet : _metting) {
            if (meet.getPatient() == p) {
                if (meet.isPayed()) {
                    ret += meet.getService().getPrice();
                }

            }
        }
        return ret;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientTotalCost(Patient p) throws Exception {
        return this.CalcPatientPaid(p) + this.CalcPatientUnpaidMeeting(p);
    }

    /**
     *
     * @param meeting
     * @return
     * @throws Exception
     */
    @Override
    public double CalcAllPatientTotalCost(ArrayList<Meeting> meeting) throws Exception {
        double ret = 0;

        for (Meeting meet : meeting) {
            ret += meet.getService().getPrice();
        }
        return ret;
    }

    @Override
    public ArrayList<String> treatmentType() throws Exception{
        ArrayList<String> v = new ArrayList<>();

        for (Object o : Treatments.Services.TypesTret.values()) {
            v.add(o.toString());
        }
        return v;
    }

    @Override
    public ArrayList<String> counselingType() throws Exception{
        ArrayList<String> v = new ArrayList<>();
        for (Object o : Treatments.Services.TypesCons.values()) {
            v.add(o.toString());
        }
        return v;

    }
}
