package mrp.web.main.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.log.action.IdFindTestAction;
import mrp.web.log.action.JoinProcessAction;
import mrp.web.log.action.LoginProcessAction;
import mrp.web.log.action.LogoutProcessAction;
import mrp.web.log.action.PwFindTestAction;
import mrp.web.log.action.idChkAction;
import mrp.web.log.action.nickChkAction;
import mrp.web.main.action.BoardRankProAction;
import mrp.web.main.action.BoardRankViewAction;
import mrp.web.main.action.ProBoxOfficeAction;
import mrp.web.main.action.productCookieAction;
import mrp.web.main.action.weeksDataAction;
import mrp.web.vo.ActionForward;

/**
 * Servlet implementation class LogFrontController
 */
@WebServlet("*.main")
public class mainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mainController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;
		if (command.equals("/weeksData.main")) {
			action = new weeksDataAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/proboxoffice.main")) {
			action = new ProBoxOfficeAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/boardRankView.main")) {
			action = new BoardRankViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/boardRankPro.main")) {
			action = new BoardRankProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/productCookie.main")) {
			action = new productCookieAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (forward != null) {
			// �����Ͻ� ������ ���������� ó���Ǿ��� ���
			if (forward.isRedirect()) {
				// redirect �������
				response.sendRedirect(forward.getUrl());
			} else {
				// dispatch �������
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