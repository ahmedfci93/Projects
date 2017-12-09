<%@page import="Model.userbean"%>
<%@page import="Model.QuestionBean" %>
<%@page import="Model.QuestionHelper" %>
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
	  QuestionBean quesB = new QuestionBean();
	  QuestionHelper quesH = new QuestionHelper();
        %>

        <form method="POST" action='QuestionController' >
            <input type="hidden" name="action" value="update" /> 
            <%
                    String qid = request.getParameter("Id");
            		String qzId = request.getParameter("qz");
                   
                        String id = (String)(qid);
                        quesB = quesH.getQuestionBeanbyid(qid);
                        String Correct_Answer=quesB.getCorrectAnswer();
                        
            %>
            <input type="hidden" name="Id" value="<%=quesB.getId() %>" />
            <table>
                <tr>
                    <td>Question</td>
                    <td><input type="text" name="Question" value="<%=quesB.getQuestion()%>"/></td>
                </tr>
                <tr>
                    <td>Quiz id</td>
                    <td><input type="text" name="QuizId" value="<%=qzId%>" /></td>
                </tr>
                <tr>
                    <td>answer1</td>
                    <td><input type="text" name="answer1" value="<%=quesB.getAnswer1()%>" /></td>
                </tr>
                <tr>
                    <td>answer2</td>
                    <td><input type="text" name="answer2" value="<%=quesB.getAnswer2()%>" /></td>
                </tr>
                <tr>
                    <td>answer3</td>
                    <td><input type="text" name="answer3" value="<%=quesB.getAnswer3()%>" /></td>
                </tr>
                <tr>
                    <td>answer4</td>
                    <td><input type="text" name="answer4" value="<%=quesB.getAnswer4()%>" /></td>
                </tr>
                <tr>
                    <td>correctAnswer</td>
                    <td>
                    <select name="correctanswer">
                    <option value="1"<%if(Correct_Answer.equals(quesB.getAnswer1())){%>selected<%} %>>Answer1</option>
                    <option value="2"<%if(Correct_Answer.equals(quesB.getAnswer2())){%>selected<%} %>>Answer2</option>
                    <option value="3"<%if(Correct_Answer.equals(quesB.getAnswer3())){%>selected<%} %>>Answer3</option>
                    <option value="4"<%if(Correct_Answer.equals(quesB.getAnswer4())){%>selected<%} %>>Answer4</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
           
        </form>
</body>
</html>