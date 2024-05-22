<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
    <div class="container">
        <h2>메인페이지</h2>
        <p>${sessionScope.userName}님 안녕하세요</p>
        
       <div class="section">
            <h3>친구찾기</h3>
            <form onsubmit="openSearchPopup(); return false;">
                <label for="userId">ID or Email:</label>
                <input type="text" id="userId" name="userId">
                <button type="submit">친구찾기</button>
            </form>
        </div>
        
        <div class="section">
            <h3>친구목록 리스트</h3>
            <ul>
                <c:forEach var="friend" items="${friendList}">
                    <li>
                        ${friend.friendName}
                        <form action="createChatRoom" method="post" style="display:inline;">
                            <input type="hidden" name="friendId" value="${friend.friendId}">
                            <button type="submit">대화방 생성</button>
                        </form>
                    </li>
                </c:forEach>
            </ul>
        </div>
        
        <div class="section">
            <h3>대화방 리스트</h3>
            <ul>
                <c:forEach var="chatRoom" items="${chatRoomsList}">
                    <li class="chat-room" ondblclick="enterChatRoom('${chatRoom}')">${chatRoom}</li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <script>
        function openSearchPopup() {
            var userId = document.getElementById("userId").value;
            var contextPath = '${pageContext.request.contextPath}';
            var popup = window.open(contextPath + '/home/searchFriendResult?userId=' + userId, 'searchFriendPopup', 'width=600,height=400');
            return false;
        }
    </script>
</body>
</html>
