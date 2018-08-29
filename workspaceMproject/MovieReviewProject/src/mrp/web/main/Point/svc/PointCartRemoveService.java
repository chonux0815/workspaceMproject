package mrp.web.main.Point.svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mrp.web.vo.Cart;


public class PointCartRemoveService {
 


public void removeCart(HttpServletRequest request, java.lang.String[] names) {
	HttpSession session = request.getSession();
	ArrayList<Cart> cartList = (ArrayList<Cart>)session.getAttribute("cartList");
	  for(int i=0; i<names.length;i++) {
		  for(int j=0; j<cartList.size();j++) {
			  if(names[i].equals(cartList.get(j).getP_name())) {
				  cartList.remove(cartList.get(j));
			  }
		  }
	  }
	}
}