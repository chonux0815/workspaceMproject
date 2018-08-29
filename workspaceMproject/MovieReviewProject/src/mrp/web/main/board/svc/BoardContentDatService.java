package mrp.web.main.board.svc;

import static mrp.web.db.JdbcUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import mrp.web.main.board.dao.BoardDAO;
import mrp.web.vo.BoardBo;


public class BoardContentDatService {
	public Boolean getBoardDatInsert(int d_code,int b_code,String name,String content) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<BoardBo> boardBo = null;
		
		
		boolean success = boardDAO.BoardDatinsert(d_code,b_code,name,content);
		
		
		
		if(success==true) {
			commit(con);
		}
		else {
			rollback(con);
		}
		close(con);
		return success;
	}
	public ArrayList<BoardBo> getBoardDatList(int b_code) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		ArrayList<BoardBo> boardBo = null;
		
		boardBo=boardDAO.selectBoardDatList(b_code);
		System.out.println(boardBo);
		close(con);
		return boardBo;
	}
	public boolean DatRemake(String text,int d_code) {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int num=0;
		boolean success = boardDAO.BoardDatRemake(text,d_code);	
		
		
		close(con);
		return success;
	}
	public Boolean DatDelete(int d_code) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean success=boardDAO.BoardDatDelete(d_code);
		
		return success;
	}
}