<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="databasePackage.SubjectConnect" %>
<%@ page import="databasePackage.AbstConnect" %>
<%@ page import="java.util.HashMap" %>
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
			<li class="active"><a href="#8" data-toggle="tab">8</a>
			</li>
			<li><a href="#9" data-toggle="tab">9</a>
			</li>
			<li><a href="#10" data-toggle="tab">10</a>
			</li>
			<li><a href="#11" data-toggle="tab">11</a>
			</li>
			<li><a href="#12" data-toggle="tab">12</a>
			</li>
		</ul>

		<div id="tab-content">
			<div class="tab-pane active" id="8">
				<ul class="nav nav-pills">
					<li class="active"><a href="#А">A</a>
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
								<tr>
									<td><%
										AbstConnect
												.setDbURL("jdbc:derby:C:\\Users\\Lumnatiq\\Desktop\\db-derby-10.8.1.2-bin\\bin\\SchoolSchedule");
										AbstConnect.setConn(null);
										AbstConnect.setStmt(null);
										AbstConnect.setTableName("subjects");
										SubjectConnect.createConnection();
									%> 
									<%! HashMap<String,String> hs; %>
									<% hs = SubjectConnect.getSubject(21); %>
									<%= hs.get("name") %>
									</td>
									<td>Indiana Jones</td>
									<td>The Punisher</td>
									<td>Wall-E</td>
									<td>Math</td>
								</tr>
								<tr>
									<td>Epic Movie</td>
									<td>Star Wars</td>
									<td>Bad Boys</td>
									<td>Madagascar</td>
									<td>History</td>
								</tr>
								<tr>
									<td>Spartan</td>
									<td>LOTR</td>
									<td>Die Hard</td>
									<td>Finding Nemo</td>
									<td>BEL</td>
								</tr>
								<tr>
									<td>Dr. Dolittle</td>
									<td>The Mummy</td>
									<td>300</td>
									<td>A Bug's Life</td>
									<td>Programirane</td>
								</tr>
							</tbody>
						</table></li>
					<!-- <li><a href="#Б">Б</a></li>
					<li><a href="#В">В</a></li>
					<li><a href="#Г">Г</a></li> -->
				</ul>
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
