﻿<%@page import="mrp.web.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script>
	$(document)
			.ready(
					function() {
						$(document)
								.keydown(
										function(event) {
											if (event.ctrlKey == true
													&& (event.which == '61'
															|| event.which == '107'
															|| event.which == '173'
															|| event.which == '109'
															|| event.which == '187' || event.which == '189')) {

												event.preventDefault();
												// 107 Num Key  +
												//109 Num Key  -
												//173 Min Key  hyphen/underscor Hey
												// 61 Plus key  +/=
											}
										});

						$(window).bind('mousewheel DOMMouseScroll',
								function(event) {
									if (event.ctrlKey == true) {

										event.preventDefault();
									}
								});
					});

	function logout() {
		session.invalidate();
		alert("로그아웃 합니다.");
	}
</script>
<link href="https://fonts.googleapis.com/css?family=Sunflower:300"
	rel="stylesheet">
<style>
#header {
	font-family: 'Sunflower', sans-serif;
	background-image: url("images/mainback11.png");
	margin: 0 auto;
	padding: 0;
	font-weight: bold;
}

.pull-left {
	float: left;
}

.pull-right {
	float: right;
}

a {
	text-decoration: none;
}

.main {
	width: 20%;
	height: 10%;
}
</style>
<style>
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

#main-navigation {
	border-top: 1px solid #C8C8C8;
	border-bottom: 1px solid #C8C8C8;
	margin-bottom: 20px;
	height: 40px;
	background-color: #3F3A89;
	border-radius: 10px;
}

.outer-menu-item {
	float: left;
	position: relative;
}

.outer-menu-item:hover {
	border-radius: 7px;
	background: #BCA9F5;
	color: white;
}

.menu-title {
	display: block;
	height: 30px;
	line-height: 30px;
	text-align: center;
	padding: 5px 20px;
	font-weight: bolder;
	color: white;
}

ul>li:hover>ul {
	display: block;
	background: white;
}

.inner-menu {
	display: none;
	position: absolute;
	top: 40px;
	left: 0;
	width: 100%;
	background: white;
	box-shadow: 0 2px 6px rgba(5, 5, 5, 0.9);
	z-index: 1000;
	text-align: center;
}

.inner-menu-item>a {
	display: block;
	padding: 5px 10px;
	color: black;
}

.inner-menu-item>a:hover {
	background: #4F639B;
	color: white;
}
</style>
<!-- 네비게이션 내부의 검색 -->
<style>
.search-bar {
	height: 26px;
	padding: 7px;
}

.input-search {
	display: block;
	float: left;
	background-color: #FFFFFF;
	border: 1px solid #CCCCCC;
	border-radius: 15px 0 0 15px;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
	width: 120px;
	height: 24px;
	padding: 0 0 0 10px;
	font-size: 12px;
	color: #555555;
}

.input-search:focus {
	border-color: rgba(82, 168, 236, 0.8);
	outline: 0;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.05);
}

.input-search-submit {
	display: block;
	float: left;
	width: 50px;
	height: 26px;
	border-radius: 0 15px 15px 0;
	border: 1px solid #CCCCCC;
	margin-left: -1px;
	vertical-align: top;
	display: inline-block;
}

#loginformation {
	right: 0px;
}

.profileimg {
	width: 50px;
	height: 50px;
	border-radius: 50%;
}

.dropdown {
	position: relative;
	display: inline-block;
	color: white;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	padding: 12px 16px;
	z-index: 1;
}

#shift_class:visited {
	color: white;
	text-decoration: none;
}
</style>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<script>
	
</script>
<body>
	<br>
	<div id="header">
		<a href="layoutTest.jsp"><img src="images/log.png" class="main"></a>
		<br>



		<div align=right id="loginformation">

			<img src="images/man.jpg" class="profileimg">
			<div class="dropdown">
				환영합니다!
				<c:if test="${u_name != null}">
				${u_name}님! <br>
				</c:if>
				<c:if test="${u_name == null}">
					<script>
						location.href = "Login.jsp";
					</script>
				</c:if>
				<div class="dropdown-content">

					<ul class="welcome">
						<li class="inner-menu-item"><a href="updateForm.log">회원정보수정</a></li>
						<c:if test="cartList != null">
							<li class="inner-menu-item"><a href="PointCartList.po">장바구니</a></li>
						</c:if>
						<li><hr></li>
						<li class="inner-menu-item"><a href="logout.log"
							onclick="logout">로그아웃</a></li>
						<c:if test="${u_division == 0}">
							<li><hr></li>
							<li class="inner-menu-item"><a href="adminListForm.ad"
								onclick="modifyForm">회원 목록보기</a></li>
						</c:if>
					</ul>

				</div>

			</div>


		</div>
		<nav id="main-navigation">
			<div class="pull-left">
				<ul class="outer-menu">
					<li class="outer-menu-item"><span class="menu-title"><a
							href="boardList.bo?b_division=1" id="shift_class">추천영화</a></span></li>
					<li class="outer-menu-item"><span class="menu-title"><a
							href="boardList.bo?b_division=2" id="shift_class">너의리뷰는?</a></span></li>
					<li class="outer-menu-item"><span class="menu-title"><a
							href="eventBoardList.bo?b_division=3" id="shift_class">이벤트 정보</a></span></li>
					<li class="outer-menu-item"><span class="menu-title"><a
							id="shift_class" href="pointProductList.po">포인트 상점</a></span>
					<li class="outer-menu-item"><span class="menu-title"><a
							id="shift_class" href="gpsLayout.jsp">주변 상영관</a></span>
				</ul>
			</div>
			<div class="pull-right">
				<div class="search-bar">
					<form action="findText.bo">
						<input type="text" name="find_text" class="input-search" /> <input
							type="submit" class="input-search-submit" value="검색" />
					</form>
				</div>
			</div>
		</nav>
	</div>
</body>
</html>