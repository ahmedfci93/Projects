<%@page import="Model.userbean"%>
<%@page import="Model.QuizBean"%>
<%@page import="Model.QuizHelper"%>
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
        QuizBean quizB = new QuizBean();
        QuizHelper quizH = new QuizHelper();
        %>

        <form method="POST" action='QuizController' >
            <input type="hidden" name="action" value="update" /> <%
                    String qid = request.getParameter("Id");
                   
                        String id = (String)(qid);
                        quizB = quizH.getQuizBeanbyid(id);
                        int subject_id=Integer.parseInt(quizB.getSubject_id());
                        String visible=quizB.getVisible();
            %>
            <table>
                <tr>
                    <td>Quiz ID</td>
                    <td><input type="text" name="Id" readonly="readonly"
                               value="<%=qid%>"></td>
                </tr>
                <tr>
                    <td>Quiz name</td>
                    <td><input type="text" name="quizName" value="<%=quizB.getName()%>" /></td>
                </tr>
                <tr>
                    <td>Subject id</td>
                    <td><input type="text" name="subjectId" value="<%=subject_id%>"/></td>
                </tr>
                <tr>
                    <td>Visible</td>
                    <td><input type="text" name="visible" value="<%=visible%>"/></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Update" /></td>
                </tr>
            </table>
           
        </form>
    </body>
</html>
