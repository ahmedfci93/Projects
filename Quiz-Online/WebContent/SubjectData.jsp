<%@page import="Model.userbean"%>
<%@page import="Model.SubjectHelper"%>
<%@page import="Model.SubjectBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
        <%
        SubjectHelper subH = new SubjectHelper();
            List<SubjectBean> l = subH.getallSubjectbean();

        %>
        <table border="1" align="center" >
            <caption> user information</caption>
            <tr>

                <th>Id</th>
                <th>Subject Name</th>
                <th>Action</th>
              
            </tr>
            <tr>
                <%        for (SubjectBean subB : l) {


                %>
                <td><%=subB.getId()%></td>
				<td><%=subB.getName()%></td>
                <td><a
                        href="updateSubject.jsp?Id=<%=subB.getId()%>">Update</a>
                        <a
                        href="SubjectController?action=delete&Id=<%=subB.getId()%>">Delete</a>
                </td>
              
            </tr>
            <%
                }
            %>
        </table>

        <p align="center"><a href="addSubject.jsp">Add Subject</a></p>
    </body>
</html>
