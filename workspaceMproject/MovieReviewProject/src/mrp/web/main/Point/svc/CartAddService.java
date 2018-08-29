package mrp.web.main.Point.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mrp.web.vo.Cart;
import mrp.web.vo.PointProduct;

public class CartAddService {

	public void addCart(HttpServletRequest request, PointProduct point) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");

		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			session.setAttribute("cartList", cartList);
		}
		Cart cart = null;
		boolean newCart = true;
		for (int i = 0; i < cartList.size(); i++) {
			cart = cartList.get(i);
			if (point.getP_name().equals(cart.getP_name()))
				;
		}
		if (newCart) {
			// 추가 안돼있을 때 새로운 카트객체 생성
			cart = new Cart();
			cart.setP_image(point.getP_image());
			cart.setP_name(point.getP_name());
			cart.setP_point(point.getP_point());
			cart.setQty(1); // 무조건 1이 들어감
			cartList.add(cart);
		}
	}
}