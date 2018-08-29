package mrp.web.main.svc;

import static mrp.web.db.JdbcUtil.*;
import static mrp.web.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.Board;

public class BoardRankViewService {


	public ArrayList<Board> getBoardRankList() {
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<Board> boardRankList = boardDAO.selectBoardRankList();
		close(con);
		return boardRankList;
	}
}