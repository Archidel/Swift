<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../elements/localization.jspf"%>
<%@include file="../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../elements/el_navigation.jspf" %>
	
	<div class="wrapper container">
		<div class="heading">
			<h1>swift.net</h1>
			<legend></legend>
		</div>

   		<c:if test="${not empty requestScope.statusSuccess}">
	   		<div class="alert alert-success">
				<strong>Success!</strong> <c:out value="${requestScope.statusSuccess}" />
			</div>
		</c:if>

		<c:if test="${not empty requestScope.statusError}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.statusError}" />
			</div>
		</c:if>

		<div class="jumbotron">
			<blockquote>
				<p>&ldquo;${quote_label}&rdquo;</p>
				<small>${quote_authror_label}</small>
			</blockquote>
		</div>
		
		<p>
			${head_one_label}
		</p>
		
		<p>
			${head_two_label} 
		</p>
		
		<p>
			${head_three_label}  
		</p>
		
		<p>
			${head_four_label}  
		</p>
		
		<p>
			${head_five_label} 
		</p>
		
		<p>
			${head_fix_label} 
		</p>
		
		<p>
			${head_seven_label} 
		</p>
		
		<p>
			${head_eight_label} 
		</p>
		
		<p>
			${head_nine_label}  
		</p>
		
		<br>
		<br>	
	</div>
	<%@include file="../elements/el_footer.jspf" %>
</body>
</html>