package com.example.board.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.dto.LoginDTO;
import com.example.board.dto.MemberDTO;
import com.example.board.service.MemberService;
import com.example.board.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/save")
	public String saveForm() {
		return "member/save";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute MemberDTO memberDTO) {
		memberService.save(memberDTO);
		return "member/login";
	}
	
	@GetMapping("/login")
	public String loginForm() {
		return "member/login";
	}
	
	@PostMapping("/login")
	public String loginPost(@ModelAttribute LoginDTO loginDTO, HttpSession session) {
		MemberDTO loginResult = memberService.login(loginDTO);
		if (loginResult != null) {
			session.setAttribute("loginMember", loginResult);
			return "redirect:/";
		} else {
			return "member/login";
		}
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
