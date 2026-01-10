package com.example.board.controller; // 패키지명

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.board.dto.BoardDTO;
import com.example.board.mapper.BoardMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping; // ★이게 없으면 에러남!

@Controller
public class BoardController {

    @Autowired
    private BoardMapper boardMapper;

    // 1. 목록 보기
    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "1")int page,
    				   @RequestParam(value = "searchType", required = false) String searchType,
    				   @RequestParam(value = "keyword", required = false) String keyword,
    				   Model model) {
    	
    	System.out.println("================================");
    	System.out.println("현재 페이지(page): " + page);
    	System.out.println("검색어(keyword) : [" + keyword + "]");
    	System.out.println("검색유형(searchType) : [" + searchType + "]" );
  
    	int size = 10;
    	int pageCount = 10;
    	int offset = (page - 1) * size;
    	
    	System.out.println("계산된 offset: "+ offset);
    	System.out.println("가져올 개수(size): " + size);
    	System.out.println("================================");
    	
    	List<BoardDTO> list = boardMapper.findAll(offset, size, keyword, searchType);
        int totalCount = boardMapper.count(keyword, searchType);
        int totalPage = (int)Math.ceil((double)totalCount / size);
        int startPage = ((page - 1) / pageCount) * pageCount + 1;
        int endPage = startPage + pageCount - 1;
        if (endPage > totalPage) {
        	endPage = totalPage;
        }
        model.addAttribute("boardList", list);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("page", page);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("keyword", keyword);
        model.addAttribute("searchType", searchType);
        return "home";
    }

    // 2. 글쓰기 화면 보여주기
    @GetMapping("/write")
    public String writeForm() {
        return "write";
    }

    // 3. 글 저장하기 (이게 404 났던 부분!)
    @PostMapping("/board/save")
    public String save(BoardDTO boardDTO) {
        System.out.println("글 저장 요청:" + boardDTO);
        boardMapper.save(boardDTO);
        return "redirect:/";
    }
    
    // 4. 글 상세 보기
    @GetMapping("/board/view")
    public String findById(@RequestParam("idx") Long idx,
    					   @RequestParam(value = "page", defaultValue = "1") int page,
    					   @RequestParam(value = "keyword", defaultValue = "") String keyword,
    					   @RequestParam(value = "searchType", defaultValue = "") String searchType,
    					   Model model) {
    	// (1) DB에서 글 하나 가져오기
    	BoardDTO board = boardMapper.findById(idx);
    	
    	// (2) 화면에 보여줄 수 있게 "board"라는 이름으로 담기
    	model.addAttribute("board", board);
    	
    	// (3) detail.jsp로 이동
    	return "detail";
    }
    
    //5. 수정 화면 이동(기존 데이터를 가지고 감!)
    @GetMapping("/board/update")
    public String updateForm(Long idx, Model model) {
    	BoardDTO board = boardMapper.findById(idx);
    	model.addAttribute("board", board);
    	return "update"; 	
    }
    //6. 글 수정 저장
    @PostMapping("board/update")
    public String update(BoardDTO boardDTO) {
    	boardMapper.update(boardDTO);
    	return "redirect:/board/view?idx=" + boardDTO.getIdx();
    }
    //7. 글 삭제
    @GetMapping("/board/delete")
    public String delete(Long idx) {
    	//1. DB에서 삭제
    	boardMapper.delete(idx);
    	//2. 삭제 후 목록으로 이동
    	return "redirect:/";
    }

} // 클래스 끝나는 괄호 확인!