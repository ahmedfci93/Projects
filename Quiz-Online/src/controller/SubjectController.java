package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.SubjectBean;
import Model.SubjectHelper;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Servlet implementation class SubjectController
 */
public class SubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static String INSERT = "/addSubject.jsp";
    private static String Edit = "/update.jsp";
    private static String Subjectdata = "/SubjectData.jsp";
    private static String deleteemp = "/delete.jsp";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String redirect = "";
        String sId = request.getParameter("subjectId");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("insert")) {
            SubjectBean subB = new SubjectBean();
            String id = (String)request.getParameter("subjectid");
            String name = request.getParameter("name");
            subB.setId(id);
            subB.setName(name);

            try {
                new SubjectHelper().insertSubject(subB);
                redirect=Subjectdata;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (action.equalsIgnoreCase("update")) {
            String id = (String)(sId);
            SubjectBean subB2=new SubjectBean();
            subB2.setId(id);
            subB2.setName(request.getParameter("subName"));
            
            try {
                new SubjectHelper().updateSubject(subB2);
                redirect=Subjectdata;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (action.equalsIgnoreCase("delete")) {
            String id = (String)(request.getParameter("Id"));
            try {
                new SubjectHelper().deletesubject(id);
                redirect=Subjectdata;
            } catch (SQLException ex) {
                Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else if (action.equalsIgnoreCase("listsubject")) {
            redirect = Subjectdata;
            try {
                request.setAttribute("users",new SubjectHelper().getallSubjectbean() );
            } catch (SQLException ex) {
                Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
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
