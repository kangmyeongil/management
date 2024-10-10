<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.manage.user.domain.*, java.util.Map" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(document).ready(function() {
    var idChecked = false;

    // 아이디 중복 체크 기능
    $('#checkIdBtn').click(function() {
        var userId = $('#userid').val();
        if (userId === '') {
            alert('아이디를 입력해주세요.');
            return;
        }
        $.ajax({
            url: 'checkId',
            type: 'POST',
            data: { userid: userId },
            success: function(response) {
                if (response.isIdTaken) {
                    alert('이미 사용 중인 아이디입니다.');
                    idChecked = false;
                } else {
                    alert('사용 가능한 아이디입니다.');
                    idChecked = true;
                    $('#idCheckStatus').val('true');
                }
            },
            error: function() {
                alert('아이디 중복 확인 중 오류가 발생했습니다.');
                idChecked = false;
            }
        });
    });

    // 폼 제출 시 아이디 중복 확인 여부 확인
    $('form').submit(function() {
        if (!idChecked) {
            alert('아이디 중복 확인을 해주세요.');
            return false;
        }
    });
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

    .signup-container {
        background-color: rgba(255, 255, 255, 0.9);
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 400px;
        text-align: center;
    }

    .signup-container h1 {
        margin-bottom: 30px;
        color: #333;
    }

    .signup-container input[type="text"],
    .signup-container input[type="password"],
    .signup-container input[type="email"],
    .signup-container select {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .signup-container input[type="submit"] {
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

    .signup-container input[type="submit"]:hover,
    .signup-container input[type="button"]:hover,
    .signup-container button:hover {
        background-color: #e64a19;
    }

    .signup-container a {
        color: #ff5722;
        text-decoration: none;
        font-size: 14px;
        display: inline-block;
        margin-top: 20px;
    }

    .signup-container a:hover {
        text-decoration: underline;
    }

    /* 아이디 입력 필드와 중복 확인 버튼을 한 줄에 배치 */
    .id-check-container {
        display: flex;
        align-items: center;  /* 세로로 가운데 정렬 */
        justify-content: space-between;
        gap: 10px;
    }

    .id-check-container input[type="text"] {
        flex: 3; /* 아이디 입력 필드가 더 넓게 */
    }

    .id-check-container button {
        flex: 1; /* 중복 확인 버튼이 적당한 너비로 */
        padding: 10px;
        height: 100%; /* 버튼 높이 맞춤 */
        box-sizing: border-box; /* 패딩과 높이를 함께 계산 */
        border: none;
        border-radius: 5px;
        background-color: #ff5722;
        color: white;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    /* 반응형 디자인 */
    @media (max-width: 600px) {
        .signup-container {
            padding: 20px;
        }

        .id-check-container {
            flex-direction: column;
        }

        .id-check-container input[type="text"],
        .id-check-container button {
            width: 100%;
        }
    }
</style>
</head>
<body>
    <div class="signup-container">
        <h1>회원가입</h1>
        <form action="signUp" method="POST">
            <div class="id-check-container">
                <input type="text" id="userid" name="userid" placeholder="아이디" required />
                <button type="button" id="checkIdBtn">중복 확인</button>
            </div>
            <input type="password" name="userpassword" placeholder="비밀번호" required />
            <input type="text" name="username" placeholder="이름" required />
            <input type="email" name="email" placeholder="이메일" required />
            <select name="role" required>
                <option value="ROLE_USER">일반회원</option>
                <option value="ROLE_COMPANY">기업회원</option>
            </select>
            <input type="submit" value="회원가입" />
            <input type="hidden" id="idCheckStatus" name="idCheckStatus" value="false" />
        </form>
    </div>
</body>
</html>
