<%@page import="mrp.web.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#eventBoardArea {
	width: 620px;
	margin: auto;
}

.eventList {
	text-align: center;
	font-size: 20px;
	margin-top: 2%;
}

table {
	border: 1px solid #BCBCBC;
	width: 600px;
	margin: auto;
	text-align: center;
	margin-left: -15%;
	margin-bottom: 2%;
}

.eventImage {
	width: 200px;
	height: 150px;
	border: none;
	padding: 20px 35px;
}

.eventRegist {
	color: white;
	display: inline;
	border: 1px solid #655ce4;
	background-color: #655ce4;
	font-size: small;
	text-align: center;
	padding: 0.4%;
	height: 5%;
	width: 11%;
	margin-top: 5%;
	margin-left: 2%;
	border-radius: 10px;
}

.eventRegist:hover {
	color: white;
}

.notice_board {
	border-collapse: separate;
	border-spacing: 1px;
	text-align: center;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	width: 100%;
	margin-left: 1%;
}

.th1 {
	width: 100px;
	padding: 5px;
	font-weight: bold;
	font-size: small;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
	background: #efefef;
}

.td1 {
	width: 200px;
	padding: 5px;
	vertical-align: top;
	border-bottom: 1px solid #ccc;
}

.sideTest {
	width: 20%;
	margin-left: 66%;
	margin-top: 2%;
}

b {
	margin-top: 15%;
}

.eventResist1:link {
	text-decoration: none;
	color: #9097C5;
}

.eventResist1:visited {
	text-decoration: none;
	color: #9097C5;
}

.eventResist1:active {
	text-decoration: none;
	color: #9097C5;
}

.notice1 {
	display: block;
	width: 100%;
	width: 220px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

.notice1:link {
	text-decoration: none;
	color: #646464;
}

.notice1:visited {
	text-decoration: none;
	color: #646464;
}

.notice1:active {
	text-decoration: none;
	color: #646464;
}

.notice1:hover {
	text-decoration: none;
	color: #3F3A89;
}

.a1 {
	background-color: #DFDFDF;
	text-align: center;
}

.ellipsis {
	display: inline-block;
	width: 220px;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	width: 220px;
	font-weight: bold;
}

.regist1 {
	color: white;
	margin-top: 15%;
}

.date {
	color: #9B9B9E;
}
</style>
</head>
<body>
	<%
		ArrayList<Board> eventBoardList = (ArrayList<Board>) request.getAttribute("eventBoardList");
		ArrayList<Board> boardNoticeList = (ArrayList<Board>) request.getAttribute("boardNoticeList");
	%>
	<h1 class="eventList">이벤트 목록</h1>
	<nav class="sideTest">
		<div class="eventRegist">
			<a href="eventWriteForm.bo?b_division=${b_division}"
				class="eventRegist1"><b class="regist1">이벤트 글 등록</b></a>
		</div>
		<c:if test="${u_division == 0}">
			<div class="eventRegist">
				<a href="writeForm.bo?b_division=${b_division + 3}"
					class="eventRegist1"><b class="regist1">공지사항 글쓰기</b></a>
			</div>
		</c:if>
	</nav>
	<br>
	<section id="eventBoardArea">
		<table class="notice_board">
			<%
				if (boardNoticeList != null) {
					for (int i = 0; i < boardNoticeList.size(); i++) {
			%>
			<tr>
				<th class="th1">공지사항</th>
				<td class="td1"><b><a
						href="boardContent.bo?b_code=<%=boardNoticeList.get(i).getB_code()%>&b_division=${b_division}"
						class="notice1"><b><%=boardNoticeList.get(i).getB_name()%></a></td>
				<td class="td1"><%=boardNoticeList.get(i).getB_author()%></td>
				<td class="td1"><%=boardNoticeList.get(i).getReadcount()%></td>

			</tr>

			<%
				}
				}
			%>
		</table>
		<%
			if (eventBoardList != null && eventBoardList.size() > 0) {
		%>


		<table>
			<tr>
				<%
					for (int i = 0; i < eventBoardList.size(); i++) {
							System.out.println(eventBoardList.get(i).getB_code());
				%>

				<td><a
					href="boardContent.bo?b_code=<%=eventBoardList.get(i).getB_code()%>&b_division=${b_division}">
						<img src="images/<%=eventBoardList.get(i).getB_image()%>"
						class="eventImage">
				</a><br>
					<p class="ellipsis"><%=eventBoardList.get(i).getB_name()%>
					</p> <br>
					<p class="date">
						기간 :
						<%=eventBoardList.get(i).getB_time()%></p></td>
				<%
					if ((i + 1) % 3 == 0) {
				%>

			</tr>
			<tr>
				<%
					}
						}
				%>

			</tr>
		</table>

		<%
			}
		%>

	</section>
</body>
</html>
