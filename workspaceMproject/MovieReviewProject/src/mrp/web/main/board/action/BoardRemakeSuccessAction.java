package mrp.web.main.board.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.vo.ActionForward;

public class BoardRemakeSuccessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int b_code=Integer.parseInt(request.getParameter("b_code"));
		String b_mcode=request.getParameter("b_mcode");
		String b_name=request.getParameter("b_name");
		String b_content=request.getParameter("b_content");
		int b_division=Integer.parseInt(request.getParameter("b_division"));
		boolean success=false;
		
		BoardContentService boardContentService=new BoardContentService(); 
		success=boardContentService.boardRemake(b_code,b_mcode,b_name,b_content);
		
	
		
		ActionForward forward=new ActionForward();
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
			out.println("alert('��� �Է� ����')");
			out.println("history.back()");
			out.println("</script>");
		}
		
		return forward; 
	}

}