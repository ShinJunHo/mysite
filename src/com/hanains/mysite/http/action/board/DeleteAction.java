package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String no=request.getParameter("no");
		String password = request.getParameter("password");
		
		BoardVo vo = new BoardVo();
		vo.setNo(Long.parseLong(no));
		
		BoardDao dao = new BoardDao();
		dao.delete(vo);
		response.sendRedirect("/mysite/board");
	
	}

}
