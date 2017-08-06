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
	<h1>main page</h1>
	<c:if test="${ empty signIn }">
		<a href="signin" class="btn btn-info">sign in</a>
		<a href="signup" class="btn btn-info">sign up</a>
	</c:if>
	<c:if test="${ not empty signIn }">
		<a href="signout" class="btn btn-info">sign out</a>
		<a href="mypage" class="btn btn-info">my page</a>
	</c:if>
</body>
</html>