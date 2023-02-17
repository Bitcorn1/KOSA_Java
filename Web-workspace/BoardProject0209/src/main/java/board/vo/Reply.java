package board.vo;

public class Reply {
	private int replyNum;
	private String replyContent;
	private String replyAuthor;
	private String replyDate;
	private int boardnumber;
	private String boardAuthor;
	
	public Reply() {
		
	}
	
	
	
	public Reply(int replyNum, String replyContent, String replyAuthor, String replyDate, int boardnumber, String boardAuthor) {
		super();
		this.replyNum = replyNum;
		this.replyContent = replyContent;
		this.replyAuthor = replyAuthor;
		this.replyDate = replyDate;
		this.boardnumber = boardnumber;
		this.boardAuthor = boardAuthor;
	}



	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyAuthor() {
		return replyAuthor;
	}

	public void setReplyAuthor(String replyAuthor) {
		this.replyAuthor = replyAuthor;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public int getBoardnumber() {
		return boardnumber;
	}

	public void setBoardnumber(int boardnumber) {
		this.boardnumber = boardnumber;
	}



	public String getBoardAuthor() {
		return boardAuthor;
	}



	public void setBoardAuthor(String boardAuthor) {
		this.boardAuthor = boardAuthor;
	}
	
}
