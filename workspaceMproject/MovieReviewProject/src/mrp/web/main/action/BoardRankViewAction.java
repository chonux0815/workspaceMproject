package mrp.web.main.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.action.Action;
import mrp.web.main.board.svc.EventBoardListService;
import mrp.web.main.svc.BoardRankViewService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.Movie;

public class BoardRankViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		    BoardRankViewService boardRankViewService = new BoardRankViewService();
			ArrayList<Board> boardRankList = boardRankViewService.getBoardRankList();
			
			request.setAttribute("boardRankList", boardRankList);
			ActionForward forward = new ActionForward();
			request.setAttribute("menu_form", "boardRankForm.jsp");
			forward.setUrl("layoutTest.jsp");
			
			return forward;
	}

}
