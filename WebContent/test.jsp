<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>취향저격</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<h1>main page</h1>
	<ul>
		<li><a href="login.do">로그인</a></li>
		<li><a href="register.do">회원가입</a></li>
		<li><a href="list.do">list</a></li>
	</ul>
	
	<button onclick="cl()">button</button>
	
	<script>
		function cl(){
			t = "adsfa";
			console.log('debug');
			$.ajax({
				url: "api",
				type: "POST",
				headers : {"client-id" : "1234", "client-secret" : "5678"},
			    data : {"text":t},
				success: function(data){
				    console.log(data);
			    	console.log(data.name);
			    	console.log(data.result.text);
			    	console.log(data.result.emotion_score);
			    	console.log(data.result.errorCode);
				}
			});
			console.log("debug");
        }
	</script>
	
</body>
</html>