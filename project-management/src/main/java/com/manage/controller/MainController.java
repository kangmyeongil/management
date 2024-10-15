package com.manage.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.manage.project.domain.ProjectDO;
import com.manage.project.service.ProjectService;
import com.manage.user.domain.UserDO;
import com.manage.user.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes(value={"user", "board"})
public class MainController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProjectService projectService;
    
    @GetMapping("/main")
    public String showUserProjects(HttpSession session, Model model) {
        // 세션에서 사용자 정보 가져오기
        UserDO user = (UserDO) session.getAttribute("user");
        
        // 사용자가 로그인되지 않았으면 로그인 페이지로 리다이렉트
        if (user == null) {
            return "redirect:/login";
        }

        // 사용자 팀 ID를 이용해 프로젝트 목록 조회
        String teamId = user.getTeamid();
        
        if (teamId != null) {
            List<ProjectDO> projectList = projectService.getProjectList(teamId);
            model.addAttribute("projects", projectList);
        } else {
            model.addAttribute("projects", new ArrayList<>()); // 팀 ID가 없으면 빈 리스트 추가
        }

        return "main";  // 메인 페이지로 이동
    }





}
