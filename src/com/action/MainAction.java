package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

@ParentPackage("user")
@Action("main")
@Result(name="success",location="main.jsp")
public class MainAction {
	public String execute(){
		return "success";
	}
}
