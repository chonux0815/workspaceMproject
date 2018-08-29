package mrp.web.main.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.vo.ActionForward;

public class WriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_division = Integer.parseInt((String) request.getParameter("b_division"));
		ActionForward forward = new ActionForward();
		request.setAttribute("b_division", b_division);
		request.setAttribute("form_menu","writeForm.jsp");
		forward.setUrl("MainLayout.jsp");
		return forward;
	}

}
