package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.domain.Pic;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.page.PageVO;
import com.service.PicService;
import com.util.SpringUtil;
@Action("pic")
@Result(name="success",location="user/picdemo.jsp")
public class picAction extends ActionSupport implements ModelDriven<PageVO<Pic>>{
	@Autowired
	private PicService service;

	private PageVO<Pic> pagevo = new PageVO<Pic>();
	
	public PageVO<Pic> getPagevo() {
		return pagevo;
	}

	public void setPagevo(PageVO<Pic> pagevo) {
		this.pagevo = pagevo;
	}

	public String execute(){
		try {
			//service=SpringUtil.getBean(PicService.class);
			pagevo=service.listPic(pagevo);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("pagevo:"+pagevo);
		return "success";
	}

	@Override
	public PageVO<Pic> getModel() {
		// TODO Auto-generated method stub
		return pagevo;
	}
}
