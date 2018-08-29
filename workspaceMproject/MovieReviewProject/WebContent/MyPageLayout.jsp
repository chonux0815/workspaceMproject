<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>너의 영화는</title>
<%
	String form_menu = (String) request.getAttribute("form_menu");
%>
<style>
#special {
	background: #FCFBFB;
	width: 1400px;
	margin: auto;
	padding-top: 20px;
}

#wrap {
	width: 1300px;
	margin: auto;
}

#title {
	height: 150px;
}

#main {
	height: 600px;
}

#mainContent {
	height: 600px;
	width: 1300px;
	float: left;
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
				<section id="mainContent"><jsp:include
						page="<%=form_menu%>"></jsp:include>
				</section>
			</section>
			<footer id="bottom">
				<jsp:include page="footer.html"></jsp:include>
			</footer>
		</section>
	</section>
</body>
</html>