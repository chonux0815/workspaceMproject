package mrp.web.log.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mrp.web.vo.User;
import mrp.web.vo.ActionForward;

public class PwFindAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		
		
		
		ActionForward forward = new ActionForward();
		
	      forward.setUrl("pwFind.jsp");
	      
	      return forward;
	}

}
