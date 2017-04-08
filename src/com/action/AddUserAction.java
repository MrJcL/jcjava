package com.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage("user")
@Namespace("/user")
@Action("addUser")
@Results({
@Result(name="success",location="view.jsp"),
@Result(name="input",location="view.jsp")
})
public class AddUserAction extends ActionSupport{
	private String name;
	private int id;
	
	
	public AddUserAction() {
		System.out.println("AddUserAction 被实例化");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String execute(){
		System.out.println(this.name);
		System.out.println("添加用户");
		
		this.name="管理员";
		return "success";
	}
}
