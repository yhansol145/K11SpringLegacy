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
		<h2>@RequestMapping 어노테이션</h2>
		
		<h3>GET방식으로 전송된 검색 파라미터</h3>
		
		<ul>
			<li>검색필드 : ${sColumn }</li>
			<li>검색단어 : ${sWord }</li>
		</ul>
	</div>
</body>
</html>