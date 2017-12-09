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

public class QuestionHelper {
	  private Connection conn;

	    public QuestionHelper() throws SQLException {
	        try {
	            conn = DB.OpenConnection();
	        } catch (ClassNotFoundException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public  void insertQuestion(QuestionBean ques) {

	        try {
	            String sql = "insert into question(question , quiz_id , answer1 , answer2 , answer3 , answer4 , correctAnswer  ) values (?,?,?,?,?,?,?) ";
	            PreparedStatement pre = conn.prepareCall(sql);
//	            pre.setString(1, q.getId());
	            pre.setString(1, ques.getQuestion());
	            pre.setString(2, ques.getQuiz_id());
	            pre.setString(3, ques.getAnswer1());
	            pre.setString(4, ques.getAnswer2());
	            pre.setString(5, ques.getAnswer3());
	            pre.setString(6, ques.getAnswer4());
	            pre.setString(7, ques.getCorrectAnswer());
	            pre.executeUpdate();
	            
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }

	    }

	    public void updateQuestion(QuestionBean ques) {
	        try {
	            String sql = "update question set  question=? , quiz_id=? , answer1=? , answer2=? , answer3=? ,answer4=? ,correctAnswer=?  where id=?";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, ques.getQuestion());
	            pre.setString(2, ques.getQuiz_id());
	            pre.setString(3, ques.getAnswer1());
	            pre.setString(4, ques.getAnswer2());
	            pre.setString(5, ques.getAnswer3());
	            pre.setString(6, ques.getAnswer4());
	            pre.setString(7, ques.getCorrectAnswer());
	            pre.setString(8, ques.getId());
	            pre.executeUpdate();
	             System.out.println("Worked correctly"+ques.getQuiz_id());
	             
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public void deleteQuestion(String id) {
	        try {
	            String sql = "delete from question where id=?";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, id);
	            pre.executeUpdate();
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }

	    public List<QuestionBean> getallQuestionbean() {
	        List<QuestionBean> ldata = new ArrayList<QuestionBean>();
	        try {
	            String sql = "select * from question ";
	            PreparedStatement pre = conn.prepareCall(sql);
	            ResultSet rs = pre.executeQuery();
	            while(rs.next()){
	            QuestionBean Question=new QuestionBean();
	            Question.setId(rs.getString(1));
	            Question.setQuestion(rs.getString(2));
	            Question.setQuiz_id(rs.getString(3));
	            Question.setAnswer1(rs.getString(4));
	            Question.setAnswer2(rs.getString(5));
	            Question.setAnswer3(rs.getString(6));
	            Question.setAnswer4(rs.getString(7));
	            Question.setCorrectAnswer(rs.getString(8));
	            ldata.add(Question);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ldata;
	    }
	    public QuestionBean getQuestionBeanbyid(String id){
	     QuestionBean Question=new QuestionBean();
	        try {
	            String sql = "select * from question where id=? ";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, id);
	            ResultSet rs = pre.executeQuery();
	            while(rs.next()){
	           
	            Question.setId(rs.getString(1));
	            Question.setQuestion(rs.getString(2));
	            Question.setQuiz_id(rs.getString(3));
	            Question.setAnswer1(rs.getString(4));
	            Question.setAnswer2(rs.getString(5));
	            Question.setAnswer3(rs.getString(6));
	            Question.setAnswer4(rs.getString(7));
	            Question.setCorrectAnswer(rs.getString(8));
	      
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return Question;
	    
	    }

	    
	    public List<QuestionBean> getallQuestionbeanbyQuizid(String quiz_id) {
	        List<QuestionBean> ldata = new ArrayList<QuestionBean>();
	        try {
	            String sql = "select * from question where quiz_id=?";
	            PreparedStatement pre = conn.prepareCall(sql);
	            pre.setString(1, quiz_id);
	            ResultSet rs = pre.executeQuery();
	            while(rs.next()){
	            QuestionBean Question=new QuestionBean();
	            Question.setId(rs.getString("id"));
	            Question.setQuestion(rs.getString("question"));
	            Question.setQuiz_id(rs.getString("quiz_id"));
	            Question.setAnswer1(rs.getString("answer1"));
	            Question.setAnswer2(rs.getString("answer2"));
	            Question.setAnswer3(rs.getString("answer3"));
	            Question.setAnswer4(rs.getString("answer4"));
	            Question.setCorrectAnswer(rs.getString("correctAnswer"));
	            ldata.add(Question);
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(QuestionHelper.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        return ldata;
	    }

}
