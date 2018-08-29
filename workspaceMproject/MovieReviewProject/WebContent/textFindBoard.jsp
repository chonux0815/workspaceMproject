<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="mrp.web.vo.PageInfo"%>
<%@page import="mrp.web.vo.Board"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
 	border-collapse: collapse;
    text-align: center;
    line-height: 1.5;
    border: 1px solid #ccc;
    margin-left: 20%;
    border-right: 1px solid #ccc;
    border-left: 1px solid #ccc;
    border-top: 1px solid #ccc;
    font-size: small;
}

.td_10{
    color: #2E2E2E;
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #fcf1f4;
      border-top: 1px solid #ccc;
}
.td_1{
	width: 180px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
}
.title_h1{
font-size: medium;
text-align: center;
}






</style>
</head>
<body>
<%
	ArrayList<Board> boardMovieList=(ArrayList<Board>)request.getAttribute("boardMovieList");
	ArrayList<Board> boardReviewList=(ArrayList<Board>)request.getAttribute("boardReviewList");
	ArrayList<Board> boardEventList=(ArrayList<Board>)request.getAttribute("boardEventList");
%>
<table>
<tr>
<h1  class="title_h1">추천영화게시판에서 찾은 결과</h1>
</tr>
<br>
<%
		if(boardMovieList !=null && boardMovieList.size() > 0){
	%>
			<tr>
				<td class = "td_10">영화제목</td>
				<td class = "td_10">제목</td>
				<td class = "td_10">작성자</td>
				<td class = "td_10">조회수</td>
			</tr>
			<%
				for(int i = 0; i <boardMovieList.size();i++){
			%>
			<tr>
				<td class = "td_1"><%=boardMovieList.get(i).getB_mcode() %></td>
				<td class = "td_1">
				<a href="boardContent.bo?b_code=<%=boardMovieList.get(i).getB_code()%>&b_division=<%=boardMovieList.get(i).getB_division()%>"><%=boardMovieList.get(i).getB_name() %></a>
				</td>
				<td class = "td_1"><%=boardMovieList.get(i).getB_author() %></td>
				<%-- <td class = "td_regdate"><%=sdf.format(boardList.get(i).getBoard_regDate()) %></td> --%>
				<td class = "td_1"><%=boardMovieList.get(i).getReadcount() %></td>
			</tr>
			<%
				}
			%>
			
			
<%
		}
		else{
%>
		<tr>
		검색된 결과가 없습니다.
		</tr>
<%} %>
</table>
<br>
<br>
<br>
<br>
<table>
<tr>
<h1 class="title_h1">리뷰게시판에서 찾은 결과</h1>
</tr>
<br>
<%
		if(boardReviewList !=null && boardReviewList.size() > 0){
	%>
			<tr>
				<td class = "td_10">영화제목</td>
				<td class = "td_10">제목</td>
				<td class = "td_10">작성자</td>
				<td class = "td_10">조회수</td>
			</tr>
			<%
				for(int i = 0; i <boardReviewList.size();i++){
			%>
			<tr>
				<td class="td_1"><%=boardReviewList.get(i).getB_mcode() %></td>
				<td class="td_1">
				<a href="boardContent.bo?b_code=<%=boardReviewList.get(i).getB_code()%>&b_division=<%=boardReviewList.get(i).getB_division()%>"><%=boardReviewList.get(i).getB_name() %></a>
				</td>
				<td class="td_1"><%=boardReviewList.get(i).getB_author() %></td>
				<%-- <td class = "td_regdate"><%=sdf.format(boardList.get(i).getBoard_regDate()) %></td> --%>
				<td class="td_1"><%=boardReviewList.get(i).getReadcount() %></td>
			</tr>
			<%
				}
			%>
			
			
<%
		}else{
			%>
			<tr>
			검색된 결과가 없습니다.
			</tr>
	<%} %>
</table>
<br>
<br>
<br>
<br>
<table>
<tr>
<h1  class="title_h1">이벤트게시판에서 찾은 결과</h1>
</tr>
<br>
<%
		if(boardEventList !=null && boardEventList.size() > 0){
	%>
			<tr>
				<td class = "td_10">영화제목</td>
				<td class = "td_10">제목</td>
				<td class = "td_10">작성자</td>
				<td class = "td_10">조회수</td>
			</tr>
			<%
				for(int i = 0; i <boardEventList.size();i++){
			%>
			<tr>
				<td class="td_1"><%=boardEventList.get(i).getB_mcode() %></td>
				<td class="td_1">
				<a href="boardContent.bo?b_code=<%=boardEventList.get(i).getB_code()%>&b_division=<%=boardEventList.get(i).getB_division()%>"><%=boardEventList.get(i).getB_name() %></a>
				</td>
				<td class="td_1"><%=boardEventList.get(i).getB_author() %></td>
				<%-- <td class = "td_regdate"><%=sdf.format(boardList.get(i).getBoard_regDate()) %></td> --%>
				<td class="td_1"><%=boardEventList.get(i).getReadcount() %></td>
			</tr>
			<%
				}
			%>
			
			
<%
		}else{
			%>
			<tr>
			검색된 결과가 없습니다.
			</tr>
	<%} %>
</table>
</body>
</html>