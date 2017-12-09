package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.DB;

public class QuizHelper {
	  private Connection conn;

	    public QuizHelper() throws SQLException {
	        try {
	            conn = DB.OpenConnection();
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public  void insertQuiz(QuizBean q) {

	        try {
	            String sql = "insert into quiz(name , subject_id , visible) values (?,?,?) ";
	            PreparedStatement pre = conn.prepareCall(sql);
//	            pre.setString(1, q.getId());
	            pre.setString(1, q.getName());
	            pre.setString(2, q.getSubject_id());
	            pre.setString(3, q.getVisible());
	            pre.executeUpdate();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public void updateQuiz(QuizBean q) {
	        try {
	            String sql = "update quiz set name=? , Subject_id=? , Visible=?  where id=?";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, q.getName());
	            pre.setInt(2, Integer.parseInt(q.getSubject_id()));
	            pre.setString(3, q.getVisible());
	            pre.setString(4, q.getId());
	            pre.executeUpdate();
	             
	        } catch (SQLException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public void deleteQuiz(String id) {
	        try {
	            String sql = "delete from quiz where id=?";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, id);
	            pre.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public List<QuizBean> getallQuizbean() {
	        List<QuizBean> ldata = new ArrayList<QuizBean>();
	        try {
	            String sql = "select * from quiz";
	            PreparedStatement pre = conn.prepareCall(sql);
	            ResultSet rs = pre.executeQuery();
	            while(rs.next()){
	            QuizBean Quiz=new QuizBean();
	            Quiz.setId(rs.getString(1));
	            Quiz.setName(rs.getString(2));
	            Quiz.setSubject_id(rs.getString(3));
	            Quiz.setVisible(rs.getString(4));
	            ldata.add(Quiz);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ldata;
	    }
	    public QuizBean getQuizBeanbyid(String id){
	     QuizBean Quiz=new QuizBean();
	        try {
	            String sql = "select * from quiz where id=? ";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, id);
	            ResultSet rs = pre.executeQuery();
	            while(rs.next()){
	           
	            Quiz.setId(rs.getString(1));
	            Quiz.setName(rs.getString(2));
	            Quiz.setSubject_id(rs.getString(3));
	            Quiz.setVisible(rs.getString(4));
	      
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuizHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return Quiz;
	    
	    }


}
