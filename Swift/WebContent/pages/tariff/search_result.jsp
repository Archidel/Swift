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
			<h1>${result_label}</h1>
		</div>
		<h4><span>${found_label}: ${requestScope.amountResult}</span></h4>
		<legend></legend>

		<c:if test="${not empty requestScope.statusError}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.statusError}" />
			</div>
		</c:if>
		
		<div class="row">
			<c:forEach items="${requestScope.list}" var = "list">
				<div class="panel panel-primary">
	    			
	    			<div class="panel-heading">${title_label} : ${list.title}
	    				<span class="pull-right">${type_label}: ${list.type}</span>
	    			</div>
	    			
	    			<div class="panel-body" style="overflow: hidden;">
						<form action="Controller" method="get">
							<input type="hidden" name="command" value="get_single_tariff"/>
							<div class="form-group row">
								<div class="offset-sm-2 col-sm-10">
									<input type="hidden" name="tariff_type" value="${list.type}">
									<button type="submit" class="btn btn-info" name="tariff_id" value="${list.id}">${more_button}</button>
			  					</div>
							</div>
						</form>	
					</div>
	  			</div>
			</c:forEach>
		</div>
		
		<c:if test="${requestScope.amountResult > 10}">
			<div class="text-center">
				<ul class="pagination pagination-lg">
					<c:forEach begin="1" end="${requestScope.amountPage}" var="i">
						<c:choose>
							<c:when test="${requestScope.numberPage eq i}">
								<li class="active"><a>${i}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="Controller?command=search_tariff&search_tariff=${requestScope.tariffName}&page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
	
</body>
</html>