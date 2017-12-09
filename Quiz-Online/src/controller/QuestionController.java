package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import Model.QuestionBean;
import Model.QuestionHelper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class QuestionController
 */

public class QuestionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addQuestion.jsp";
    private static String Edit = "/updateQuestion.jsp";
    private static String questionData = "/questionData.jsp";
    private static String delete = "/deleteQuestion.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionController() {
        super();
    }
        // TODO Auto-generated constructor stub
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String redirect = "";
        String qId = request.getParameter("id");
        String Question = request.getParameter("Question");
        String QuizId = request.getParameter("qz");
        INSERT="/addQuestion.jsp?qz="+QuizId;
        
        String answer1 =  request.getParameter("answer1");
        String answer2 =  request.getParameter("answer2");
        String answer3 =  request.getParameter("answer3");
        String answer4 =  request.getParameter("answer4");
        String correctanswer =  request.getParameter("correctanswer");
        String action = request.getParameter("action");
        String qesCorrectAnswer="";
        System.out.println(action);
        switch(correctanswer)
        {
        case "1":
      	  qesCorrectAnswer=answer1;
      	  break;
        case "2":
      	  qesCorrectAnswer=answer2;
      	  break;
        case "3":
      	  qesCorrectAnswer=answer3;
      	  break;
        case "4":
      	  qesCorrectAnswer=answer4;
      	  break;
      	  
        }
       
        if (action.equalsIgnoreCase("insert")) {
            QuestionBean quesB = new QuestionBean();
            
            quesB.setId(qId);
            quesB.setQuestion(Question);
            quesB.setQuiz_id(QuizId);
            quesB.setAnswer1(answer1);
            quesB.setAnswer2(answer2);
            quesB.setAnswer3(answer3);
            quesB.setAnswer4(answer4);
            quesB.setCorrectAnswer(qesCorrectAnswer);
            
            try {
                new QuestionHelper().insertQuestion(quesB);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=questionData+"?qz="+QuizId;
        } else if (action.equalsIgnoreCase("update")) {
        	String id1 = (String)(request.getParameter("Id"));
             Question = request.getParameter("Question");
             QuizId = request.getParameter("QuizId");
              answer1 =  request.getParameter("answer1");
              answer2 =  request.getParameter("answer2");
              answer3 =  request.getParameter("answer3");
              answer4 =  request.getParameter("answer4");
              correctanswer =  request.getParameter("correctanswer");
              
              
              System.out.println(action);
              System.out.println(id1);
              System.out.println(QuizId);
              System.out.println(Question);
              System.out.println(answer1);
              System.out.println(answer2);
              System.out.println(answer3);
              System.out.println(answer4);
           //----------------------------------------------
            QuestionBean quesB2=new QuestionBean();
            quesB2.setId(id1);
            quesB2.setQuestion(Question);
            quesB2.setQuiz_id(QuizId);
            quesB2.setAnswer1(answer1);
            quesB2.setAnswer2(answer2);
            quesB2.setAnswer3(answer3);
            quesB2.setAnswer4(answer4);
            quesB2.setCorrectAnswer(qesCorrectAnswer);

            try {
                new QuestionHelper().updateQuestion(quesB2);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=questionData+"?qz="+QuizId;
        } 
        else if (action.equalsIgnoreCase("delete")) {
            String id = (String)(request.getParameter("Id"));
            try {
                new QuestionHelper().deleteQuestion(id);
            } catch (SQLException ex) {
                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=questionData;
        }
        else if (action.equalsIgnoreCase("listsubject")) {
            redirect = questionData+"?qz="+QuizId;;
            try {
                request.setAttribute("users",new QuestionHelper().getallQuestionbean() );
            } catch (SQLException ex) {
                Logger.getLogger(QuestionController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            redirect=INSERT;
        }
         RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
