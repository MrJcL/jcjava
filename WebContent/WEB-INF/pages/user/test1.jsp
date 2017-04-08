<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="align:center">
		<table style='border-color: red' border='1' cellpadding='0' cellspacing='0'>
			<tr><th>ID</th><th>账号</th><th>名称</th></tr>
			<s:iterator var="item" value="userList">
				<tr>
					<td><s:property value="#item.id"/></td>
					<td><s:property value="#item.account"/></td>
					<td><s:property value="#item.name"/></td>
				
				</tr>
			</s:iterator>
		</table>
	
	</div>
	

</body>
</html>