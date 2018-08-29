package mrp.web.main.board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.main.board.svc.BoardListService;
import mrp.web.vo.ActionForward;
import mrp.web.action.Action;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;
import mrp.web.vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageSize = 10;
		int count=0;
		int number = 0;
		int b_division = Integer.parseInt((String) request.getParameter("b_division"));
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage -1) * pageSize + 1;
		
		ArrayList<Board> boardList = null;
		ArrayList<Board> boardNoticeList=null;
		
		BoardListService boardListService = new BoardListService();
		count = boardListService.getBoardCount(b_division);
		
		if(count > 0) {
			boardList = boardListService.getBoardList(startRow, pageSize, b_division);
			
		}
		
		boardNoticeList=boardListService.getBoardNoticeList(b_division);
		
		number = count - (currentPage -1) * pageSize;
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		
		if(count >0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
	        int pageBlock = 10;
	        
	        startPage = (currentPage - 1)/pageSize * pageBlock + 1;
	        endPage = startPage + pageBlock - 1;
	        
	        if(endPage > pageCount) endPage = pageCount;
	        
		}
		
		request.setAttribute("boardList", boardList);
		request.setAttribute("boardNoticeList", boardNoticeList);
		request.setAttribute("b_division", b_division);
		PageInfo pageInfo = new PageInfo();
		pageInfo.setCount(count);
		pageInfo.setCurrentPage(currentPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setNumber(number);
		pageInfo.setPageCount(pageCount);
		pageInfo.setStartPage(startPage);
		
		request.setAttribute("pageInfo", pageInfo);
			
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "list.jsp");
		forward.setUrl("MainLayout.jsp");
		return forward;
		
		
	}

}






















