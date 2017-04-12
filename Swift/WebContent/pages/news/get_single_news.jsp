<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../elements/localization.jspf"%>
<%@include file="../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../../elements/el_navigation.jspf" %>
	
	<div class="wrapper container">
		
		<c:if test="${not empty requestScope.result}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.result}" />
			</div>
		</c:if>
		
		<div style="overflow: hidden;">			
			<div class="panel panel-primary">
	    			<div class="panel-heading"><h2>${requestScope.more.title}</h2></div>
	    			<div class="panel-body">
	    			<h4>${date_of_publication_label}: ${requestScope.more.datePublication}</h4>
	    			<h3><br>${requestScope.more.description}</h3>
	    			</div>
	    	</div>
		</div>
	</div>
<%@include file="../../elements/el_footer.jspf" %>
</body>
</html>