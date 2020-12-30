<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/managerAd/css/managerAd.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

google.charts.load('current', {packages: ['corechart']});
//묶은 세로 막대형 차트 1
function managerChart() {
//버튼 클릭 시 ajax를 사용하여 서버로부터 json 배열 객체를 가져왔다
var arr = [['나이(성별)', '클릭수',],
['10대',${manager.click10}],['20대',${manager.click20}],
['30대',${manager.click30}],['40대',${manager.click40}],
['50ov',${manager.click50ov}],['남자',${manager.clickm}],
['여자',${manager.clickf}]];
//실 데이터를 가진 데이터테이블 객체를 반환하는 메소드
var dataTable = google.visualization.arrayToDataTable(arr);
//옵션객체 준비
var options = {
title: '나이대별(성별) 클릭수',
hAxis: {title: '나이(성별)',
}};
//차트를 그릴 영역인 div 객체를 가져옴
var objDiv = document.getElementById('managerST');
// 인자로 전달한 div 객체의 영역에 컬럼차트를 그릴수 있는 차트객체를 반환
var chart = new google.visualization.ColumnChart(objDiv);
// 차트객체에 데이터테이블과 옵션 객체를 인자로 전달하여 차트 그리는 메소드
chart.draw(dataTable, options);
} 
$(document).ready(function(){
  $('button').on('click', function(){
	  managerChart();
   });
});

</script>
<title>통계정보창</title>
</head>
<body>
          
    <h1>광고별 통계</h1>
  
    <table  class="managertable">

    <tr>  
    <td rowspan="8" align = "center" width="350" >
    <img  width="300"  alt="" src="/Project/resources/upload/${manager.adimg}"></td>
    <td align="center" width="150">광고총클릭수 현황</td>
    <td align="char">${manager.totalclick}</td> 
    </tr>
    <tr> 
    <td align="center" width="150">10대 클릭수</td>
    <td align="char">${manager.click10}</td> 
    </tr>  
    <tr> 
     <td align="center" width="150">20대 클릭수</td>
    <td align="char">${manager.click20}</td> 
    </tr>
    <tr>              
    <td align="center" width="150">30대 클릭수</td>
    <td align="char">${manager.click30}</td> 
    </tr>
    <tr>              
     <td align="center" width="150">40대 클릭수</td>
    <td align="char">${manager.click40}</td> 
    </tr> 
     <tr>              
     <td align="center" width="150">50대 이상클릭수</td>
     <td align="char">${manager.click50ov}</td> 
     </tr>
     <tr>              
     <td align="center" width="150">남자</td>
     <td align="char">${manager.clickm}</td> 
     </tr>
     <tr>              
     <td align="center" width="150">여자</td>
     <td align="char">${manager.clickf}</td> 
     </tr>                  
      </table>    
      
    <input class="manager-but" onclick="location.href='getManagerST.do'" type="button" value="통계목록보기">

 
           <h1>그래프</h1> 
             <button type="button" class="manager-but" id="btn">클릭당 그래프 보고싶으면 여기누르세요~</button>
             <div id="managerST" style="width: 1300px; height: 500px;"></div>



</body>
</html>