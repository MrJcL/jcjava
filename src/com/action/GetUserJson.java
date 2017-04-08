package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.domain.User;
import com.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

//@ParentPackage("json-default")
@Action("getUserJson")
//@Result(name="success",type="json",params={"root","userList","excludeNullProperties","false"})
@Result(name="success",location="user/test1.jsp")
public class GetUserJson extends ActionSupport{
	@Autowired
	private UserService service;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}

	public String execute(){
		/*userList=new ArrayList<User>();
		for(int i=1;i<=10;i++){
			
			User user=new User();
			user.setId(i);
			user.setAccount("admin"+i);
			user.setName("管理员"+i);
			userList.add(user);
		}*/
		try {
			this.userList=service.listUserByName(this.name);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name);
		System.out.println("userlist:"+userList);
		return "success";
	}
}
