<%@page import="Model.userbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
  
        <form action='QuizController' name="addQuiz">
            <input
                type="hidden" name="action" value="insert" />
            <p><b>Add New Record</b></p>
            <table>
                <tr>
                    <td>Quiz name</td>
                    <td><input type="text" name="quizName" /></td>
                </tr>
                <tr>
                    <td>subject id</td>
                    <td><input type="text" name="subjectId" /></td>
                </tr>
                <tr>
                    <td>Visible</td>
                    <td><input type="text" name="visible" /></td>
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
