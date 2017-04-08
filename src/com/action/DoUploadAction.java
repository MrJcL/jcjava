package com.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
@Action("doUpload")
//@Result(name="success",location="/upload.jsp")
@Result(name="success",location="http://127.0.0.1:8080/image/${imgName}",type="redirect")
public class DoUploadAction {
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
		System.out.println(img.getPath());
		System.out.println(imgFileName);
		String fileName = UUID.randomUUID()+"."+FilenameUtils.getExtension(imgFileName);
		System.out.println(fileName);
		String savePath = "e:/pic/"+fileName;
		System.out.println(savePath);
		File destFile = new File(savePath);
		FileUtils.copyFile(img, destFile);
		ActionContext.getContext().put("imgName", fileName);
		return "success";
	}
	
}
