package mrp.web.main.Point.action;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointProductViewService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.PointProduct;

public class PointProductViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("p_id"); // id값 받기

		PointProductViewService pointProductViewService = new PointProductViewService();

		PointProduct pointProduct = pointProductViewService.getPointProduct(id);

		Cookie cookie = new Cookie("today"+id,
				pointProduct.getP_image()); //클라이언트에서 넘어온 쿠키객체 넘어올 때 
		cookie.setMaxAge(60*60*24);
		response.addCookie(cookie);
		
		ActionForward forward = null;
		if (pointProduct != null) {
			request.setAttribute("pointProduct", pointProduct);
			System.out.println(pointProduct.getP_id());
			forward = new ActionForward();
			request.setAttribute("form_menu", "pointProductView.jsp");
			forward.setUrl("MainLayout.jsp");
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('정보 가져오기 실패')");
			out.println("history.back()");
			out.println("</script>");
		}

		return forward;
	}

}
