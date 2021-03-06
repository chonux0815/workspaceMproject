package mrp.web.main.Point.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.vo.User;
import mrp.web.log.action.Action;
import mrp.web.log.action.IdFindTestAction;
import mrp.web.log.action.JoinProcessAction;
import mrp.web.log.action.LoginProcessAction;
import mrp.web.log.action.LogoutProcessAction;
import mrp.web.log.action.PwFindTestAction;
import mrp.web.main.Point.action.PointCartAddAction;
import mrp.web.main.Point.action.PointCartListAction;
import mrp.web.main.Point.action.PointCartQtyDownAction;
import mrp.web.main.Point.action.PointCartQtyUpAction;
import mrp.web.main.Point.action.PointCartRemoveAction;
import mrp.web.main.Point.action.PointProductListAction;
import mrp.web.main.Point.action.PointProductRegistAction;
import mrp.web.main.Point.action.PointProductRegistFormAction;
import mrp.web.main.Point.action.PointProductViewAction;
import mrp.web.main.Point.action.UpdatProAction;
import mrp.web.main.Point.action.UpdatePointAction;
import mrp.web.main.Point.action.pointProductEditAction;
import mrp.web.vo.ActionForward;
import java.io.IOException;

@WebServlet("*.po")
public class PointController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;
		System.out.println("command = " + command);
		if (command.equals("/PointCartRemove.po")) {
			action = new PointCartRemoveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/PointCartList.po")) {
			action = new PointCartListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/PointCartAdd.po")) {
			action = new PointCartAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/PointCartQtyUp.po")) {
			action = new PointCartQtyUpAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/PointCartQtyDown.po")) {
			action = new PointCartQtyDownAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if (command.equals("/updatePoint.po")) {
			action = new UpdatePointAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/pointProductList.po")) {
			action = new PointProductListAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/pointProductView.po")) {
			action = new PointProductViewAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/pointProductRegist.po")) {
			action = new PointProductRegistAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(command.equals("/pointProductEdit.po")) {
			action = new pointProductEditAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/UpdatPro.po")) {
			action = new UpdatProAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/pointProductRegistForm.po")) {
			action = new PointProductRegistFormAction();
			
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		if (forward != null) {
			// 비지니스 로직이 정상적으로 처리되었을 경우
			if (forward.isRedirect()) {
				// redirect 방식으로
				response.sendRedirect(forward.getUrl());
			} else {
				// dispatch 방식으로
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}

		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}