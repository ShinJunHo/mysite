package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String id = request.getParameter("id");
		String no = request.getParameter("no");
		BoardVo vo = new BoardVo();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_no(Long.parseLong(id));
		vo.setNo(Long.parseLong(no));
		
		BoardDao dao =new BoardDao();
		dao.update(vo);
		
		HttpUtil.redirect(response, "/mysite/board");
	}

}
