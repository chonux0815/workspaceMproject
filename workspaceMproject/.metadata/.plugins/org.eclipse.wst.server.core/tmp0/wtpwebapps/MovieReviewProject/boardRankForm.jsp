<%@page import="java.util.ArrayList"%>
<%@page import="mrp.web.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
<style>
#boardRankFormArea {
	text-align: center;
	font-family: 'Sunflower', sans-serif;
	font-weight: bold;
	font-size: medium;
}
.rankTd{
margin-right : 10px;
border: 2px solid #8B93B2;
border-radius: 25px;
}
.style_p{
	margin-top : 20px;
	font-size: 20px;
}
.ellipsis{
 display : block;
 width : 215px;
 white-space:nowrap;
 overflow: hidden;
 text-overflow: ellipsis;
}

</style>

</head>
<body>
	<%
		ArrayList<Board> boardRankList = (ArrayList<Board>) request.getAttribute("boardRankList");
	%>
	
	<section id="boardRankFormArea">

		<div class = "rankTd">
		<table class = "table_Rank">
			<tr>
				<td colspan="2"><p class = "style_p"><b>게시글 인기 랭킹</b></p></td>
			</tr>
			<tr>
				<td colspan="2"><hr></td>
			</tr>
			<%
				for (int i = 0; i < boardRankList.size(); i++) {
			%>
			<tr>
				<td class="td_left"><%=i + 1%></td>
				<td class="td_right"><a class="ellipsis" href="boardRankPro.main?b_code=<%=boardRankList.get(i).getB_code()%>&b_division=<%=boardRankList.get(i).getB_division()%>"><%=boardRankList.get(i).getB_name()%></a></td>
			</tr>
			<tr>
			<td colspan="2"><hr></td>
			</tr>
			<%
				}
			%>

		</table>
		</div>
	</section>
</body>
</html>