<%@page import="mrp.web.vo.PageInfo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>

<%@page import="mrp.web.vo.Board"%>
<%@page import="mrp.web.vo.BoardBo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %> --%>
<%
	ArrayList<BoardBo> boardBoList = (ArrayList<BoardBo>) request.getAttribute("boardBoList");
	Board board = (Board) request.getAttribute("board");
	/* String pageNum = (String)session.getAttribute("pageNum"); */
	int b_division = (int) request.getAttribute("b_division");
%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DAEGU</title>
<style>
.ggaggoong {
	display: none;
	height: 10px;
}

.ggaggoong2 {
	display: none;
	height: 20px;
}

td {
	text-align: left;
}

.smalltext {
	font-size: 5px;
}

.smalltext:active { .ggaggoong { display:block;
	
}
.board_content1{
	
}

}
#board_title{
	width:1000px;
	 border-bottom: 1px solid #bcbcbc;
	 margin-bottom: 1%;
	 font-weight: bold;
}
#contentArea {
	width: 70%;
	height: 100%;
	margin: auto;
	text-align: center;
	border : solid 1px #bcbcbc;
	padding-bottom: 2%;
	background-color: #FAFAFA;
	padding : 1.5%;
}

h1 {
	text-align: center;
	
}

#basicContent {
	height: 70px;
	border-bottom: 3px double orange;
	text-align: center;
}

#detailContent {
	margin-top: 2.5%;
	overflow: auto;
	text-align: left;
}

#commandArea {
	width: 600px;
	margin: auto;
	margin-top: 10px;
	text-align: center;
}

form {
	display: inline;
}

p {
	display: inline;
	margin-right: 1%;
}

.td_Readcount{
 border-bottom: 1px solid #bcbcbc;
}
#reftext{
	width: 50%;
	margin-top: 3%;
	}
.dat_content{
 	border-bottom: 1px solid #bcbcbc;
 	width: 1%;
}
.smalltext{
	color : #817E7E;
}
#datgul{
	background: #F2F1F1;
}
</style>

<script type="text/javascript">
function textview(code) {
	document.getElementById("dattext"+code).style.display = "inline-block";
	document.getElementById("data"+code).style.display = "inline-block";
}
function sujung(code){
	document.getElementById("content"+code).style.display="none";
	document.getElementById("sujung"+code).style.display="none";
	document.getElementById("delete"+code).style.display="none";
	document.getElementById("dat"+code).style.display="none";
	document.getElementById("inputtext"+code).style.display="inline";
	document.getElementById("ok"+code).style.display="inline";
	document.getElementById("no"+code).style.display="inline";
	
}
function ok(code) {
	
	var text=document.getElementById("inputtext"+code).value;
	
}
function no(code) {
	document.getElementById("ok"+code).style.display="none";
	document.getElementById("no"+code).style.display="none";
	document.getElementById("inputtext"+code).style.display="none";
	document.getElementById("content"+code).style.display="inline";
	document.getElementById("dat"+code).style.display="inline";
	document.getElementById("sujung"+code).style.display="inline";
	document.getElementById("delete"+code).style.display="inline";
}
function boardDelete(b_code, b_division) {
	var check=confirm("삭제 하시겠습니까?");
	if(check==true){
		location.href="boardDelete.bo?b_code="+b_code+"&b_division="+b_division;
	}
}
function textDatDelete(d_code,b_code,b_division) {
	var check=confirm("삭제 하시겠습니까?");
	if(check==true){
		location.href="datDelete.bo?d_code="+d_code+"&b_code="+b_code+"&b_division="+b_division;
	}
}
</script>

</head>
<body>

	<section id="contentArea">
		<h1>자신의 작성글은 본인의 얼굴입니다^^ 예쁘게 작성해주세요^^</h1>
		<div class="basicContent">
			<table>
			<tr>
			<td class="td_left"><label for="board_title"></label></td>
			<td class="td_right" id="board_title"><%=board.getB_name()%></td>
			</tr>
			<tr>
			<td class="td_left"><label for="board_writer"></label></td>
			<td class="td_right" id="board_writer"><%=board.getB_author()%></td>
			</tr>	
			</table>
