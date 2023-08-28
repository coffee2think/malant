package board.model.vo;

import java.sql.Date;

public class Comment implements java.io.Serializable {

	private static final long serialVersionUID = 5471428830133210366L;

	private String commentNo;
	private int commentLike;
	private String commentContent;
	private Date commentDate;

	public Comment() {
		super();
	}

	public Comment(String commentNo, int commentLike, String commentContent, Date commentDate) {
		super();
		this.commentNo = commentNo;
		this.commentLike = commentLike;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
	}

	public String getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}

	public int getCommentLike() {
		return commentLike;
	}

	public void setCommentLike(int commentLike) {
		this.commentLike = commentLike;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", commentLike=" + commentLike + ", commentContent=" + commentContent
				+ ", commentDate=" + commentDate + "]";
	}

}
