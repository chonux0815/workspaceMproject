package mrp.web.log.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.svc.IdChkService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.User;

public class idChkAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = null;
		String id = request.getParameter("id");
		
		IdChkService idChkService = new IdChkService();
		boolean idChkSuccess = idChkService.idChk(id);
		
		
		request.setAttribute("idExists", idChkSuccess);
		request.setAttribute("id", id);
		forward = new ActionForward();
		forward.setUrl("idChk.jsp");
		return forward;
	}

}
