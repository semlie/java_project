<%-- 
    Document   : get
    Created on : 06/06/2014, 01:54:59
    Author     : Admin
--%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONSerializer"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="application/json" pageEncoding="UTF-8"%>

<%
    try {
        String func = request.getParameter("f");
        String nameOfP = request.getParameter("name");
        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
        webservice.NewWebService port = service.getNewWebServicePort();
        // TODO process result here
        java.util.List<webservice.Patient> patient = port.getAllPatient();
        java.util.List<webservice.Meeting> meeting = port.getAllMeetings();
        java.util.List<webservice.Services> services = port.getAllServices();
        java.util.List<webservice.Meeting> meetingP = port.getAllMeetings();
        JSONArray patientJson = new JSONArray();
        JSONArray meetingJson = new JSONArray();
        JSONArray meetingJsonP = new JSONArray();
        JSONArray serviceJson = new JSONArray();
        int no = 1;

        for (webservice.Patient p : patient) {
            JSONObject patientD = new JSONObject();
            patientD.put("no", no++);

            patientD.put("id", p.getId());
            patientD.put("name", p.getName());
            patientD.put("phone", p.getPhone());
            patientJson.put(patientD);
        }
        no = 1;
        for (webservice.Services s : services) {
            JSONObject serviceD = new JSONObject();
            serviceD.put("no", no++);

            serviceD.put("id", s.getId());
            serviceD.put("price", s.getPrice());
            serviceD.put("nameOf", s.getNameOfAttendant());
            if (s instanceof webservice.Treatment) {
                serviceD.put("problem", ((webservice.Treatment) s).getProblem());
                 serviceD.put("type", ((webservice.Treatment) s).getTypes().name());
                 serviceD.put("cat", "טיפול");
            } else if (s instanceof webservice.Counseling) {
                serviceD.put("type", ((webservice.Counseling) s).getTyps().name());
                serviceD.put("cat", "יעוץ");
            }
            serviceJson.put(serviceD);
        }
        no = 1;
        for (webservice.Meeting m : meeting) {
            JSONObject meetingD = new JSONObject();
            meetingD.put("no", no++);
            meetingD.put("id", m.getId());
                    meetingD.put("date", m.getDate().toXMLFormat());
            meetingD.put("patientName", m.getPatient().getName());
            meetingD.put("patientId", m.getPatient().getId());
            meetingD.put("serviceId", m.getService().getId());
            meetingD.put("serviceName", m.getService().getNameOfAttendant().toString());
            meetingD.put("isPaid", m.isPayed().toString());

            meetingJson.put(meetingD);
        }
        no = 1;
        for (webservice.Meeting m : meetingP) {

            JSONObject meetingD = new JSONObject();
            meetingD.put("no", no++);
            meetingD.put("id", m.getId());
                    meetingD.put("date", m.getDate().toXMLFormat());
            meetingD.put("patientName", m.getPatient().getName());
            meetingD.put("patientId", m.getPatient().getId());
            meetingD.put("serviceId", m.getService().getId());
            meetingD.put("serviceName", m.getService().getNameOfAttendant().toString());
            meetingD.put("isPaid", m.isPayed().toString());
            if (m.getPatient().getId().toString().equals(nameOfP)) {
                meetingJsonP.put(meetingD);
            }
        }
        if (func.equals("meeting")) {

            out.print(meetingJson);
        }
        if (func.equals("service")) {

            out.print(serviceJson);
        }
        if (func.equals("patient")) {

            out.print(patientJson);
        }
        if (func.equals("userD")) {

            out.print(meetingJsonP);
        }

    } catch (Exception ex) {
        // TODO handle custom exceptions here
    }
%>
<%-- end web service invocation --%>
