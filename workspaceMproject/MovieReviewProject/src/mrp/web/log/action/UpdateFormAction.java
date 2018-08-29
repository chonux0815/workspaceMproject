package mrp.web.log.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.UpdateFormService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class UpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("action");
		HttpSession session = request.getSession(false);
		String u_name = (String)session.getAttribute("u_name");
		UpdateFormService updateFormService = new UpdateFormService(); 
		User user = updateFormService.getUpdateUser(u_name);
		
		request.setAttribute("user", user);
		
		
		
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "updateForm.jsp");
		forward.setUrl("MyPageLayout.jsp");
		
		return forward;
	}

}
