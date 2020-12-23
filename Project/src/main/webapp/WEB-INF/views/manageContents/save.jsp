<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="saveContent.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="ccontent" id="ccontent"></textarea></td>
		</tr>
			<input type="hidden" name="memnum" value="2"/>
		<tr>
			<td>파일</td>
			<td><input type="file" name="file" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="등록"/></td>
			<td><a href="getContentsList.do"><input type="button" value="목록"/></a></td>
		</tr>
	</table>
</form>

</body>
</html>