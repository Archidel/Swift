<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../elements/localization.jspf" %>
<%@include file="../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../elements/el_navigation.jspf" %>
	<div class="wrapper container">	
		<div class="heading">
			<h1>${rules_label}</h1>
			<legend></legend>
		</div>
		<div class="row">
			<div id="signin_panel" class="tab-pane fade in active">    
   		<div class="row">
    		<div class="col-md-8 col-md-offset-2">	
    			<div class="panel panel-default" >
			  		<div class="panel-heading" style="text-align: center; font-size: 24px;">${rules_label} SWIFT.NET</div>
			  		<div class="panel-body" style="max-height: 500px; overflow: scroll;">
						<p>
							<strong style="font-size: 18px;">${rules_heading_label}:</strong>
						</p>
				
						<p>
							<strong style="font-size: 16px;">1.</strong>
							${rules_one_label}.
						</p>
				
						<p>
							<strong style="font-size: 16px;">2.</strong>
							${rules_two_label}
						</p>
						
						<p>
							<strong style="font-size: 16px;">3.</strong>
							${rules_three_label}
						</p>
				
						<p>
							<strong style="font-size: 16px;">${notation_label}:</strong><br>
							${rules_notation_label}
						</p>
								
						<br>
					</div>
				</div>
				
    		</div>
		</div>
	</div>
			
			
					
		</div>
	</div>
	<%@include file="../elements/el_footer.jspf" %>
</body>
</html>