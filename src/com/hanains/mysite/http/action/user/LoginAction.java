package com.hanains.mysite.http.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.UserDao;
import com.hanains.mysite.vo.UserVo;

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		
		UserDao dao =new UserDao();
		UserVo vo = dao.get(email, password);
		
		if(vo == null){
			//HttpUtil.redirect(response, "/mysite/user?a=loginform");
			//방법1.
			//	HttpUtil.forwarding(request, response, "/WEB-INF/views/user/loginform_retry.jsp");
			//forwarding 방법 jsp 페이지를 하나 더 만들어서.
			
			HttpUtil.redirect(response, "/mysite/user?a=loginform&result=fail");
		 	//	이렇게 하는 방법 2번째.
			
			
			//여기서 끝나야해.
			//통신은 끝났지만 코드는 계속 타고 있다.
			//여기서 return을 해야함.
			return ;
		}
		//로그인 성공.
		//없으면 만들어서 주고 있으면 있는거 줘.
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", vo);
		HttpUtil.redirect(response, "/mysite/main");
		
		
		
	}

}
