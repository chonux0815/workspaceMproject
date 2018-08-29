
<%@page import="mrp.web.vo.PointProduct"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
#pointProductListArea {
	width: 620px;
	border: 1px solid gold;
	margin: auto;
	background-color: #FDF3DE;
}



table {
	width: 600px;
	margin: auto;
	text-align: center;
	border : 1px solid #BCBCBC;
}

.productImage {
	width: 200px;
	height: 150px;
	border: none;
	padding: 20px 35px;
}

.pointRegist {
	color: white;
	border: 1px solid #655ce4;
	background-color: #655ce4;
	font-size: small;
	text-align: center;
	padding: 0.4%;
	height: 5%;
	width: 8%;
	margin-top: 2%;
	margin-left: 72%;
	border-radius: 10px;
	margin-bottom: 1%;
}

.pointRegist:hover {
	color: white;
}

.pointProductList {
	text-align: center;
	font-size: 20px;
	margin-top: 2%;
}
.regist1 {
   color: white;
}

</style>


</head>


<body>
	<%
		ArrayList<PointProduct> pointProductList = (ArrayList<PointProduct>) request
				.getAttribute("pointProductList");
		int u_division = (Integer) session.getAttribute("u_division");
	%>

	<section id="PointProductListArea">
	<h1 class="pointProductList">포인트 상점</h1>
	<%
		if (pointProductList != null && pointProductList.size() > 0) {
	%> <%
 	if (u_division == 0) {
 %>
	<div class="pointRegist">
		<a href="pointProductRegistForm.po"><b class = "regist1">포인트 상품등록</b></a>

	</div>
	<%
		}
	%>
	<table class="list_1">
		<tr>
			<%
				for (int i = 0; i < pointProductList.size(); i++) {
			%>

			<td><a
				href="pointProductView.po?p_id=<%=pointProductList.get(i).getP_id()%>">
					<img src="images/<%=pointProductList.get(i).getP_image()%>"
					class="productImage">
			</a><br> [<%=pointProductList.get(i).getP_name()%>]<br> <font
				color="red"><b><%=pointProductList.get(i).getP_point()%>P</b></font></td>
			<%
				if ((i + 1) % 3 == 0) {
			%>
		</tr>
		<tr>
			<%
				}
					}
			%>
		
		<tr>
	</table>
	<%
		}
	%> </section>




</body>
</html>