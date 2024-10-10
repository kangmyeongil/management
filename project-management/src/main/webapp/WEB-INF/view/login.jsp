<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
        // 서버에서 전달된 성공 메시지를 alert로 표시
        var successMessage = "${successMessage}";
        if (successMessage) {
            alert(successMessage);
        }
    });
</script>

<style type="text/css">
    body {
        font-family: 'Arial', sans-serif;
        background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url('https://source.unsplash.com/random');
        background-size: cover;
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .login-container {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        text-align: center;
    }

    .login-container h1 {
        margin-bottom: 30px;
        color: #333;
    }

    .login-container input[type="text"], 
    .login-container input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .login-container input[type="submit"], 
    .login-container input[type="button"] {
        width: 100%;
        padding: 12px;
        margin-top: 20px;
        border: none;
        border-radius: 5px;
        background-color: #ff5722;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .login-container input[type="submit"]:hover, 
    .login-container input[type="button"]:hover {
        background-color: #e64a19;
    }

    .login-container a {
        color: #ff5722;
        text-decoration: none;
        font-size: 14px;
        display: inline-block;
        margin-top: 20px;
    }

    .login-container a:hover {
        text-decoration: underline;
    }

    /* 에러 메시지 스타일 */
    .message {
        color: red;
        text-align: center;
        margin-bottom: 20px;
        font-size: 16px;
    }

    /* 반응형 디자인 */
    @media (max-width: 600px) {
        .login-container {
            padding: 20px;
        }
    }
</style>
</head>
<body>
    <div class="login-container">
        <h1>로그인</h1>
        
        <!-- 로그인 실패 시 에러 메시지 출력 -->
        <c:if test="${not empty errorMessage}">
            <div class="message">${errorMessage}</div>
        </c:if>
        
        <form name="loginForm" action="login" method="POST" onsubmit="return validateForm()">
            <input type="text" name="userid" placeholder="아이디" value="${enteredId}" required />
            <input type="password" name="userpassword" placeholder="비밀번호" required />
            <input type="submit" value="로그인" />
            <input type="button" value="회원가입" onclick="location.href='signUp'" />
        </form>
    </div>
</body>
</html>
