package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.QuizBean;
import Model.QuizHelper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class QuizController
 */
public class QuizController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String INSERT = "/addQuiz.jsp";
    private static String Edit = "/updateQuiz.jsp";
    private static String quizData = "/quizData.jsp";
    private static String delete = "/deleteQuiz.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String redirect = "";
        String qId = request.getParameter("Id");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("insert")) {
            QuizBean quizB = new QuizBean();
            String quizName = request.getParameter("quizName");
            String subjectId = request.getParameter("subjectId");
            String visible =  request.getParameter("visible");
            quizB.setId(qId);
            quizB.setName(quizName);
            quizB.setSubject_id(subjectId);
            quizB.setVisible(visible);

            try {
                new QuizHelper().insertQuiz(quizB);
            } catch (SQLException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=quizData;
        } else if (action.equalsIgnoreCase("update")) {
            QuizBean quizB2=new QuizBean();
            quizB2.setId(qId);
            quizB2.setName(request.getParameter("quizName"));
            quizB2.setSubject_id(request.getParameter("subjectId"));
            quizB2.setVisible(request.getParameter("visible"));
            
            System.out.println(qId);
            System.out.println(quizB2.getName());
            System.out.println(quizB2.getSubject_id());
            System.out.println(quizB2.getVisible());
            
            try {
                new QuizHelper().updateQuiz(quizB2);
            } catch (SQLException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=quizData;
        } else if (action.equalsIgnoreCase("delete")) {
            String id = (String)(request.getParameter("Id"));
            try {
                new QuizHelper().deleteQuiz(id);
            } catch (SQLException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
            }
            redirect=quizData;
        }
        else if (action.equalsIgnoreCase("listsubject")) {
            redirect = quizData;
            try {
                request.setAttribute("users",new QuizHelper().getallQuizbean() );
            } catch (SQLException ex) {
                Logger.getLogger(QuizController.class.getName()).log(Level.SEVERE, null, ex);
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
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
