package com.gn.dao;

import org.apache.ibatis.session.SqlSession;

import com.gn.common.sql.SqlSessionTemplate;
import com.gn.dto.Member;

public class MemberDao {
	public int insertMember(Member param) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		int result = session.insert("com.gn.mapper.MemberMapper.insert", param);
		session.close();
		return result;
	}
	
	public Member selectMember(Member param) {
		SqlSession session = SqlSessionTemplate.getSqlSession(true);
		Member result = session.selectOne("com.gn.mapper.MemberMapper.selectMember", param);
		session.close();
		return result;
	}
}
