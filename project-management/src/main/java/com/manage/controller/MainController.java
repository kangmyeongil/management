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
    public String showUserProjects(HttpSession session, HttpServletResponse response, Model model) {
    	
        UserDO user = (UserDO) session.getAttribute("user");
        
        // 세션에서 가져온 사용자 정보 출력
        System.out.println("메인 페이지에서 가져온 사용자 정보: " + user);
        
        if (user == null) {
            return "redirect:/login";
        }



        // 팀 ID 가져오기 (teamId가 null이거나 빈 값인 경우 처리)
        String teamId = user.getTeamid();  // UserDO에 팀 ID가 있다고 가정
        List<ProjectDO> projectList;

        System.out.println("\n\n" + teamId + "\n\n");
        if (teamId == null || teamId.isEmpty()) {
            // 팀 ID가 없는 경우 빈 프로젝트 목록 설정
            projectList = new ArrayList<>();
        } else {
            // 팀 ID가 있는 경우 해당 팀의 프로젝트 목록을 가져온다
            projectList = projectService.getProjectList(teamId);
        }

        // 모델에 프로젝트 목록과 사용자 정보 추가
        model.addAttribute("projects", projectList);
        model.addAttribute("user", user);

        return "main";
    }




}
