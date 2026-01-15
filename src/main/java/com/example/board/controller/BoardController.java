package com.example.board.controller; // 패키지명

import com.example.board.dto.BoardDTO;
import com.example.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.dto.BoardDTO;
import com.example.board.dto.PageResponseDTO;
import com.example.board.dto.SearchDTO;
import com.example.board.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String home(@ModelAttribute SearchDTO searchDTO, Model model) {
		System.out.println("검색 조건 : " + searchDTO);
		PageResponseDTO response = boardService.findAll(searchDTO);
		model.addAttribute("response", response);
		return "home";	
	}
	@GetMapping("/write")
	public String writeForm() {
		return "write";
	}
	@PostMapping("/board/save")
	public String save(BoardDTO boardDTO) {
		boardService.save(boardDTO);
		return "redirect:/";
	}
	@GetMapping("/board/view")
    public String findById(@RequestParam("idx") Long idx, 
                           @ModelAttribute SearchDTO searchDTO,
                           Model model) {
		BoardDTO board = boardService.findById(idx);
		model.addAttribute("board", board);
		model.addAttribute("SearchDTO", searchDTO);
		return "detail";
	}
	@GetMapping("/board/update")
	public String updateForm(@RequestParam("idx") Long idx, Model model) {
		BoardDTO board = boardService.findById(idx);
		model.addAttribute("board", board);
		return "update";
	}
	@PostMapping("/board/update")
		public String update(BoardDTO boardDTO) {
			boardService.update(boardDTO);
			return "redirect:/board/view?idx=" + boardDTO.getIdx();
	}
	@GetMapping("/board/delete")
	public String delete(@RequestParam("idx") Long idx) {
		boardService.delete(idx);
		return "redirect:/";
	}
}
