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
			<h1>${about_us_label}</h1>
			<legend></legend>
		</div>
		<div class="row">
			<%@include file="../elements/el_content_aboutUs.jspf" %>			
		</div>
	</div>
	<%@include file="../elements/el_footer.jspf" %>
</body>
</html>