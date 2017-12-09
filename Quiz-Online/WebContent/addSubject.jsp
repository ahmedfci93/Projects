<%@page import="Model.userbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
<%  
  if(session.getAttribute("userbean")!=null){
    userbean user=(userbean)request.getSession().getAttribute("userbean");
   System.out.println("User type value is: "+user.getUsertype());
    if( user.getUsertype() != 2){
        System.out.println("run");
        response.sendRedirect(request.getContextPath() + "/Logout");}
    else{
        response.sendRedirect("index.jsp");
    }
  }else{
        response.sendRedirect("index.jsp");
    }


%>
    <body>
        <form action='SubjectController' name="addSubject">
            <input
                type="hidden" name="action" value="insert" />
            <p><b>Add New Record</b></p>
            <table>
                <tr>
                    <td>Subject name</td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
        <p><a href="SubjectController?action=listsubject">View-All-Records</a></p>
    </body>
</html>
