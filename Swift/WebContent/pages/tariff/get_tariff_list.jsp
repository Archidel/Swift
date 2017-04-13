<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../../elements/localization.jspf"%>
<%@include file="../../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
<%@include file="../../../elements/el_navigation.jspf" %>
	<div class="wrapper container">
		<div class="heading">
			<h1>${tariffs_label}</h1>
		</div>
		<h4><span>${found_label}: ${requestScope.amountResult}</span></h4>
		<legend></legend>

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
	        		<th>${title_label}</th>
	        		<th>${type_label}</th>
	        		<th>${price_label} ${dimension_price_per_month}</th>
	        		
	        		<th>${action_label}</th>		
	      		</tr>
	    	</thead> 
	    	<c:forEach items="${requestScope.list}" var = "list">
				<tbody>
			   		<tr>
						<td style="color: black;">${list.title}</td>
					    <td>${list.type}</td>
					    <td>${list.price}</td>
					    <td>
						    <form action="Controller" method="get">
								<input type="hidden" name="command" value="get_single_tariff"/>
								<div class="form-group row">
									<div class="offset-sm-2 col-sm-10">
										<input type="hidden" name="tariff_type" value="internet"/>
										<button type="submit" class="btn btn-primary" name="tariff_id" value="${list.id}">${more_button}</button>
									</div>
								</div>
							</form>	
						</td>
			 		</tr>	
				</tbody>			
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
								<li><a href="Controller?command=get_tariff_list&tariff_type=${tariffType}&page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</c:if>

	</div>
	<%@include file="../../../elements/el_footer.jspf" %>
</body>
</html>