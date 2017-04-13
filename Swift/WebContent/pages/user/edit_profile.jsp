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
			<h1>${profile_edit_label}</h1>
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
	
		<div class="row">
			<form action="Controller" method="post">
		   		<input type="hidden" name="command" value="edit_profile"/>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label">${position_label} </label>
						<div class="col-sm-10">
							<label class="col-sm-2 col-form-label">${sessionScope.user.position}</label>		
						</div>
					</div>
					
					<c:if test="${not empty sessionScope.user.blockedTill}">							
						<div class="alert alert-danger">
							<strong>${blocked_to_label}:</strong> <c:out value="${sessionScope.user.blockedTill}" />
						</div>
					</c:if>
											
					<div class="form-group row">
						<label for="userName" class="col-sm-2 col-form-label">${name_label}</label>
						<div class="col-sm-10">
							<input id="userName" class="form-control" type="text"  name="user_name" value="${sessionScope.user.name}" required>
						</div>
					</div>
													
					<div class="form-group row">
						<label for="userSurname" class="col-sm-2 col-form-label">${surname_label}</label>
						<div class="col-sm-10">
							<input id="userSurname" class="form-control" type="text" name="user_surname" value="${sessionScope.user.surname}" required>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="userEmail" class="col-sm-2 col-form-label">${email_label}</label>
						<div class="col-sm-10">
					    	<input id="userEmail" class="form-control" type="text" name="user_email" value="${sessionScope.user.email}" required>
					  	</div>
					</div>
						
					<div class="form-group row">
						<label for="userPhone" class="col-sm-2 col-form-label">${phone_label}</label>
						<div class="col-sm-10">
					   		<input id = "userPhone" class="form-control" type="text" name="user_phone" value="${sessionScope.user.phone}" required>
					  	</div>
					</div>
						
					<div class="form-group row">
						<label for="userLogin" class="col-sm-2 col-form-label">${login_label}</label>
						<div class="col-sm-10">
					   		<input id="userLogin" class="form-control" type="text" name="user_login" value="${sessionScope.user.login}" required>
					  	</div>
					</div>
	
					<div class="form-group row">
						<label for="userBirthdate" class="col-sm-2 col-form-label">${birth_date_label} </label>
						<div class="col-sm-10">
					    	<input id="userBirthdate" class="form-control" type="date" value="${sessionScope.user.birthdate}" name="user_birthdate">
					  	</div>
					</div>

					<div class="form-group row">
						<label for="userPassport" class="col-sm-2 col-form-label">${passport_label}</label>
						<div class="col-sm-10">
					   		<input id="userPassport" class="form-control" type="text" name="user_passport" value="${sessionScope.user.passport}">
					  	</div>
					</div>
						
					<div class="form-group row">
						<label for="userAddress" class="col-sm-2 col-form-label">${address_label}</label>
						<div class="col-sm-10">
					   		<input id="userAdress" class="form-control" type="text" name="user_address" value="${sessionScope.user.address}">
					  	</div>
					</div>

					<div class="form-group row">
						<div class="offset-sm-2 col-sm-10">
					       <button type="submit" class="btn btn-primary">${apply_button}</button>
					     </div>
					</div>
				</form>
			</div>
		</div>
	<%@include file="../../../elements/el_footer.jspf" %>

</body>
</html>