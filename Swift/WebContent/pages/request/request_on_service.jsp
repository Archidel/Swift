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
			<h1>${create_request_on_service_label}</h1>
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


<form action="Controller" method="post">
	<input type="hidden" name="command" value="make_request_on_service">
		<table>
			<tr>
				<td style="widows: 200px; height: 50px;">${type_label}: </td>
				<td>
					<select class="selectpicker" data-live-search="true" id="tariff_type" name="tariff_type">
						<c:forEach items="${requestScope.tariffTypeList}" var = "typeList">
							<option>${typeList}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>${title_label}: </td>
				<td>
					<select class="selectpicker" data-live-search="true" id="tariff_title" name="tariff_title">
						<c:forEach items="${requestScope.list}" var = "list">
							<option>${list.title} [Type: ${list.type}]</option>
						</c:forEach>
					</select>
				</td>
			</tr>	
			
			<tr>
				<td>${peroid_label}:</td>
				<td>
				<input type="date" name="date_period">
				
				</td>
			</tr>	

	<tr>
		<td>${service_action_label}:</td>
		<td>
			<select class="selectpicker" id="request_service_action" name="request_service_action">
				<option>${enable_label}</option>
				<option>${disable_label}</option>
			</select>
		</td>
	</tr>



		</table>
		
		
		<br><br>
		<button type="submit" class="btn btn-primary">${make_order_button}</button>
		
		
</form>		
		
		<br><br>
	</div>
	
	<%@include file="../../elements/el_footer.jspf" %>

</body>
</html>