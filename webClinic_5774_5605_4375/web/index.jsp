<%-- 
    Document   : index
    Created on : 05/06/2014, 23:14:50
    Author     : Admin
--%>

<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONSerializer"%>
<%@page import="org.json.JSONArray"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="he" dir="rtl" ng-app="javapro">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.16/angular.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.16/angular-route.min.js"></script>
        <script src="js/myapp.js"></script>
        <link rel="stylesheet" href=" //cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap-rtl.css">
        <link rel="stylesheet" href=" //cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css">

<%
                        JSONObject ob = new JSONObject();
                        JSONObject ob1 = new JSONObject();
                    try {
                        JSONArray g = new JSONArray();
                        JSONSerializer s = new JSONSerializer();
                        webservice.NewWebService_Service service = new webservice.NewWebService_Service();
                        webservice.NewWebService port = service.getNewWebServicePort();
                        // TODO process result here
                        java.util.List<webservice.Meeting> result = port.getAllMeetings();
                        out.println("Result = " + result);
                        out.println("<br>");
                        out.println("<br>");
                        out.println("<br>");
                        ArrayList a = new ArrayList();
                        for (int i = 0; i < 10; i++) {
                            ob.put("name" + i, i);
                        }
ob1.put("m", ob);

                        session.setAttribute("meeting",ob1);
                        String att = session.getAttribute("meeting").toString();
                        out.println("s:" + session.getAttribute("meeting"));
                    } catch (Exception ex) {
                        // TODO handle custom exceptions here
                    }
                %>
                <%-- end web service invocation --%><hr/>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="navbar navbar-inverse " role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#home">עמוד ראשי</a>
                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="#service">services</a></li>
                                <li><a href="#meeting">meeting</a></li>
                                <li><a href="#users">users</a></li>
                                <li><a href="#">Help</a></li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="row">
                <h1>Hello World!</h1>    <%-- start web service invocation --%><hr/>
                
                <div class="view-container">
                    <div ng-view class="view-frame"></div>
                </div>
                <script> 
                  
                </script>
                    
            </div>
        </div>
    </body>
</html>
