package mrp.web.log.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.svc.IdChkService;
import mrp.web.log.svc.NickChkService;
import mrp.web.vo.ActionForward;

public class nickChkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		ActionForward forward = null;
		String nickname = request.getParameter("nickname");
		System.out.println(nickname);
		
		NickChkService nickChkService = new NickChkService();
		boolean nickChkSuccess = nickChkService.nickChk(nickname);
		
		System.out.println(nickChkSuccess);
		request.setAttribute("nickExists", nickChkSuccess);
		request.setAttribute("nickname", nickname);
		forward = new ActionForward();
		forward.setUrl("nickChk.jsp");
		return forward;
	}

}
