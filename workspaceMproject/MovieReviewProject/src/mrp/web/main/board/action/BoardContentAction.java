package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.main.board.svc.BoardContentDatService;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;
import mrp.web.action.Action;

public class BoardContentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		/*String pageNum = request.getParameter("pageNum");*/
		
		int b_division=Integer.parseInt(request.getParameter("b_division"));
		
		BoardContentService boardContentService = new BoardContentService();
		BoardContentDatService boardContentDatService=new BoardContentDatService();
		
		Board board = boardContentService.getBoard(b_code);
		ArrayList<BoardBo> boardBoList=boardContentDatService.getBoardDatList(b_code);
		
		
		request.setAttribute("boardBoList", boardBoList);
		/*request.setAttribute("pageNum", pageNum);*/
		request.setAttribute("board", board);
		request.setAttribute("b_division", b_division);
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "content.jsp");
		forward.setUrl("MainLayout.jsp");
				
		return forward;
	}

}
