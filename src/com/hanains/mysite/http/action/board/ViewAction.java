package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//게시글 정보를 받아서 넘기도록 해야겠다.
		
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		Long no = Long.parseLong(request.getParameter("no"));
		vo.setNo(no);
		dao.view(vo);
//		response.
//		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/view.jsp");
		/*
		//BoardDao dao = 
		String no=request.getParameter("no");
		String password = request.getParameter("password");
		
		GuestBookVo vo = new GuestBookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);
		response.sendRedirect("/mysite/guestbook");
		*/
	}

}
