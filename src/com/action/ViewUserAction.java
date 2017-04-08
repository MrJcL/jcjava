package com.action;

public class ViewUserAction {
	// http://域名名:端口/应用名/命名空间/action名.action
	private int id;
	private String name;
	public ViewUserAction(){
		System.out.println("ViewUserAction 被实例化！");
	}

	public String execute() {
		System.out.println(this.id);
		System.out.println(this.name);
		System.out.println("UserAction execute");
		this.name="管理员";
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

}
