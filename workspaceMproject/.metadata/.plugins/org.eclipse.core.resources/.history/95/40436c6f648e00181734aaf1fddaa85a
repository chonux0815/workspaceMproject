package mrp.web.main.board.svc;
import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.Board;
public class BoardListService {

	public int getBoardCount(int b_division) {
		// TODO Auto-generated method stub
		int boardCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boardCount = boardDAO.selectArticleCount(b_division);
		close(con);
		return boardCount;
	}

	public ArrayList<Board> getBoardList(int startRow, int pageSize,int b_division) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Board> boardList = boardDAO.selectBoardList(startRow, pageSize, b_division);
		close(con);
		return boardList;
	}
	public ArrayList<Board> getBoardNoticeList(int b_division) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<Board> boardNoticeList = boardDAO.selectBoardNoticeList(b_division);
		close(con);
		return boardNoticeList;
	}

}
