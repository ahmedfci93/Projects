<%@page import="Model.userbean"%>
<%@page import="Model.userbean"%>
<h1>Add User</h1>


<form action="${pageContext.request.contextPath}/UserController" method="post">
    <input type="hidden" name="action" value="add" />
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>username:</td>
            <td><input type="text" name="username"></td>
        </tr>  
        <tr>
            <td>password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>email:</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>usertype:</td>
            <td>
              
                <select name="usertype">
                    <option value="1"> Admin</option>
                        <option value="2" >Teacher</option>
                        <option value="3" >Student</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="submit"></td>
        </tr> 
        
    </table>
    
</form>
<form method="post" action="show user.jsp">
    <input type="submit" value="show all">
</form>