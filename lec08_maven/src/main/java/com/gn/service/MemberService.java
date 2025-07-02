package com.gn.service;

import java.util.List;

import com.gn.dao.MemberDao;
import com.gn.dto.Member;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
	public int insertMember(String id, String pw) {
		Member param = new Member();
		param.setMemberId(id);
		param.setMemberPw(pw);
		int result = dao.insertMember(param);
		return result;
	}
	
}
