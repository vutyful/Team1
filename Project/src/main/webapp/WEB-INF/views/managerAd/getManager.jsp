<%@ page  contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css"  href="../resources/managerAd/css/managerAd.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script>
function readURL(input) {
	if(input.files && input.files[0] ){
		var reader = new FileReader();
		reader.onload = function (e) {
			$("#blah").attr('src',e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
$("#adimg").change(function () {
	readURL(this);
})
</script>
<style type="text/css">


</style>
<title>광고 상세보기</title>
</head>
<body>
      <h1>광고 상세</h1>


      <form action="updateManager.do" method="post" id="manager">
        <input name="adnum" type="hidden" value="${manager.adnum}" />
        
        <table class="managertable">
        
      <tr>
            <td width="120">광고이름</td>
            <td align="left"><input name="adname" type="text" 
                value="${manager.adname}"/></td>
      </tr>
      <tr>
          <td width="120">광고사진</td>
          <td align="left" ><input name="adimg" type="file" onchange="readURL(this);" 
          value="${manager.adimg}"/> 
          <img alt="tour image" src="#" id="blah" width="100"/>
          </td>
          
      </tr>
      <tr>
         <td width="120">광고링크</td>
         <td align="left"><input name="adlink" type="text"
           value="${manager.adlink}"/></td>
      </tr>
      <tr>
         <td width="120">광고시작날짜</td>
         <td align="left">${manager.startdate }</td>
      </tr>
      <tr>
         <td width="120">광고끝나는날짜</td>
         <td align="left" >${manager.enddate }</td>
      </tr>
      
      <tr>
         <td colspan="2" align="center">
         <input class="manager-but" type="submit" value="광고수정">
         </td>
      </tr>
    </table>
 </form>
 
 

<input class="manager-but" onclick="location.href='insertManager.do'" type="button" value="광고등록">
<input class="manager-but" onclick="location.href='deleteManager.do?adnum=${manager.adnum}'" type="button" value="광고삭제">
<input class="manager-but" onclick="location.href='getManagerList.do'" type="button" value="광고목록">
 
</body>
</html>