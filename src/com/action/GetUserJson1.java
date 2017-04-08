package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.domain.User;
import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("json-default")
@Action("getUserJson1")
//将userList的内容以JSON形式输出
@Result(name="success",type="json",params={"root","userList","excludeNullProperties","false"})//设成true的话，空值就省略
//@Result(name="success",location="user/test1.jsp")
public class GetUserJson1 extends ActionSupport {
	private List<User> userList;
	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


	@Override
	public String execute() throws Exception {
		userList = new ArrayList<User>();
		for(int i=1;i<=10;i++){
			User user=new User();
			user.setId(i);
			user.setName("admin"+i);
			user.setAccount("傻仔龙"+i);
			userList.add(user);
		}
		return "success";
	}
}
