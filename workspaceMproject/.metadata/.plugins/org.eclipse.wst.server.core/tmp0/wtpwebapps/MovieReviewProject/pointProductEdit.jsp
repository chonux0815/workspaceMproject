<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#main {
	padding-top: 10%;
}

#registFormArea {
	width: 600px;
	height: 350px;
	margin: auto;
	text-align: center;
	marging-top: 5%;
	background-color: #FAFAFA;
	border-radius: 20px;
}

table {
	width: 600px;
	margin: auto;
	text-align: center;
}

.td_left {
	width: 20%;
	padding: 1%;
	margin-top: 10%;
	margin-left: 20%;
	text-align: right;
}

.td_right {
	width: 50%;
	padding: 2%;
}

.td_right2 {
	width: 400px;
}

#p_point {
	width: 70%;
}

#p_name {
	width: 70%;
}

#p_content {
	width: 66%;
}

#p_term {
	width: 66%;
}

.title1 {
	font-size: large;
	padding-top: 5%;
}

.table1 {
	margin-top: 5%;
}

.button1 {
	margin: 10%;
	padding-top: 5%;
}
</style>

</head>
<body>
	<section id="registFormArea">
		<h1 class="title1">[상 품 등 록]</h1>

		<form action="pointProductEdit.po" method="POST"
			enctype="multipart/form-data">
			<table class="table1">
				<tr>
					<td class="td_left"><label for="p_name"><b>이름</b></label></td>
					<td class="td_right"><input type="text" name="p_name"
						id="p_name"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="p_point"><b>포인트 가격</b></label></td>
					<td class="td_right"><input type="text" name="p_point"
						id="p_point"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="p_image"><b>상품 이미지</b></label></td>
					<td class="td_right2"><input type="file" name="p_image"
						id="p_image"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="p_content"><b>상품
								설명</b></label></td>
					<td class="td_right2"><input type="text" name="p_content"
						id="p_content"></td>
				</tr>
				<tr>
					<td class="td_left"><label for="p_term"><b>유효 기간</b></label></td>
					<td class="td_right2"><input type="text" name="p_term"
						id="p_term"></td>
				</tr>
				<tr>
					<td colspan=2 class="button1"><input type="submit"
						value="상품 등록">&nbsp&nbsp&nbsp<input type="reset"
						value="다시 작성"></td>
				</tr>
			</table>
		</form>
	</section>

</body>
</html>