<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	
	function checkvalue() {

		// a 텍스트 필드와 b 텍스트 필드 중 둘다 값이 있을 때
		if (test.pw.value && test.password.value) {

			// 두 필드의 값이 서로 다를 때
			if (test.pw.value != test.password.value) {

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
</script>
<title>회원가입</title>
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
	height: 50%;
}

#title {
	text-align: right;
	font-size: 15px;
	width: 20%;
}

#content {
	padding-right: 10%;
	width: 80%;
	height: 80%;
	padding-left: 15%;
	margin-left: 10%;
	margin-right: 10%;
	ime-mode: disabled;
}

#content2-1 {
	text-align: left;
	width: 35%;
	padding-left: 3%;
}

#content2-2 {
	text-align: left;
	padding-right: 7%;
	width: 35%;
	padding-left: 3%;
}

#content2-3 {
	text-align: left;
	padding-right: 7%;
	width: 35%;
	padding-left: 3%;
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
	background-color: #3F3A89;
	color: white;
	border: none;
}

#btn2 {
	border-radius: 6px;
	width: 30%;
	height: 8%;
	background-color: #3F3A89;
	color: white;
	font-size: 25px;
	text-align: center;
	border: none;
	margin-bottom: 5%;
	font-weight: bold;
}
.status{
	border:0;
	color:red;
	font-size:12px;
	width:160;
	background: #F2F2F2;
}

</style>
<script>// 회원가입폼 공백 체크
function checking()
{
if(document.writeForm.name.value == "") alert("이름을 입력하세요")
else if(document.writeForm.id.value == "") alert("아이디를 입력하세요")
else if(document.writeForm.pwd.value == "") alert("패스워드를 입력하세요")
else if(document.writeForm.pwd.value != document.writeForm.repwd.value) alert("패스워드가 틀립니다")
else document.writeForm.submit() 
}

function idCheck(){
	//alert("");
	window.open("idChk.log?id=" + document.forms[0].id.value ,"","width=400,height=250,location=no,status=no,scrollbars=yes");
}
function nickCheck(){
	//alert("");
	window.open("nickChk.log?nickname=" + document.forms[0].nickname.value ,"","width=300,height=300,location=no,status=no,scrollbars=yes");
}
</script>
</head>
<body>
	<div id="join">

		<br>
		<br>
		<div class=backimage2>

			<b><div class=title2>
					<font>회 원 가 입</font>
				</div></b> <br>
			<br>
			<br>

			<form action="joinProcess.log" method="post" name = "test">
				<table id="content">
					<tr>
						<td id="title">아이디</td>
						<td id="content2-1"><input type="text" name="id"
							maxlength="20"> <input id="btn1" type="button"
							value="중복확인" onClick="idCheck()"></td>
					</tr>

					<tr>
						<td id="title">비밀번호</td>
						<td id="content2-2"><input type="password" name="pw"
							onblur=checkvalue();></td>
					</tr>

					<tr>
						<td id="title">비밀번호 확인</td>
						<td id="content2-3"><input type="password" name="password"
							onblur=checkvalue();> <input type="text" name="status"
							class="status" readonly onfocus="this.blur();" value="">
						</td>
					</tr>

					<tr>
						<td id="title">닉네임</td>
						<td id="content2-4"><input type="text" name="nickname"
							maxlength="40"> <input id="btn1" type="button"
							value="중복확인" onClick="nickCheck()"></td>
					</tr>

					<tr>
						<td id="title">이메일</td>
						<td id="content2-5"><input type="text" name="str_email01"
							id="str_email01"> @ <input type="text" name="str_email02"
							id="str_email02" disabled value="선택하세요"> <select
							name="str_email02" id="selectEmail">
								<option value="0">선택하세요</option>
								<option value="1">직접입력</option>
								<option value="naver.com">naver.com</option>
								<option value="hanmail.net">daum.net</option>
								<option value="nate.com">nate.com</option>
								<option value="gmail.com">gmail.com</option>
						</select> <script type="text/javascript"
								src="http://code.jquery.com/jquery-latest.min.js"></script> <script
								type="text/javascript"> //이메일 입력방식 선택 
                                
                                $('#selectEmail').change(function(){ 
                                    $("#selectEmail option:selected").each(function () { 
                                        if($(this).val()== '1'){ //직접입력일 경우 
                                            $("#str_email02").val(''); //값 초기화 
                                            $("#str_email02").attr("disabled",false); //활성화 
                                        }else{ //직접입력이 아닐경우 
                                            $("#str_email02").val($(this).text()); //선택값 
                                            $("#str_email02").attr("disabled",true); //비활성화 
                                        } 
                                    }); 
                                }); 
                            </script></td>
					</tr>

					<tr>
						<td id="title">성별</td>
						<td id="content2-4"><input type="radio" name="gender"
							value="1" checked>남 <input type="radio" name="gender"
							value="2">여</td>
					</tr>

					<tr>
						<td id="title">생년월일</td>
						<td id="content2-4"><input type="date" name="birth">
						</td>
					</tr>
					<tr>
						<td id="title">비밀번호 찾기 질문</td>
						<td id="content2-4">태어난 출생지는 어디인가요?</td>
					</tr>

					<tr>
						<td id="title">비밀번호 찾기 답변</td>
						<td id="content2-4"><input type="text" name="pass"
							maxlength="20"></td>
					</tr>
				</table>
				<br> <input id="btn2" type="submit" value="가입하기" />
			</form>

		</div>
	</div>
</body>
</html>