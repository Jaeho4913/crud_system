package com.example.board.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MemberDTO {
	private String userId;
	private String password;
	private String userName;
	private String email;
	private LocalDateTime createdAt;
}
