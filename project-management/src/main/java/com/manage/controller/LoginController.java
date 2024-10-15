package com.manage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manage.user.domain.UserDO;
import com.manage.user.service.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
@SessionAttributes(value={"user", "board"})
public class LoginController {

    @Autowired
    private UserService userService;
    
    @GetMapping("login")
    public String login() {
        return "login";
    }
    
    @PostMapping("login")
    public String loginProc(UserDO user, RedirectAttributes redirectAttributes, HttpSession session, HttpServletRequest request) {
        // 기존 세션 무효화 후 새로운 세션 생성
        session.invalidate();
        session = request.getSession(true);

        UserDO user1 = userService.getUser(user);

        if (user1 != null && user1.getUserpassword().equals(user.getUserpassword())) {
            System.out.println(user1.getUsername() + "님 접속");

            // 세션에 사용자 정보 저장
            session.setAttribute("user", user1);
            
            // 세션 정보 로그 확인
            System.out.println("세션에 저장된 사용자 정보: " + session.getAttribute("user"));

            return "redirect:/main";  // main 페이지로 리다이렉트
        } else {
            // 로그인 실패 시 오류 메시지 전달
            redirectAttributes.addFlashAttribute("errorMessage", "아이디 또는 비밀번호가 잘못되었습니다.");
            return "redirect:/login";  // 로그인 페이지로 리다이렉트
        }
    }






    @GetMapping("signUp")
    public String signUpForm(UserDO user) {
        return "signUp";
    }
    
    @PostMapping("/signUp")
    public String signUpProc(UserDO user, RedirectAttributes redirectAttributes) {
        try {
            userService.insertUser(user);  // 회원가입 처리
            // 회원가입 성공 메시지 설정
            redirectAttributes.addFlashAttribute("successMessage", "회원가입에 성공하셨습니다.");
            return "redirect:login";  // 회원가입 성공 후 로그인 페이지로 리다이렉트
        } catch (Exception e) {
            // 회원가입 실패 메시지 설정
            redirectAttributes.addFlashAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "redirect:signUp";  // 회원가입 실패 시 다시 회원가입 페이지로 리다이렉트
        }
    }


    
    @PostMapping("/checkId")
    @ResponseBody
    public Map<String, Boolean> checkId(@RequestParam("userid") String userid) {
        UserDO user = new UserDO();
        user.setUserid(userid);
        UserDO existingUser = userService.getUser(user);
        
        Map<String, Boolean> response = new HashMap<>();
        response.put("isIdTaken", existingUser != null); // 결과가 없을 때 처리
        return response;
    }

    
    @RequestMapping("/logout")
    public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        session.invalidate(); // 세션 무효화

        // 쿠키 삭제
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // 쿠키 삭제
                response.addCookie(cookie); // 클라이언트에 반영
            }
        }

        return "redirect:/login"; // 로그인 페이지로 리다이렉트
    }

}
