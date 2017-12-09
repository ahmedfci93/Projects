
<%@page import="Model.userbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.QuizBean" %>
<%@page import="Model.QuizHelper" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
 
        <%
        QuizHelper quizH = new QuizHelper();
         List<QuizBean> l = quizH.getallQuizbean();
        %>
        
        <table border="1" align="center" >
            <caption> user information</caption>
            <tr>

                <th>Id</th>
                <th>Quiz Name</th>
                <th>Subject Id</th>
                <th>Visible</th>
              
            </tr>
            <tr>
                <%        for (QuizBean quizB : l) {


                %>
                <td><%=quizB.getId()%></td>
				<td><a href="questionData.jsp?qz=<%=quizB.getId()%>"><%=quizB.getName()%></a></td>
				<td><%=quizB.getSubject_id()%></td>
				<td><%=quizB.getVisible()%></td>
                <td><a
                        href="updateQuiz.jsp?Id=<%=quizB.getId()%>">Update</a>
                        <a
                        href="QuizController?action=delete&Id=<%=quizB.getId()%>">Delete</a>
                </td>
              
            </tr>
            <%
                }
            %>
        </table>

        <p align="center"><a href="addQuiz.jsp">Add Quiz</a></p>
    </body>
</html>
