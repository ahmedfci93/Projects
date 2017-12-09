<%@page import="Model.userbean"%>
<%@page import="Model.SubjectBean"%>
<%@page import="Model.SubjectHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
        SubjectBean subB = new SubjectBean();
        SubjectHelper subH = new SubjectHelper();
        %>

        <form method="POST" action='SubjectController' >
            <input type="hidden" name="action" value="update" /> <%
                    String sid = request.getParameter("Id");
                   
                        String id = (String)(sid);
                        subB = subH.getSubjectBeanbyid(id);
            %>
            <table>
                <tr>
                    <td>Subject ID</td>
                    <td><input type="text" name="subjectId" readonly="readonly"
                               value="<%=subB.getId()%>"></td>
                </tr>
                <tr>
                    <td>subject name</td>
                    <td><input type="text" name="subName" /></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Update" /></td>
                </tr>
            </table>
           
        </form>
    </body>
</html>
