 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	alert('비밀번호가 성공적으로 변경되었습니다. 재로그인 해주세요');
	window.location.href="Login.jsp";
</script>
</head>
<body>
<form action="logout.log" method="post">
<h1>비밀번호가 성공적으로 변경되었습니다. 재로그인 해주세요</h1>
<input type="submit" value = "로그인" class="button">
</form>
</body>
</html>