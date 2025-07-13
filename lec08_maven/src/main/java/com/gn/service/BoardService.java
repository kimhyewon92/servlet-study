package com.gn.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dao.BoardDao;
import com.gn.dto.Attach;
import com.gn.dto.Board;

public class BoardService {
	private BoardDao boardDao = new BoardDao();
	
	public List<Board> selectBoardList(Board param){
		return boardDao.selectBoardList(param); // param 에 저장된 값은 nowpage, keyword, totaldata
	}
	
	public int selectBoardCount(Board param) {
		return boardDao.selectBoardCount(param); // param 에 저장된 값은 nowpage, keyword
	}
	
	public Board selectBoardOne(int boardNo) {
		return boardDao.selectBoardOne(boardNo);
	}
	
	public Attach selectAttachByBoardNo(int boardNo) {
		return boardDao.selectAttachByBoardNo(boardNo);
	}
	
	public Attach selectAttachByAttachNo(int attachNo) {
		return boardDao.selectAttachByAttachNo(attachNo);
	}
	// 게시글 + 파일 트랜젝션 처리
	public int createBoardWithAttach(Board board, Attach attach) {
		SqlSession session = SqlSessionTemplate.getSqlSession(false); // 아무때나 commit 되면 안되고 지정한 순간에 되야함
		int result =0;
		
		try {
			// 1. 게시글 등록
			result = boardDao.insertBoard(session,board);
			
			// 2. 파일 정보 등록
			if(attach != null && result > 0) {
				attach.setBoardNo(board.getBoardNo());
				result = boardDao.insertAttach(session,attach);
			}
			
			// 3. commit 또는 rollback 
			if(result > 0) {
				session.commit();
			} else {
				session.rollback(); // insertBoard, insertAttach 둘다
			}
		}catch(Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		return result;
		
	}
	
	
	
	
}
