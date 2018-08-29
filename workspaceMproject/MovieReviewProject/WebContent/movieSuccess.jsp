<%@page import="mrp.web.vo.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
* {
   margin: 0;
   padding: 0;
}

img {
   width: 200px;
   height: 300px;
}

a {
   color: red;
}

p {
   font-weight: bolder;
   text-align: center;
}

h1 {
   margin: 10px;
}

.tab {
   border: 1px solid #8B93B2;
   text-align: center;
   border-radius: 10px;
}

.painthr {
   border: 1px solid #8B93B2;
}
.painttd{
    background:  #8B93B2;
    color:white;
}
.widthtd{
    width:577px;
    height: 270px;
    text-align: left;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
   Movie movieList = (Movie) request.getAttribute("movie");
   int i = (int) request.getAttribute("i");
%>
<body>
   <table class="tab">
      <tr>
         <td colspan="3" class = "font_m"><h1><%=i%>위&nbsp;<%=movieList.getMovieNum()%></h1>
            <a><%=movieList.getRankOldAndNew()%></a></td>

      </tr>
      <tr>
         <td colspan="3">
            <hr class="painthr">
         </td>
      </tr>
      <tr>

       <td colspan="2" rowspan="2"><img
            src="images/<%=movieList.getMovieNum()%>.jpg"></td>
       <td colspan="2" class="painttd">
       줄거리
       </td>
      </tr>
      <tr>
         
         <td colspan="2" class="widthtd">
            <%
               if (movieList.getMovieNum().equals("인크레더블 2")) {
            %> <b>지금까지의 히어로는 잊어라!</b> <br><br>
            슈퍼맘 ‘헬렌’이 국민 히어로 ‘일라스티걸’로 활약하며
            세상의 주목을 받자 바쁜 아내의 몫까지 집안일을 하기 위해 육아휴직을 낸 아빠 ‘밥’은 질풍노도 시기의 딸 ‘바이올렛’,
            자기애가 넘치는 아들 ‘대쉬’, 어마무시한 능력을 시도때도 없이 방출하는 막내 ‘잭잭’까지 전담하며 전쟁같은 하루하루를
            보낸다.<br>
             그러던 어느 날, 각자의 위치에서 바쁜 일상을 보내던 슈퍼파워 가족 앞에 새로운 악당이 나타났다!<br>
             다시 한번
            세상을 구하기 위해 나선 가족은 ‘인크레더블’한 능력을 발휘할 수 있을까? <%
    } else if (movieList.getMovieNum().equals("앤트맨과 와스프")) {
 %> <b>“이제 믿을 건 자네 둘 뿐이야”</b><br><br>
                  사이즈부터 다른 마블의 히든카드가 온다 ‘시빌 워’ 사건 이후 은둔하며 히어로와 가장의
            역할 사이에서 고민 중이던 ‘앤트맨’과 새로운 파트너 ‘와스프’ 앞에 정체불명의 빌런 ‘고스트’가 등장한다.<br>
             시공간의
            개념이 사라진 양자 영역으로 들어갈 수 있는 기술을 훔쳐 달아난 고스트를 쫓던 앤트맨과 와스프는 상상도 못했던 상황에
            직면하는데… <%
    } else if (movieList.getMovieNum().equals("마녀")) {
 %> 10년 전 의문의 사고가 일어난 시설에서 홀로 탈출한 후 모든 기억을 잃은 ‘자윤’. 나이도, 이름도 모르는 자신을 거두고
            키워준 노부부의 보살핌으로 씩씩하고 밝은 여고생으로 자라났다.<br>
             어려운 집안사정을 돕기 위해 상금이 걸린 오디션 프로그램에
            출연한 자윤, 방송이 나간 직후부터 의문의 인물들이 그녀 앞에 나타난다.<br> 자윤의 주변을 맴돌며 날카롭게 지켜보는 남자
            ‘귀공자’, 그리고 과거 사고가 일어난 시점부터 사라진 아이를 찾던 ‘닥터 백’과 ‘미스터 최’까지 자신은 전혀 기억하지
            못하는 그들의 등장으로, 자윤은 혼란에 휩싸이게 되는데...!<br>
             그들이 나타난 후 모든 것이 바뀌었다 <%
    } else if (movieList.getMovieNum().equals("스카이스크래퍼")) {
 %> <b>누구도 구하지 못한다면 내가 한다!</b><br><br> 세계 최고층 빌딩, 사상 최대의 재난 역대 최악의 테러 집단을 향한 불꽃같은 그의
            분노가 폭발한다! <%
    } else if (movieList.getMovieNum().equals("독전 익스텐디드 컷")) {
 %> <b>아시아 최대 마약 조직, 실체 없는 적을 추적하라!</b><br><br> 
             의문의 폭발 사고 후, 오랫동안 마약 조직을 추적해온 형사
            ‘원호’(조진웅)의 앞에 조직의 후견인 ‘오연옥’(김성령)과 버림받은 조직원 ‘락’(류준열)이 나타난다.<br>
             그들의 도움으로
            아시아 마약 시장의 거물 ‘진하림’(김주혁)과 조직의 숨겨진 인물 ‘브라이언’(차승원)을 만나게 되면서 그 실체에 대한
            결정적 단서를 잡게 되는데… <br>
            끝까지 의심하라! 독한 자들의 전쟁이 시작된다! <%
    } else if (movieList.getMovieNum().equals("호텔 아르테미스")) {
 %> <b>살인 금지, 무기 금지, 욕설 금지!</b><br><br>
              엄격한 룰과 신뢰를 바탕으로 운영되는 범죄자 전용 병원 호텔 아르테미스.<br>
                 무면허 의사
            진 토마스는 섬세한 간호사 에베레스트와 함께 22년째 이곳을 운영 중이다.<br>
            어느 날 총상을 입은 은행 강도와 베테랑 킬러,
            진상 고객 무기상과 마피아 보스 '울프킹'과 그의 패거리까지 최악의 악당들이 이곳에 모여들면서 모든 룰이 깨지고, 오픈
            이래 가장 분주한 밤이 시작되는데… <%
    } else if (movieList.getMovieNum().equals("속닥속닥")) {
 %>             <b>섬뜩한 소문의 귀신의 집, 그곳의 문이 열린다!</b><br><br> 
                             수능을 끝낸 6명의 고등학생, 섬뜩한 소문이 있는 귀신의 집을 우연히
            발견하게 된다.<br>
            그곳에서 죽음의 속삭임과 함께 친구들이 한 명씩 사라지고 멈출 수 없는 극한의 공포가 그들을 덮치는데...
            <%
    } else if (movieList.getMovieNum().equals("미드나잇 선")) {
 %> <b>사랑을 꿈꿨던 낮, 사랑이 이뤄진 밤 어두운 밤에도 네가 나의 태양이었어...</b><br><br>
               XP(색소성건피증)라는 희귀병으로 태양을 피해야만
            하는 케이티. <br>
            오직 밤에만 외출이 허락된 그녀에게는 어머니가 남겨준 기타와 창문 너머로 10년째 짝사랑해온 ‘찰리’가
            세상의 빛이다. 어느 날 작은 기차역에서 한밤의 버스킹을 하던 ‘케이티’의 앞에 ‘찰리’가 나타나고, 두 사람은 매일
            밤마다 모두가 부러워하는 완벽한 데이트를 이어간다.<br>
            처음으로 함께 여행을 떠난 날, 꿈 같은 시간을 보내던 ‘케이티’는
            그만 지켜야만 하는 규칙을 어기게 되고 결국 피할 수 없는 선택을 해야만 하는데… 너에게 하고 싶은 진짜 사랑 고백 태양이
            뜬 뒤에도 내 곁에 있어줄래? <%
    } else if (movieList.getMovieNum().equals("변산")) {
 %> <b>“꼬일 대로 꼬여버린 빡센(?) 인생, 더 꼬이기 시작했다!”</b><br><br>
              발렛 파킹, 편의점 아르바이트로 빡센(?!) 청춘을
            보내지만, 쇼미더머니 6년 개근의 열정을 불태우는 무명 래퍼 학수 a.k.a 심뻑(박정민).<br>
            또 다시 예선 탈락을 맞이한
            인생 최악의 순간, 한 통의 전화를 받고 잊고 싶었던 고향 변산으로 향한다. 짝사랑 선미 (김고은)의 꼼수(?)에 제대로
            낚여 고향에 강제로 소환된 학수.<br>
            징글징글하게 들러 붙는 옛 친구들로 인해 지우고 싶었던 흑역사는 하나, 둘 떠오르고 하루
            빨리 고향을 뜨고 싶었던 학수는 예측 불허의 사건들을 겪으면서 인생 최대 위기를 맞이하게 되는데…<br>
            빡세지만 스웩 넘치고,
            부끄럽지만 빛나는 청춘! 징하게 들러붙는 흑역사 정면 돌파가 시작된다! <%
    }
 %>

         </td>
      </tr>
      <tr>
         <td colspan="3">
            <hr class="painthr">
         </td>
      </tr>
      <tr>
         <td colspan="3"class="painttd"><p>
               누적 관객수 :<%=movieList.getAudiacc()%></p></td>
      </tr>
   </table>
</body>
</html>