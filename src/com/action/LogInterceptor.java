package com.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LogInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("LogInterceptor action:"+invocation.getAction().getClass().getName());
		System.out.println("LogInterceptor actionproxy:"+invocation.getProxy().getClass().getName());
		System.out.println("action处理前");
		String result = invocation.invoke();
		System.out.println("action处理后:  "+result);
		return result; 
	}

}
