<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>api test</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<header class="container">
		<div class="jumbotron"> 
	        <h1>API TEST PAGE</h1>
		</div>
	</header>
	<section class="container">
		<h3>Emotion processing restful api</h3>
		<hr>
		<textarea id="in" class="form-control" rows="4" placeholder="ex) 정말 더럽게 재미없다. 이딴 쓰래기 같은 영화는 없어져야함.&#13;&#10;       이렇게 재미있는 영화는 처음입니다. 끝까지 집중하며 봤어요."></textarea>
		<hr>
		<button type="button" class="btn btn-default" onclick="cl()" id="btn1">Submit</button>
		<hr>
		<textarea id="out" class="form-control" rows="4" placeholder=":: output ::"></textarea>
	</section>
	<script>
		function cl(){
			var t = $("#in").val();
			$("#in").text("");
			$.ajax({
				url: "api",
				type: "POST",
				headers : {"client-id" : "1234", "client-secret" : "5678"},
			    data : {"text":t},
				success: function(data){
					console.log(data.toString());
					if(data.result.emotion_score != null){
						$("#out").val(data.result.emotion_score);	
					}else{
						$("#out").val(data.result.errorCode);	
					}
				}
			});
			console.log("debug");
        }
	</script>
	
</body>
</html>