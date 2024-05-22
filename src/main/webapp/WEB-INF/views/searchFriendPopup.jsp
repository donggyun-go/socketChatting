<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Friend</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        function addFriend(friendId) {
            $.ajax({
                url: '${pageContext.request.contextPath}/home/addFriend',
                type: 'POST',
                data: { friendId: friendId },
                success: function(response) {
                    if (response.friendAddSuccess) {
                        alert('친구 추가 성공!');
                        window.close(); 
                    } else {
                        alert('친구 추가 실패. 다시 시도하세요.');
                    }
                },
                error: function() {
                    alert('친구 추가 중 오류가 발생했습니다. 다시 시도하세요.');
                }
            });
        }
    </script>
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
                        ${friend.userName} (${friend.userEmail})
                        <button type="button" onclick="addFriend('${friend.userId}')">친구추가</button>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>
</html>
