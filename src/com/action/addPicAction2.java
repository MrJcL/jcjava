package com.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.domain.Pic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PicService;

@Action("addPic3")
@Result(name="success",location="/picdemo3.jsp")
public class addPicAction2 extends ActionSupport{
	private File img;
	private String imgFileName;
	private String imgContentType;
	private String picurl;
	private String picinfo;
	private String pictitle;
	private Pic pic = new Pic();
	@Autowired
	private PicService service;
	
	public Pic getPic() {
		return pic;
	}
	public String getPicurl() {
		return picurl;
	}
	public String getPicinfo() {
		return picinfo;
	}
	public String getPictitle() {
		return pictitle;
	}
	
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public void setPicinfo(String picinfo) {
		this.picinfo = picinfo;
	}
	public void setPictitle(String pictitle) {
		this.pictitle = pictitle;
	}
	public void setPic(Pic pic) {
		this.pic = pic;
	}
	public File getImg() {
		return img;
	}
	public void setImg(File img) {
		this.img = img;
	}
	public String getImgFileName() {
		return imgFileName;
	}
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}
	public String getImgContentType() {
		return imgContentType;
	}
	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}
	
	public String execute(){
		
		//http://127.0.0.1:8080/image/
		//System.out.println("imgpath--------->"+img.getPath());
		if(imgFileName!=null){
			String fileName = UUID.randomUUID()+"."+FilenameUtils.getExtension(imgFileName);
			String savePath = "e:/pic/"+fileName;
			System.out.println("path---->"+savePath);
			File destFile = new File(savePath);
			try {
				FileUtils.copyFile(img, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			picurl = "http://127.0.0.1:8080/image/"+fileName;
			System.out.println(picurl);
		}
		System.out.println(pictitle);
		pic.setPictitle(pictitle);
		pic.setPicinfo(picinfo);
		pic.setPicurl(picurl);
		try {
			service.addPic(pic);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return "success";
	}
}
