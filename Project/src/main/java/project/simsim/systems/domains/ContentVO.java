package project.simsim.systems.domains;

public class ContentVO {
	
	private int connum;  /* 컨텐츠번호 */
	private String 	title; /* 컨텐츠이름 */
	private String ccontent; /* 컨텐츠내용 */
	private String img; /* 컨텐츠사진 */
	private String postdate; /* 날짜 */
	private int cview;  /* 컨텐츠조회수 */
	private int creco;  /* 컨텐츠추천수 */
	private String cstate; /* 상태 */
	private int memnum;  /* 작성자 */
	
	public int getConnum() {
		return connum;
	}
	public void setConnum(int connum) {
		this.connum = connum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getPostdate() {
		return postdate;
	}
	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	public int getCview() {
		return cview;
	}
	public void setCview(int cview) {
		this.cview = cview;
	}
	public int getCreco() {
		return creco;
	}
	public void setCreco(int creco) {
		this.creco = creco;
	}
	public String getCstate() {
		return cstate;
	}
	public void setCstate(String cstate) {
		this.cstate = cstate;
	}
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}
	

	

}
