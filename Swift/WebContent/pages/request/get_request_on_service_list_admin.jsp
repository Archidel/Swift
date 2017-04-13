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
			<h1>REQUEST ON SERVICE LIST ADMIN</h1>
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

		<table class="table table-hover">
		  		<thead>
	    	  		<tr>
	        			<th>Request id</th>
	        			<th>Tariff id</th>
	        			<th>Date</th>	
	        			<th>Service action</th>
	        			<th>${action_label}</th>
	      			</tr>
	    		</thead>
	    		<c:forEach items="${requestScope.list}" var = "list">
					<section class="col-md-17" >
				 	<tbody>
				   		<tr>
							<td>${list.idRequest}</td>
						    <td>${list.idTariff}</td>
						   	<td>${list.date}</td>
						    <td>
					
						    	<c:if test="${list.serviceAction == true}">
						    		Enable service
						    	</c:if>
						    	
						    	<c:if test="${list.serviceAction != true}">
						    		Disable service
						    	</c:if>
						    </td>
						    <td>
						    	
								<form action="Controller" method="get">
									<input type="hidden" name="command" value="get_single_request_on_service"/>
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">	
								  			<button type="submit" class="btn btn-info" name="request_id" value="${list.idRequest}">${more_button}</button>
								  		</div>
									</div>
								</form>
								
								<form action="Controller" method="post">
									<input type="hidden" name="command" value="remove_request_on_service"/>
									<input type="hidden" name="status" value="true">
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">	
								  			<button type="submit" class="btn btn-danger" name="request_id" value="${list.idRequest}">${remove_button}</button>
								  		</div>
									</div>
								</form>      		
						
							</td>
				 		</tr>	
					</tbody>
				</section>
				</c:forEach>
			</table>
		
		<c:if test="${requestScope.amountResult > 10}">
			<div class="text-center">
				<ul class="pagination pagination-lg">
					<c:forEach begin="1" end="${requestScope.amountPage}" var="i">
						<c:choose>
							<c:when test="${requestScope.numberPage eq i}">
								<li class="active"><a>${i}</a></li>
							</c:when>
							<c:otherwise>
										<li><a href="Controller?command=get_agreement_list_admin&page=${i}">${i}</a></li>
					</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</c:if>
		
	</div>
	
	<%@include file="../../elements/el_footer.jspf" %>
</body>
</html>