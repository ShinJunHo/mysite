<%@ page contentType="text/html;charset=UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.hanains.mysite.dao.GuestBookDao"%>
<%@ page import="com.hanains.mysite.vo.GuestBookVo"%>
<!--  tag lib 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!--  
	import는 지워도 된다. JSTL EL 로 처리를 했음. 
		List for each & 개행.
		로그인 세션 유지.
-->
<%
	//object to down casting
	//	List<GuestBookVo> list = (List<GuestBookVo>)request.getAttribute("list");
	//list 를 이렇게 사용해서 하지 않아도 된다.
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<!--  JSTL 변경 부분. -->
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<c:choose>
			<c:when test="${not empty authUser }">
				<div id="content">
					<div id="guestbook">
						<form action="/mysite/guestbook" method="post">
							<input type="hidden" name="a" value="insert">
							<table>
								<tr>
									<td>이름</td>
									<td><input type="text" name="name"
										value="${authUser.name }"></td>
									<td>비밀번호</td>
									<td><input type="password" name="pass"></td>
								</tr>
								<tr>
									<td colspan=4><textarea name="content" id="content"></textarea></td>
								</tr>
								<tr>
									<td colspan=4 align=right><input type="submit"
										VALUE=" 확인 "></td>
								</tr>
							</table>
						</form>
						<%
							//	int countTotal=list.size();
									//	int i=0;
									//	for(GuestBookVo vo : list){
									//From Java Code To JSTL EL
						%>
						<%
							//	<!-- <c:set var="newline" value="${\n}"/> --> 이거 하면 Error?...
									//pageContext.setAttribute("cr", "\r");
							pageContext.setAttribute("newline", "\n");
									//--${count}-- 
									//
						%>
						<c:set var="count" value="${fn:length(list) }" />
						<input type="text" value="${nl}">
						<c:forEach items="${list }" var="vo" varStatus="status">
							<br>
							<table width=510 border=1>
								<tr>
									<td>${count - status.index }</td>
									<td>${vo.name }</td>
									<td>${vo.reg_date }</td>
									<td><a href="/mysite/guestbook?a=deleteform&id=${vo.no}">삭제</a></td>
								</tr>
								<tr>
									<td colspan=4>${fn:replace(vo.message,newline,"<br/>")}</td>
								</tr>
							</table>
							<%
								//}
							%>
						</c:forEach>
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
			</c:when>
			<c:otherwise>
				<h1>로그인 해주시오.</h1>
			</c:otherwise>
		</c:choose>
		<!--  JSTL 변경 부분. -->
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="menu" value="guestbook"></c:param>
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" />

		<%
			//<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
			//<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		%>
	</div>
</body>
</html>