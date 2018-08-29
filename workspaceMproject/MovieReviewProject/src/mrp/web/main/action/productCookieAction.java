package mrp.web.main.action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.vo.ActionForward;

public class productCookieAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		if(cookies != null){ //클라이언트에서 쿠키객체가 하나라도 넘어왔을때
			for(int i=0;i<cookies.length;i++){
				if(cookies[i].getName().startsWith("today")){
					todayImageList.add(cookies[i].getValue());
				}
			}
		}
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward();
		request.setAttribute("cookie_menu", "todayProductSuccess.jsp");
		forward.setUrl("layoutTest.jsp");
		return forward;
	}

}
