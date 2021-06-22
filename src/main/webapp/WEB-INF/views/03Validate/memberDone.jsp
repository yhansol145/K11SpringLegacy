<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>Validator 인터페이스를 구현한 폼값 검증</h2>
		<h3>유효성 검증 성공 - 회원가입 완료</h3>
		
		<ul>
			<li>아이디 : ${mInfo.id }</li>
			<li>패스워드 : ${mInfo.pw }</li>
			<li>이름 : ${mInfo.name }</li>
		</ul>
	</div>
</body>
</html>