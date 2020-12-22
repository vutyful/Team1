package project.simsim.systems.domains;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ManagerAdVO {
	
	private int adnum ; //광고번호
	private String adname; //광고이름
	private String adimg; //광고사진
	private String adlink; //광고링크
	private String click10; //10대
	private String click20;  //20대
	private String click30;  //30대
	private String click40;  //40대
	private String click50ov;  //50이상
	private String clickm;     //남자
	private String clickf;     //여자
	private String totalclick;   //총클릭수
	private String startdate;   //시작날짜
	private String enddate;     //끝날짜
	
	
MultipartFile file;	// write.jsp에 파일첨부시 name="file"과 동일한 변수명
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		
		// 업로드 파일 접근
		if(! file.isEmpty()){
			this.adimg = file.getOriginalFilename();
			
			// 해당 경로로 변경
			File f = new File("C:\\Users\\admin\\git\\Team1v2\\Project\\src\\main\\webapp\\resources\\upload"+adimg);

			try {
				file.transferTo(f);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	
	//setter getter 생성
	public int getAdnum() {
		return adnum;
	}
	public void setAdnum(int adnum) {
		this.adnum = adnum;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdimg() {
		return adimg;
	}
	public void setAdimg(String adimg) {
		this.adimg = adimg;
	}
	public String getAdlink() {
		return adlink;
	}
	public void setAdlink(String adlink) {
		this.adlink = adlink;
	}
	public String getClick10() {
		return click10;
	}
	public void setClick10(String click10) {
		this.click10 = click10;
	}
	public String getClick20() {
		return click20;
	}
	public void setClick20(String click20) {
		this.click20 = click20;
	}
	public String getClick30() {
		return click30;
	}
	public void setClick30(String click30) {
		this.click30 = click30;
	}
	public String getClick40() {
		return click40;
	}
	public void setClick40(String click40) {
		this.click40 = click40;
	}
	public String getClick50ov() {
		return click50ov;
	}
	public void setClick50ov(String click50ov) {
		this.click50ov = click50ov;
	}
	public String getClickm() {
		return clickm;
	}
	public void setClickm(String clickm) {
		this.clickm = clickm;
	}
	public String getClickf() {
		return clickf;
	}
	public void setClickf(String clickf) {
		this.clickf = clickf;
	}
	public String getTotalclick() {
		return totalclick;
	}
	public void setTotalclick(String totalclick) {
		this.totalclick = totalclick;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
	
}