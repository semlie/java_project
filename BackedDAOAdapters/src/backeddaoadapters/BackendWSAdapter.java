/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backeddaoadapters;

import Interface.Backend;
import TreatmentD.Meeting;
import TreatmentD.Patient;
import TreatmentD.Services;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import webservice.Exception_Exception;

/**
 *
 * @author Admin
 */
public class BackendWSAdapter implements Backend {

    public static void main(String[] args) {

    }

    public webservice.Counseling ConvertCounseling(TreatmentD.Counseling c) {
        webservice.Counseling _c = new webservice.Counseling();
        _c.setId(c.getId());
        _c.setDate(convDate(c.getDate()));
        _c.setNameOfAttendant(c.getNameOfAttendant());
        _c.setPrice(c.getPrice());
        _c.setTyps(webservice.TypesCons.valueOf(c.getTyps().name()));
        return _c;
    }

    public XMLGregorianCalendarImpl convDate(Date d) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(d);
        return new XMLGregorianCalendarImpl(calendar);
    }

    /**
     *
     * @param c
     * @return
     */
    public TreatmentD.Counseling ConvertCounseling(webservice.Counseling c) throws ParseException {
        TreatmentD.Counseling _c = new TreatmentD.Counseling();
        _c.setId(c.getId());
        _c.setDate(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(c.getDate().toString()));
        _c.setNameOfAttendant(c.getNameOfAttendant());
        _c.setPrice(c.getPrice());
        _c.setTyps(TreatmentD.Counseling.TypesCons.valueOf(c.getTyps().name()));
        return _c;
    }

    public webservice.Treatment ConvertTreatment(TreatmentD.Treatment t) {
        webservice.Treatment _t = new webservice.Treatment();
        _t.setDate(convDate(t.getDate()));
        _t.setId(t.getId());
        _t.setNameOfAttendant(t.getNameOfAttendant());
        _t.setPrice(t.getPrice());
        _t.setProblem(t.getProblem());
        _t.setTypes(webservice.TypesTret.valueOf(t.getTypes().name()));
        return _t;
    }

    public TreatmentD.Treatment ConvertTreatment(webservice.Treatment t) throws ParseException {
        TreatmentD.Treatment _t = new TreatmentD.Treatment();
        _t.setDate(new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH).parse(t.getDate().toString()));
        _t.setId(t.getId());
        _t.setNameOfAttendant(t.getNameOfAttendant());
        _t.setPrice(t.getPrice());
        _t.setProblem(t.getProblem());
        _t.setTypes(TreatmentD.Services.TypesTret.valueOf(t.getTypes().name()));
        return _t;
    }

    public webservice.Services ConvertService(TreatmentD.Services s) {
        webservice.Services _s;
        if (s instanceof TreatmentD.Counseling) {
            _s = new webservice.Counseling();
            _s.setDate(convDate(s.getDate()));
            _s.setId(s.getId());
            _s.setNameOfAttendant(s.getNameOfAttendant());
            _s.setPrice(s.getPrice());

            return _s;
        } else {
            webservice.Treatment _t = new webservice.Treatment();
            TreatmentD.Treatment _ss = new TreatmentD.Treatment((TreatmentD.Treatment) s);

            _t.setDate(convDate(s.getDate()));
            _t.setId(s.getId());
            _t.setNameOfAttendant(s.getNameOfAttendant());
            _t.setPrice(s.getPrice());
            _t.setProblem(_ss.getProblem());

            return _t;
        }

    }

    public TreatmentD.Services ConvertService(webservice.Services s) throws ParseException {
        TreatmentD.Services _s;
        if (s instanceof webservice.Counseling) {
            _s = new TreatmentD.Counseling(ConvertCounseling((webservice.Counseling) s));
        } else {
            _s = new TreatmentD.Treatment(ConvertTreatment((webservice.Treatment) s));

        }

        return _s;

    }

    public webservice.Meeting convertMeeting(TreatmentD.Meeting m) {
        webservice.Meeting _m = new webservice.Meeting();
        _m.setId(m.getId());
        _m.setPatient(ConvertPatient(m.getPatient()));
        _m.setPayed(m.isPayed());
        _m.setPayed(m.isPayed());
        _m.setService(ConvertService(m.getService()));
        return _m;
    }

    public TreatmentD.Meeting convertMeeting(webservice.Meeting m) throws ParseException {
        TreatmentD.Meeting _m = new TreatmentD.Meeting();
        _m.setId(m.getId());
        _m.setPatient(ConvertPatient(m.getPatient()));
        _m.setPayed(m.isPayed());
        _m.setPayed(m.isPayed());
        _m.setService(ConvertService(m.getService()));
        return _m;
    }

    public webservice.Patient ConvertPatient(TreatmentD.Patient p) {
        webservice.Patient p_WC = new webservice.Patient();
        p_WC.setId(p.getId());
        p_WC.setName(p.getName());
        p_WC.setPhone(p.getPhone());
        return p_WC;
    }

    public TreatmentD.Patient ConvertPatient(webservice.Patient p) {
        TreatmentD.Patient p_WC = new TreatmentD.Patient();
        p_WC.setId(p.getId());
        p_WC.setName(p.getName());
        p_WC.setPhone(p.getPhone());
        return p_WC;
    }

    private static void addMeeting(webservice.Meeting m) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.addMeeting(m);
    }

    private static void addPatiant(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.addPatiant(p);
    }

    private static void addService(webservice.Services s) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.addService(s);
    }

    private static double calcAllPatientTotalCost(java.util.List<webservice.Meeting> metting) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.calcAllPatientTotalCost(metting);
    }

    private static double calcPatientPaid(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.calcPatientPaid(p);
    }

    private static double calcPatientTotalCost(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.calcPatientTotalCost(p);
    }

    private static double calcPatientUnpaidMeeting(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.calcPatientUnpaidMeeting(p);
    }

    private static void delMeeting(webservice.Meeting m) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.delMeeting(m);
    }

    private static void delPatient(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.delPatient(p);
    }

    private static void delService(webservice.Services s) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.delService(s);
    }

    private static java.util.List<webservice.Meeting> getAllMeetings() throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.getAllMeetings();
    }

    private static java.util.List<webservice.Patient> getAllPatient() throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.getAllPatient();
    }

    private static java.util.List<webservice.Services> getAllServices() throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.getAllServices();
    }

    private static java.util.List<webservice.Meeting> getPatientMeeting(webservice.Patient p) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.getPatientMeeting(p);
    }

    private static void changeMeeting(java.util.List<webservice.Meeting> ml) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.changeMeeting(ml);
    }

    private static void changePatient(java.util.List<webservice.Patient> pl) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.changePatient(pl);
    }

    private static void changeServices(java.util.List<webservice.Services> sl) throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        port.changeServices(sl);
    }

    private static java.util.List<java.lang.String> counselingType1() throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.counselingType();
    }

    private static java.util.List<java.lang.String> treatmentType1() throws Exception_Exception {
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        return port.treatmentType();
    }

    @Override
    public void changePatient(ArrayList<Patient> PL) throws Exception {
        ArrayList<webservice.Patient> _PL = new ArrayList<>();
        for (TreatmentD.Patient patient : PL) {
            _PL.add(ConvertPatient(patient));
        }
        this.changePatient(_PL);
    }

    @Override
    public void changeMeeting(ArrayList<Meeting> ML) throws Exception {
        ArrayList<webservice.Meeting> _ML = new ArrayList<>();
        for (TreatmentD.Meeting meeting : ML) {
            _ML.add(convertMeeting(meeting));
        }
        this.changeMeeting(_ML);
    }

    @Override
    public void changeServices(ArrayList<Services> SL) throws Exception {
        ArrayList<webservice.Services> _SL = new ArrayList<>();
        for (TreatmentD.Services services : SL) {
            _SL.add(ConvertService(services));
        }
        this.changeServices(_SL);
    }

    @Override
    public void AddPatiant(Patient p) throws Exception {
        this.addPatiant(ConvertPatient(p));
    }

    @Override
    public void DelPatient(Patient p) throws Exception {
        this.delPatient(ConvertPatient(p));

    }

    @Override
    public void AddMeeting(Meeting m) throws Exception {
        this.addMeeting(convertMeeting(m));
    }

    @Override
    public void DelMeeting(Meeting m) throws Exception {
        this.delMeeting(convertMeeting(m));

    }

    @Override
    public void AddService(Services s) throws Exception {
        this.addService(ConvertService(s));
    }

    @Override
    public void DelService(Services s) throws Exception {
        this.delService(ConvertService(s));

    }

    @Override
    public ArrayList<Patient> GetAllPatient() throws Exception {
        ArrayList<Patient> _p = new ArrayList<>();
        for (webservice.Patient patient : this.getAllPatient()) {
            _p.add(ConvertPatient(patient));
        }
        return _p;
    }

    @Override
    public ArrayList<Services> GetAllServices() throws Exception {
        ArrayList<Services> _s = new ArrayList<>();
        for (webservice.Services services : this.getAllServices()) {
            _s.add(ConvertService(services));
        }
        return _s;
    }

    @Override
    public ArrayList<Meeting> GetAllMeetings() throws Exception {
        ArrayList<Meeting> _s = new ArrayList<>();
        for (webservice.Meeting meeting : this.getAllMeetings()) {
            _s.add(convertMeeting(meeting));
        }
        return _s;
    }

    @Override
    public ArrayList<Meeting> GetPatientMeeting(Patient p) throws Exception {
        ArrayList<Meeting> _s = new ArrayList<>();
        for (webservice.Meeting meeting : this.getPatientMeeting(ConvertPatient(p))) {
            _s.add(convertMeeting(meeting));
        }
        return _s;
    }

    @Override
    public double CalcPatientUnpaidMeeting(Patient p) throws Exception {
        return this.calcPatientUnpaidMeeting(ConvertPatient(p));
    }

    @Override
    public double CalcPatientPaid(Patient p) throws Exception {
        return this.calcPatientPaid(ConvertPatient(p));

    }

    @Override
    public double CalcPatientTotalCost(Patient p) throws Exception {
        return this.calcPatientTotalCost(ConvertPatient(p));
    }

    @Override
    public double CalcAllPatientTotalCost(ArrayList<Meeting> metting) throws Exception {
        ArrayList<webservice.Meeting> _m = new ArrayList<>();
        for (TreatmentD.Meeting meeting : metting) {
            _m.add(convertMeeting(meeting));
        }
        return this.calcAllPatientTotalCost(_m);

    }

    @Override
    public ArrayList<String> counselingType() throws Exception {
        return (ArrayList<String>) this.counselingType1();
    }

    @Override
    public ArrayList<String> treatmentType() throws Exception {
        return (ArrayList<String>) this.treatmentType1();

    }
}
