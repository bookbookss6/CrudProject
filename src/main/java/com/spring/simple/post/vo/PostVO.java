package com.spring.simple.post.vo;

import java.util.Arrays;
import java.util.Date;

import com.spring.simple.page.vo.PageVO;

public class PostVO {
	
	private int id;
	private String title;
	private String author;
	private String content;
	private Date date;
	private byte[] image;
	private int userId;	
	private int visited;

	@Override
	public String toString() {
		return "PostVO [id=" + id + ", title=" + title + ", author=" + author + ", content=" + content + ", date="
				+ date + ", image=" + Arrays.toString(image) + ", userId=" + userId + ", visited=" + visited + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getVisited() {
		return visited;
	}

	public void setVisited(int visited) {
		this.visited = visited;
	}

}
