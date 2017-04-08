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
import com.opensymphony.xwork2.ModelDriven;
import com.service.PicService;
import com.util.SpringUtil;

@Action("update")
@Result(name="success",location="/pic.action",type="redirect")
public class UpdateAction implements ModelDriven<Pic>{
	@Autowired
	private PicService service;
	private Pic pic=new Pic();
	private File img;
	private String imgFileName;
	private String imgContentType;
	
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
		System.out.println("id---->"+pic.getId());
		System.out.println("url---->"+pic.getPicurl());
		System.out.println("title---->"+pic.getPictitle());
		System.out.println("info---->"+pic.getPicinfo());
		if(imgFileName!=null){
			String fileName = UUID.randomUUID()+"."+FilenameUtils.getExtension(imgFileName);
			String savePath = "e:/pic/"+fileName;
			System.out.println("path---->"+savePath);
			File destFile = new File(savePath);
			FileUtils.copyFile(img, destFile);
			pic.setPicurl("http://127.0.0.1:8080/image/"+fileName);
		}
		try {
			/*System.out.println("title---->"+pic.getPictitle());
			Pic pic1 = service.getid(pic.getPictitle());
			
			System.out.println("pic1------>"+pic1);
			System.out.println("pic1.getId()------>"+pic1.getId());
			pic.setId(pic1.getId());*/
			
			System.out.println(pic.getPicurl());
			//service = SpringUtil.getBean(PicService.class);
			service.updatePic(pic);
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
