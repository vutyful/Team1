<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="/resources/css/main.css"> -->
<meta charset="UTF-8">
<title>insertManger</title>
</head>
<body>
   
   <h1>광고등록</h1>

<form action="saveManager.do" name='form' enctype="multipart/form-data" method="post">

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
      <input type="submit" value="광고등록" />
      </td>
     </table>
     
     <a href="getManagerList.do">광고목록</a>
</form>

</body>
</html>