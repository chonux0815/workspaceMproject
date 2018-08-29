package mrp.web.main.board.svc;
import java.sql.Connection;
import java.util.ArrayList;
import static mrp.web.db.JdbcUtil.*;

import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;

public class BoardContentRefService {

	public boolean writeBoard(int b_code, int ref,String name,String reftext) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean writeSuccess = false;
		ArrayList<BoardBo> boardBoList=null;
		
		int insertCount=boardDAO.insertBoardBoRef(b_code,ref,name,reftext); //´ñ±ÛÀÇ ref ¿ø±Û »ðÀÔÇÏ±â
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
