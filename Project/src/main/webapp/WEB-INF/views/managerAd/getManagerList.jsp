<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<link rel="stylesheet" type="text/css" 
href="../resources/css/main.css">
<title>광고 목록</title>
</head>
<body>
 
        <h2>광고 목록</h2>
        
   <table border="1">
       <tr> 
        <th  width="100">광고번호</th>
        <th  width="100">광고이름</th>
        <th  width="100">광고사진</th>
        <th  width="100">광고링크</th>
        <th  width="150">광고시작날짜</th>
        <th  width="150">광고끝나는날짜</th>
       </tr>
   <c:forEach items="${managerList}" var="manager">
   <tr>
       <td>${manager.adnum}</td><td align="left">
       <a href="getManager.do?adnum=${manager.adnum}">
       ${manager.adname}</a></td>
       <td>${manager.adimg}</td>
       <td>${manager.adlink}</td>
       <td>${manager.startdate}</td>
       <td>${manager.enddate}</td>
     
     
      </tr>
        </c:forEach>
   </table>
   <br>  <a href="insertManager.do"><input type="button" value="광고등록"></a>

</body>
</html>