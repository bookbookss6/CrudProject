package com.spring.simple.page.vo;

public class PageVO {
	
	private int maxSize;
	private int offset;
	private String keyword;
	
	public int getMaxSize() {
		return maxSize;
	}
	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	@Override
	public String toString() {
		return "PageVO [maxSize=" + maxSize + ", offset=" + offset + ", keyword=" + keyword + "]";
	}
	
	
	
}
