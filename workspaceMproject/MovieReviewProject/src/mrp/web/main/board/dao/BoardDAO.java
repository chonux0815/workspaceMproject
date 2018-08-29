﻿package mrp.web.main.board.dao;

import static mrp.web.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.websocket.Session;


import mrp.web.vo.Board;
import mrp.web.vo.BoardBo;
import mrp.web.vo.PointProduct;

public class BoardDAO {
	
	private Connection con;
	private static BoardDAO boardDAO;
	
	private BoardDAO() {
	
	}
	
	
	public static BoardDAO getInstance(){
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}
	
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		int insertCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		int num = board.getB_code();

		
		int number = 0;
		try {
			pstmt = con.prepareStatement("SELECT MAX(b_code) FROM board");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				// �씠�쟾�뿉 �옉�꽦�맂 湲��씠 �엳�쑝硫�
				number = rs.getInt(1) + 1;
			} else {
				number = 1;
			}

			String sql = "INSERT INTO board(b_code,b_name,b_content,b_author,b_time,b_division,b_mcode,b_hashtag,b_image)"
					+ "VALUES(b_code_seq.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, board.getB_name());
			pstmt.setString(2, board.getB_content());
			pstmt.setString(3, board.getB_author());
			pstmt.setString(4, board.getB_time());
			pstmt.setInt(5, board.getB_division());
			pstmt.setString(6, board.getB_mcode());
			pstmt.setString(7, board.getB_hashtag());
			pstmt.setString(8, board.getB_image());
			insertCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return insertCount;
	}

	public Boolean BoardDatinsert(int d_code, int b_code, String name, String content) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBo> insertCount = null;

		int level = 0;
		int step = 0;
		int number=0;
		boolean success=false;

		try {

			String sql = "SELECT * FROM board_Bo where d_boardcode=? and d_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			pstmt.setInt(2, d_code);
			rs = pstmt.executeQuery();

			int ref = 0;
			if (rs.next()) {

				// �씠�쟾�뿉 �옉�꽦�맂 湲��씠 �엳�쑝硫�
				sql = "UPDATE board_Bo SET re_level = re_level + 1 WHERE ref = ? AND re_level > ? ";

				pstmt = con.prepareStatement(sql);
				ref = rs.getInt("ref");
				pstmt.setInt(1, ref);
				pstmt.setInt(2, rs.getInt("re_level"));

				int updateCount = pstmt.executeUpdate();
				if (updateCount > 0) {
					commit(con);
				} else {
					rollback(con);
				}
				level = rs.getInt("re_level") + 1;
				step = rs.getInt("re_step") + 1;

			}

			sql = "INSERT INTO board_Bo(d_code,d_boardcode,ref,re_step,re_level,d_author,d_content)"
					+ "VALUES(d_code_seq.nextval,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			pstmt.setInt(2, ref);
			pstmt.setInt(3, step);
			pstmt.setInt(4, level);
			pstmt.setString(5, name);
			pstmt.setString(6, content);

			int updateCount = pstmt.executeUpdate();
			if (updateCount > 0) {
				commit(con);
				success = true;
			} else {
				rollback(con);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return success;
	}

	
	public int insertBoardBoRef(int b_code, int ref, String name, String reftext) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		int level = 0;
		int step = 0;
		int number = 0;
		try {

			String sql = "INSERT INTO board_Bo(d_code,d_boardcode,ref,re_step,re_level,d_author,d_content)"
					+ "VALUES(d_code_seq.nextval,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			pstmt.setInt(2, ref + 1);
			pstmt.setInt(3, step);
			pstmt.setInt(4, level);
			pstmt.setString(5, name);
			pstmt.setString(6, reftext);

			number = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return number;
	}

	public int selectArticleCount(int b_division) {

		int boardCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("SELECT COUNT(*) From board where b_division = ? ");
			pstmt.setInt(1, b_division);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boardCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		return boardCount;
	}

	public ArrayList<Board> selectBoardList(int startRow, int pageSize,int b_division) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> boardList = null;
		Board board = null;
		if(b_division>3) {
			b_division-=3;
		}
		try {
			String sql = "SELECT list2.* FROM (SELECT rownum r, list1.* FROM (SELECT * FROM board ORDER BY b_code DESC) list1) "
					+ " list2 WHERE r BETWEEN ? AND ? and b_division = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, startRow + pageSize - 1);
			pstmt.setInt(3, b_division);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardList = new ArrayList<Board>();
				do {
					board = new Board();

					board.setB_author(rs.getString("b_author"));
					board.setB_name(rs.getString("b_name"));
					board.setB_content(rs.getString("b_content"));
					board.setB_time(rs.getString("b_time"));
					board.setB_hashtag(rs.getString("b_hashtag"));

					board.setB_division(rs.getInt("b_division"));
					board.setB_mcode(rs.getString("b_mcode"));
					board.setReadcount(rs.getInt("readcount"));
					board.setB_code(rs.getInt("b_code"));

					boardList.add(board);

				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardList;

	}

	public ArrayList<BoardBo> selectBoardDatList(int b_code) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBo> boardDatList = null;
		BoardBo boardBo = null;

		try {
			String sql = "SELECT * FROM board_bo where d_boardcode=? ORDER BY ref,re_level ASC";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			int i = 0;
			rs = pstmt.executeQuery();

			if (rs.next()) {

				boardDatList = new ArrayList<BoardBo>();
				do {
					boardBo = new BoardBo();

					boardBo.setD_code(rs.getInt("d_code"));
					boardBo.setD_boardcode(rs.getInt("d_boardcode"));
					boardBo.setD_content(rs.getString("d_content"));
					boardBo.setD_author(rs.getString("d_author"));
					boardBo.setRef(rs.getInt("ref"));
					boardBo.setRe_step(rs.getInt("re_step"));
					boardBo.setRe_level(rs.getInt("re_level"));
					
					boardDatList.add(boardBo);
					
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return boardDatList;

	}
	public Board readCount(int b_code) {
		// TODO Auto-generated method stub
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = con.prepareStatement("UPDATE board SET readCount = readcount+1 WHERE b_code = ?");
			pstmt.setInt(1, b_code);
			int updateCount=pstmt.executeUpdate();
			if (updateCount > 0) {
					commit(con);
					
			} else {
					rollback(con);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}
	public Board selectBoard(int b_code) {
		// TODO Auto-generated method stub
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement("UPDATE board SET readCount = readcount + 1 WHERE b_code = ?");
			pstmt.setInt(1, b_code);
			int success=pstmt.executeUpdate();
			if(success>0) {
				commit(con);
			}else{
				rollback(con);
			}
			pstmt = con.prepareStatement("SELECT * FROM board WHERE b_code=?");
			pstmt.setInt(1, b_code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new Board();
				board.setB_content(rs.getString("b_content"));
				board.setB_mcode(rs.getString("b_mcode"));
				board.setB_time(rs.getString("b_time"));
				board.setB_hashtag(rs.getString("b_hashtag"));
				board.setReadcount(rs.getInt("readcount"));
				board.setB_name(rs.getString("b_name"));
				board.setB_author(rs.getString("b_author"));
				board.setB_code(rs.getInt("b_code"));
				board.setB_division(rs.getInt("b_division"));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return board;
	}

	public boolean BoardDatRemake(String text, int d_code) {
		// TODO Auto-generated method stub

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardBo> insertCount = null;
		boolean success = false;
		int ref = 0;
		int level = 0;
		int step = 0;
		int number = 0;
		try {
			String sql = "SELECT ref,d_step,d_level FROM board_bo WHERE d_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, d_code);
			// �씠�쟾�뿉 �옉�꽦�맂 湲��씠 �엳�쑝硫�
			sql = "UPDATE board_Bo SET d_content=? WHERE d_code=? ";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, text);
			pstmt.setInt(2, d_code);

			int updateCount = pstmt.executeUpdate();
			if (updateCount > 0) {
				commit(con);
				success = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return success;
	}

	public Boolean BoardDatDelete(int d_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ref = 0;
		int level = 0;
		int step = 0;
		int board_code = 0;
		Boolean success=false;
		int updateCount = 0;
		String sql;
		try {
			sql = "SELECT d_boardcode,ref,re_step,re_level FROM board_bo WHERE d_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, d_code);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ref = rs.getInt("ref");
				step = rs.getInt("re_step");
				level = rs.getInt("re_level");
				board_code = rs.getInt("d_boardcode");

				sql = "SELECT re_step,re_level,d_boardcode FROM board_bo WHERE ref=? AND d_boardcode=? AND re_step=? AND re_level>?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, ref);
				pstmt.setInt(2, board_code);
				pstmt.setInt(3, step);
				pstmt.setInt(4, level);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					sql = "DELETE board_bo WHERE ref=? AND re_level>=? AND re_level < (SELECT MIN(re_level) FROM Board_bo WHERE ref=? AND re_step<=? AND re_level > ? AND d_boardcode=?)";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, ref);
					pstmt.setInt(2, level);
					pstmt.setInt(3, ref);
					pstmt.setInt(4, step);
					pstmt.setInt(5, level);
					pstmt.setInt(6, board_code);
					updateCount = pstmt.executeUpdate();
				} else {
					sql = "DELETE board_bo WHERE ref=? AND re_step>=? AND re_level>=? AND d_boardcode=?";

					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, ref);
					pstmt.setInt(2, step);
					pstmt.setInt(3, level);
					pstmt.setInt(4, board_code);
					updateCount = pstmt.executeUpdate();

				}
			}
			if (updateCount > 0) {
				commit(con);
				success = true;
			} else {
				rollback(con);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return success;
	}


	public ArrayList<Board> selectEventBoardList(int b_division) {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<Board> eventBoardList = null;
		
		try{
			String sql="select * from board where b_division = ? ORDER BY b_code DESC";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_division);
			rs = pstmt.executeQuery();
			eventBoardList = new ArrayList<Board>();
			Board board = null;
			if (rs.next()) {
			do{
				board = new Board();
				board.setB_name(rs.getString("b_name"));
				board.setB_image(rs.getString("b_image"));
				board.setB_content(rs.getString("b_content"));
				board.setB_time(rs.getString("b_time"));
				board.setB_code(rs.getInt("b_code"));
				eventBoardList.add(board);
			}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
		
		return eventBoardList;
	}
	public ArrayList<Board> selectBoardNoticeList(int b_division) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Board> boardNoticeList = null;
		Board board = null;
		if(b_division>3) {
			b_division-=3;
		}
		try {
			String sql = "select * from (SELECT * FROM board ORDER BY b_code DESC) where b_division=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_division+3);
		
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				boardNoticeList = new ArrayList<Board>();
				do {
					board = new Board();
					
					board.setB_author(rs.getString("b_author"));
					board.setB_name(rs.getString("b_name"));
					board.setB_content(rs.getString("b_content"));
					board.setB_time(rs.getString("b_time"));
					board.setB_hashtag(rs.getString("b_hashtag"));
					board.setReadcount(rs.getInt("readcount"));
					board.setB_division(rs.getInt("b_division"));
					board.setB_mcode(rs.getString("b_mcode"));
					board.setReadcount(rs.getInt("readcount"));
					board.setB_code(rs.getInt("b_code"));
					
					boardNoticeList.add(board);
					
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return boardNoticeList;
		
	}


	public ArrayList<Board> selectBoardRankList() {
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<Board> boardRankList = new ArrayList<Board>();
		try{
			String sql="SELECT b_code, b_name from (SELECT readcount,b_code, b_name FROM board ORDER BY readcount DESC) where rownum<=10";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			Board board = null;
			if(rs.next()){
				
				
				do {
					board = new Board();
					board.setB_code(rs.getInt("b_code"));
					board.setB_name(rs.getString("b_name"));
					boardRankList.add(board);					
				} while (rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
	
		return boardRankList;
	}
	public boolean BoardDelete(int b_code) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success = false;
		int count = 0;
		try {
			// �씠�쟾�뿉 �옉�꽦�맂 湲��씠 �엳�쑝硫�
			String sql = "DELETE FROM board WHERE b_code=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			count = pstmt.executeUpdate();
			if (count > 0) {
				commit(con);
				success = true;
			} else {
				rollback(con);
			}
			sql = "DELETE FROM board_bo WHERE d_boardcode=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_code);
			count = pstmt.executeUpdate();
			if (count > 0) {
				commit(con);
				success = true;
			} else {
				rollback(con);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return success;
	}
	public boolean BoardRemake(int b_code, String b_mcode, String b_name, String b_content) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean success=false;
		try {
			pstmt = con.prepareStatement("UPDATE board SET b_mcode=?,b_name=?,b_content=? WHERE b_code = ?");
			pstmt.setString(1, b_mcode);
			pstmt.setString(2, b_name);
			pstmt.setString(3, b_content);
			pstmt.setInt(4, b_code);
			int count=pstmt.executeUpdate();
			
			if(count>0) {
				commit(con);
				success=true;
			}else{
				rollback(con);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			close(pstmt);
		}
		return success;
	}


	public ArrayList<Board> boardTextList(String text,int b_division) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<Board> boardList = null;
		
		try{
			String sql="select * from board where b_division = ? AND (b_name LIKE '%'||?||'%' OR b_content LIKE '%'||?||'%' OR b_mcode LIKE '%'||?||'%' OR b_author LIKE '%'||?||'%')";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, b_division);
			pstmt.setString(2, text);
			pstmt.setString(3, text);
			pstmt.setString(4, text);
			pstmt.setString(5, text);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<Board>();
			Board board = null;
			if (rs.next()) {
				
				do{
					board = new Board();
					board.setB_division(rs.getInt("b_division"));
					board.setReadcount(rs.getInt("readcount"));
					board.setB_mcode(rs.getString("b_mcode"));
					board.setB_author(rs.getString("b_author"));
					board.setB_name(rs.getString("b_name"));
					board.setB_image(rs.getString("b_image"));
					board.setB_content(rs.getString("b_content"));
					board.setB_time(rs.getString("b_time"));
					board.setB_code(rs.getInt("b_code"));
					boardList.add(board);
				}while(rs.next());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
		}
		
		return boardList;
	}
	
}