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
			<h1>${error_label} ${pageContext.errorData.statusCode}</h1>
			<legend></legend>
		</div>
		
		<h3>
			<c:choose>
	    		<c:when test="${pageContext.errorData.statusCode == 404}">
	       			${error_404_message}
	    		</c:when>
	    		<c:when test="${pageContext.errorData.statusCode == 403}">
	       			${error_403_message}
	       		</c:when>
	    		<c:when test="${pageContext.errorData.statusCode == 414}">
	       			${error_414_message}
	       		</c:when>
	    		<c:when test="${pageContext.errorData.statusCode == 504}">
	       			${error_504_message}
	       		</c:when>
	    		<c:otherwise>
	    			Unknown error
	    		</c:otherwise>
			</c:choose>
		</h3>
	</div>
</body>
</html>