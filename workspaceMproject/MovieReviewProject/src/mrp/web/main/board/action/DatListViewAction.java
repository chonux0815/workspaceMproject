package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentDatService;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;

public class DatListViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		BoardContentDatService boardContentDatService=new BoardContentDatService();
		ArrayList<BoardBo> boardBoList = boardContentDatService.getBoardDatList(b_code);
		int b_division= Integer.parseInt(request.getParameter("b_division"));
		ActionForward forward = new ActionForward();
//		HttpSession session = request.getSession();
		BoardContentService boardContentService = new BoardContentService();
		
		Board board = boardContentService.getBoard(b_code);
		request.setAttribute("board", board);
		request.setAttribute("b_division", b_division);
		request.setAttribute("boardBoList", boardBoList);
		request.setAttribute("form_menu", "content.jsp");
		forward.setUrl("MainLayout.jsp");
		return forward;
	}

}
