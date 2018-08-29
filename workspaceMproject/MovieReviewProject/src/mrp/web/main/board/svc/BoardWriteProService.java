package mrp.web.main.board.svc;


import mrp.web.vo.Board;

import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;

import mrp.web.main.board.dao.BoardDAO;

public class BoardWriteProService {

	public boolean insertBoard(Board board) {
		// TODO Auto-generated method stub
		boolean writeSuccess = false;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.insertBoard(board);
		
		if(insertCount>0) {
			writeSuccess = true;
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		
		return writeSuccess;
	}
}
