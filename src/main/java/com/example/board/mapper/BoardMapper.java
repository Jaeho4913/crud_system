package com.example.board.mapper; // (패키지명은 작성자님꺼 그대로 두세요)

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param; // 👈 ★ 이거 중요! (임포트 필수)

import com.example.board.dto.BoardDTO;

import java.util.List;

@Mapper
public interface BoardMapper {
    
    // 1. 목록 보기 (파라미터 2개 추가된 버전으로 교체!)
    List<BoardDTO> findAll(@Param("offset") int offset,
    					   @Param("size") int size,
    					   @Param("keyword") String keyword,
    					   @Param("searchType") String searchType);

    // 2. 글 저장
    void save(BoardDTO boardDTO);
    
    // 3. 상세 보기
    BoardDTO findById(Long idx);

    // 4. 수정
    void update(BoardDTO boardDTO);

    // 5. 삭제
    void delete(Long idx);

    // 6. 전체 글 개수 (추가!)
    int count(@Param("keyword") String keyword, @Param("searchType") String searchType);
    
}