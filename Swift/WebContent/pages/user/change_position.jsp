<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../elements/localization.jspf" %>
<%@include file="../../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%@include file="../../../elements/el_navigation.jspf" %>	
	
	<div class="wrapper container">
		<div class="heading">
			<h1>${change_position_label}</h1>
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
	
		<%@include file="../../../elements/el_content_user_info.jspf" %>	
		<form action="Controller" method="post">
    		
		<table cellpadding="4" cellspacing="0" style="width: 300px;" align="center">
   			<caption style="text-align: center;">${select_position_label}</caption>
   			<tr>
    			<th>
    				<label for="user_position">${position_label}</label>
    			</th>
    			<th>
					<select class="form-control" id="user_position" name="user_position">
						<option>User</option>
						<option>Moderator</option>
						<option>Admin</option>
					</select>
				</th>
   			</tr>
   			<tr>
    			<th colspan="2">
    				<input type="hidden" name="command" value="change_position">
    				<button class="btn btn-success form-control" type="submit" name="user_id" value="${requestScope.user.id}">${apply_button}</button>	
    			</th>
   			</tr> 
  		</table>
			</form>
    	
	</div>
	<br><br><br>
	<%@include file="../../../elements/el_footer.jspf" %>
</body>
</html>