<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" 
href="../resources/css/main.css">
<meta charset="UTF-8">
<title>광고 목록</title>

 <h1>광고 목록</h1>
      <hr>
      <form action="updateManager.do" method="post">
        <input name="adnum" type="hidden" value="${manager.adnum}" />
        <table border="1" cellpadding="0" cellspacing="0">
        
      <tr>
            <td width="120">광고이름</td>
            <td align="left"><input name="adname" type="text" 
                value="${manager.adname}"/></td>
      </tr>


    </table>
 </form>
 <hr>


</head>
<body>

</body>
</html>