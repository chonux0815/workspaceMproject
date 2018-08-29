package mrp.web.main.board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentDatService;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;
import mrp.web.vo.ActionForward;

public class BoardContentDatAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int d_code=Integer.parseInt(request.getParameter("d_code"));
		int b_code=Integer.parseInt(request.getParameter("b_code"));
		int b_division= Integer.parseInt(request.getParameter("b_division"));
		BoardContentService boardContentService = new BoardContentService();
				
		String pageNum = request.getParameter("pageNum");
		Board board=boardContentService.getBoard(b_code);
		
		String name=request.getParameter("name");
		String content=request.getParameter("dattext"+d_code);
		ArrayList<BoardBo> boardBoList=null;
		
		BoardContentDatService boardContentDatService=new BoardContentDatService(); 
		Boolean success=boardContentDatService.getBoardDatInsert(d_code,b_code,name,content);
		
		ActionForward forward = null;
		if(success) {
			forward = new ActionForward();
			forward.setUrl("datListView.bo?b_code=" + b_code+"&b_division="+b_division);
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 입력 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
		
	}

}