<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../elements/localization.jspf"%>
<%@include file="../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../elements/el_navigation.jspf" %>
	<div class="wrapper container">
		<div class="heading">
			<h1>${error_label}</h1>
			<legend></legend>
		</div>

		<h3>
			<c:if test="${not empty requestScope.statusError}">
				${requestScope.statusError}	
			</c:if>
				
			<c:if test="${empty requestScope.statusError}">
				${error_wrong_request_label}	
			</c:if>
		</h3>
		
		<a href="index"><button type="button" class="btn btn-lg  btn-primary" style="height: 50px">${security_button}</button></a>
	</div>
</body>
</html>