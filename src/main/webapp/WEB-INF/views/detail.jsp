<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>상세 보기</title>
		<style>
			body{width: 800px; margin: 0 auto; padding 20px;}
			table{width: 100%; border-collapse: collapse; margin-bottom: 20px;}
			th, td{border: 1px solid #ddd; padding:15px;}
			th{background-color: #f2f2f2; width: 100px;}
			.btn-area{padding: 10px 20px; cursor: pointer;}
		</style>
	</head>
	<body>
		<h2>📖 글 상세 보기</h2>
		
		<table>
			<tr>
				<th>번호</th>
				<td>${board.idx}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.createdAt}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.writer}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${board.viewCnt}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td style="height: 200px; vertical-aligin: top;">
					${board.content}
				</td>
			</tr>
		</table>
	
		<div class="btn-area">
			<button onclick="location.href='/?page=${page}&keyword=${keyword}&searchType=${searchType}'">목록으로</button>
			<button onclick="location.href='/board/update?idx=${board.idx}'">수정</button>
			<button onclick="if(confirm('정말 삭제하시겠습니까?')) location.href='/board/delete?idx=${board.idx}'">삭제</button>
		</div>
	</body>
<html>