package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import sun.util.logging.resources.logging_zh_HK;

@Namespace("/user")
@Action("login")
@Result(name="success",location="login.jsp")
public class LoginAction extends ActionSupport{
	public String execute(){
		String login = this.getText("login");
		System.out.println("Login========"+login);
		return "success";
	}
}
