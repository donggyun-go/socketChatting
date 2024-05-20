<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Friend</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
    <div class="container">
        <h2>친구찾기</h2>
        <form action="searchFriendResult" method="post">
            <label for="searchId">ID or Email:</label>
            <input type="text" id="searchId" name="searchId">
            <button type="submit">검색</button>
        </form>
        
        <div class="section">
            <h3>검색 결과</h3>
            <ul>
                <c:forEach var="friend" items="${searchResults}">
                    <li>
                        ${friend.userName} (${friend.email})
                        <form action="addFriend" method="post" style="display:inline;">
                            <input type="hidden" name="friendId" value="${friend.userId}">
                            <button type="submit">친구추가</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>