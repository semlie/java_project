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
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import webservice.Exception_Exception;

/**
 *
 * @author Admin
 */
public class BackendWSAdapter implements Backend {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    /**
     *
     * @param c
     * @return
     * @throws DatatypeConfigurationException
     * @throws ParseException
     */
    public webservice.Counseling ConvertCounseling(TreatmentD.Counseling c) throws DatatypeConfigurationException, ParseException {
        webservice.Counseling _c = new webservice.Counseling();
        _c.setId(c.getId());
//        XMLGregorianCalendarImpl d=new XMLGregorianCalendarImpl();
//        d.toGregorianCalendar().setTime(c.getDate());
        _c.setDate(convDate(c.getDate()));
        _c.setNameOfAttendant(c.getNameOfAttendant());
        _c.setPrice(c.getPrice());
        _c.setTyps(webservice.TypesCons.valueOf(c.getTyps().name()));
        return _c;
    }

    /**
     *
     * @param d
     * @return
     * @throws DatatypeConfigurationException
     */
    public XMLGregorianCalendar convDate(Date d) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        if (d == null) {
            d = new Date();
        }
        c.setTime(d);
        XMLGregorianCalendar da = new XMLGregorianCalendarImpl();
        da = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        return da;
    }
//   from the auto genertor
//    public void setDate(Date value) throws DatatypeConfigurationException, ParseException {
//        SimpleDateFormat ss = new SimpleDateFormat("yyyy-mm-dd");
//        GregorianCalendar cal = new GregorianCalendar();
//          cal.setTime(stringToJavaDate(ss.format(value)));
//        this.date=DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
//    }

    /**
     *
     * @param c
     * @return
     */
    public TreatmentD.Counseling ConvertCounseling(webservice.Counseling c) throws ParseException {
        TreatmentD.Counseling _c = new TreatmentD.Counseling();
        _c.setId(c.getId());
        _c.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(c.getDate().toString()));
        _c.setNameOfAttendant(c.getNameOfAttendant());
        _c.setPrice(c.getPrice());
        _c.setTyps(TreatmentD.Counseling.TypesCons.valueOf(c.getTyps().name()));
        return _c;
    }

    /**
     *
     * @param t
     * @return
     * @throws DatatypeConfigurationException
     * @throws ParseException
     */
    public webservice.Treatment ConvertTreatment(TreatmentD.Treatment t) throws DatatypeConfigurationException, ParseException {
        webservice.Treatment _t = new webservice.Treatment();
        _t.setDate(convDate(t.getDate()));
        _t.setId(t.getId());
        _t.setNameOfAttendant(t.getNameOfAttendant());
        _t.setPrice(t.getPrice());
        _t.setProblem(t.getProblem());
        _t.setTypes(webservice.TypesTret.valueOf(t.getTypes().name()));
        return _t;
    }

    /**
     *
     * @param t
     * @return
     * @throws ParseException
     */
    public TreatmentD.Treatment ConvertTreatment(webservice.Treatment t) throws ParseException {
        TreatmentD.Treatment _t = new TreatmentD.Treatment();
        _t.setDate(new SimpleDateFormat("MMMM d, yyyy").parse(t.getDate().toString()));
        _t.setId(t.getId());
        _t.setNameOfAttendant(t.getNameOfAttendant());
        _t.setPrice(t.getPrice());
        _t.setProblem(t.getProblem());
        _t.setTypes(TreatmentD.Services.TypesTret.valueOf(t.getTypes().name()));
        return _t;
    }
