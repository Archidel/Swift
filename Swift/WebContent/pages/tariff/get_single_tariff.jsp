<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../elements/localization.jspf" %>
<%@include file="../../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../../../elements/el_navigation.jspf" %>
	
	<div class="wrapper container">
		
		<br><br><br>
		
		<c:if test="${not empty requestScope.result}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.result}" />
			</div>
		</c:if>
				
		<div style="overflow: hidden;">			
			<div class="panel panel-primary">
	    		<div class="panel-heading"><h2>${requestScope.more.title} <span class="pull-right">${type_label}: ${requestScope.more.type}</span></h2></div>
	    		<div class="panel-body">
		    		<br>
		    		<div class="row">
		    			<div class="col-md-1">TYPE:</div>
	  					<div class="col-md-4">${requestScope.more.type}</div>
		    		</div>
		    		<br>
		    		<div class="row">
		    			<div class="col-md-1">${price_label}:</div>
	  					<div class="col-md-4">${requestScope.more.price} $ per MONTH</div>
		    		</div>
		    		<br>
		    		<div class="row">
		    			<div class="col-md-1">${description_label}:</div>
		    			<br>
	  					<div class="col-md-12">${requestScope.more.description}</div>
		    		</div>
	    		
	    				    		<br><br>

	    		
	    		</div>
	    	</div>
		</div>
	</div>
	<%@include file="../../../elements/el_footer.jspf" %>
</body>
</html>