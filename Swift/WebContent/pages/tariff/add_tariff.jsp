<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../elements/localization.jspf"%>
<%@include file="../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<%@include file="../../elements/el_navigation.jspf" %>
	
	<div class="wrapper container">
		<div class="heading">
			<h1>${add_tariff_label}</h1>
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
		
		<div class="row">
			<section class="col-md-17">				
				<p>
					<form action="Controller" method="post">
		    			<input type="hidden" name="command" value="add_tariff"/>
						<div class="form-group row">
							<label for="tariffTitle" class="col-sm-2 col-form-label">${title_label}</label>
							<div class="col-sm-10">
								<input id="tariffTitle" class="form-control" type="text" name="tariff_title" required>
							</div>
						</div>
							
						<div class="form-group row">
							<label for="tariffType" class="col-sm-2 col-form-label">${select_type_of_tariff_label}</label>
							<div class="col-sm-10">
								<select id="tariffType" class="form-control" name="tariff_type" style="width: 300px;">
							  		<c:forEach items="${requestScope.list}" var = "list">
							    		<option>${list}</option>
							 		</c:forEach>
							  	</select>
							  	<br>
								<button type="button" onclick="sumbitUploadDataToAddTariff();">${tariff_load_type_label}</button>
							</div>	
							
							
							
						</div>
						
						<div class="form-group row">
							<label for="tariffPrice" class="col-sm-2 col-form-label">${price_label} ${dimension_price_per_month}</label>
							<div class="col-sm-10">
								<input id="tariffPrice" class="form-control" type="text" name="tariff_price" required>
							</div>
						</div>					
													
						<div class="form-group row">
							<label for="tariffDescription" class="col-sm-2 col-form-label">${description_label}</label>
							<br>
							<div class="col-sm-10" style="width: 100%">
								<textarea id="tariffDescription" class="form-control" name="tariff_description" rows="10" required></textarea>
							</div>
						</div>
							
						<div class="form-group row">
							<div class="offset-sm-2 col-sm-10">
								<button type="submit" class="btn btn-primary">${add_button}</button>
						   	</div>
						</div>
					</form>
				</p>
			</section>		
		</div>
	</div>
	
	<form id="form-upload-to-add-tariff" action="Controller" method="get">
		<input type="hidden" name="command" value="">	
	</form>
	
	<script type="text/javascript">
		function sumbitUploadDataToAddTariff(){
			document.getElementById('form-upload-to-add-tariff').submit()
		}	
	</script>
	
</body>
</html>