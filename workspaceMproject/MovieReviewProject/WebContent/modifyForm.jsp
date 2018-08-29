<%@page import="mrp.web.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = (User) request.getAttribute("user");
	%>

<body>
	<section id="updateFormArea">
	<h1>수정</h1>
	<form action="modifyUserPro.ad" method="post">
		<table>
			<tr>
				<td class="td_left"><label for="u_id">아이디</label></td>
				<td class="td_right"> <input type="text" name="u_id" maxlength="40" value="<%=user.getU_id()%>"></td>

			</tr>
			<tr>
				<td class="td_left"><label for="u_name">닉네임</label></td>
				<td class="td_right"><input type="text" name="u_name" maxlength="40" value="<%=user.getU_name()%>"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="u_email">이메일</label></td>
				<td class="td_right"><input type="text" name="u_email" maxlength="40" value="<%=user.getU_email()%>"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="u_passwd">비밀번호</label></td>
				<td class="td_right"><input type="text" name="u_passwd" maxlength="40" value="<%=user.getU_passwd()%>"></td>
			</tr>
			<tr>
				<td class="td_left"><label for="u_point">포인트</label></td>
				<td class="td_right"><input type="text" name="u_point" maxlength="40" value="<%=user.getU_point()%>"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정하기"></td>
			</tr>
		</table>

	</form>
	</section>
</body>
</html>