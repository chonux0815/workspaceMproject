<%@page import="mrp.web.vo.Board"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String u_name = (String) session.getAttribute("u_name");
	Board board = (Board)request.getAttribute("board");
	int b_division = (Integer)request.getAttribute("b_division");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DAEGU</title>
<style>
#writeFormArea {
	width: 75%;
	height: 85%;
	margin: auto;
	text-align: center;
	border : 0.5px solid #bcbcbc;
	background-color:#FAFAFA; 
}
h1{
	font-size: large;
	margin-bottom: 2%;
	text-align: center;
	width: 100px;	
}

table {
	width: 100%;
	height: 100%;
	margin: auto;
}
img.h1{
	width : 100px;
	height: 50px;
}

.td_left {
	width: 20%;
	text-align: center;
}
.td_left_content{
	vertical-align: top;
}

.td_right {
	width: 80%;
	text-align: left;
	
}
.td_right_content{
	height : 100%;
	text-align: left;
}
.text_name{
	width : 50%;

}
</style>
</head>
<body>
<br>
	<section id="writeFormArea">
		<img class="h1" src="images/logo.png">
		<form action="boardWriteForm.bo?b_division=<%=b_division%>" method="POST">
			<table>
				<tr>
					<td class="td_left"><label for="board_writer">작성자</label></td>
					<td class="td_right"  id="board_writer"><%=u_name %></td>
				</tr>
				<tr>
					<td class="td_left">영화 제목</td>
					<td class="td_right">
					<input type="text" class = "text_name" name="board_movie">
					</td>
				</tr>
				<tr>
					<td class="td_left"><label for="board_name">글제목</label></td>
					<td class="td_right"><input  class = "text_name" type="text" name="board_name" id=board_subject"></td>
				</tr>
			
				
				<tr>
					<td class="td_left_content"><label for="board_content">글 내용</label></td>
					<td class="td_right_content"><textarea rows="23.5" cols="100" name="board_content" id="board_content"></textarea></td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="글 등록"><input
						type="reset" value="다시 작성 "></td>
				</tr>
			</table>
		</form>

	</section>
</body>
</html>