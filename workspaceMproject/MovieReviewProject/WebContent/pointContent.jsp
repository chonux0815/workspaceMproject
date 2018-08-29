<%@page import="mrp.web.vo.PayList"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>

<title>Insert title here</title>

<style>
body, html {
	margin: 0;
	padding: 0;
	height: 100%;
}

#backimage1 {
	background: #F2F2F2;
	height: 520px;
	width: 1100px;
	position: absolute;
	margin-top: 10px;
	text-align: center;
	padding-top: 2%;
}

.sidebar {
	width: 20%;
	height: 90%;
	float: left;
	margin-left: 5%;
}

.sidebar ul {
	margin: 0;
	padding-top: 60%;
	list-style: none;
}

.sidebar ul li {
	margin: 10%;
	padding: 10px 5px;
	border-bottom: 1px solid #DDD;
}

.sidebar ul li a {
	color: #333;
	text-decoration: none;
}

.sidebar ul li a:hover {
	color: #F00;
	text-decoration: underline;
}

#updateFormArea {
	width: 60%;
	height: 90%;
	margin-right: 15%;
	position: relative;
	text-align: center;
	font-size: 20px;
	float: right;
	display: table-cell;
	vertical-align: middle;
}
    #updateFormArea > table {
    margin : 15px;
    }
table {
	padding-right: 10%;
	width: 100%;
	height: 100%;
	padding-left: 10%;
}

.status {
	border: 0;
	color: red;
	font-size: 12px;
	width: 160;
	background: #F2F2F2;
}

.buttonTab {
	padding-top: 14%;
	padding-left: 12%;
}

.button {
	background: #2D3854;
	color: white;
	border: 5px solid #2D3854;
	font-size: 18px;
	width: 60%;
}

.tablecell {
	margin-left: 10%;
	margin-top: 5%;
}

h1 {
	padding-top: 5%;
	font-size: 20px;
}

</style>
</head>
<body>
	<%
		ArrayList<PayList> paylist = (ArrayList<PayList>) request.getAttribute("paylist");

		if (paylist != null && paylist.size() > 0) {
	%>
	<div id="backimage1">
		<div class="sidebar">
			<ul>
				<li><a href="updateForm.log">회원 정보 수정</a></li>
				<li><a href="pointCon.log">포인트 사용 내역 확인</a></li>
				<li><a href="pointChk.log">포인트 잔액 확인</a></li>
			</ul>
		</div>
		<div id="updateFormArea">

			<h1>포인트 사용내역</h1>
			<form action="pointCon.log" method="post" name="test">
				<table class="tablecell">
					<tr>
						<th>닉네임</th>
						<th>종류</th>
						<th>포인트</th>
						<th>수량</th>
					</tr>
					<%
						for (int i = 0; i < paylist.size(); i++) {
					%>
					<tr>
						<td><%=paylist.get(i).getL_name()%></td>
						<td><%=paylist.get(i).getL_kind()%></td>
						<td><%=paylist.get(i).getL_point()%></td>
						<td><%=paylist.get(i).getL_qty()%></td>
					</tr>
					<%
						}
					%>
					<%
						}
					%>


				
				</table>
			</form>
		</div>
	</div>

</body>
</html>