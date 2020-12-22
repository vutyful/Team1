<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <link rel="stylesheet" href="/resources/css/main.css"> -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>광고 상세보기</title>
</head>
<body>
      <h1>광고 상세</h1>
      <hr>
      <form action="updateManager.do" method="post">
        <input name="adnum" type="hidden" value="${manager.adnum}" />
      
      
      <table border="1">
      
      <tr>
      <td bgcolor="orange" width="70">광고이름</td>
      <td align="left"><input name="adname" type="text" value="${manager.adname}" /></td>
      </tr>
      
       <tr>
      <td bgcolor="orange" width="70">광고사진</td>
      <td align="left">${manager.adimg}</td>
      </tr>
      
       <tr>
      <td bgcolor="orange" width="70">광고링크</td>
      <td align="left">${manager.adlink}</td>
       </tr>
       
      <tr>
      <td bgcolor="orange" width="70">광고시작날짜</td>
      <td align="left">${manager.startdate}</td>
      </tr>
      
      <tr>
      <td bgcolor="orange" width="70">광고끝나는날짜</td>
      <td align="left">${mmanager.enddate}</td>
      </tr>
      
      <tr>
         <td colspan="2" align="center">
         <input type="submit" value="광고수정">
 
 </table>
 </form>
 <hr>
 <a href="insertManager.do">광고등록</a>
 <a href="deleteManagerel.do">광고삭제</a>
</body>
</html>