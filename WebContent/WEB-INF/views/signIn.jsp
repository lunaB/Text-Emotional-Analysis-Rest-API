<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<section class="container">
		<c:if test="${param.signInFail}">
			<div class="col-xs-12 bg-info">가입에 실패하였습니다.</div>
		</c:if>
		<h1>Sign Ip</h1>
		<div class="col-xs-4">
			<form action="signin" method="POST" class="form-horizontal">
				<div class="form-group">
			    	<label for="inputID" class="col-sm-2 control-label">ID</label>
			    	<div class="col-sm-10">
			      		<input type="text" class="form-control" name="id" id="inputID" placeholder="ID">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="inputPW" class="col-sm-2 control-label">PW</label>
			    	<div class="col-sm-10">
			      		<input type="password" class="form-control" name="pw" id="inputPW" placeholder="PW" >
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<div class="col-sm-offset-2 col-sm-10">
			      		<button type="submit" class="btn btn-default">Sign Up</button>
			    	</div>
			  	</div>
			</form>
		</div>
	</section>
</body>
</html>