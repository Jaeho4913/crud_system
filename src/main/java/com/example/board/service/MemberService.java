package com.example.board.service;

import com.example.board.dto.MemberDTO;
import com.example.board.dto.LoginDTO;

public interface MemberService {
	void save(MemberDTO memberDTO);
	
	MemberDTO login(LoginDTO loginDTO);
}
