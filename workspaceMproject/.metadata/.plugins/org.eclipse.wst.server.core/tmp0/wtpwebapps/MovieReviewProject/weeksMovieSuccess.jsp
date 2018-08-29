<%@page import="java.net.URLEncoder"%>
<%@page import="mrp.web.vo.Movie"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300"
	rel="stylesheet">
<style>
.head {
	display: table-cell;
	vertical-align: middle;
	text-align: center;
	position: relative;
	font-size: x-large;
	font-weight: bold;
	background-color: #8B93B2;
	color: white;
	width: 320px;
	height: 32px;
	border-radius: 10em;
	font-family: 'Sunflower', sans-serif;
}

.weeksMovie {
	padding-top: 220px;
}

.movieName {
	width: 100px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	font-family: 'Sunflower', sans-serif;
}

.weeksMovie {
	text-align: center;
}

#test {
	margin-top: 3.5%;
	margin-left: 3.5%;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function idCheck(i) {
		//alert("");
		window.open("proboxoffice.main?i="+i, "",
				"width=787,height=434\
				,location=no,status=no,scrollbars=yes");
	}
</script>
</head>
<%
	ArrayList<Movie> movieList = (ArrayList<Movie>) session.getAttribute("items");
	String showRange = (String) request.getAttribute("showRange");
%>
<body>
	<div class="weeksMovie">
		<%
			if (movieList != null && movieList.size() > 0) {
		%>
		<table>
			<tr>
				<td colspan="4"><div class="head">금주 영화순위</div></td>
			</tr>
			<table id="test">
				<tr>
					<%
						for (int i = 0; i < 3; i++) {
					%>
					<td><a href="#" onclick="idCheck(<%=i%>);"><img
							src="images/<%=movieList.get(i).getMovieNum()%>.jpg"></a> <br>
						<p class="movieName"><%=i + 1%>위 :
							<%=movieList.get(i).getMovieNum()%></p></td>
					<%
						}
					%>
				</tr>
				<tr>
					<%
						for (int i = 3; i < 6; i++) {
					%>
					<td><a href="#" onclick="idCheck(<%=i%>);"><img
							src="images/<%=movieList.get(i).getMovieNum()%>.jpg"></a> <br>
						<p class="movieName"><%=i + 1%>위 :
							<%=movieList.get(i).getMovieNum()%></p></td>
					<%
						}
					%>
				</tr>
				<tr>
					<%
						for (int i = 6; i < 9; i++) {
					%>
					<td><a href="#" onclick="idCheck(<%=i%>);"><img
							src="images/<%=movieList.get(i).getMovieNum()%>.jpg"></a> <br>
						<p class="movieName"><%=i + 1%>위 :
							<%=movieList.get(i).getMovieNum()%></p></td>
					<%
						}
					%>
				</tr>
			</table>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>