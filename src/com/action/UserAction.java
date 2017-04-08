package com.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("user")
@Namespace("/user")
@Results({@Result(name="success",location="view.jsp"),
	@Result(name="input",location="add.jsp"),
	@Result(name="login",location="login.jsp")
})
public class UserAction  implements ModelDriven<User> {
	private int id;
	private String name;
	private User user=new User();
	
	@Action("addUser2")
	public String addUser(){
		System.out.println("UserAction addUser");
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		
		System.out.println("user:"+user);
		
		//ActionContext.getContext().getSession();
		//ServletActionContext.getRequest().getSession(); 获取servlet原生对象
		name="测试";
		//return "input";
		return "view";
	}
	@Action("viewUser2")
	public String viewUser(){
		System.out.println("UserAction viewUser");
		System.out.println("id:"+id);
		System.out.println("name:"+name);
		name="测试";
		return "success";
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public User getModel() {
		return this.user;
	}
}
