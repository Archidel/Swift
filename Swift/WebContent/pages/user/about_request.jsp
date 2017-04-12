<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../../elements/localization.jspf" %>
<%@include file="../../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../../elements/el_navigation.jspf" %>
	<div class="wrapper container">
		<div class="heading">
			<h1>${management_label}</h1>
			<legend></legend>
		</div>
		<div class="row">
		</div>
		
		<p>
			<table>
				<tr>
					<td style="width: 200px;">Request ID</td>
					<td>${requestScope.more.id}</td>
				</tr>
				<tr>
					<td>Tariff ID</td>
					<td>${requestScope.more.idTariff}</td>
				</tr>
				<tr>
					<td>Tariff type</td>
					<td>${requestScope.more.typeTariff}</td>
				</tr>
				<tr>
					<td>Date</td>
					<td>${requestScope.more.date}</td>
				</tr>
				<tr>
					<td>Service Action</td>
					<td>${requestScope.more.serviceAction}</td>
				</tr>
				
				<tr>
					<td>User ID</td>
					<td>${requestScope.user.id}</td>
				</tr>
				
				<tr>
					<td>User Name</td>
					<td>${requestScope.user.name}</td>
				</tr>
				
				<tr>
					<td>User surname</td>
					<td>${requestScope.user.surname}</td>
				</tr>
				
				<tr>
					<td>User login</td>
					<td>${requestScope.user.login}</td>
				</tr>
				
				
				<tr>
					<td>User passport</td>
					<td>${requestScope.user.passport}</td>
				</tr>
				<tr>
					<td>User birth date</td>
					<td>${requestScope.user.birthdate}</td>
				</tr>
				
				<tr>
					<td>User address</td>
					<td>${requestScope.user.address}</td>
				</tr>
				
				<tr>
					<td>User balance</td>
					<td>${requestScope.user.balance}</td>
				</tr>
				
				
				<tr>
					<td>User telephony ID</td>
					<td>${requestScope.user.idTelephony}</td>
				</tr>
				
				<tr>
					<td>User digital_Tv ID</td>
					<td>${requestScope.user.idDigitalTV}</td>
				</tr>
				
				<tr>
					<td>User internet ID</td>
					<td>${requestScope.user.idInternet}</td>
				</tr>
			</table>
			
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="remove_request"/>
				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">				  			
						<button type="submit" class="btn btn-danger" name="request_id" value="${requestScope.more.id}">${remove_button}</button>
					</div>
				</div>
			</form> 
			
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="apply_request"/>
				<div class="form-group row">
					<div class="offset-sm-2 col-sm-10">
						<input type="hidden" name="tariff_type" value="${requestScope.more.typeTariff}">				  			
						<button type="submit" class="btn btn-success" name="request_id" value="${requestScope.more.id}">${apply_button}</button>
					</div>
				</div>
			</form> 
			
		</p>
		
	</div>
<%@include file="../../../elements/el_footer.jspf" %>
</body>
</html>