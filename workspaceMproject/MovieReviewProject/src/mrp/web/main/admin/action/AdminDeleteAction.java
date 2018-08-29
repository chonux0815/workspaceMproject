package mrp.web.main.admin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.main.admin.svc.AdminDeleteService;
import mrp.web.vo.ActionForward;

public class AdminDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String u_id = request.getParameter("u_id");

		AdminDeleteService adminDeleteService = new AdminDeleteService();
		boolean deleteSuccess = adminDeleteService.deleteProcess(u_id);
		ActionForward forward = null;
		if (deleteSuccess) {
			forward = new ActionForward();
			forward.setUrl("adminListForm.ad");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 삭제실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}

}
