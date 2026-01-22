<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 수정</title>
    <style>
        body { width: 800px; margin: 0 auto; padding: 20px; }
        input, textarea { width: 100%; margin-bottom: 10px; padding: 10px; box-sizing: border-box; }
        button { padding: 10px 20px; }
    </style>
</head>
<body>
    <h2>🛠️ 글 수정하기</h2>

    <form action="/board/update" method="post">
        <input type="hidden" name="idx" value="${board.idx}">
        
        <label>제목</label>
        <input type="text" name="title" value="${board.title}" required>
        
        <label>작성자</label>
        <input type="text" name="writer" value="${board.writer}" readonly>
        
        <label>내용</label>
        <textarea name="content" rows="10">${board.content}</textarea>
        
        <button type="submit">수정 완료</button>
        <button type="button" onclick="history.back()">취소</button>
    </form>
</body>
</html>