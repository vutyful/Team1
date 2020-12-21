<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/main.css">
<meta charset="UTF-8">
<title>메인페이지</title>

</head>
<body>

<h2>광고등록</h2>

<!-- 폼태그에 속성추가  --> 
<form id='form' name='form' enctype="multipart/form-data" method="post">
<table border="3" >
   
    <tr>
    <td>광고번호</td> 
    <td><input type="text" name="adnum" ></td> 
    </tr>
    <tr> 
    <td>광고이름</td>
    <td><input type="text" name="adname" ></td> 
    </tr>
    <tr>
    <td>광고링크</td>
    <td><input type="text" name="adlink" ></td>
    </tr>
    <tr>
    <td>광고사진</td>
     <td><input type="file" name="file" ></td>
     </tr>
     <tr>
     <td colspan="2" align="center">
      <a href="getBoardList.do"><input type="button" value="등록" id="addBtn"></a>
      <input type="button" value="수정" id="InBtn">
      <input type="button" value="삭제" id="DelBtn">
     </table>
</form>










</body>
</html>