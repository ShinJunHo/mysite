<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.hanains.mysite.dao.GuestBookDao" %>
<%@ page import="com.hanains.mysite.vo.GuestBookVo" %>
<%
	//object to down casting
	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/guestbook" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td><td><input type="text" name="name"></td>
							<td>비밀번호</td><td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				
				<%
					int countTotal=list.size();
					int i=0;
					for(GuestBookVo vo : list){
				%>
				<br>
				<table width=510 border=1>
					<tr>
						<td><%=countTotal-(i++)%></td>
						<td><%=vo.getName() %></td>
						<td><%=vo.getReg_date() %></td>
						<td><a href="/mysite/guestbook?a=deleteform&id=<%=vo.getNo()%>">삭제</a></td>
					</tr>
					<tr>
						<td colspan=4><%=vo.getMessage().replaceAll("\n", "<br/>") %></td>
					</tr>
				</table>
				<%
				}
				
				%>
				<!--  <ul>
					<li>
						<table>
							<tr>
								<td>[4]</td>
								<td>안대혁</td>
								<td>2015-11-10 11:22:30</td>
								<td><a href="">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>
								안녕하세요. ^^;<br>
								하하하하	
								</td>
							</tr>
						</table>
						<br>
					</li>
				</ul>-->
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>