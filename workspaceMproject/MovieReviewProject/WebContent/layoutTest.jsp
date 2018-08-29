<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>너의 영화는</title>
<%
	String form_menu = (String) request.getAttribute("form_menu");
	if (form_menu == null) {
		form_menu = "weeksMovie.jsp";
	}
	String menu_form = (String) request.getAttribute("menu_form");
	if (menu_form == null) {
		menu_form = "boardRank.jsp";
	}
	String cookie_menu = (String) request.getAttribute("cookie_menu");
	if (cookie_menu == null) {
		cookie_menu = "todayProduct.jsp";
	}
%>
<style>
#special {
	background: #FCFBFB;
	width: 1400px;
	height: 1050px;
	margin: auto;
}

#wrap {
	width: 1300px;
	height: 1000px;
	margin: auto;
	padding-top: 20px;
}

#title {
	height: 200px;
}

#main {
	height: 700px;
}

#menu {
	display: block;
	height: 700px;
	width: 250px;
	float: left;
}

#mainContent {
	height: 500px;
	width: 350px;
	float: left;
}

#mainContent3 {
	height: 500px;
	width: 360px;
	float: left;
}

#mainContent4 {
	height: 500px;
	width: 340px;
	float: left;
}

#mainContent2 {
	height: 200px;
	width: 1050px;
	float: left;
}

#footer {
	height: 100px;
}

</style>
</head>
<body>
	<section id="special">
		<section id="wrap">
			<header id="title">
				<jsp:include page="index.jsp"></jsp:include>
			</header>
			<br>
			<section id="main">
				<aside id="menu">
					<jsp:include page="<%=menu_form%>"></jsp:include>
				</aside>
				<section id="mainContent2">
					<jsp:include page="MovieSlide.jsp"></jsp:include>
				</section>
				
					<section id="mainContent"><jsp:include
							page="<%=form_menu%>"></jsp:include>
					</section>
					<section id="mainContent3"><jsp:include
							page="MovieInfo.jsp"></jsp:include>
					</section>
					<section id="mainContent4"><jsp:include
							page="<%=cookie_menu%>"></jsp:include>
					</section>

			</section>
			<footer id="bottom">
				<jsp:include page="footer.html"></jsp:include>
			</footer>
		</section>
	</section>
</body>
</html>