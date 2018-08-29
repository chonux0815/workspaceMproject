package mrp.web.main.board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentRefService;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;
import mrp.web.vo.ActionForward;

public class BoardContentDatRefAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		int ref = Integer.parseInt(request.getParameter("ref"));
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		String pageNum = request.getParameter("pageNum");
		String name = request.getParameter("name");
		String reftext = request.getParameter("reftext");
		int b_division= Integer.parseInt(request.getParameter("b_division"));
		ActionForward forward = null;
		ArrayList<BoardBo> boardBoList = null;
		BoardContentService boardContentService = new BoardContentService();
		Board board = boardContentService.getBoard(b_code);

		BoardContentRefService boardContentRefService = new BoardContentRefService();

		boolean writeSuccess = boardContentRefService.writeBoard(b_code, ref, name, reftext);
		if (writeSuccess) {
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
