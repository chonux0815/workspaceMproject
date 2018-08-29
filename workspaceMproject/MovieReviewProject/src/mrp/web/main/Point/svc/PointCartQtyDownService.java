package mrp.web.main.Point.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mrp.web.vo.Cart;

public class PointCartQtyDownService {

	public void downQty(HttpServletRequest request, String p_name) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
		
		for(int i=0 ; i<cartList.size(); i ++) {
			if(p_name.equals(cartList.get(i).getP_name())) {
				cartList.get(i).setQty(cartList.get(i).getQty() -1);
			}
		}
	}

}
