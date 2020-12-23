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

	제목 : <input type="text" name="title" id="title"/>
	내용 : <textarea name="ccontent" id="ccontent"></textarea>
	<input type="hidden" name="memnum" value="2"/>
	<input type="submit" value="등록"/>
	파일 : <input type="file" name="file" />
	
</form>

</body>
</html>