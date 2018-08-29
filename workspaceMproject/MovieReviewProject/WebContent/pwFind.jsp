<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	margin-left: 5%;
}

#content2-1 {
	text-align: left;
	width: 35%;
	/* padding-left: 3%; */
	padding: 0% 3%;
}

#content2-2 {
	text-align: left;
	padding-right: 5%;
	width: 35%;
	padding-left: 0%;
}

#content2-3 {
	text-align: left;
	padding-right: 7%;
	width: 35%;
	padding-left: 0%;
}

#content2-4 {
	text-align: left;
	width: 35%;
	padding-left: 3%;
}

#content2-5 {
	text-align: left;
	width: 50%;
	padding-left: 3%;
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

#title3 {
	width: 0px;
}

.form {
	width: 50%;
	height: 30%;
	margin: 0 auto;
	
}

.form td {
	padding: 10px;
}

input {
	width: 500px;
	height: 40px;
	font-size: 25px;
}
</style>
</head>
<body>
	<div id="join">

		<br> <br>
		<div class=backimage2>

			<b><div class=title2>
					<font>비밀번호 찾기</font>
				</div></b> <br> <br> <br>
			<div class="form">
				<form id=jointext action="pwFindTest.log" method="post">
					<table id="content">
						<tr>
							<td id=content2-1><input type="text" name="id"
								maxlength="20" placeholder="아이디"></td>

						</tr>
						<tr>
							<td></td>

						</tr>
						<tr>
							<td></td>

						</tr>

						<tr>
							<td id=content2-4><input type="text" name="hint"
								maxlength="15" placeholder="당신의 출생지는 어디인가요?"></td>
						</tr>
					</table> \
			</div>
			<br>
			<input id=btn2 type="submit" value="조회하기" /> <br>
			</form>
		</div>
	</div>

</body>
</html>