//
//    public webservice.Services ConvertService(TreatmentD.Services s) throws DatatypeConfigurationException, ParseException {
//        webservice.Services _s = new webservice.Services();
//        _s.setDate(s.getDate());
//        _s.setId(s.getId());
//        _s.setNameOfAttendant(s.getNameOfAttendant());
//        _s.setPrice(s.getPrice());
//        return _s;
//    }
//
//    public TreatmentD.Services ConvertService(webservice.Services s) throws ParseException {
//        TreatmentD.Services _s = new TreatmentD.Services();
//        _s.setId(s.getId());
//        _s.setNameOfAttendant(s.getNameOfAttendant());
//        _s.setPrice(s.getPrice());
//        _s.setDate(s.getDate().toGregorianCalendar().getTime());
//        return _s;
//    }

    /**
     *
     * @param s
     * @return
     * @throws DatatypeConfigurationException
     * @throws ParseException
     */
    public webservice.Services ConvertService(TreatmentD.Services s) throws DatatypeConfigurationException, ParseException {
        webservice.Services _s;
        if (s instanceof TreatmentD.Counseling) {
            _s = new webservice.Counseling();
            _s.setDate(convDate(s.getDate()));
            _s.setId(s.getId());
            _s.setNameOfAttendant(s.getNameOfAttendant());
            _s.setPrice(s.getPrice());
            ((webservice.Counseling) _s).setTyps(webservice.TypesCons.valueOf(((TreatmentD.Counseling) s).getTyps().toString()));
            return _s;
        } else if (s instanceof TreatmentD.Treatment) {
            webservice.Treatment _t = new webservice.Treatment();
            _t.setDate(convDate(s.getDate()));
            _t.setId(s.getId());
            _t.setNameOfAttendant(s.getNameOfAttendant());
            _t.setPrice(s.getPrice());
            _t.setProblem(((TreatmentD.Treatment) s).getProblem());
            ((webservice.Treatment) _t).setTypes(webservice.TypesTret.valueOf(((TreatmentD.Treatment) s).getTypes().toString()));

            return _t;
        }
        return null;
    }

    /**
     *
     * @param s
     * @return
     * @throws ParseException
     */
    public TreatmentD.Services ConvertService(webservice.Services s) throws ParseException {
        TreatmentD.Services _s;
        if (s instanceof webservice.Counseling) {
            _s = new TreatmentD.Counseling();
            _s.setDate(s.getDate().toGregorianCalendar().getTime());
            _s.setId(s.getId());
            _s.setNameOfAttendant(s.getNameOfAttendant());
            _s.setPrice(s.getPrice());
            ((TreatmentD.Counseling) _s).setTyps(TreatmentD.Counseling.TypesCons.valueOf(((webservice.Counseling) s).getTyps().name()));

            return _s;
        } else if (s instanceof webservice.Treatment) {
            TreatmentD.Treatment _t = new TreatmentD.Treatment();
            webservice.Treatment _ss = (webservice.Treatment) s;
            _t.setDate(s.getDate().toGregorianCalendar().getTime());
            _t.setId(s.getId());            _t.setNameOfAttendant(s.getNameOfAttendant());
            _t.setPrice(s.getPrice());
            _t.setProblem(_ss.getProblem());
            ((TreatmentD.Treatment) _t).setTypes(TreatmentD.Treatment.TypesTret.valueOf(((webservice.Treatment) s).getTypes().name()));

            return _t;
        }
        return null;

    }

    /**
     *
     * @param m
     * @return
     * @throws DatatypeConfigurationException
     * @throws ParseException
     */
    public webservice.Meeting convertMeeting(TreatmentD.Meeting m) throws DatatypeConfigurationException, ParseException {
        webservice.Meeting _m = new webservice.Meeting();
        _m.setId(m.getId());
        _m.setPatient(ConvertPatient(m.getPatient()));
        _m.setPayed(m.isPayed());
        
        if (m.getDate()!=null) {
            _m.setDate(convDate(m.getDate()));
        }
        _m.setService(ConvertService(m.getService()));

        return _m;
    }

    /**
     *
     * @param m
     * @return
     * @throws ParseException
     */
    public TreatmentD.Meeting convertMeeting(webservice.Meeting m) throws ParseException {
        TreatmentD.Meeting _m = new TreatmentD.Meeting();
        _m.setId(m.getId());
        _m.setPatient(ConvertPatient(m.getPatient()));
        _m.setPayed(m.isPayed());
        if (m.getDate()!=null) {
            _m.setDate(m.getDate().toGregorianCalendar().getTime());
        }
        _m.setService(ConvertService(m.getService()));
        return _m;
    }

    /**
     *
     * @param p
     * @return
     */
    public webservice.Patient ConvertPatient(TreatmentD.Patient p) {
        webservice.Patient p_WC = new webservice.Patient();
        p_WC.setId(p.getId());
        p_WC.setName(p.getName());
        p_WC.setPhone(p.getPhone());
        return p_WC;
    }

    /**
     *
     * @param p
     * @return
     */
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

    /**
     *
     * @param PL
     * @throws Exception
     */
    @Override
    public void changePatient(ArrayList<Patient> PL) throws Exception {
        ArrayList<webservice.Patient> _PL = new ArrayList<>();
        for (TreatmentD.Patient patient : PL) {
            _PL.add(ConvertPatient(patient));
        }
        this.changePatient(_PL);
    }

    /**
     *
     * @param ML
     * @throws Exception
     */
    @Override
    public void changeMeeting(ArrayList<Meeting> ML) throws Exception {
        ArrayList<webservice.Meeting> _ML = new ArrayList<>();
        for (TreatmentD.Meeting meeting : ML) {
            _ML.add(convertMeeting(meeting));
        }
        this.changeMeeting(_ML);
    }

    /**
     *
     * @param SL
     * @throws Exception
     */
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

    /**
     *
     * @param p
     * @throws Exception
     */
    @Override
    public void DelPatient(Patient p) throws Exception {
        this.delPatient(ConvertPatient(p));

    }

    @Override
    public void AddMeeting(Meeting m) throws Exception {
        this.addMeeting(convertMeeting(m));
    }

    /**
     *
     * @param m
     * @throws Exception
     */
    @Override
    public void DelMeeting(Meeting m) throws Exception {
        this.delMeeting(convertMeeting(m));

    }

    /**
     *
     * @param s
     * @throws Exception
     */
    @Override
    public void AddService(Services s) throws Exception {
        this.addService(ConvertService(s));
    }

    /**
     *
     * @param s
     * @throws Exception
     */
    @Override
    public void DelService(Services s) throws Exception {
        this.delService(ConvertService(s));

    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Patient> GetAllPatient() throws Exception {
        ArrayList<Patient> _p = new ArrayList<>();
        for (webservice.Patient patient : this.getAllPatient()) {
            _p.add(ConvertPatient(patient));
        }
        return _p;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Services> GetAllServices() throws Exception {
        ArrayList<Services> _s = new ArrayList<>();
        for (webservice.Services services : this.getAllServices()) {
            _s.add(ConvertService(services));
        }
        return _s;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Meeting> GetAllMeetings() throws Exception {
        ArrayList<Meeting> _s = new ArrayList<>();
        for (webservice.Meeting meeting : this.getAllMeetings()) {
            _s.add(convertMeeting(meeting));
        }
        return _s;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<Meeting> GetPatientMeeting(Patient p) throws Exception {
        ArrayList<Meeting> _s = new ArrayList<>();
        for (webservice.Meeting meeting : this.getPatientMeeting(ConvertPatient(p))) {
            _s.add(convertMeeting(meeting));
        }
        return _s;
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientUnpaidMeeting(Patient p) throws Exception {
        return this.calcPatientUnpaidMeeting(ConvertPatient(p));
    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientPaid(Patient p) throws Exception {
        return this.calcPatientPaid(ConvertPatient(p));

    }

    /**
     *
     * @param p
     * @return
     * @throws Exception
     */
    @Override
    public double CalcPatientTotalCost(Patient p) throws Exception {
        return this.calcPatientTotalCost(ConvertPatient(p));
    }

    /**
     *
     * @param metting
     * @return
     * @throws Exception
     */
    @Override
    public double CalcAllPatientTotalCost(ArrayList<Meeting> metting) throws Exception {
        ArrayList<webservice.Meeting> _m = new ArrayList<>();
        for (TreatmentD.Meeting meeting : metting) {
            _m.add(convertMeeting(meeting));
        }
        return this.calcAllPatientTotalCost(_m);

    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<String> counselingType() throws Exception {
        return (ArrayList<String>) this.counselingType1();
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    public ArrayList<String> treatmentType() throws Exception {
        return (ArrayList<String>) this.treatmentType1();

    }
}
