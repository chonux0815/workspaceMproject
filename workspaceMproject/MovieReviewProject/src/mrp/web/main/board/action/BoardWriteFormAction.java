package mrp.web.main.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;
import mrp.web.main.board.svc.BoardWriteProService;
import mrp.web.vo.Board;



public class BoardWriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_code = 0, re_step = 0, re_level = 0;
		HttpSession session=request.getSession();
		Board board=new Board();
		BoardWriteProService boardWriteProService = new BoardWriteProService();
		int b_division = Integer.parseInt((String) request.getParameter("b_division"));
		board.setB_author((String)session.getAttribute("u_name"));
		board.setB_division(b_division);
		board.setB_mcode(request.getParameter("board_movie"));
		board.setB_name(request.getParameter("board_name"));
		board.setB_content(request.getParameter("board_content"));
		board.setB_hashtag(request.getParameter("board_hashTag"));
		
		
		
		boolean writeSuccess = boardWriteProService.insertBoard(board);
		
		
		ActionForward forward = null;
		if(writeSuccess) {
			forward = new ActionForward();
			request.setAttribute("b_division", b_division);
			forward.setUrl("boardList.bo?b_division="+b_division);
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("<alert('빠꾸')>");
			out.println("history.back()");
			out.println("</script>");
		}
		return forward;
		
	}

}
