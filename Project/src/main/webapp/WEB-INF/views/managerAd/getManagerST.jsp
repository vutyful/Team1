<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../resources/managerAd/css/managerAd.css">

<style type="text/css">
a{text-decoration:none}
</style>

<meta charset="UTF-8">
<title>광고 목록</title>

       <h2 align="center" >광고 통계 목록</h2> 
       
 <table class="managertable">
  <tr>
   <th width="100">광고번호</th>
   <th width="100">광고이름</th>
   <th width="100">광고사진</th>
  </tr>
 <c:forEach items="${managerSTList}" var="manager">
 <tr>
      <td align="center">${manager.adnum}</td>
      <td align="center">
      <a href="getManagerSTList.do?adnum=${manager.adnum}">
      ${manager.adname}</a></td>
    <td align="center"><img  width="70" alt="" src="/Project/resources/upload/${manager.adimg}"></td>
 
 
 </tr>
 </c:forEach>
 </table>
 


</head>
<body>

</body>
</html>