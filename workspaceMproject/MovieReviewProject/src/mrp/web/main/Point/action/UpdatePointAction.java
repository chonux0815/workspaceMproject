package mrp.web.main.Point.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointCartQtyDownService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Cart;

public class UpdatePointAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String totalMoney = request.getParameter("totalMoney");
		int u_point = (Integer)session.getAttribute("u_point");
	    System.out.println(totalMoney);
	    String p_name = request.getParameter("p_name");
		u_point = u_point-Integer.parseInt(totalMoney);
		ActionForward forward = null;
		
	    if(u_point > 0) {
	    	request.setAttribute("p_name", p_name);
	    	forward = new ActionForward();
			forward.setUrl("UpdatPro.po");
	    }else {
	    	response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('포인트가 부족합니다.')");
			out.println("history.back()");
			out.println("</script>");
	    }
		return forward;
	}

}
