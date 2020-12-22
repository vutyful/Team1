<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th>글번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>추천수</th>
	</tr>
	<c:forEach items="${contentsList}" var="content">
		<tr>
			<td>${content.connum}</td>
			<td><a href='view.do?connum=${content.connum}'>${content.title}</a></td>
			<td>${content.memnum}</td>
			<td>${content.postdate}</td>
			<td>${content.cview}</td>
			<td>${content.creco}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>