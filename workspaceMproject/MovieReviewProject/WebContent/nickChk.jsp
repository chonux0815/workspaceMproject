<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	boolean nickExists = (Boolean)request.getAttribute("nickExists");
    String name = (String)request.getAttribute("nickname");
 %> 
<!DOCTYPE html>
<html>
<head>
<style>
h1 {
  font-size: 15px;
}
.nickForm {
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
		opener.document.forms[0].nickname.value = '<%=name%>';
		window.close();
	}
</script>
</head>
<body>

<%
	if(nickExists){
%>
<input type="button" value="현재 닉네임 선택" onClick="closeWin()" class="nickForm">
<%
}
else // 사용자가 입력한 아이디를 사용 가능한경우....
{
%>
<form method="post" action="nickChk.log">
<h1>이 닉네임은 사용 중인 닉네임 입니다.</h1><br>
닉네임 :<input type="text" name="nickname"></input><!-- 아이디 입력 텍스트박스 생성--><input type="submit" value="중복체크" class="nickForm"></input><!-- 재 중복체크를 위한 버튼 생성 -->
</form>

<% 
}
%>
</body>
</html>