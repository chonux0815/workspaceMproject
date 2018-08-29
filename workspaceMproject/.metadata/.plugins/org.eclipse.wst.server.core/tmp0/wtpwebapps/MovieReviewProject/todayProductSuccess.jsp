<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE htm>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
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

.review {
	position: absolute;
	width: 350px;
	height: 278px;
	padding-top: 220px;
}

.info {
	position: relative;
	width: 100%;
}

div>a {
	padding: 12px;
}

.todayImage {
	padding-left: 15px;
	width: 100px;
	height: 100px;
}
#test{
 margin-top: 3.5%;
}
</style>
</head>
<%
	ArrayList<String> todayImageList = (ArrayList<String>) request.getAttribute("todayImageList");
%>
<body>
	<div class="review">
		<div class="head">오늘 본 상품</div>
		<%
			if (todayImageList != null && todayImageList.size() > 0) {
		%>
		<table id="test">
			<tr>
				<%
					for (int m = 0; m < todayImageList.size(); m++) {
				%>
				<td><img src="images/<%=todayImageList.get(m)%>"
					class="todayImage"></td>
				<%
					if (m == 2 || m == 5) {
				%></tr><tr>
				<%
					}if(m == 9)break;
						}
				%>
			</tr>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>