package com.example.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardGroupMapper {
	int countActiveBoardGroup(@Param("boardGroupIdx") Integer boardGroupIdx);
}
