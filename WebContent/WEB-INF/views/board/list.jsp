<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<!--  JSTL 변경 부분. -->
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<c:choose>
			<c:when test="${not empty authUser }">
				<div id="content">
					<div id="board">
						<form id="search_form" action="" method="post">
							<input type="text" id="kwd" name="kwd" value=""> <input
								type="submit" value="찾기">
						</form>
						<table class="tbl-ex">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>&nbsp;</th>
							</tr>
							<c:set var="count" value="${fn:length(list)}"/>
							<c:forEach items="${list }" var="vo" varStatus="status">
								<tr>
									<td>${count - status.index}</td>
									<td><a href="/mysite/board?a=view&no=${vo.no}">${vo.title}</a></td>
									<td>${vo.name }</td>
									<td>${vo.view_cnt}</td>
									<td>${vo.reg_date}</td>
									<td><a href="/mysite/board?a=delete&no=${vo.no}" class="del">삭제</a></td>
								</tr>
							</c:forEach>
							
							
							
							<!--  <tr>
								<td>3</td>
								<td><a href="/mysite/board?a=view">세 번째 글입니다.</a></td>
								<td>안대혁</td>
								<td>3</td>
								<td>2015-10-11 12:04:20</td>
								<td><a href="" class="del">삭제</a></td>
							</tr>
							<tr>
								<td>2</td>
								<td><a href="/mysite/board?a=view">두 번째 글입니다.</a></td>
								<td>안대혁</td>
								<td>3</td>
								<td>2015-10-02 12:04:12</td>
								<td><a href="" class="del">삭제</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="/mysite/board?a=view">첫 번째 글입니다.</a></td>
								<td>안대혁</td>
								<td>3</td>
								<td>2015-09-25 07:24:32</td>
								<td><a href="" class="del">삭제</a></td>
							</tr>-->
						</table>
						<div class="pager">
							<ul>
								<li class="pg-prev"><a href="#">◀ 이전</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li class="disable">4</li>
								<li class="disable">5</li>
								<li class="pg-next"><a href="#">다음 ▶</a></li>
							</ul>
						</div>
						<div class="bottom">
							<a href="/mysite/board?a=write" id="new-book">글쓰기</a>
						</div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<h1>로그인해주세요.</h1>
			</c:otherwise>
		</c:choose>
		<!--  JSTL 변경 부분. -->
		<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="menu" value="board"></c:param>
		</c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp" />
		<%
			//<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
			//<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
		%>
	</div>
</body>
</html>