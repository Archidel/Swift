<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../../elements/localization.jspf"%>
<%@include file="../../../elements/generallib.jspf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<%@include file="../../../elements/el_navigation.jspf"%>
	<div class="wrapper container">
		<div class="heading">
			<h1>${balance_label}</h1>
			<legend></legend>
		</div>

		<c:if test="${not empty requestScope.statusError}">
			<div class="alert alert-danger">
				<strong>Error!</strong>
				<c:out value="${requestScope.statusError}" />
			</div>
		</c:if>

		<c:if test="${not empty requestScope.statusSuccess}">
			<div class="alert alert-success">
				<strong>Success!</strong>
				<c:out value="${requestScope.statusSuccess}" />
			</div>
		</c:if>

		<table>
			<tr>
				<td width="200px;">${balance_label}:</td>
				<td>${requestScope.more}$</td>
			</tr>
		</table>
		<br>
		<a href="#" data-toggle="modal" data-target="#exampleModal1" class="btn btn-primary">${add_button}</a>
		<br> 
		<br> 
		<br> 
		<br>
	</div>

	<%@include file="../../elements/el_footer.jspf"%>

	<!--------------------------------------------------------------------------------------------------------->
	<!---------------------------------------------------MODAL-ADD_BALANCE------------------------------------->
	<!--------------------------------------------------------------------------------------------------------->

	<div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span></button>
					<h3 class="modal-title" id="exampleModalLabel" style="text-align: center;">${balance_label}</h3>
				</div>

				<div class="modal-body">
					<form id="form-add-balance" action="Controller" method="post">
						<input type="hidden" name="command" value="add_balance">
						<div class="form-group">
							<label for="recipient-name" class="form-control-label">${amount_label} [$]: </label> 
							<input type="text" class="form-control" id="recipient-name" name="user_balance">
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">${close_label}</button>
					<button type="button" class="btn btn-success" onclick="submitAddBalance();">${add_button}</button>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		function submitAddBalance() {
			document.getElementById('form-add-balance').submit()
		}
	</script>

</body>
</html>