<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="databasePackage.SubjectConnect" %>
<%@ page import="databasePackage.AbstConnect" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
<title>School Project</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="author" content="Desi Matoushek & Valery Poliakov" />
<link rel="stylesheet" type="text/css" href="css/mainStyle.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
</head>

<body>
	<div class="wrapper">

		<div id="user">
			<h1>Kiril Mitov</h1>
		</div>

		<div id="Settings">
			<h1>Settings.</h1>
		</div>

		<ul class="nav nav-tabs" id="myTab">
			<li class="active"><a href="?class=8" data-toggle="tab">8</a>
			</li>
			<li><a href="?class=9" data-toggle="tab">9</a>
			</li>
			<li><a href="?class=10" data-toggle="tab">10</a>
			</li>
			<li><a href="?class=11" data-toggle="tab">11</a>
			</li>
			<li><a href="?class=12" data-toggle="tab">12</a>
			</li>
		</ul>

		<div id="tab-content">
			<div class="tab-pane active" id="8">
				<ul class="nav nav-pills">
					<li class="active"><a href="#А">A</a>
						<form method="post" action="change-subjects" >
						<table id="ver-minimalist" summary="Most Favorite Movies">
							<thead>
								<tr>
									<th scope="col">Monday</th>
									<th scope="col">Tuesday</th>
									<th scope="col">Wednesday</th>
									<th scope="col">Thursday</th>
									<th scope="col">Friday</th>
								</tr>
							</thead>
							<tbody>
<%
	AbstConnect
			.setDbURL("jdbc:derby:C:\\Users\\Lumnatiq\\Desktop\\db-derby-10.8.1.2-bin\\bin\\SchoolSchedule");
	AbstConnect.setConn(null);
	AbstConnect.setStmt(null);
	AbstConnect.setTableName("subjects");
	SubjectConnect.createConnection();
%>
								<% for(int i = 0; i < 10; i++) { %>
								<tr>													
									<%! HashMap<String, String> monday; %>
									<% monday = SubjectConnect.selectSubjectByHourAndDay(i, 1, 1); %>				
									<td><input type="text" name="monday" value="<%= (monday.containsKey("name")) ? monday.get("name") : "" %>" /></td>
									<%! HashMap<String, String> tuesday; %>
									<% monday = SubjectConnect.selectSubjectByHourAndDay(i, 2, 1); %>				
									<td><input type="text" name="tuesday" value="<%= (monday.containsKey("name")) ? monday.get("name") : "" %>" /></td>
									<%! HashMap<String, String> wednesday; %>
									<% monday = SubjectConnect.selectSubjectByHourAndDay(i, 3, 1); %>				
									<td><input type="text" name="wednesday" value="<%= (monday.containsKey("name")) ? monday.get("name") : "" %>" /></td>
									<%! HashMap<String, String> thursday; %>
									<% monday = SubjectConnect.selectSubjectByHourAndDay(i, 4, 1); %>				
									<td><input type="text" name="thursday" value="<%= (monday.containsKey("name")) ? monday.get("name") : "" %>" /></td>
									<%! HashMap<String, String> friday; %>
									<% monday = SubjectConnect.selectSubjectByHourAndDay(i, 5, 1); %>				
									<td><input type="text" name="friday" value="<%= (monday.containsKey("name")) ? monday.get("name") : "" %>" /></td>
								</tr>
								<% } %>
							</tbody>							
						</table>						
						</li>			
						
			<% AbstConnect.shutdown(); %>			
					<!-- <li><a href="#Б">Б</a></li>
					<li><a href="#В">В</a></li>
					<li><a href="#Г">Г</a></li> -->
				</ul>
				<input type="submit" value="Change subjects" />
				<input type="hidden" name="scheduleID" value="1" />
				</form>
			</div>
		</div>

		<!-- <div class="pill-content">
			<div class="pill-pane" id="A"></div>
			<div class="pill-pane" id="Б"></div>
			<div class="pill-pane" id="В"></div>
			<div class="pill-pane" id="Г"></div>

		</div> -->

	</div>
	<!-- end of wrapper -->
	<script>
		$(function() {
			$('#myTab a[href="#8"]').tab('show');
		})
	</script>
</body>
</html>
