<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글쓰기</title>
    <style>
        /* 간단하게 예쁘게 꾸미기 */
        body { width: 800px; margin: 0 auto; padding: 20px; }
        input, textarea { width: 100%; margin-bottom: 10px; padding: 10px; box-sizing: border-box; }
        button { padding: 10px 20px; }
    </style>
</head>
<body>
    <h2>✏️ 글 작성하기</h2>

    <form action="/board/save" method="post">
        
        <label>제목</label>
        <input type="text" name="title" placeholder="제목을 입력하세요" required>
        
        <label>작성자</label>
        <input type="text" name="writer" placeholder="이름" required>
        
        <label>내용</label>
        <textarea name="content" rows="10" placeholder="내용을 입력하세요"></textarea>
        
        <button type="submit">등록</button>
        <button type="button" onclick="history.back()">취소</button>
    </form>
</body>
</html>