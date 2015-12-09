package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpUtil.redirect(response, url);
		
		
		//글을 쓸때 로그인 같은걸 고려해야겠다.
		
		
		
		
		
		//HttpUtil.redirect(response, "/mysite/board");
		HttpUtil.forwarding(request,response,"/WEB-INF/views/board/write.jsp");
	}

}
