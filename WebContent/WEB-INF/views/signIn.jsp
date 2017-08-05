<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
	<h1>Sign In</h1>
	<section class="container">
		<h1>Sign Up</h1>
		<div class="col-xs-4">
			<form action="signin" method="post" class="form-horizontal">
				<div class="form-group">
			    	<label for="inputID" class="col-sm-2 control-label">ID</label>
			    	<div class="col-sm-10">
			      		<input type="text" class="form-control" id="inputID" placeholder="ID">
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label for="inputPW" class="col-sm-2 control-label">PW</label>
			    	<div class="col-sm-10">
			      		<input type="password" class="form-control" id="inputPW" placeholder="PW" >
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<div class="col-sm-offset-2 col-sm-10">
			      		<button type="submit" class="btn btn-default">Sign in</button>
			    	</div>
			  	</div>
			</form>
		</div>
	</section>
</body>
</html>