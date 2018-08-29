package mrp.web.main.Point.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.UpdateProService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Cart;
import mrp.web.vo.PayList;

public class UpdatProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;
		UpdateProService updateProService = new UpdateProService();
		PayList payList = updateProService.updatePay(request);
		if (payList.getL_kind() != null) {
			forward = new ActionForward();
			forward.setUrl("pointCon.log");
		}
		return forward;
	}

}
