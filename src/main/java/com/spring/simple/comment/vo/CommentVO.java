package com.spring.simple.comment.vo;

public class CommentVO {
	
	private int id;
	private String content;
	private int postId;
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "CommentVO [id=" + id + ", content=" + content + ", postId=" + postId + ", author=" + author + "]";
	}

	
	
}
