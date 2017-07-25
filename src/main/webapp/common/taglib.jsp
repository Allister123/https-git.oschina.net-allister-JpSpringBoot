<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	Integer port = request.getServerPort();
	String basePath = null;
	String tom_path = null;
	if(port == 80 || port == 443){
		basePath = request.getScheme() + "://" + request.getServerName() + path;
		tom_path = request.getScheme() + "://" + request.getServerName();
	}else{
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		tom_path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
	}
	pageContext.setAttribute("basePath", basePath);
	pageContext.setAttribute("resPath", basePath + "/resources");
%>