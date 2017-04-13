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
			<h1>${news_get_all_label}</h1>
			<legend></legend>
		</div>

		<div class="row">
			<h4><span>${found_label}: ${requestScope.amountResult}</span></h4>
			<table class="table table-hover">	
				<caption><h2 style="text-align: center;">${news_label}</h2></caption> 
		  		<thead>
	    	  		<tr>
	        			<th>${id_label}</th>
	        			<th>${title_label}</th>
	        			<th>${date_of_publication_label}</th>
	        			<th>${action_label}</th>		
	      			</tr>
	    		</thead>
	    		<c:forEach items="${requestScope.list}" var = "list">
					<tbody>
						<tr>
							<td>${list.id}</td>
							<td>${list.title}</td>
							<td>${list.datePublication}</td>
							<td>
								<form action="Controller" method="get">
									<input type="hidden" name="command" value="get_single_news"/>	
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">
											<button type="submit" class="btn btn-info" name="news_id" value="${list.id}">${more_button}</button>
								  		</div>
									</div>
								</form>	
							   
							   	<form action="Controller" method="get">
									<input type="hidden" name="command" value="upload_news_data_to_edit"/>
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">
											<button type="submit" class="btn btn-primary" name="news_id" value="${list.id}">${edit_button}</button>
											</div>
									</div>
								</form>
									
								<form action="Controller" method="post">
									<input type="hidden" name="command" value="remove_news"/>
									<input type="hidden" name="page" value="${requestScope.page}">
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">	
											<c:if test="${list.status == true}">
												<button type="submit" class="btn btn-success" name="news_id" value="${list.id}">${reestablish_button}</button>
								  			</c:if>
									  			
								  			<c:if test="${list.status == false}">
												<button type="submit" class="btn btn-danger" name="news_id" value="${list.id}">${remove_button}</button>
								  			</c:if>
										</div>
									</div>
								</form>		      		
							</td>
					 	</tr>	
					</tbody>
				</c:forEach>
			</table>
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
								<li><a href="Controller?command=get_news_list_admin&page=${i}">${i}</a></li>
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