<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
    <div style="width: 800px; margin: 0 auto; text-align: center;">
        
        <h2>📋 게시글 목록</h2>
		<h3>현재 searchType 값: [${searchType}]</h3>
		<div style="margin-bottom: 10px;">
			<form action="/" method="get">
				<select name="searchType">
				    <option value="title" <c:if test="${response.searchDTO.searchType == 'title'}">selected</c:if>>제목</option>
				    <option value="content" <c:if test="${response.searchDTO.searchType == 'content'}">selected</c:if>>내용</option>
				    <option value="writer" <c:if test="${response.searchDTO.searchType == 'writer'}">selected</c:if>>작성자</option>
				</select>

				<input type="text" name="keyword" value="${response.searchDTO.keyword}" placeholder="검색어를 입력하세요"/>

				<button id="searchBtn">검색</button>
			</form>
		</div>
        <div style="text-align: right; margin-bottom: 10px;">
            <button onclick="location.href='/write'">✏️ 글쓰기</button>
        </div>

        <table border="1" style="width: 100%; border-collapse: collapse; text-align: center;">
            <tr style="background-color: #f2f2f2;">
                <th style="padding: 10px;">번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            
            <c:forEach items="${response.boardList}" var="board">
                <tr>
                    <td style="padding: 10px;">${board.idx}</td>
                    <td><a href="/board/view?idx=${board.idx}&page=${response.searchDTO.page}&keyword=${response.searchDTO.keyword}&searchType=${response.searchDTO.searchType}">
						${board.title}
						</a>
					</td>
                    <td>${board.writer}</td>
                    <td>${board.createdAt}</td>
                </tr>
            </c:forEach>
        </table>

        <div style="text-align: center; margin-top: 20px;">
            
            <c:if test="${response.searchDTO.page > 1}">
                <a href="/?page=1&searchType=${response.searchDTO.searchType}&keyword=${response.searchDTO.keyword}" style="font-weight: bold;">[<<]</a>
            </c:if>

            <c:if test="${response.searchDTO.page > 1}">
                 <a href="/?page=${response.searchDTO.page - 1}&searchType=${response.searchDTO.searchType}&keyword=${response.searchDTO.keyword}">[<]</a>
            </c:if>

            <c:forEach begin="${response.startPage}" end="${response.endPage}" var="i">
                <c:choose>
                    <c:when test="${response.searchDTO.page == i}">
                        <span style="color: red; font-weight: bold; margin: 0 5px;">${i}</span>
                    </c:when>
                    <c:otherwise>
                        <a href="/?page=${i}&searchType=${response.searchDTO.searchType}&keyword=${response.searchDTO.keyword}" style="margin: 0 5px;">[${i}]</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            
            <c:if test="${response.searchDTO.page < response.totalPage}">
                 <a href="/?page=${response.searchDTO.page + 1}&searchType=${response.searchDTO.searchType}&keyword=${response.searchDTO.keyword}">[>]</a>
            </c:if>

            <c:if test="${response.searchDTO.page < response.totalPage}">
                <a href="/?page=${response.totalPage}&searchType=${response.searchDTO.searchType}&keyword=${response.searchDTO.keyword}" style="font-weight: bold;">[>>]</a>
            </c:if>

        </div>
        </div>

</body>
</html>