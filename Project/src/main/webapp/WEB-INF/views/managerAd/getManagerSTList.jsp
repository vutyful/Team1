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
function columnChart1() {
//10초마다 갱신	
google.charts.setOnLoadCallback(function(){
setInterval(columnChart1(),10000);}); 
//버튼 클릭 시 ajax를 사용하여 서버로부터 json 배열 객체를 가져왔다고 가정함
var arr = [['나이', '클릭수',],['10대', 1000],['20대', 1170],['30대', 660],['40대', 1030],['50ov', 1030]];
//실 데이터를 가진 데이터테이블 객체를 반환하는 메소드
var dataTable = google.visualization.arrayToDataTable(arr);
//옵션객체 준비
var options = {
title: '나이대별 클릭수',
hAxis: {title: '나이',
titleTextStyle: {color: 'red'}}};
//차트를 그릴 영역인 div 객체를 가져옴
var objDiv = document.getElementById('column_chart_div1');
// 인자로 전달한 div 객체의 영역에 컬럼차트를 그릴수 있는 차트객체를 반환
var chart = new google.visualization.ColumnChart(objDiv);
// 차트객체에 데이터테이블과 옵션 객체를 인자로 전달하여 차트 그리는 메소드
chart.draw(dataTable, options);
} 
$(document).ready(function(){
  $('button').on('click', function(){
	  columnChart1();
   });
});
</script>
<title>통계정보창</title>
</head>
<body>
          
    <h1>광고별 통계</h1>
  
    <table  class="managertable">

    <tr>  
    <td rowspan="6" align = "center" width="350" >
    <img  width="200"  alt="" src="/Project/resources/upload/${manager.adimg}"></td>
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
      </table>    
      
    <input class="manager-but" onclick="location.href='getManagerST.do'" type="button" value="통계목록보기">

 
           <h1>그래프</h1> 
             <button type="button" class="manager-but" id="btn">버튼</button>
             <div id="column_chart_div1" style="width: 1000px; height: 500px;"></div>



</body>
</html>