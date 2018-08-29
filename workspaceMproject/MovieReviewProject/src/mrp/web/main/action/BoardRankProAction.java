package mrp.web.main.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.board.svc.EventBoardListService;
import mrp.web.main.svc.BoardRankProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;

public class BoardRankProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int b_code = Integer.parseInt((String) request.getParameter("b_code"));
		int b_division = Integer.parseInt((String) request.getParameter("b_division"));
		ActionForward forward = new ActionForward();
		forward.setUrl("boardContent.bo?b_code="+b_code+"&b_division="+b_division);	
		return forward;
	}

}
