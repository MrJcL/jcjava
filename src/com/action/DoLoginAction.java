package com.action;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@InterceptorRefs({
	@InterceptorRef("token"),
	@InterceptorRef("defaultStack")
})
@Namespace("/user")
@Action("doLogin")
@Results({@Result(name="loginPage",location="login.jsp"),
	@Result(name="mainPage",location="/main.action",type="redirect"),
	@Result(name="invalid.token",location="login.jsp")
})//action只能客户端转发

public class DoLoginAction extends ActionSupport{
	private static Map<String,String> accountMap=new HashMap<String,String>();
	static{
		accountMap.put("admin","123");
		accountMap.put("user1","123");
	}
	private String name;
	private String password;

	public String execute(){
		String password=accountMap.get(this.name);
		if(password!=null&&password.equals(password)){
			//通过session来保存用户的登录状态
			ActionContext.getContext().getSession().put("name",this.name);
			System.out.println("ok");
			return "mainPage";
		}else{
			System.out.println("no");
			ActionContext.getContext().put("msg",this.getText("loginfail"));
			return "loginPage";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
