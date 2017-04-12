<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../elements/localization.jspf" %>
<%@include file="../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../elements/el_navigation.jspf" %>
	
	<div class="wrapper container">
		<div class="heading">
			<h1>${authorization_label}</h1>
			<legend></legend>	
		</div>
	
		<c:if test="${not empty requestScope.statusError}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.statusError}" />
			</div>
		</c:if>

   		<c:if test="${not empty requestScope.statusSuccess}">
	   		<div class="alert alert-success">
				<strong>Success!</strong> <c:out value="${requestScope.statusSuccess}" />
			</div>
		</c:if>

		<ul id="myTab2" class="nav nav-tabs">
  			<li class="active"><a data-toggle="tab" href="#signin_panel">${signin_label}</a></li>
  			<li><a data-toggle="tab" href="#signup_panel">${signup_label}</a></li>
		</ul>
 
		<div class="tab-content">
	  		<%@include file="../elements/el_content_signin_authorization.jspf" %>
		  	<%@include file="../elements/el_content_signup_authorization.jspf" %>	  		 		
		</div>
 	</div>   
	<%@include file="../elements/el_footer.jspf" %>
</body>
</html>