package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PicService;

@Action("delete3")
@Result(name="success",location="/picdemo3.jsp")
//@Result(name="success",location="/pic.action",type="redirect")
public class delete2Action {
	/*@Autowired
	private PicService service;
	private String pictitlename;
	
	public String getPictitlename() {
		return pictitlename;
	}

	public void setPictitlename(String pictitlename) {
		this.pictitlename = pictitlename;
	}

	public String execute() throws Throwable{
		System.out.println("pictitlename---->"+pictitlename);
		try {
			service.deletePic(pictitlename);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return "success";
	}*/
}
