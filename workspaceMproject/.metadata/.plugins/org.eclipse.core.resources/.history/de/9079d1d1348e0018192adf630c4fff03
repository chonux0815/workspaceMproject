package mrp.web.main.board.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mrp.web.action.Action;
import mrp.web.main.board.svc.BoardContentDatService;
import mrp.web.main.board.svc.BoardContentService;
import mrp.web.main.board.svc.BoardWriteProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;

public class boardWriteEventAction implements Action {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("images");
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		String b_image = multi.getFilesystemName("board_image");
		int b_division=Integer.parseInt(multi.getParameter("b_division"));
		String name=multi.getParameter("board_name");
		String start=multi.getParameter("start");
		String end=multi.getParameter("end");
		String content=multi.getParameter("board_content");
		HttpSession session=request.getSession();
		
		
		String date = start + " ~ " + end;
			
		Board board=new Board();
		board.setB_author((String)session.getAttribute("u_name"));
		board.setB_name(name);
		board.setB_content(content);
		board.setB_time(date);
		board.setB_image(b_image);
		board.setB_division(b_division);
		BoardWriteProService boardWriteProService=new BoardWriteProService();
		
		boolean success=boardWriteProService.insertBoard(board);
		
		ActionForward forward = null;
		if(success) {
			forward = new ActionForward();
			forward.setUrl("eventBoardList.bo?b_division=" +b_division );
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
