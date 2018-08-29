package mrp.web.main.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;

public class boardDeleteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_code = Integer.parseInt(request.getParameter("b_code"));
		int b_division = Integer.parseInt(request.getParameter("b_division"));
		BoardContentService boardContentService = new BoardContentService();
		boolean success = boardContentService.boardDelete(b_code);
		HttpSession session = request.getSession();
		/* int pageNum=(int)session.getAttribute("pageNum"); */

		ActionForward forward = new ActionForward();

		if (success) {
			forward = new ActionForward();
			if (b_division == 3) {
				forward.setUrl("eventBoardList.bo?b_code=" + b_code + "&b_division=" + b_division);
			} else {
				forward.setUrl("boardList.bo?b_code=" + b_code + "&b_division=" + b_division);
			}
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
