package mrp.web.main.Point.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import mrp.web.log.action.Action;
import mrp.web.main.Point.svc.PointProductRegistService;
import mrp.web.vo.ActionForward;
import mrp.web.vo.PointProduct;

public class pointProductEditAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("images");
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024 * 1024 * 10, "UTF-8",
				new DefaultFileRenamePolicy());
		String p_image = multi.getFilesystemName("p_image");
		String p_name = multi.getParameter("p_name");
		int p_point = Integer.parseInt(multi.getParameter("p_point"));
		
		PointProduct pointProduct = new PointProduct();
		pointProduct.setP_image(p_image);
		pointProduct.setP_name(p_name);
		pointProduct.setP_point(p_point);
		
		PointProductRegistService pointProductRegistService = new PointProductRegistService();
		boolean registSuccess = pointProductRegistService.registPointProduct(pointProduct);
		
		
		ActionForward forward = null;
		if(registSuccess) {
			forward = new ActionForward();
			forward.setUrl("pointProductList.po");
			forward.setRedirect(true);
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back()");
			out.println("</script>");	
		}
		
		return forward;
	}

}
