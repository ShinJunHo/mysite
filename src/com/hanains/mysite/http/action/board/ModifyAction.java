package com.hanains.mysite.http.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		BoardDao dao = new BoardDao();
		Long no = Long.parseLong(request.getParameter("no"));
		BoardVo vo = dao.getView(no);
		
		request.setAttribute("board",vo);
		System.out.println(vo);
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/modify.jsp");
	}

}
