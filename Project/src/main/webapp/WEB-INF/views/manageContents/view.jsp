<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="modifyContent.do" method="post" enctype="multipart/form-data">

	제목 : <input type="text" name="title" id="title" value="${content.title}"/>
	이미지 : <img src="../resources/upload/${content.img}">
	내용 : <textarea name="ccontent" id="ccontent">${content.ccontent}</textarea>
	<input type="hidden" name="memnum" value="${content.memnum}"/>
	<input type="submit" value="수정"/>
	파일 : <input type="file" name="file"/>
	
</form>

</body>
</html>