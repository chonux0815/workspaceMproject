package mrp.web.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.UpdateProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class UpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		HttpSession session = request.getSession(false);
		String u_name = (String) session.getAttribute("u_name");
		user.setU_name(u_name);
		user.setU_passwd(request.getParameter("u_passwd"));
		UpdateProService updateProService = new UpdateProService();
		boolean updateSuccess = updateProService.updateuser(user);

		ActionForward forward = null;
		if (updateSuccess) {
			forward = new ActionForward();
			request.setAttribute("form_menu", "passwdSuccess.jsp");
			forward.setUrl("MyPageLayout.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('수정실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
