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
			<h1>AGreement</h1>
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
	
			
		<c:if test="${not empty sessionScope.user.blockedTill}">							
			<div class="alert alert-danger">
				<strong>${blocked_to_label}:</strong> <c:out value="${sessionScope.user.blockedTill}" />
			</div>
		</c:if>

		<table class="table table-hover" style="text-align: center;">
			<tr>
				<td>Request onservice ID</td>
				<td>${requestScope.more.idRequest}</td>
			</tr>	
			
			<tr>
				<td>Agreement ID</td>
				<td>${requestScope.more.idAgreement}</td>
			</tr>	

			<tr>
				<td>Tariff ID</td>
				<td>${requestScope.more.idTariff}</td>
			</tr>
			
			<tr>
				<td>Request Date</td>
				<td>${requestScope.more.date}</td>
			</tr>
			
			<tr>
				<td>Service Action</td>
				<c:if test="${requestScope.more.serviceAction == true}">
					<td>Enable service</td>
				</c:if>

				<c:if test="${requestScope.more.serviceAction != true}">
					<td>Disable service</td>
				</c:if>
			</tr>

			<tr>
				<td>${position_label}</td>
				<td>${requestScope.user.position}</td>
			</tr>
			
			<tr>
				<td>${name_label}</td>
				<td>${requestScope.user.name}</td>
			</tr>
			<tr>
				<td>${surname_label}</td>
				<td>${requestScope.user.surname}</td>
			</tr>
			<tr>
				<td>${balance_label}</td>
				<td>${requestScope.user.balance} $</td>
			</tr>
			
			<tr>
				<td>${login_label}</td>
				<td>${requestScope.user.login}</td>
			</tr>
			<tr>
				<td>${email_label}</td>
				<td>${requestScope.user.email}</td>
			</tr>
			<tr>
				<td>${phone_label}</td>
				<td>${requestScope.user.phone}</td>
			</tr>
			<tr>
				<td>${birth_date_label}</td>
				<td>${requestScope.user.birthdate}</td>
			</tr>
			<tr>
				<td>${passport_label}</td>
				<td>${requestScope.user.passport}</td>
			</tr>
			<tr>
				<td>${address_label}</td>
				<td>${requestScope.user.address}</td>
			</tr>	
			
			<tr>
				<td>		
					<form action="Controller" method="get">
						<input type="hidden" name="command" value="accept_request_on_service"/>
						<input type="hidden" name="user_id" value="${requestScope.user.id}">	
						<input type="hidden" name="status" value="${requestScope.more.serviceAction}">	
						<button type="submit" class="btn btn-success" name="request_id" value="${requestScope.more.idRequest}">${apply_button}</button>
					</form>
				</td>
				<td>	
					<form action="Controller" method="post" >
						<input type="hidden" name="command" value="remove_request_on_service"/>
						<input type="hidden" name="status" value="true">
						<button type="submit" class="btn btn-danger" name="request_id" value="${requestScope.more.idRequest}">${remove_button}</button>
					</form>
				</td>
			</tr>
				  		
		</table>
		

								
								
		
						
	</div>

	<%@include file="../../elements/el_footer.jspf" %>

</body>
</html>