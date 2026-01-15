package com.example.board.dto;

import lombok.Data;

@Data
public class SearchDTO {
	private Integer page;
	private Integer size;
	private String keyword;
	private String searchType;
	
	public SearchDTO() {
		this.page = 1;
		this.size = 10;
		this.keyword = "";
		this.searchType = "";
	}
	public int getPage() {
		if (page == null) return 1;
		return page;
	}
	public int getSize() {
		if (size == null) return 10;
		return size;
	}
	public int getOffset() {
		return (getPage() - 1) * getSize();
	}
}
