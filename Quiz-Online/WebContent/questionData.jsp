<%@page import="Model.userbean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Model.QuestionBean" %>
<%@page import="Model.QuestionHelper" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
        QuestionHelper quesH = new QuestionHelper();
	 		String quiz_id=request.getParameter("qz");
            List<QuestionBean> l = quesH.getallQuestionbeanbyQuizid(quiz_id);
           
        %>
        
        <table border="1" align="center" >
            <caption> user information</caption>
            <tr>

                <th>Id</th>
                <th>Question</th>
                <th>Quiz Id</th>
                <th>answer1</th>
                <th>answer2</th>
                <th>answer3</th>
                <th>answer4</th>
                <th>Correct answer</th>
              
            </tr>
            <tr>
                <%        for (QuestionBean quesB : l) {


                %>
                <td><%=quesB.getId()%></td>
				<td><%=quesB.getQuestion()%></td>
				<td><%=quesB.getQuiz_id()%></td>
				<td><%=quesB.getAnswer1()%></td>
				<td><%=quesB.getAnswer2()%></td>
				<td><%=quesB.getAnswer3()%></td>
				<td><%=quesB.getAnswer4()%></td>
				<td><%=quesB.getCorrectAnswer()%></td>
                <td><a
                        href="updateQuestion.jsp?Id=<%=quesB.getId()%>&qz=<%=quiz_id%>">Update</a>
                        <a
                        href="QuestionController?action=delete&Id=<%=quesB.getId()%>">Delete</a>
                </td>
              
            </tr>
            <%
                }
            %>
        </table>

        <p align="center"><a href="addQuestion.jsp?qz=<%=quiz_id %>">Add Question</a></p>
</body>
</html>