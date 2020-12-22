package project.simsim.systems.domains;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ContentVO {
	private int connum;
	private String title;
	private String ccontent;
	private String img;
	private long imgsize;
	private String postdate;
	private int cview;
	private int creco;
	private int memnum;
	
	MultipartFile file;	// write.jsp에 파일첨부시 name="file"과 동일한 변수명
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
		
		// 업로드 파일 접근
		if(! file.isEmpty()){
			this.img = file.getOriginalFilename();
			this.imgsize = file.getSize();
			
			//***********************************************
			// 해당 경로로 변경
			File f = new File("D:\\java\\git\\Team1\\Project\\src\\main\\webapp\\resources\\upload\\"+ img);
			
			try {
				file.transferTo(f);
				
			} catch (IllegalStateException e) {				
				e.printStackTrace();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public long getImgsize() {
		return imgsize;
	}
	public void setImgsize(long imgsize) {
		this.imgsize = imgsize;
	}
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
	public int getMemnum() {
		return memnum;
	}
	public void setMemnum(int memnum) {
		this.memnum = memnum;
	}
}
