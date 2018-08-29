<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
body, html {
	margin: 0;
	padding: 0;
	height: 100%;
}

#join {
	border: 0;
	padding: 0;
	min-height: 100%;
	background-image: url('images/back1.jpg');
	background-position: center;
	background-size: cover;
}

.backimage2 {
	background: #F2F2F2;
	height: 70%;
	width: 60%;
	position: absolute;
	left: 45%;
	top: 25%;
	margin-left: -450px;
	margin-top: -100px;
	z-index: 10;
	text-align: center;
	padding-top: 2%;
	border-radius: 70px;
}

#jointext {
	margin-top: 1%;
	text-align: center;
	height: 60%;
}

#title {
	text-align: right;
	font-size: 15px;
	width: 20%;
}

#content {
	text-align: center;
	padding-right: 10%;
	width: 80%;
	height: 80%;
	padding-top: 0%;
	padding-bottom: 10%;
	padding-left: 15%;
	margin-left: 10%;
	margin-right: 10%;
}

.title2 {
	color: black;
	font-size: 40px;
	padding-top: 5%;
	font-weight: 900;
}

#btn1 {
	border-radius: 3px;
	background-color: #0B0B3B;
	color: white;
	border: none;
}

#btn2 {
	margin-top : 15%;
	border-radius: 6px;
	width: 30%;
	height: 12%;
	background-color: #0B0B3B;
	color: white;
	font-size: 25px;
	text-align: center;
	border: none;
	margin-bottom: 5%;
	font-weight: bold;
}

fieldset {
	width: 500px;
	height: 500px;
}

p {
	text-align: left;
}

#title2 {
	width: 0px;
}




</style>
</head>
<%
				String u_email = (String) request.getAttribute("u_email");
%>
<body>
	<div id="join">
		<br> <br>
		<div class=backimage2>
			<b><div class=title2><h1>비밀번호 찾기</h1></div></b> <br> <br> <br>
						<%if (u_email != null) {%>
						<b class = "b_namo">회원님의 비밀번호를<%=u_email%>로 전송하였습니다. 확인 부탁드립니다.</b><br>
						<%
							}
						%>
						
				<a href="Login.jsp"> <input id=btn2 type="button"
					value="로그인하러가기"></a>
			
			
		</div>
	</div>

</body>
</html>