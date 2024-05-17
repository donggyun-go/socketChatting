<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>로그인</h2>
        <form action="${pageContext.request.contextPath}/" method="post">
            <label for="userId">아이디:</label>
            <input type="text" id="userId" name="userId" required>
            
            <label for="userPass">비밀번호:</label>
            <input type="password" id="userPass" name="userPass" required>
            
            <input type="submit" value="로그인">
        </form>
    </div>
    <script>
        var errorMessage = '<%= request.getAttribute("error") %>';
    </script>    
    <script src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</body>
</html>
