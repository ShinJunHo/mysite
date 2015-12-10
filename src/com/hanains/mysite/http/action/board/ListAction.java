package com.hanains.mysite.http.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;
import com.hanains.mysite.dao.BoardDao;
import com.hanains.mysite.vo.BoardListVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//DAO 를 이용해서 리스트를 받아오로록 한다.
		//list.jsp에서 리스트를 뽑아서 보여주도록.
		BoardDao dao = new BoardDao();
		List<BoardListVo> list = dao.getList();
		
		request.setAttribute("list", list);
		HttpUtil.forwarding(request, response, "/WEB-INF/views/board/list.jsp");
	}

}
