package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.domain.Pic;
import com.opensymphony.xwork2.ModelDriven;
import com.service.PicService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.SpringUtil;

import javassist.bytecode.LineNumberAttribute.Pc;

@Action("delete")
@Result(name="success",location="/pic.action",type="redirect")
public class deleteAction {
	@Autowired
	private PicService service;
	private Pic pic = new Pic();
	private int id;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String execute() throws Throwable{
		//service = SpringUtil.getBean(PicService.class);
		System.out.println(id);
		pic.setId(id);
		service.deletePic(pic);
		return "success";
	}

}
