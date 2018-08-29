package mrp.web.main.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.main.admin.svc.ModifyProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		user.setU_id(request.getParameter("u_id"));
		user.setU_name(request.getParameter("u_name"));
		user.setU_email(request.getParameter("u_email"));
		user.setU_point(Integer.parseInt(request.getParameter("u_point")));
		user.setU_passwd(request.getParameter("u_passwd"));

		HttpSession session = request.getSession(false);
		String be_name = (String) session.getAttribute("be_name");

		ModifyProService modifyProService = new ModifyProService();
		boolean modifySuccess = modifyProService.modifyuser(user, be_name);

		ActionForward forward = null;
		if (modifySuccess) {
			forward = new ActionForward();
			forward.setUrl("successModify.jsp");
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
