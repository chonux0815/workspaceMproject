<%@page import="mrp.web.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script>
	function checkValue() {

		// a 텍스트 필드와 b 텍스트 필드 중 둘다 값이 있을 때
		if (test.u_passwd.value && test.u_passwd1.value) {

			// 두 필드의 값이 서로 다를 때
			if (test.u_passwd.value != test.u_passwd1.value) {

				// status 필드에 일치하지 않는다는 문장 출력
				test.status.value = "일치하지 않습니다.";

				// 그에 맞게 길이 수정
				test.status.style.width = 120;

				// 두 필드의 값이 동일 할 때
			} else {

				// status 필드에 일치한다는 문장 출력
				test.status.value = "일치합니다.";

				// 역시 그에 맞게 길이 수정
				test.status.style.width = 83;
			}

			// a 텍스트 필드와 b 텍스트 필드 두중하나라도 값이 없을 때
		} 

	}
	function updateCheck(){
		window.open("index.jsp","로그인화면","width=430,height=500,location=no,status=no,scrollbars=yes");
	}
	
</script>
<title>Insert title here</title>
<style>
body, html {
   margin: 0;
   padding: 0;
   height: 100%;
}
#backimage1 {
   background: #F2F2F2;
   height: 520px;
   width : 1100px;
   position: absolute;
  margin-top : 10px;
   text-align: center;
   padding-top: 2%;
}
    .sidebar{
        width: 20%;
        height: 90%;
        float: left;
        margin-left: 5%; 
    }
    .sidebar ul { 
        margin: 0; 
        padding-top: 60%; 
        list-style: none; 
    }
    .sidebar ul li {
        margin: 10%;
        padding: 10px 5px; 
        border-bottom: 1px solid #DDD; 
    }
    .sidebar ul li a { 
        color: #333; 
        text-decoration: none; }
    .sidebar ul li a:hover { 
        color: #F00; 
        text-decoration: underline; 
    }
   #updateFormArea {
       width : 60%;
       height: 90%;
       margin-right: 15%;
       position : relative;
       text-align: center;
       font-size: 20px;
       float: right;
       display: table-cell;
       vertical-align: middle;
    }
    #updateFormArea > table {
    margin : 15px;
    }
    table {
        padding-right: 10%;
      width: 80%;
      height: 80%;
      padding-left: 15%;
    }
    .td_left {
        font-weight: bold;
        text-align: right;
        font-size: 17px;
        width: 35%;
        padding : 3%;
    }
    .td_right {
   text-align: left;
   width: 50%;
   padding-left: 5%;
   font-size: 16px;
    }
    .status{
   border:0;
   color:red;
   font-size:12px;
   width:160;
   background: #F2F2F2;
    }
    .buttonTab {
       padding-top: 10%;
       padding-left: 5%;
    }
    .button {
        background: #2D3854;
        color: white;
        border: 5px solid #2D3854;
        font-size: 18px;
        width: 40%; 
     
    }  
    .tablecell{
    margin-left:5%;
    margin-top: 7%;
    
    }
    h1 {
      padding-top: 5%;
    }
</style>
</head>
<%
 User user = (User)request.getAttribute("user");
 
%>
<body>
<div id = "backimage1">
 <div class="sidebar">
     <ul>
        <li><a href="#">회원 정보 수정</a></li>
        <li><a href="pointCon.log">포인트 사용 내역 확인</a></li>
        <li><a href="pointChk.log">포인트 잔액 확인</a></li>
     </ul>
 </div>
 <div id="updateFormArea">
   
   <h1>회원정보 수정</h1>
   <form action ="updatePro.log" method="post" name="test">
     <table class = "tablecell">
     <tr>
        <td class="td_left"><label for="u_id">아이디</label></td>
        <td class="td_right"><%=user.getU_id() %></td>
     </tr>
     <tr>
        <td class="td_left"><label for="u_passwd">비밀번호</label></td>
        <td class="td_right"><input type="password" name="u_passwd" id="u_passwd" onblur=checkValue();></td>
     </tr>
    <tr>
        <td class="td_left"><label for="u_passwd">비밀번호 확인</label></td>
        <td class="td_right"><input type="password" name="u_passwd1" id="u_passwd1" onblur=checkValue();>
            <input type="text" name="status" class="status" readonly onfocus="this.blur();" value=""></td>
     </tr>
     <tr>
        <td class="td_left"><label for="u_name">닉네임</label></td>
        <td class="td_right"><%=user.getU_name()%></td>
     </tr>
     <tr>
        <td class="td_left"><label for="u_email">이메일</label></td>
        <td class="td_right"><%=user.getU_email() %></td>
     </tr>
     <tr>
        <td class="td_left"><label for="u_day">생년월일</label></td>
        <td class="td_right"><%=user.getU_day() %></td>
     </tr>
    
     <tr>
        <td colspan="2" class="buttonTab"><input type="submit" value="수정하기" class="button">&nbsp&nbsp<input type="button" value="홈으로" onclick = "location.href='layoutTest.jsp'" class="button"></td>
     </tr>
     </table>
   </form>
   </div>
    </div>
</body>
</html>