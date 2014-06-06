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
                webservice.NewWebService_Service service = new webservice.NewWebService_Service();
                webservice.NewWebService port = service.getNewWebServicePort();
                // TODO process result here
                java.util.List<webservice.Patient> patient = port.getAllPatient();
                java.util.List<webservice.Meeting> meeting = port.getAllMeetings();
                java.util.List<webservice.Services> services = port.getAllServices();
                JSONArray patientJson = new JSONArray();
                JSONArray meetingJson = new JSONArray();
                JSONArray serviceJson = new JSONArray();

                for (webservice.Patient p : patient) {
                    JSONObject patientD = new JSONObject();
                    patientD.put("id", p.getId());
                    patientD.put("name", p.getName());
                    patientD.put("phone", p.getPhone());
                    patientJson.put( patientD);
                }
                for (webservice.Services s : services) {
                    JSONObject serviceD = new JSONObject();
                    serviceD.put("id", s.getId());
                    serviceD.put("price", s.getPrice());
                    serviceD.put("nameOf", s.getNameOfAttendant());
                    if (s instanceof webservice.Treatment) {
                        serviceD.put("problem", ((webservice.Treatment) s).getProblem());
                        serviceD.put("type", ((webservice.Treatment) s).getTypes());
                    } else if (s instanceof webservice.Counseling) {
                        serviceD.put("type", ((webservice.Counseling) s).getTyps().name());
                    }
                    patientJson.put( serviceD);
                }
                int met=1;
                for (webservice.Meeting m : meeting) {
                    JSONObject meetingD = new JSONObject();
                    meetingD.put("no", met++);
                    meetingD.put("id", m.getId());
//                    meetingD.put("date", m.getDate().toXMLFormat());
                    meetingD.put("patient-name", m.getPatient().getName());
                    meetingD.put("patient-id", m.getPatient().getId());
                    meetingD.put("service-id", m.getService().getId());
                    meetingD.put("service-name", m.getService().getNameOfAttendant().toString());
                    meetingD.put("isPaid", m.isPayed().toString());

                    meetingJson.put( meetingD);
                }
                if (func.equals("meeting")) {

                    out.print(meetingJson);
                }
                if (func.equals("service")) {

                    out.print(serviceJson);
                }
                if (func.equals("pat")) {

                    out.print(patientJson);
                }

            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        %>
        <%-- end web service invocation --%>
