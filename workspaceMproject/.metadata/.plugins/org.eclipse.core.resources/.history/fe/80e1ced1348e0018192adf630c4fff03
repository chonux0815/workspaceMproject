package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;

public class BoardRemakeFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_code=Integer.parseInt(request.getParameter("b_code"));
		String b_content=request.getParameter("b_content");
		String b_name=request.getParameter("b_name");
		String b_mcode=request.getParameter("b_mcode");
		int b_division=Integer.parseInt(request.getParameter("b_division"));
		
		request.setAttribute("b_code", b_code);
		request.setAttribute("b_content", b_content);
		request.setAttribute("b_name", b_name);
		request.setAttribute("b_code", b_mcode);
		request.setAttribute("b_division", b_division);
		HttpSession session=request.getSession();
				
		ActionForward forward=new ActionForward();
		
		
		session.setAttribute("form_menu", "remakeForm.jsp");
		forward.setUrl("MainLayout.jsp");
		
		return forward;
	}

}
