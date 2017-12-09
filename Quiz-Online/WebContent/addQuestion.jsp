<%@page import="Model.userbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--  --><%String quiz_id=request.getParameter("qz");
if(quiz_id==null)
	quiz_id="not found";
%>
</head>
<body>
  
	<form action='QuestionController' name="addQuestion" method="post">
            <input
                type="hidden" name="action" value="insert" />
            <p><b>Add New Record</b></p>
            <table>
                <tr>
                    <td>Question</td>
                    <td><input type="text" name="Question" /></td>
                </tr>
                <tr>
                    <td>Quiz id</td>
                    <td>
                    <input type="text" name="qz" readonly="readonly" value="<%=quiz_id%>" >
                    </td>
                </tr>
                <tr>
                    <td>answer1</td>
                    <td><input type="text" name="answer1" /></td>
                </tr>
                <tr>
                    <td>answer2</td>
                    <td><input type="text" name="answer2" /></td>
                </tr>
                <tr>
                    <td>answer3</td>
                    <td><input type="text" name="answer3" /></td>
                </tr>
                <tr>
                    <td>answer4</td>
                    <td><input type="text" name="answer4" /></td>
                </tr>
                <tr>
                    <td>correctAnswer</td>
                    <td>
                    <select name="correctanswer">
                    <option value="1">Answer1</option>
                    <option value="2">Answer2</option>
                    <option value="3">Answer3</option>
                    <option value="4">Answer4</option>
                    </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit" /></td>
                </tr>
            </table>
        </form>
        <p><a href="QuizController?action=listQuiz">View-All-Records</a></p>
</body>
</html>