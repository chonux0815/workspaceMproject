package mrp.web.main.admin.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mrp.web.main.admin.svc.AdminListService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class AdminListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		AdminListService adminListService = new AdminListService();
		ArrayList<User> userList = adminListService.selectList();

		request.setAttribute("userList", userList);

		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "adminList.jsp");
		forward.setUrl("MainLayout.jsp");

		return forward;
	}

}
