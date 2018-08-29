package mrp.web.main.board.svc;

import static mrp.web.db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import static mrp.web.db.JdbcUtil.*;
import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.Board;

public class BoardContentService {

	public Board getBoard(int b_code) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		Board board = boardDAO.selectBoard(b_code);
		close(con);
		return board;
	}
	public ArrayList<Board> textBoard(String text,int b_division) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<Board> boardList = boardDAO.boardTextList(text,b_division);
		close(con);
		return boardList;
	}
	public boolean boardDelete(int b_code) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean success=false;
		
		success=boardDAO.BoardDelete(b_code);
		
		return success;
	}
	
	public boolean boardRemake(int b_code, String b_mcode, String b_name, String b_content) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boolean success=false;
		
		success=boardDAO.BoardRemake(b_code,b_mcode,b_name,b_content);
		
		return success;	
	}
	
}
