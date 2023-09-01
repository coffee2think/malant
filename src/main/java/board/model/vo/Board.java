package board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable {

	private static final long serialVersionUID = -5219066150385199445L;

	private int boardNo;
	private String userNo;
	private String nickname;
	private String boardTitle;
	private String boardContent;
	private int boardLike;
	private Date boardDate;
	private String boardPhoto;
	private int viewcount;
	private Date likeDate;
	private String likeYN;
	private int hashtagNo;
	private String hashtagContent;
	private String reportedYN;

	public Board() {
		super();
	}

	public Board(int boardNo, String userNo, String nickname, String boardTitle, String boardContent, int boardLike,
			Date boardDate, String boardPhoto, int viewcount, Date likeDate, String likeYN, int hashtagNo,
			String hashtagContent, String reportedYN) {
		super();
		this.boardNo = boardNo;
		this.userNo = userNo;
		this.nickname = nickname;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardLike = boardLike;
		this.boardDate = boardDate;
		this.boardPhoto = boardPhoto;
		this.viewcount = viewcount;
		this.likeDate = likeDate;
		this.likeYN = likeYN;
		this.hashtagNo = hashtagNo;
		this.hashtagContent = hashtagContent;
		this.reportedYN = reportedYN;
	}

	public String getReportedYN(String reportedYN) {
		return reportedYN;
	}

	public void setReportedYN(String reportedYN) {
		this.reportedYN = reportedYN;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public String getBoardPhoto() {
		return boardPhoto;
	}

	public void setBoardPhoto(String boardPhoto) {
		this.boardPhoto = boardPhoto;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public String getLikeYN() {
		return likeYN;
	}

	public void setLikeYN(String likeYN) {
		this.likeYN = likeYN;
	}

	public int getHashtagNo() {
		return hashtagNo;
	}

	public void setHashtagNo(int hashtagNo) {
		this.hashtagNo = hashtagNo;
	}

	public String getHashtagContent() {
		return hashtagContent;
	}

	public void setHashtagContent(String hashtagContent) {
		this.hashtagContent = hashtagContent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", userNo=" + userNo + ", nickname=" + nickname + ", boardTitle="
				+ boardTitle + ", boardContent=" + boardContent + ", boardLike=" + boardLike + ", boardDate="
				+ boardDate + ", boardPhoto=" + boardPhoto + ", viewcount=" + viewcount + ", likeDate=" + likeDate
				+ ", likeYN=" + likeYN + ", hashtagNo=" + hashtagNo + ", hashtagContent=" + hashtagContent
				+ ", reportedYN " + reportedYN + "]";
	}

}
