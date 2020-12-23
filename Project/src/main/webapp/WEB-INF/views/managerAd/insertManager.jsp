<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" 
href="../resources/css/main.css">
<title>insertManger</title>
</head>
<body>
   
   <h1>광고등록</h1>

<form action="saveManager.do" enctype="multipart/form-data" method="post">

<table border="3" >
   
    <tr> 
    <td>광고이름</td>
    <td><input type="text" name="adname"></td> 
    </tr>
    <tr>
    <td>광고링크</td>
    <td><input type="text" name="adlink"></td>
    </tr>
    <tr>
    <td>광고사진</td>
     <td><input type="file" name="file"></td>
     </tr>
     <tr>
     <td colspan="2" align="center">
      <input type="submit" value="광고등록"/>
      </td>
     </table>
     
     <a href="getManagerList.do"><input type="button" value="광고목록"></a>
</form>

</body>
</html>