<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../elements/localization.jspf" %>
<%@include file="../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../../elements/el_navigation.jspf" %>
	<div class="wrapper container">	
		<div class="heading">
			<h1>${tariff_edit_label}</h1>
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
	    		<input type="hidden" name="command" value="edit_tariff"/>
					
				<div class="form-group row">
					<label for="tariffTitle" class="col-sm-2 col-form-label">${title_label}</label>
					<div class="col-sm-10">
						<input id="tariffTitle" class="form-control" type="text" name="tariff_title" value="${requestScope.more.title }" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="tariffPrice" class="col-sm-2 col-form-label">${price_label} per day</label>
					<div class="col-sm-10">
						<input id="tariffPrice" class="form-control" type="text" name="tariff_price" value="${requestScope.more.price}" required>
					</div>
				</div>					
													
				<div class="form-group row">
					<label for="tariffDescription" class="col-sm-2 col-form-label">${description_label}</label>
					<div class="col-sm-10" style="width: 100%">
						<textarea id="tariffDescription" class="form-control" name="tariff_description" rows="10" required>${requestScope.more.description}</textarea>
					</div>
				</div>
				<button type="submit" class="btn btn-primary" name="tariff_id" value="${requestScope.more.id}">Edit</button>
			</form>
		</div>
	</div>
	<%@include file="../../elements/el_footer.jspf" %>
</body>
</html>