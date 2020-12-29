package project.simsim.systems.domains;

public class ReplyVO {
	
	private int replynum; /* 댓글번호 */
	private String redate;  /* 댓글날짜 */
	private String rcontent;  /* 댓글내용 */
	private int rreco; /* 추천수 */
	private int connum; /* 컨텐츠번호 */
	private int memnum; /* 작성자 */
	
	private MemberVO memberVO; /* 댓글 불러오기 서브쿼리에 필요*/
	
	
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public int getRreco() {
		return rreco;
	}
	public void setRreco(int rreco) {
		this.rreco = rreco;
	}
	public int getConnum() {
		return connum;
	}
	public void setConnum(int connum) {
		this.connum = connum;
	}
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}

	

	

}
