package com.gn.common.wrapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class AnonymousWrapper extends HttpServletRequestWrapper{

	public AnonymousWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String writer) {
		// key가 writer인 경우 값이 null, 빈 문자열, 혹은 "익명"이 아닌 경우 "익명" 반환
		String writerValue = super.getParameter(writer);
		String result = "";
		if(writer.equals("writer")) {
			result = (writerValue != null && writerValue != "" && writerValue != "익명") ? writerValue : "익명" ;
		}
		return result;
	}
	
}
