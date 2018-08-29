<%@page import="mrp.web.vo.PageInfo"%>
<%@page import="mrp.web.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
    
<!DOCTYPE html >
<html>
<head>
   
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DAEGU</title>
<style>

.a1{
   display : block;
   width : 100%;
}
.a1:link {text-decoration:none; color : #646464;}
.a1:visited{text-decoration:none; color: #646464;}
.a1:active {text-decoration:none; color: #646464;}
.a1:hover {text-decoration:none; color: white;}
.a2:link {text-decoration:none; color : #646464;}
.a2:visited{text-decoration:none; color: #646464;}
.a2:active {text-decoration:none; color: #646464;}
.a2:hover {text-decoration:none; color: white;}
.a3:link {text-decoration:none; color : #646464;}
.a3:visited{text-decoration:none; color: #646464;}
.a3:active {text-decoration:none; color: #646464;}
.a3:hover {text-decoration:none; color: #646464;}
   #mainContent{
      margin-top: 3%;
   }
   #boardListArea{
   margin-top : 0%;
   width : 600px;
   height : 450px;
   margin-left:10%;
   margin-right:12.1%;
   text-align: center;
/*    border : 2px soild gold; */
   display: inline-block;
   vertical-align: top;
   
   }
   h1{
      text-align:center;
   }
   table {
   color: #333;
   font-family: Helvetica, Arial, sans-serif;
   width: 640px;
/*    border-collapse: collapse; */
   border-spacing: 0;
}
td, th {
   border: 1px solid transparent;
   /* No more visible border */
   height: 30px;
   transition: all 0.3s;
   /* Simple transition for hover effect */
}
th {
   background: #DFDFDF;
   /* Darken header a bit */
   font-weight: bold;
}
td {
   background: #FAFAFA;
   text-align: center;
   color : #585858;
}

/* Cells in even rows (2,4,6...) are one color */

tr:nth-child(even) td {
   background: #F1F1F1;
}

/* Cells in odd rows (1,3,5...) are another (excludes header cells)  */

tr:nth-child(odd) td {
   background: #FEFEFE;
}
.namehover:hover {
   background: #666;
   color: white;
}

/* Hover cell effect! */
   }
   .tr_title{
      background : orange;
   }
   .td_num, .td_readcount{
      width : 70px;
   }
   .td_subject{
      width : 200px;
      text-align : left;
   }
   .td_writer, .td_regdate{
      width : 110px;
   }
   .td_writer, .td_regdate{
      width : 110px;
   }
   .td_mcode{
      width : 110px;
   }
   .notice{
      background: green;
   }
.t1:hover{
   color : white;
}

.divside1{
	width:200px;
	height:800px;
	display: inline-block;
 } 
.side1{
	width:190px;
	height: 600px;
}
.divside2{
	width:190px;
	height:800px;
	display: inline-block;
	right:0px;
 } 
.side2{
	width:190px;
	height: 600px;
	right:0%;
}

</style>
</head>
<%
   ArrayList<Board> boardList = (ArrayList<Board>)request.getAttribute("boardList");
   ArrayList<Board> boardNoticeList=(ArrayList<Board>)request.getAttribute("boardNoticeList");
   PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
   int number =pageInfo.getNumber();
   int b_division = (Integer)request.getAttribute("b_division");
%>
<body>

<div class="divside1">
<img class="side1" src="images/side1.png">
</div>


   <section id = "boardListArea">
   <%
      if(boardList !=null && boardList.size() > 0){
   %>
      <h1>좋은 하루 되세요^^</h1>
      <br>
      <div>
      <table>
         <tr class = "tr_title">
            <th>영화제목</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            
         </tr>
         <%
         if(boardNoticeList !=null){
            for(int i=0; i<boardNoticeList.size(); i++){
         %>
            <tr class="notice">
               <td><b>공지사항</b></td>
               <td class = "namehover"><a href="boardContent.bo?b_code=<%=boardNoticeList.get(i).getB_code()%>&pageNum=<%=pageInfo.getCurrentPage()%>&b_division=<%=b_division%>" class="a1"><b><%=boardNoticeList.get(i).getB_name() %></b></a></td>
               <td><b><%=boardNoticeList.get(i).getB_author() %></b></td>
               <td><b><%=boardNoticeList.get(i).getReadcount()%></b></td>
            
            
            </tr>
         <%
            }
         }
         %>
         <%
            for(int i = 0; i <boardList.size();i++){
         %>
         <tr>
            <td><%=boardList.get(i).getB_mcode() %></td>
            <td class="namehover">
            <a href="boardContent.bo?b_code=<%=boardList.get(i).getB_code()%>&pageNum=<%=pageInfo.getCurrentPage()%>&b_division=<%=b_division%>" class="a1"><%=boardList.get(i).getB_name() %></a>
            </td>
            <td><%=boardList.get(i).getB_author() %></td>
            <%-- <td class = "td_regdate"><%=sdf.format(boardList.get(i).getBoard_regDate()) %></td> --%>
            <td><%=boardList.get(i).getReadcount() %></td>
         </tr>
         <%
            }
         %>
      </table>
      </div>
         <%
            if(pageInfo.getStartPage() > 1){
               
         %>
         <a href = "boardList.bo?pageNum=<%=pageInfo.getStartPage() - 10 %>&b_division=<%=b_division%>" class="a2">[이전]</a>
      <%
      }
         for(int i = pageInfo.getStartPage(); i<=pageInfo.getEndPage();i++){
      %>
         <a href = "boardList.bo?pageNum=<%=i%>&b_division=<%=b_division%>"  class="a3">[<%=i %>]</a>
       <%
      }
         if(pageInfo.getEndPage() < pageInfo.getPageCount()){//현재 마지막 그룹이 아니면
   %>
      <a href = "boardList.bo?pageNum=<%=pageInfo.getStartPage() + 10 %>&b_division=<%=b_division%>" class="a2">[다음]</a>
   <%
      }
   %>
   <%
      }
   %>
   <br><a href = "writeForm.bo?b_division=<%=b_division%>"><input type="button" value="글쓰기"></a>
   <%
   int u_division=(int)session.getAttribute("u_division");
   %>
   <% if(u_division==0){ %> 
   <a href = "writeForm.bo?b_division=<%=b_division+3%>"><input type="button"  value="공지사항 글쓰기"></a>
   <%} %>
   </section>
   <div class="divside2">
<img class="side2" src="images/side2.png">
</div>

</body>
</html>
