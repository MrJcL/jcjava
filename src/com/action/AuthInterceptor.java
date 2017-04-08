package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 负责精确的权限检查
 * @author liushd
 *
 */
public class AuthInterceptor extends AbstractInterceptor {
    private static Map<String,List<String>> authMap=new HashMap<String,List<String>>();
    static{
    	List<String> adminList=new ArrayList<String>();
    	adminList.add("com.action.AddUserAction");
    	adminList.add("com.action.ViewUserAction");
    	adminList.add("com.action.MainAction");
    	authMap.put("admin", adminList);
    	
    	List<String> userList=new ArrayList<String>();
    	userList.add("com.action.ViewUserAction");
    	userList.add("com.action.MainAction");
    	authMap.put("user1", userList);
    	
    }
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("AuthInterceptor");
		String name=(String)invocation.getInvocationContext().getSession().get("name");
		String actionName=invocation.getAction().getClass().getName();
		List<String> authList=authMap.get(name);
		if(authList.contains(actionName)){//有权限访问此action
			System.out.println(name+"有权限访问:"+actionName);
			return invocation.invoke();
		}else{//无权限访问，重定向到权限错误提示页面
			System.out.println(name+"有权限访问:"+actionName);
			return "authError";
		}
	}

}
