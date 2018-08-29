package mrp.web.log.controller;

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
import mrp.web.log.action.UpdateFormAction;
import mrp.web.log.action.UpdateProAction;
import mrp.web.log.action.idChkAction;
import mrp.web.log.action.nickChkAction;
import mrp.web.log.action.pointChkAction;
import mrp.web.log.action.pointConAction;
import mrp.web.vo.ActionForward;

/**
 * Servlet implementation class LogFrontController
 */
@WebServlet("*.log")
public class LogFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogFrontController() {
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
		
		if (command.equals("/loginProcess.log")) {
			action = new LoginProcessAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/logout.log")) {
			action = new LogoutProcessAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/idFindTest.log")) {
			action = new IdFindTestAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/pwFindTest.log")) {
			action = new PwFindTestAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/joinProcess.log")) {
			action = new JoinProcessAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/idChk.log")) {
			
			action = new idChkAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/nickChk.log")) {
			
			action = new nickChkAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/nickChk.log")) {
			action = new nickChkAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/updateForm.log")) {
			action = new UpdateFormAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/updatePro.log")) {
			action = new UpdateProAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/pointCon.log")) {
			action = new pointConAction();

			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (command.equals("/pointChk.log")) {
			action = new pointChkAction();

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