/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclinic;


import TreatmentD.Counseling;
import TreatmentD.CounselingJpaController ;
import TreatmentD.Meeting;
import TreatmentD.Patient;
import TreatmentD.Services;
import TreatmentD.Treatment;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Dell
 */
public class toolsRandoData {

    private List<Patient> _patient;
    private List<Services> _services;
    private List<Meeting> _metting;
    private Faker f;
    private Random r;

    /**
     *
     */
    public toolsRandoData() {
        _patient = new ArrayList<Patient>();
        _services = new ArrayList<Services>();
        _metting = new ArrayList<Meeting>();
        f = new Faker();
        r = new Random();
    }

    private Patient buildPatient() {
        String name = f.name();
        int id = r.nextInt();
        String phone = f.phoneNumber();
        Patient p = new Patient(name, id, phone);
        return p;
    }

    private Services BuildService() {
        String name = f.name();
        int id = r.nextInt();
        String phone = f.phoneNumber();
        Date d = new Date();
        double price = r.nextDouble() % 250;
        Services.TypesCons typeC = Services.TypesCons.ACUPNCTURE;
        Services.TypesTret typeT = Services.TypesTret.ACUPNCTURE;
        String problem = f.paragraph();

        Patient p = new Patient(name, id, phone);
        Services s;
        if (r.nextInt() % 2 == 0) {
            s = new Counseling(typeC, id, d, price, name);
        } else {
            s = new Treatment(typeT, problem, id, d, price, name);
        }
        return s;
    }

    public ArrayList<Patient> addListofPatient(int NumOfPatient) {
        ArrayList<Patient> ret = new ArrayList<>();
        for (int i = 0; i < NumOfPatient; i++) {
            ret.add(this.buildPatient());
        }
        return ret;
    }

    public ArrayList<Meeting> addListOfMeeting(ArrayList<Patient> ps, int MaxNumOfMeetingForEach) {
        ArrayList<Meeting> m = new ArrayList<>();
        for (int i = 0; i < MaxNumOfMeetingForEach; i++) {
            for (Patient p : ps) {
                if (r.nextInt() % MaxNumOfMeetingForEach != 0) {
                    m.add(new Meeting(p, BuildService(),new Date()));
                }
            }
        }
        return m;
    }
    public ArrayList<Services> addListOfServices(int NumOfService){
        ArrayList<Services> s = new ArrayList<>();
        for (int i = 0; i < NumOfService; i++) {
            s.add(BuildService());
        }
        return s;
        }
}
