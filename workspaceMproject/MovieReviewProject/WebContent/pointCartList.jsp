<%@page import="mrp.web.vo.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function checkQty(p_name, qty) {
		if (qty != 1) {
			location.href = "PointCartQtyDown.po?p_name=" + p_name;
		} else {
			return;
		}
	}

	function cheakAll() {
		var deleteChk = myForm.delete1;
		if (deleteChk.length == undefined) {
			/* 체크박스의 체크상태 속성은 cheaked이다. true : 체크 false : 체크안함 */
			myForm.delete1.checked = myForm.allCheck.checked;
		} else {
			for (i = 0; i < deleteChk.length; i++) {
				deleteChk[i].checked = myForm.allCheck.checked;
			}
		}
	}
</script>
<style type="text/css">
#cartListArea {
	width: 600px;
	margin: auto;
	border: 1px solid orange;
}

#tr_title {
	background: orange;
}

table {
	width: 600px;
	margin: auto;
	text-align: center;
}

h1, .commandCell {
	text-align: center;
}

.cartimage {
	width: 70px;
	height: 70px;
}

.updownimage {
	width: 15px;
	height: 15px;
	border: 0;
}

#totalMoneyArea {
	width: 600px;
	margin: auto;
	text-align: right;
	font-size: xx-large;
}

#deleteBtn {
	text-align: right;
}
</style>
<meta charset="UTF-8">
</head>
<body>
	<%
		ArrayList<Cart> cartList = (ArrayList<Cart>) request.getAttribute("cartList");
		int totalMoney = (Integer) request.getAttribute("totalMoney");
	%>
	<section id="cartListArea">
		<h1>
			장바구니 <a href="pointProductList.po">쇼핑 계속하기</a>
		</h1>
		<%
			if (cartList == null || cartList.size() == 0) {
		%>
		<h1>상품이 존재하지 않습니다.</h1>
		<%
			} else {
		%>
		<form action="PointCartRemove.po" method="post" name="myForm">
			<table>
				<tr id="tr_title">
					<td>상품코드</td>
					<td>상품이미지</td>
					<td>상품명</td>
					<td>가격</td>
					<td>수량</td>
					<td class="commandCell"><input type="checkbox" id="allCheck"
						name="allCheck" onclick="cheakAll()"></td>
				</tr>
				<%
					int num = 1;
						for (int i = 0; i < cartList.size(); i++) {
				%>
				<tr>
					<td><%=num++%></td>
					<td><img src="images/<%=cartList.get(i).getP_image()%>"
						class="cartimage" /></td>
					<td><%=cartList.get(i).getP_name()%></td>
					<td><%=cartList.get(i).getP_point()%></td>
					<td><a
						href="PointCartQtyUp.po?p_name=<%=cartList.get(i).getP_name()%>"><img
							src="images/up.jpg" class="updownimage" /></a><br><%=cartList.get(i).getQty()%><br>
						<a
						href="javascript:checkQty('<%=cartList.get(i).getP_name()%>',<%=cartList.get(i).getQty()%>)"><img
							src=images/down.jpg " class="updownimage" /></a><br></td>
					<td><input type="checkbox" name="delete1"
						value="<%=cartList.get(i).getP_name()%>" /></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td colspan="3" id ="deleteBtn"> <input type = "button" onclick="location.href='updatePoint.po?totalMoney=<%=totalMoney%>'" value = "결제" /> </td>
					<td colspan="3" id="deleteBtn"><input type="submit" value="삭제" /></td>
				</tr>
			</table>
		</form>
		<section id="totalMoneyArea">
			총 결제금액:<%=totalMoney%>원
		</section>
		<%
			}
		%>
	</section>
</body>
</html>