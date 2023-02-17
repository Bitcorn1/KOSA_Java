package board.vo;

public class LikeNum {
		private int likenum;
		private int boardNumber;
		private String myId;
		
		public LikeNum() {
			
		}
		
		

		public LikeNum(int boardNumber, String myId) {
			super();
			this.boardNumber = boardNumber;
			this.myId = myId;
		}

		

		public int getLikenum() {
			return likenum;
		}



		public void setLikenum(int likenum) {
			this.likenum = likenum;
		}



		public int getBoardNumber() {
			return boardNumber;
		}

		public void setBoardNumber(int boardNumber) {
			this.boardNumber = boardNumber;
		}



		public String getMyId() {
			return myId;
		}



		public void setMyId(String myId) {
			this.myId = myId;
		}
		
		
		
}
