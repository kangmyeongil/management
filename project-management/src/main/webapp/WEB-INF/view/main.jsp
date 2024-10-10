<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Date, java.text.SimpleDateFormat, com.manage.user.domain.*, com.manage.project.domain.*" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>프로젝트 관리 시스템</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    $(document).ready(function() {
        $('#sidebarToggle').click(function() {
            $('#sidebar').toggleClass('active');
        });
    });
</script>
<style type="text/css">
body {
        font-family: Arial, sans-serif;
        background-color: #f9f9f9;
        margin: 0;
        padding: 0;
    }
        .header {
        background-color: #fff;
        padding: 10px 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        display: flex;
        justify-content: flex-end;
        align-items: center;
        position: relative;
    }

    /* 사이드바 토글 버튼 */
    #sidebarToggle {
        cursor: pointer;
        font-size: 24px;
        position: fixed;
        right: 20px;
        top: 20px;
        z-index: 1000;
        transition: right 0.3s ease;
    }
    #sidebar {
        position: fixed;
        top: 0;
        right: -250px; /* 초기에는 숨겨진 상태로 설정 */
        height: 100%;
        width: 250px;
        background-color: #333;
        transition: right 0.3s ease; /* left 속성 변경 시 애니메이션 적용 */
        z-index: 999;
    }
    #sidebar.active {
        right: 0; /* 사이드바가 화면 안으로 들어옴 */
    }
    .sidebar-content {
        color: #fff;
        padding: 20px;
    }
    .sidebar-content h3 {
        margin-bottom: 10px;
    }
    .sidebar-content button {
        padding: 10px;
        background-color: #007bff;
        border: none;
        color: #fff;
        border-radius: 4px;
        font-size: 14px;
        cursor: pointer;
        margin-top: 10px;
    }
    .content {
        text-align: center;
    }
      table {
        width: 700px;
        margin: 0 auto;
        border: 1px solid black;
        border-collapse: collapse;
        position: relative; /* 버튼 위치를 설정하기 위한 기준 */
    }
    tr, td {
        border: 1px solid black;
    }
    /* 프로젝트 추가 버튼 스타일 */
    .add-project-btn {
        display: block; /* block으로 설정하여 테이블 아래로 내려가게 */
        margin-left: auto; /* 버튼이 테이블 오른쪽 끝과 맞추어지도록 설정 */
        margin-top: 10px; /* 테이블과 버튼 사이 간격 */
    }
    </style>
</head>
<body>

<!-- 헤더 영역 -->
<div class="header">
    <nav>
        <span id="sidebarToggle">&#9776;</span> <!-- 사이드바 토글 버튼 -->
    </nav>
</div>

<!-- 사이드바 -->
<div id="sidebar">
    <div class="sidebar-content">
        <% UserDO user = (UserDO) session.getAttribute("user"); %>
        <h3><%= user.getUsername() %> 님, 환영합니다!</h3>
        <button type="button" onclick="location.href='logout'">로그아웃</button>
    </div>
</div>

<!-- 메인 콘텐츠 -->
<h1 class="content">진행 중인 프로젝트</h1>

<article>
<div style="width: 700px; margin: 0 auto;">
    <table>
        <thead>
            <tr>
                <th>프로젝트 이름</th>
                <th>진행 정도 (%)</th>
                <th>마감 기한</th>
                <th>액션</th>
            </tr>
        </thead>
        <tbody>
        
        <%
    // 프로젝트 목록 가져오기
    List<ProjectDO> projects = (List<ProjectDO>) request.getAttribute("projects");
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    if (projects != null && !projects.isEmpty()) {
        for (ProjectDO project : projects) {
%>
            <tr>
                <td><%= project.getProjectname() %></td>
                <td><%= project.getProgress() %></td>
                <td><%= dateFormat.format(project.getDeadline()) %></td>
                <td>
                    <button onclick="location.href='projectDetails?projectId=<%= project.getProjectid() %>'">열람</button>
                    <button onclick="if(confirm('정말 삭제하시겠습니까?')) { location.href='deleteProject?projectId=<%= project.getProjectid() %>'; }">삭제</button>
                </td>
            </tr>
<%
        }
    } else {
%>
        <tr>
            <td colspan="4">진행 중인 프로젝트가 없습니다.</td>
        </tr>
<%
    }
%>
        </tbody>
    </table>
    
    <button class="add-project-btn" onclick="location.href='addProject'">프로젝트 추가</button>
</div>
</article>

</body>
</html>
