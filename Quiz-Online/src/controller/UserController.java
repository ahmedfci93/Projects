/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.userbean;
import Model.userhelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String redirect="";
            userhelper user = null;
            String action = request.getParameter("action");
            
            if(action.equalsIgnoreCase("delete")){
                int id = Integer.parseInt(request.getParameter("id"));
                try {
                    user = new userhelper();
                    user.deleteuser(id);
                    
                    redirect="show user.jsp";
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(action.equalsIgnoreCase("Update")){
                userhelper helper = new userhelper();
                String name = request.getParameter("updatename");
                String username = request.getParameter("updateusername");
                String password = request.getParameter("updatepassword");
                String email = request.getParameter("updateemail");
                int usertype =Integer.parseInt(request.getParameter("usertype"));
                userbean updateuser = new userbean(username, password, name, email,usertype);
                updateuser.setId(Integer.parseInt(request.getParameter("id")));
                
                try {
                    helper.updateuser(updateuser);
                    redirect="show user.jsp";
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }else if(action.equalsIgnoreCase("add")){
                System.out.println("enter");
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String username = request.getParameter("username");
                String email = request.getParameter("email");
                int usertype =Integer.parseInt(request.getParameter("usertype"));
            
                userbean adduser = new userbean(username,password,name,email,usertype);
                userhelper userhelp = new userhelper();
                try {
                    userhelp.insertuser(adduser);
                    redirect="show user.jsp";
                    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(redirect);
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
