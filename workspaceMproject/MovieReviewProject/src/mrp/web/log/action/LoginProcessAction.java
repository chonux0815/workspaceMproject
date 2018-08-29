package mrp.web.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.LoginService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;
public class LoginProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String u_id = request.getParameter("u_id");
		String u_passwd = request.getParameter("u_pw");

		LoginService loginService = new LoginService();
		User loginNickname = loginService.login(u_id, u_passwd);
		ActionForward forward = null;
		
		System.out.println();
		if (loginNickname.getU_name() != null) {
			forward = new ActionForward();
			HttpSession session = request.getSession();
			session.setAttribute("u_name", loginNickname.getU_name());
			session.setAttribute("u_division", loginNickname.getU_division());
			session.setAttribute("u_point", loginNickname.getU_point());
			forward.setUrl("layoutTest.jsp");
			forward.setRedirect(true);
		}else{
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
	}
}
