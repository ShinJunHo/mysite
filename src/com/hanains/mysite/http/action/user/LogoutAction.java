package com.hanains.mysite.http.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		//널이라면 잘못된 접근
		if(session == null){
			HttpUtil.redirect(response, "/mysite/main");
			return;
		}
		//로그아웃 처리
		session.removeAttribute("authUser");
		//더 완벽하게 하려면 session ID를 재발급하는거야
		session.invalidate();
		//로그인으로 돌릴지 메인으로돌릴지는 운영자 마음
		
		HttpUtil.redirect(response, "/mysite/user?a=loginform");
	}

}
