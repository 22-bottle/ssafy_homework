package edu.vo;

public class Board {
	
	private String articleNo;
	private String hit;
	private String userId;
	private String subject;
	private String content;
	private String registerTime;
	
	public Board() {};
	public Board(String userId, String subject, String content) {
		super();
		this.userId = userId;
		this.subject = subject;
		this.content = content;
	}
	public Board(String articleNo, String hit, String userId, String subject, String content, String registerTime) {
		super();
		this.articleNo = articleNo;
		this.hit = hit;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.registerTime = registerTime;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "Board [articleNo=" + articleNo + ", hit=" + hit + ", userId=" + userId + ", subject=" + subject
				+ ", content=" + content + ", registerTime=" + registerTime + "]";
	}

}
