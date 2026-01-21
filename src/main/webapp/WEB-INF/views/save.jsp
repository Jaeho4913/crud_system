<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입 페이지</title>
	</head>
	<body>
		
		<h2>회원가입</h2>	
		
		<form action="/member/save" method="post">
			
			<p>
				<label>아이디 :</label>
				<input type="text" name="userId" placeholder="아이디를 입력하세요" required>
			</p>
			
			<p>
				<label>비밀번호 :</label>
				<input type="text" name="password" placeholder="비밀번호를 입력하세요" required>
			</p>
			
			<p>
				<label>이름 :</label>
				<input type="text" name="userName" placeholder="이름을 입력하세요" required>
			</p>
			
			<p>
				<label>이메일 :</label>
				<input type="text" name="email" placeholder="이메일을 입력하세요" required>
			</p>

			<button type="submit">가입하기</button>
		</form>
		
		<hr>
		<a href="/member/login">이미 아이디가 있다면? 로그인하러 가기</a>
	</body>
</html>

			