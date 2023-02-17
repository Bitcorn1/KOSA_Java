package member.vo;

public class MemberName {
	private int boardNum;
	private String boardTitle;
	private String memberName;
	private String boardDate;
	private int boardLike;
	private String memberId;
	
	public MemberName() {
		
	}

	

	



	public MemberName(int boardNum, String boardTitle, String memberName, String boardDate, int boardLike, String memberId) {
		super();
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.memberName = memberName;
		this.boardDate = boardDate;
		this.boardLike = boardLike;
		this.memberId = memberId;
	}



	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardLike() {
		return boardLike;
	}

	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	
	public String getMemberId() {
		return memberId;
	}



	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}
