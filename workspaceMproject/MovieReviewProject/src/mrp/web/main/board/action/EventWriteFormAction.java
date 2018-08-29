package mrp.web.main.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;

public class EventWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_division=Integer.parseInt(request.getParameter("b_division"));
		ActionForward forward=new ActionForward();
		
		request.setAttribute("b_division", b_division);
		
		request.setAttribute("form_menu","eventWriteForm.jsp");	
		
		forward.setUrl("MainLayout.jsp");
		
		return forward;
	}

}
