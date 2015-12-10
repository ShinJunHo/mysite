package com.hanains.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanains.mysite.vo.BoardListVo;
import com.hanains.mysite.vo.BoardVo;

public class BoardDao {
	
	private Connection getConnection()throws SQLException{
		Connection connection = null;
		try{
			//1.드라이버 로딩.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.커넥션 만들기 ( ORACLE DB)
			String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(dbURL,"webdb","webdb");
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패 = "+ex);
		}
		return connection;
	}
	//새로운 리스크 Vo를 생성해서 보여줌.
	public List<BoardListVo> getList(){
		List<BoardListVo> list = new ArrayList<BoardListVo>();
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs= null;
		
		BoardListVo vo = null;
		try{
			//1.get Connection;
			conn = getConnection();
			
			//2,prepare statement
			String sql ="select a.no, a.title, a.member_no, b.name "+
						"as member_name, a.view_cnt, "+
						"to_char(a.reg_date,'yyyy-mm-dd hh:mi:ss') "+
						"from board a, member b "+
						"where a.member_no = b.no "+
						"order by a.reg_date desc";
			//3.statement 생성
			pstmt = conn.prepareStatement(sql);
			//4.질의.
			rs = pstmt.executeQuery();
			while(rs.next()){
				Long no =rs.getLong(1);
				String title=rs.getString(2);
				Long member_no=rs.getLong(3);
				String name=rs.getString(4);
				Long view_cnt = rs.getLong(5);
				String reg_date=rs.getString(6);
				
				vo = new BoardListVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setMember_no(member_no);
				vo.setName(name); 
				vo.setView_cnt(view_cnt);
				vo.setReg_date(reg_date);
				
				list.add(vo);
			}
		}catch( SQLException ex){
			System.out.println("SQL Error: "+ ex);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(pstmt !=null){
					pstmt.close();
				}
				if(conn!= null){
					conn.close();
				}
			}catch( SQLException ex){
				ex.printStackTrace();
			}
		}
		
		return list;
	}
	public void insert(BoardVo vo){
		Connection conn =null;
		PreparedStatement pstmt =null;
		//UserVo authUser = (UserVo) session.getAttribute("authUser");
		try{
			//1.DB connection;
			conn = getConnection();
			
			//2.prepare statement
			String sql="insert into board "+
					"values( board_no_seq.nextval,?,?,?,0,SYSDATE)";
			
			//3.statement 준비
			pstmt=conn.prepareStatement(sql);
			//4.binding 
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setLong(3,vo.getMember_no());
			
			//5.SQL실행
			pstmt.executeUpdate();
			
		}catch( SQLException ex){
			System.out.println("sql Error: "+ex);
			ex.printStackTrace();
		}finally{
			try{
			if(pstmt !=null){
				pstmt.close();
			}
			if(conn != null){
				conn.close();
			}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	public BoardVo view(BoardVo vo){
		BoardVo viewVo=null;
		Connection conn =null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try{
			conn= getConnection();
			//3.statement 준비
			String sql="select no, title, content, member_no from board where no=?";
			pstmt =conn.prepareStatement(sql);
			//4.binding.
			pstmt.setLong(1, vo.getNo());
			
			//5.SQL 실행
			rs= pstmt.executeQuery();
			while(rs.next()){
				
			}
			
		}catch(SQLException ex){
			System.out.println("SQL Error: "+ex);
		}
		
		return viewVo;
	}
	public void delete(BoardVo vo){
		
	}
}
