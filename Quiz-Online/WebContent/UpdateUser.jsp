<%@page import="Model.userhelper"%>
<%@page import="Model.userbean"%>
<h1>Update User</h1>

<%
    userbean user = new userbean();
    userhelper userhelp =new userhelper();
    int id = Integer.parseInt(request.getParameter("id"));
    user = userhelp.getuserbyid(id);
    String name = user.getName();
    String username = user.getUsername();
    String email = user.getEmail();
    String password = user.getPassword();
    int usertype = user.getUsertype();

%>


<form action="UserController" method="post">
     <input type="hidden" name="action" value="update" />
     <input type="hidden" name="id" value="<%=id%>" />
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="updatename" value="<%=name%>"></td>
        </tr>
        <tr>
            <td>username:</td>
            <td><input type="text" name="updateusername" value="<%=username%>"></td>
        </tr>  
        <tr>
            <td>password:</td>
            <td><input type="password" name="updatepassword" REQUIRED></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="text" name="updateemail" value="<%=email%>"></td>
        </tr> 
        
        <tr>
            <td>user type:</td>
            <td>
              <% if( usertype ==1){%>selected<%}%>
                <select name="usertype">
                    <option value="1"  <% if( usertype ==1){%>selected<%}%>> Admin</option>
                        <option value="2"  <% if( usertype ==2){%>selected<%}%>>Teacher</option>
                        <option value="3"  <% if( usertype ==3){%>selected<%}%>>Student</option>
                </select>
            </td>
        </tr>  
        <tr>
            <td colspan="2"><input type="submit" value="Update"></td>
        </tr>  
    </table>
    
</form>