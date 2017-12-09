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

public class SubjectHelper {
	
    private Connection conn;

    public SubjectHelper() throws SQLException {
        try {
            conn = DB.OpenConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public  void insertSubject(SubjectBean sub) {

        try {
            String sql = "insert into subject(name) values (?) ";
            PreparedStatement pre = conn.prepareCall(sql);
//            pre.setString(1, e.getId());
            pre.setString(1, sub.getName());
            pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateSubject(SubjectBean sub) {
        try {
            String sql = "update subject set name=?  where id=?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, sub.getName());
            pre.setString(2, sub.getId());
            pre.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deletesubject(String id) {
        try {
            String sql = "delete from subject where id=?";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, id);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SubjectBean> getallSubjectbean() {
        List<SubjectBean> ldata = new ArrayList<SubjectBean>();
        try {
            String sql = "select * from subject ";
            PreparedStatement pre = conn.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
            SubjectBean subject=new SubjectBean();
            subject.setId(rs.getString(1));
            subject.setName(rs.getString(2));
            ldata.add(subject);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ldata;
    }
    public SubjectBean getSubjectBeanbyid(String id){
     SubjectBean subject=new SubjectBean();
        try {
            String sql = "select * from subject where id=? ";
            PreparedStatement pre = conn.prepareCall(sql);
            pre.setString(1, id);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
           
            subject.setId(rs.getString(1));
            subject.setName(rs.getString(2));
      
            }
        } catch (SQLException ex) {
            Logger.getLogger(SubjectHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return subject;
    
    }
}
