package com.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.domain.Pic;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PicService;
@ParentPackage("json-default")
@Action("pic3")
@Result(name="success",type="json",params={"root","picList","excludeNullProperties","false"})
public class picAction2 extends ActionSupport{
	@Autowired
	private PicService service;
	private List<Pic> picList;

	public List<Pic> getPicList() {
		return picList;
	}

	public void setPicList(List<Pic> picList) {
		this.picList = picList;
	}

	public String execute(){
		try {
			//this.picList=service.listPic();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("picList:"+picList);
		return "success";
	}
}
