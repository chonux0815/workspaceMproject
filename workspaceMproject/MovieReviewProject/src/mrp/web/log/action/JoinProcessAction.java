package mrp.web.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.svc.JoinProcessService;
import mrp.web.log.svc.LoginService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class JoinProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = new User();
		user.setU_id(request.getParameter("id"));
		user.setU_passwd(request.getParameter("pw"));
		user.setU_name(request.getParameter("nickname"));
		String u_email1 = request.getParameter("str_email01");
		String u_email2 = request.getParameter("str_email02");
		System.out.println(u_email2);
		String u_email = u_email1+"@"+u_email2;
		
		user.setU_email(u_email);
		user.setU_gender(Integer.parseInt(request.getParameter("gender")));
		user.setU_day(request.getParameter("birth"));
		user.setU_hint(request.getParameter("pass"));
		
		
		System.out.println(user);
		
		
		JoinProcessService joinProcessService = new JoinProcessService();
		
		ActionForward forward = null;
		boolean joinSuccess = joinProcessService.join(user);

		if(joinSuccess) {
			forward = new ActionForward();
			forward.setUrl("Login.jsp");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원정보를 다시 확인 해주세요.')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward;
	}

}
