package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Action("picdemo3")
@Result(name="success",location="user/picdemo3.jsp")
public class picdemo3Action {

	public String execute() throws Throwable{
		return "success";
	}
}
