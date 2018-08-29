package mrp.web.main.board.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.action.Action;
import mrp.web.main.board.action.WriteFormAction;
import mrp.web.main.board.action.boardDeleteFormAction;
import mrp.web.main.board.action.boardWriteEventAction;
import mrp.web.main.board.action.findTextAction;
import mrp.web.main.board.action.BoardContentAction;
import mrp.web.main.board.action.BoardContentDatAction;
import mrp.web.main.board.action.BoardContentDatRefAction;
import mrp.web.main.board.action.BoardListAction;
import mrp.web.main.board.action.BoardRemakeAction;
import mrp.web.main.board.action.BoardRemakeFormAction;
import mrp.web.main.board.action.BoardRemakeSuccessAction;
import mrp.web.main.board.action.BoardWriteFormAction;
import mrp.web.main.board.action.DatDeleteAction;
import mrp.web.main.board.action.DatListViewAction;
import mrp.web.main.board.action.DatRemakeAction;
import mrp.web.main.board.action.EventBoardListAction;
import mrp.web.main.board.action.EventBoardViewAction;
import mrp.web.main.board.action.EventWriteFormAction;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;



@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.�뜝�럩�뭵嶺뚳퐦�삕 �뜝�럥�냱�뜝�럥�닣
		String requestURI = request.getRequestURI();
		// URL--> http://localhost:8088/boardProject/boardWriteForm.bo
		// requestURI--> /boardProject/boardWriteForm.bo
		
		String contextPath = request.getContextPath();
		//boardProject
		
		String command = requestURI.substring(contextPath.length());
		// /boardWriteForm.bo
		
		ActionForward forward = null;
		Action action = null;
		
		if(command.equals("/boardWriteForm.bo")) {
			action = new BoardWriteFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardList.bo")) {
			
			action = new BoardListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/writeForm.bo")) {
			
			action = new WriteFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardContent.bo")) {
			
			action = new BoardContentAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		else if(command.equals("/writeList.bo")) {
			action = new BoardListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardContentDat.bo")) {
			
			action = new BoardContentDatAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardContentDatRef.bo")) {
		
			action = new BoardContentDatRefAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/datRemake.bo")) {
			
			action = new DatRemakeAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/datDelete.bo")) {
		
			action = new DatDeleteAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eventBoardList.bo")) {
			
			action = new EventBoardListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eventWriteForm.bo")) {
			
			action = new EventWriteFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/eventBoardView.bo")) {
			
			action = new EventBoardViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardWriteEvent.bo")) {
			
			action = new boardWriteEventAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardRemake.bo")) {
			
			action = new BoardRemakeAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardRemakeSuccess.bo")) {
			
			action = new BoardRemakeSuccessAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/boardDelete.bo")) {

			action = new boardDeleteFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/boardRemakeForm.bo")) {
			
			action = new BoardRemakeFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/datListView.bo")) {
			action = new DatListViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else if(command.equals("/findText.bo")) {
			action = new findTextAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		if(forward != null) {
			//占쎈쑏熬곣뫜�삕�뜝�럥鍮띶뜝�럥裕� �슖�돦裕뉐퐲�굢�삕占쎈턄 �뜝�럩�젧�뜝�럡留믣뜝�럩�쓤�뜝�럩紐드슖�댙�삕 嶺뚳퐣瑗띰옙遊뷴뜝�럥�뵹�뜝�럥占썲뜝�럩紐든춯濡녹삕
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getUrl());
			}
			else {
				RequestDispatcher dispather = request.getRequestDispatcher(forward.getUrl());
				dispather.forward(request, response);
			}
			
		}
		
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
}