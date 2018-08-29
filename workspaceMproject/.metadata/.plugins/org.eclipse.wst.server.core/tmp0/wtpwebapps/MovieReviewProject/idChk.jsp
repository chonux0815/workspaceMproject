<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	boolean idExists = (Boolean)request.getAttribute("idExists");
    String id = (String)request.getAttribute("id");
 %> 
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
  font-size: 15px;
}
 .idForm {
    border-radius: 3px;
    background-color: #3F3A89;
    color: white;
    border: none;
}
 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function closeWin(){
		opener.document.forms[0].id.value = '<%=id%>';
		window.close();
	}
</script>
</head>
<body>

<%
	if(idExists){
%>
<input type="button" value="현재 아이디 선택" onClick="closeWin()"  class="idForm">
<%
}
else // 사용자가 입력한 아이디를 사용 가능한경우....
{
%>
<form method="post" action="idChk.log">
<h1>이 아이디는 사용 중인 아이디 입니다.</h1>
아이디 :<input type="text" name="id"></input><!-- 아이디 입력 텍스트박스 생성--><input type="submit" value="중복체크" class="idForm"></input><!-- 재 중복체크를 위한 버튼 생성 -->
</form>

<% 
}
%>
</body>
</html>