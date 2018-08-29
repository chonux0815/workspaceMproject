package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;

public class BoardRemakeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Board board=(Board)request.getAttribute("board");
		HttpSession session=request.getSession();
				
		request.setAttribute("board", board);
		
		ActionForward forward=new ActionForward();
		
		
		session.setAttribute("form_menu", "remakeForm.jsp");
		forward.setUrl("MainLayout.jsp");
		
		return forward;
	}

}
