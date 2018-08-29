package mrp.web.main.action;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.WebConnection;
import javax.websocket.Session;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import mrp.web.log.action.Action;
import mrp.web.log.svc.IdFindService;
import mrp.web.vo.ActionForward;

import mrp.web.vo.*;

public class weeksDataAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		int today = 0;
		Calendar cal = Calendar.getInstance();
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
		if (day_of_week != 1) {
			today = Integer.parseInt(formatter.format(date));
			today -= day_of_week;
		} else {
			today = Integer.parseInt(formatter.format(date));
			today -= 7;
		}

		String address = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.json?key=81f63ad396736217c18ba0d1ee121802&weekGb=0&targetDt="
				+ today;
		BufferedReader br;
		String protocol = "GET";
		URL url = new URL(address);
		ArrayList<Movie> items = new ArrayList<Movie>();

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod(protocol);
		br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String json = br.readLine();

		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(json);
		JSONObject boxOfficeResult = (JSONObject) obj.get("boxOfficeResult");
		String boxofficeType = (String) boxOfficeResult.get("showRange");
		JSONArray item = (JSONArray) boxOfficeResult.get("weeklyBoxOfficeList");

		for (int i = 0; i < item.size(); i++) {
			Movie movie = new Movie();
			JSONObject tmp = (JSONObject) item.get(i);
			movie.setRankOldAndNew((String) tmp.get("rankOldAndNew"));
			String movieNm = (String) tmp.get("movieNm");
			String movieSet = "";
			movieNm = movieNm.replaceFirst(":", "");
			movie.setMovieNum(movieNm);
			movie.setAudiacc((String) tmp.get("audiAcc"));
			items.add(i, movie);
		}
		request.setAttribute("showRange", boxofficeType);
		HttpSession session = request.getSession();
		session.setAttribute("items", items);
		ActionForward forward = new ActionForward();
		request.setAttribute("form_menu", "weeksMovieSuccess.jsp");
		forward.setUrl("layoutTest.jsp");
		return forward;
	}
}
