package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;

public class findTextAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String text=request.getParameter("find_text");
		ArrayList<Board> boardMovieList=null;
		ArrayList<Board> boardReviewList=null;
		ArrayList<Board> boardEventList=null;
		
		BoardContentService boardContentService=new BoardContentService(); 
		
		boardMovieList=boardContentService.textBoard(text,1);
		boardReviewList=boardContentService.textBoard(text,2);
		boardEventList=boardContentService.textBoard(text,3);		
		
		request.setAttribute("boardMovieList",boardMovieList);
		request.setAttribute("boardReviewList",boardReviewList);
		request.setAttribute("boardEventList",boardEventList);
		
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "textFindBoard.jsp");
		forward.setUrl("MainLayout.jsp");
				
		return forward;
	}

}
