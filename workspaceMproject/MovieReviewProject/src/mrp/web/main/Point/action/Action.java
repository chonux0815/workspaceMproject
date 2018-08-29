package mrp.web.main.Point.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mrp.web.vo.*;

public interface Action  {
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	}

