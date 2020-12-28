<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$('#direct').hide();
	
	$('#cate').change(function(){
		if($(this).val()=="direct")
		{
			$('#direct').show();
			$(this).attr('name', "");
			$('#direct').attr('name', "cate");
		}
		else
		{
			$('#direct').hide();
			$('#direct').attr('name', "");
			$(this).attr('name', "cate");
		}
	});
});
</script>
</head>
<body>

<form action="saveContent.do" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title" id="title"/></td>
		</tr>
		<tr>
			<td>카테고리</td>
			<td>
				<select id="cate" name="cate">
					<c:forEach items="${list}" var="category">
						<option>${category}</option>
					</c:forEach>
					<option value="direct">직접입력</option>
				</select>
				<input type="text" id="direct" name="">
			</td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea name="ccontent" id="ccontent"></textarea></td>
		</tr>
			<input type="hidden" name="memnum" value="1"/>
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