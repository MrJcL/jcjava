package com.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginStateInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		System.out.println("LoginStateInterceptor");
		Object name=invocation.getInvocationContext().getSession().get("name");
		if(name!=null){
			System.out.println(name+"已经登录");
			return invocation.invoke();
		}else{
			System.out.println("未登录");
			return "login";
		}
	}

}
