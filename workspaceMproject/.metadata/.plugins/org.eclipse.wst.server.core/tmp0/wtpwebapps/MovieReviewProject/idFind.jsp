<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>

body,html { 
    margin: 0;
    padding: 0;
    height: 100%; 
}

#join{
border: 0;
    padding: 0; 
    min-height: 100%;
     background-image: url('images/back1.jpg');
    background-position: center;
    background-size: cover;
}

.backimage2{

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

#jointext{

margin-top:1%;
text-align: center;
height: 60%;
}
#title{
text-align:right;
font-size:15px;
width: 20%;

}

#content{
padding-right: 10%;
width:80%;
height: 80%;
padding-top:0%;
padding-bottom:10%;
margin: 0 auto;
}

#content2-1{
text-align:left;
width: 35%;
/* padding-left: 3%; */
padding: 0% 3%;

}
#content2-2{
text-align:left;
padding-right: 5%;
width: 35%;
padding-left: 3%;

}
#content2-3{
text-align:left;
padding-right: 7%;
width: 35%;
padding-left: 3%;
}
#content2-4{
text-align:left;
width: 35%;
padding-left: 3%;                               
}
#content2-5{
text-align:left;
width: 50%;
padding-left: 3%;

}
.title2{
color: black;
font-size:40px;
padding-top: 5%;
font-weight: 900;
}
#btn1{
border-radius:3px;
background-color:#0B0B3B;
color: white;
border: none;
}
#btn2{
border-radius:6px;
width:30%;
height:12%;
background-color:#0B0B3B;
color: white;
font-size: 25px;
text-align: center;
border: none;
margin-bottom: 5%;
font-weight: bold;
}
fieldset{
   width:500px;
   height:500px;
}
p{
   text-align: left;
}
</style>
</head>
<body>
 <div id="join">

        <br><br>
       <div class=backimage2>
       
        <b><div class=title2><font>아이디 찾기</font></div></b>
        <br><br><br>
        
        <form id=jointext action="idFindTest.log" method="post">
            <table id="content" >
                <tr>
                    <td id="title">이름</td>
                    <td id=content2-1>
                        <input  type="text" name="name" maxlength="20" placeholder="ex)홍길동">
                          
                    </td>
                </tr>
                        
                <tr>
                    <td id="title">생년월일</td>
                    <td id=content2-2>
                        <input  type="date" name="day" maxlength="15">
                    </td>
                </tr>
                
                    
                <tr>
                    <td id="title">이메일</td>
                    <td id=content2-4>
                      <!--   <input type="text" name="email" maxlength="40"  placeholder = "ex) tmdgns5453@naver.com"> -->
                      <input type="text" name="str_email01" id="str_email01"> 
                          @
                            <input type="text" name="str_email02" id="str_email02" disabled value="선택하세요"> 
                            
                            <select name="str_email02" id="selectEmail"> 
                                <option value="0" >선택하세요</option>
                                <option value="1">직접입력</option> 
                                <option value="naver.com">naver.com</option> 
                                <option value="hanmail.net">daum.net</option>
                                <option value="nate.com">nate.com</option>
                                <option value="gmail.com">gmail.com</option>
                            </select> 
                            <script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script> 
                            <script type="text/javascript"> //이메일 입력방식 선택 
                                
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
                            </script>
                       	
                    </td>
                </tr>
                
            </table>
           
          <input id=btn2 type="submit" value="조회하기"/>
           <br>
           </form>
            </div>
    </div>

</body>
</html>