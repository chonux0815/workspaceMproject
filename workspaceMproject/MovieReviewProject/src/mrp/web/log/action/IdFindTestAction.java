package mrp.web.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.svc.IdFindService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class IdFindTestAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		String name=null;
		String day=null;
		String email1=null;
		String email2=null;
		String email=null;
		name=request.getParameter("name");
		day=request.getParameter("day");
		email1=request.getParameter("str_email01");
		email2=request.getParameter("str_email02");
		email=email1+"@"+email2;
		IdFindService idFindService = new IdFindService();
		String user = idFindService.idFind(name, day, email);
		
		if(user != null) {
			HttpSession session=request.getSession();
			session.setAttribute("id", user);
			forward = new ActionForward();
			forward.setUrl("idFindSuccess.jsp");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
	         PrintWriter out = response.getWriter();
	         out.println("<script>");
	         out.println("alert('정보와 맞는 아이디값이 없습니다.')");
	         out.println("history.back()");
	         out.println("</script>");
		}
	     return forward;
	}

}
