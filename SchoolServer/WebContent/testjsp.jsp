<%@ page language="java" import="java.sql.*"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String driver = "org.apache.derby.jdbc.ClientDriver";
	Class.forName(driver).newInstance();
	

	Connection con=null;
	ResultSet rst=null;
	Statement stmt=null;
	

	try{
		String url="jdbc:derby:/home/desi/Desktop/derby/bin/users";
		con=DriverManager.getConnection(url);
		stmt=con.createStatement();
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}

	if(request.getParameter("action") != null){ 
		String bookname=request.getParameter("username");
		String author=request.getParameter("password");
		rst=stmt.executeQuery("select * from users");
		%>
		<html>
		<body>
		<center>
			<h2>Books List</h2>
			<table border="1" cellspacing="0" cellpadding="0">
			<tr>
				<td><b>S.No</b></td>
				<td><b>Book Name</b></td>
				<td><b>Author</.b></td>
			</tr>
			 	<%
				int no=1;
				while(rst.next()){
				%>
				<tr>
				  <td><%=no%></td>
				  <td><%=rst.getString("username")%></td>
				  <td> <%=rst.getString("password")%> </td>
				</tr>
				<%
				no++;
	}
	rst.close();
	stmt.close();
	con.close();
%>
			</table>
			</center>
		</body>
	</html>
<%}else{%>
	<html>
	<head>
		<title>Book Entry FormDocument</title>
		<script language="javascript">
		    function validate(objForm){
			if(objForm.bookname.value.length==0){
			alert("Please enter Book Name!");
			objForm.bookname.focus();
			return false;
			}
			if(objForm.author.value.length==0){
			alert("Please enter Author name!");
			objForm.author.focus();
			return false;
			}
			return true;
				}
			</script>
		</head>
		

		<body>
			<center>
				
			</center>
		</body>
	</html>
<%}%>
</body>
</html>