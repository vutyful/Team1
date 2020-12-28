<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="stylesheet" type="text/css"  href="../resources/managerAd/css/managerAd.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript">
function readURL(input) {
	if(input.files && input.files[0] ){
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#blah").attr('src',e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
$("#file").change(function () {
	readURL(this);
})
</script>
<title>insertManger</title>
</head>
<body>
   
   <h1>광고등록</h1>

<form action="saveManager.do" enctype="multipart/form-data" method="post" runat="server">

<table class="managertable" >
   
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
     <td><input type="file"  name="file" onchange="readURL(this);">
     <img alt="tour image" src="#" id="blah" width="100"/>
     </td>
     </tr>
     <tr>
     <td colspan="2" align="center">
      <input class="manager-but" type="submit" value="광고등록"/>
      </td>
     </table>
     
 <input class="manager-but" onclick="location.href='getManagerList.do'" type="button" value="광고목록">
</form>

</body>
</html>