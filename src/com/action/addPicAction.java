package com.action;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Pic;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.service.PicService;
import com.util.SpringUtil;

@Action("addPic")
@Result(name="success",location="/pic.action",type="redirect")
public class addPicAction implements ModelDriven<Pic>{
	private File img;
	private String imgFileName;
	private String imgContentType;
	private Pic pic = new Pic();
	@Autowired
	private PicService service;
	
	public Pic getPic() {
		return pic;
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
	
	public String execute() throws Throwable{
		
		//http://127.0.0.1:8080/image/
		//System.out.println("imgpath--------->"+img.getPath());
		if(imgFileName!=null){
			String fileName = UUID.randomUUID()+"."+FilenameUtils.getExtension(imgFileName);
			String savePath = "e:/pic/"+fileName;
			System.out.println("path---->"+savePath);
			File destFile = new File(savePath);
			FileUtils.copyFile(img, destFile);
			pic.setPicurl("http://127.0.0.1:8080/image/"+fileName);
		}
		try {
			//service = SpringUtil.getBean(PicService.class);
			service.addPic(pic);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return "success";
	}
	@Override
	public Pic getModel() {
		// TODO Auto-generated method stub
		return pic;
	}
}
