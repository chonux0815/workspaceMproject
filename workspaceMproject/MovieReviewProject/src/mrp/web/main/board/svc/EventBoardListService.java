package mrp.web.main.board.svc;

import static mrp.web.db.JdbcUtil.close;
import static mrp.web.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;


import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.Board;


public class EventBoardListService {

	public ArrayList<Board> getEventBoardList(int b_division) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<Board> eventBoardList = boardDAO.selectEventBoardList(b_division);
		close(con);
		return eventBoardList;
	}

}
