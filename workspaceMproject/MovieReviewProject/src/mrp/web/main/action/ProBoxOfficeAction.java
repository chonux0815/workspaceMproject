package mrp.web.main.action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import mrp.web.log.action.Action;
import mrp.web.vo.ActionForward;
import mrp.web.vo.Movie;

public class ProBoxOfficeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int i = Integer.parseInt(request.getParameter("i"));
		HttpSession session = request.getSession(false);
		ArrayList<Movie> movieList = (ArrayList<Movie>)session.getAttribute("items");
		
		Movie movie = new Movie();
		movie.setRankOldAndNew(movieList.get(i).getRankOldAndNew());
		movie.setMovieNum(movieList.get(i).getMovieNum());
		movie.setAudiacc(movieList.get(i).getAudiacc());
		

		ActionForward forward = new ActionForward();
		System.out.println(movie);
		request.setAttribute("i", i+1);
		request.setAttribute("movie", movie);
		forward = new ActionForward();
		forward.setUrl("movieSuccess.jsp");
		
		
		return forward;
	}

}
