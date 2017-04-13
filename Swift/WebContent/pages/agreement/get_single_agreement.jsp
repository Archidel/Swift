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
			<h1>${agreement_label}</h1>
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
				<td>Agreement ID</td>
				<td>${requestScope.more.idAgreement}</td>
			</tr>	
			
			<tr>
				<td>Agreement Date creation</td>
				<td>${requestScope.more.dateCreation}</td>
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
						<input type="hidden" name="command" value="accept_agreement"/>
						<button type="submit" class="btn btn-success" name="agreement_id" value="${requestScope.more.idAgreement}">${apply_button}</button>
					</form>
				</td>
				<td>	
					<form action="Controller" method="post" >
						<input type="hidden" name="command" value="remove_agreement"/>
						<button type="submit" class="btn btn-danger" name="agreement_id" value="${requestScope.more.idAgreement}">${remove_button}</button>
					</form>
				</td>
			</tr>  		
		</table>					
	</div>
	<%@include file="../../elements/el_footer.jspf" %>
</body>
</html>