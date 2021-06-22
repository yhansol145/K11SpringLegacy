<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/css/bootstrap.css" />
<script src="./resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>HttpServletRequest로 폼값 받기(Get방식)</h2>
		
		<ul>
			<li>아이디 : ${id }</li>
			<li>패스워드 : ${pw }</li>
			<li>메세지 : ${message }</li>
		</ul>
	</div>
</body>
</html>