<!-- 			<br> -->
		</div>
		<section id="detailContent">
			<pre class="board_content1"><%=board.getB_content()%></pre>
		</section>
		<table>
		<tr>
			<td class="td_Readcount"><label for="board_Readcount">조회수</label></td>
			<td class="td_Readcount" id="board_Readcount"><%=board.getReadcount()%></td><br>
		</tr>
		</table>
		<br>
		<table id="datgul">
			<%
				int i = 0;
					int u_division = (Integer) session.getAttribute("u_division");
				String u_name = (String) session.getAttribute("u_name");
				if (boardBoList != null) {
					for (i = 0; i < boardBoList.size(); i++) {
			%>
			<tr class = "dat_title">
				<td class = "dat_content">
					<%
						for (int j = 0; j < boardBoList.get(i).getRe_step(); j++) {
					%> &nbsp;&nbsp; <%
 	}
 %> <%=boardBoList.get(i).getD_author()%> :
					<p id="content<%=boardBoList.get(i).getD_code()%>"><%=boardBoList.get(i).getD_content()%>
					<p>
					<form
						action="datRemake.bo?b_division=<%=b_division%>&d_code=<%=boardBoList.get(i).getD_code()%>&b_code=<%=boardBoList.get(i).getD_boardcode()%>"
						method="post" id="remake<%=boardBoList.get(i).getD_code()%>">
						<input name="inputtext<%=boardBoList.get(i).getD_code()%>"
							id="inputtext<%=boardBoList.get(i).getD_code()%>" type="text"
							class="ggaggoong" value="<%=boardBoList.get(i).getD_content()%>">
						<a href="#" id="ok<%=boardBoList.get(i).getD_code()%>"
							class="ggaggoong"
							onclick="document.getElementById('remake<%=boardBoList.get(i).getD_code()%>').submit();">확인</a>
					</form> <a href="#" id="no<%=boardBoList.get(i).getD_code()%>"
					class="ggaggoong" onclick="no(<%=boardBoList.get(i).getD_code()%>)">취소</a>
					<a href="#" id="dat<%=boardBoList.get(i).getD_code()%>"
					class="smalltext"
					onclick="textview(<%=boardBoList.get(i).getD_code()%>)">댓글</a>&nbsp;
					<%
						if (boardBoList.get(i).getD_author().equals(u_name) || u_division == 0) {
					%> <a href="#" id="sujung<%=boardBoList.get(i).getD_code()%>"
					class="smalltext"
					onclick="sujung(<%=boardBoList.get(i).getD_code()%>)">수정</a>&nbsp;
					<a href="#" id="delete<%=boardBoList.get(i).getD_code()%>"
					class="smalltext"
					onclick="textDatDelete(<%=boardBoList.get(i).getD_code()%>,<%=board.getB_code()%>,<%=b_division%>)">삭제</a>&nbsp;
					<%
						}
					%>
					<form method="post"
						action="boardContentDat.bo?b_division=<%=b_division%>&d_code=<%=boardBoList.get(i).getD_code()%>&b_code=<%=boardBoList.get(i).getD_boardcode()%>&name=<%=u_name%>">
						<input name="dattext<%=boardBoList.get(i).getD_code()%>"
							id="dattext<%=boardBoList.get(i).getD_code()%>" class="ggaggoong"
							type="text">
						<!-- 텍스트 -->
						<input type="submit" class="ggaggoong"
							id="data<%=boardBoList.get(i).getD_code()%>" value="작성">
					</form>
				</td>
			</tr>
			<%
				}

				}
			%>
		</table>
		<form method="post"
			action="boardContentDatRef.bo?ref=<%=i%>&name=<%=u_name%>&b_code=<%=board.getB_code()%>&b_division=<%=b_division%> ">
			<input id="reftext" type="text" name="reftext"><input
				type="submit" value="댓글입력">
		</form>
	</section>
	<section id="commandArea">
		<%
		if (board.getB_author().equals(u_name) || u_division == 0) {
		%>
		<a href="boardRemakeForm.bo?b_code=<%=board.getB_code()%>&b_content=<%=board.getB_content()%>&b_name=<%=board.getB_name()%>&b_mcode=<%=board.getB_mcode() %>&b_division=<%=board.getB_division() %>" id="contentsujung" class="smalltext"
			>수정</a>&nbsp;
		<a id="contentdelete" class="smalltext" onclick="boardDelete(<%=board.getB_code()%>,<%=b_division%>)" >삭제</a>&nbsp;
		<%
			}
		%>
		<% if(b_division==3||b_division==6){ %>
		<a href="eventBoardList.bo?b_division=<%=b_division%>">목록보기</a>
		<% }else{ %>
		<a href="boardList.bo?b_division=<%=b_division%>">목록보기</a>
		<%}%>
		
	</section>
</body>
</html>