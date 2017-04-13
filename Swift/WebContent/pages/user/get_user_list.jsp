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
			<h1>${show_user_lsit_label}</h1>
			<legend></legend>
		</div>

		<c:if test="${not empty requestScope.result}">
			<div class="alert alert-danger">
				<strong>Error!</strong> <c:out value="${requestScope.result}" />
			</div>
		</c:if>
		
		<div class="row">
		<h4><span>${found_label}: ${requestScope.amountResult}</span></h4>
			<table class="table table-hover">
		  		<thead>
	    	  		<tr>
	        			<th>${id_label}</th>
	        			<th>${login_label}</th>
	        			<th>${passport_label}</th>
	        			<th>${position_label}</th>
	        			<th>${blocked_to_label}</th>
	        			<th>${action_label}</th>	
	      			</tr>
	    		</thead>
	    		<c:forEach items="${requestScope.list}" var = "list">
				 	<tbody>
				   		<tr>
							<td>${list.id}</td>
						    <td><a href="#" data-toggle="tooltip" data-placement="top" title="${list.name} ${list.surname} ${list.birthdate} ${list.address}">${list.login}</a></td>
						    <td>${list.passport}</td>
						   	<td>${list.position}</td>
						   	<td>${list.blockedTill}</td>
						    <td>
						    	<form action="Controller" method="post">
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">										
<!-- Trigger the modal with a button -->
											<button type="button" class="btn btn-danger" id="myBtn">Set block</button>
<!-- Modal -->
										  	<div class="modal fade" id="myModal" role="dialog">
										    	<div class="modal-dialog">
<!-- Modal content-->
										      		<div class="modal-content" style="width: 250px">
											        <div class="modal-header" style="padding: 10px 5px;">
											       		<button type="button" class="close" data-dismiss="modal">&times;</button>
											          	<h4><span class="glyphicon glyphicon-lock"></span>Set blocked to</h4>
											        </div>
										        
										        	<div class="modal-body" style="padding:10px 20px;">
										          		<div class="form-group">
										              		<label for="date">BlockedTill</label>
										              		<input name="user_block_to" type="date" class="form-control" id="date">
										            	</div>
										            	<input name="user_id" value="${list.id}" type="hidden">
										        		<button type="submit" class="btn btn-success btn-block" name="command" value="set_block"> Apply</button>
										              	<button type="submit" class="btn btn-danger btn-block" name="command" value="up_position"> Up position</button>
										        	</div>
											        
										        	<div class="modal-footer">
										          		<button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
										        	</div>
										      	</div>
										    </div>
										  </div> 
										</div>
								 	</div>
								</form>
									
								<form action="Controller" method="post">
									<input type="hidden" name="command" value="remove_digital_tv_tariff"/>
									<div class="form-group row">
										<div class="offset-sm-2 col-sm-10">	
											<c:if test="${list.status == true}">
												<button type="submit" class="btn btn-success" name="digital_tv_id" value="${list.id}">${reestablish_button}</button>
								  			</c:if>
								  			
								  			<c:if test="${list.status == false}">
												<button type="submit" class="btn btn-danger" name="digital_tv_id" value="${list.id}">${remove_button}</button>
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
								<li><a href="Controller?command=get_tariff_list_admin&tariff_type=${tariffType}&page=${i}">${i}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	
	</div>
	<%@include file="../../../elements/el_footer.jspf" %>
	
	<script>
		$(document).ready(function(){
    		$("#myBtn").click(function(){
        		$("#myModal").modal();
    		});
		});
	</script>
	
</body>
</html>