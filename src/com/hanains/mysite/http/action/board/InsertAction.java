package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

public class InsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String id = request.getParameter("id");
		BoardVo vo = new BoardVo();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_no(Long.parseLong(id));
		
		BoardDao dao =new BoardDao();
		dao.insert(vo);
		HttpUtil.redirect(response, "/mysite/board");
	}

}
