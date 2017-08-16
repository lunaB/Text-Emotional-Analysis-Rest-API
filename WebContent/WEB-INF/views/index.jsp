<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: Vacation Project ::</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<header class="container">
		<div class="jumbotron">
			<h1 class="display-3">YoungChae's Vacation Project</h1>
			<p class="lead">텍스트 마이닝 기반 감성어 사전 구축 및 긍부정 판별 API</p>
			<hr class="my-4">
			<p>Emotional language dictionary construction & Positive and negative API</p>
			<p class="lead">
				<c:if test="${ empty signIn }">
					<a href="signin" class="btn btn-info btn-lg">sign in</a>
					<a href="signup" class="btn btn btn-primary btn-lg">sign up</a>
				</c:if>
				<c:if test="${ not empty signIn }">
					<a href="signout" class="btn btn-info btn-lg">sign out</a>
					<a href="mypage" class="btn btn btn-primary btn-lg">my page</a>
				</c:if>
			</p>
		</div>
	</header>
	<section>
		<div class="container">
			<h1>EX</h1>
			<div class="col-xs-6">
				<h3>긍정</h3>
				<hr>
				<textarea id="in" class="form-control" rows="4" readonly>정말 더럽게 재미없다. 이딴 영화가 다있냐 .. 돈이 아깝다.</textarea>
				<textarea id="out" class="form-control" rows="4" readonly>5.338405132293701</textarea>
			</div>
			<div class="col-xs-6">
				<h3>부정</h3>
				<hr>
				<textarea id="in" class="form-control" rows="4" readonly>와 이렇게 재미있는 영화는 처음입니다. 완전 집중하며 봤어요. 감사합니다.</textarea>
				<textarea id="out" class="form-control" rows="4" readonly>9.12370777130127</textarea>
			</div>
		</div>
		<hr>
		<br>
		<div class="container">
			<h1>API</h1>
			<h3>1.API 정보</h3>
			<hr>
			<table class="table">
				<thead>
					<tr class="info">
						<th>API 명</th>
						<th>메서드</th>
						<th>요청 URL</th>
						<th>출력 포맷</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>EM-LONG</td>
						<td>POST</td>
						<td>#/api</td>
						<td>JSON</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<br>
			<h3>2.요청변수</h3>
			<hr>
			<table class="table">
				<thead>
					<tr class="info">
						<th>요청 변수명</th>
						<th>타입</th>
						<th>필수 여부</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>text</td>
						<td>string</td>
						<td>Y</td>
						<td>긍부정 분석 대상의 문자열</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<br>
			<h3>3.출력결과</h3>
			<hr>
			<table class="table">
				<thead>
					<tr class="info">
						<th>필드명</th>
						<th>타입</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>result -> text</td>
						<td>string</td>
						<td>반환된 문자열</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<br>
			<h3>4.요청</h3>
			<hr>
			<pre>
POST: /api HTTP/1.1
HOST: #
Content-Type: charset=UTF-8
client-id: { 발급받은 client-id 값 }
client-secret: { 발급받은 client-secret 값 }</pre>
			<hr>
			<br>
			<h3>5.응답</h3>
			<hr>
			<pre>
{  
   "result":{  
      "emotion_score":9.769230842590332,
      "text":"당신을 좋아해요."
   },
   "version":"1.0",
   "name":"Emotion processing rest api",
   "description":"github.com/lunab 나영채의 고등학교 2학년 1학기 프로젝트"
}</pre>
			<hr>
			<br>
			<h3>6.에러</h3>
			<hr>
			<table class="table">
				<thead>
					<tr class="info">
						<th>에러코드</th>
						<th>설명</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>001</td>
						<td>post가 아닌 다른 요청</td>
					</tr>
					<tr>
						<td>002</td>
						<td>사용량 한도초과</td>
					</tr>
					<tr>
						<td>003</td>
						<td>인증 키가 일치하지 않음</td>
					</tr>
				</tbody>
			</table>
		</div>
	</section>
	<hr>
	<footer class="container">
		<p><b>열심히 만들었습니다.</b> 양영디지털 고등학교 2학년 나영채</p><br>
	</footer>
</body>
</html>