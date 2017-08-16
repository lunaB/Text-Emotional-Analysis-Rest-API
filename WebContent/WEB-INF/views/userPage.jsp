<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>:: ${ signIn }의 설정 ::</title>
	<style>
		body {
			background-color:#666;
		}
	</style>
	<script>
		var point = ${total}; // 총량
		var percent = ${per}; //퍼센트
	</script>
</head>
<body>
	<header class="container">
		<div class="jumbotron">
			<h1 class="display-3">My Page</h1>
			<p class="lead">자신의 API 사용량을 조회 할 수 있는 공간입니다.</p>
			<a class="btn btn-primary btn-lg" href="/">Back</a>
		</div>
	</header>
	<section class="container" style="height:500px;">
    	<div id="canvasO" class="col-xs-12" style="height: 100%;">
	       	<!--canvas-->
		</div>
    </section>
	<script>
		window.onload = load();
		function load(){
			var c = document.createElement("canvas");
			var canvasO = document.getElementById("canvasO");//캔버스 바깥
			var size = canvasO.offsetHeight >= canvasO.offsetWidth ? canvasO.offsetWidth : canvasO.offsetHeight; //최대 정사각형
			c.width = size;
			c.height = size;
			canvasO.appendChild(c);
			var ctx = c.getContext("2d");
			
			var x=c.width/2;
			var y=c.height/2;
			var radius = 120;
			var sa = 270 * Math.PI/180;
			var ea = -90 * Math.PI/180;
			
			ctx.fillStyle = "#666"
			ctx.fillRect(0,0,c.width,c.height);
			
			ctx.beginPath();
			ctx.arc(x,y,radius,sa,ea,false);
			ctx.lineWidth = 30;
			ctx.strokeStyle="#F8FFE9";
			ctx.stroke();
			ctx.closePath();
			
			/*
				666
				fff
				F8FFE9
				98B25C
				E1FF9D
				964AB2
				E49DFF
			*/
			/*
			var point = 400; // 남은량
			var percent = ${per}; //퍼센트
			*/
			var value = 18/5*percent;
			
			ctx.fillStyle = "#fff"
			ctx.font = "40px 맑은고딕"
			ctx.fillText("사용량",x-60,y+10);
			
			ctx.fillStyle = "#fff"
			ctx.font = "20px 맑은고딕"
			ctx.fillText(percent+"%",(percent==100?x-20:x-15),y+50);
			
			ctx.fillStyle = "#fff"
			ctx.font = "25px 맑은고딕";
			ctx.fillText(point+" 남음",c.width-150,c.height-30);
			
			var vTmp = 0;
					
			ctx.strokeStyle="#98B25C";
			ctx.lineCap = "round";
			if(value != 0){
				var drawA = setInterval(function(){
					vTmp++;
					ctx.beginPath();
					ctx.arc(x,y,radius,sa,(vTmp-90)*Math.PI/180,false);
					ctx.lineWidth = 30;
					ctx.stroke();
					ctx.closePath();
					if(Math.floor(value) == vTmp)
						clearInterval(drawA);
				},6);	
			}
		}
	</script>
</body>
</html>