<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../../elements/localization.jspf"%>
<%@include file="../../elements/generallib.jspf"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<%@include file="../../elements/el_navigation.jspf"%>
	<div class="wrapper container">
		<div class="heading">
			<h1>${news_label}</h1>
		</div>
		<h4><span>${found_label}: ${requestScope.amountResult}</span></h4>
		<legend></legend>

		<c:if test="${not empty requestScope.result}">
			<div class="alert alert-danger">
				<strong>Error!</strong>
				<c:out value="${requestScope.result}" />
			</div>
		</c:if>

		<div class="row">
			<c:forEach items="${requestScope.list}" var="list">
				<div class="panel panel-primary">
					<div class="panel-heading">${list.title}
						${list.datePublication}
						<c:if
							test="${(sessionScope.user.position eq 'admin') or (sessionScope.user.position eq 'moderator')}">
							<form action="Controller" method="get" class="pull-right"
								style="padding-left: 20px;">
								<input type="hidden" name="command" value="upload_news_data_to_edit" />
								<div class="form-group row">
									<div class="offset-sm-2 col-sm-10">
										<button type="submit" class="btn btn-danger btn-sm"
											name="news_id" value="${list.id}">${edit_button}</button>
									</div>
								</div>
							</form>
						</c:if>
						<form action="Controller" method="get" class="pull-right">
							<input type="hidden" name="command" value="get_single_news" />
							<div class="form-group row">
								<div class="offset-sm-2 col-sm-10">
									<button type="submit" class="btn btn-info btn-sm"
										name="news_id" value="${list.id}">${more_button}</button>
								</div>
							</div>
						</form>
					</div>
					<div class="panel-body" style="overflow: hidden; height: 150px">
						${list.description}</div>
				</div>
			</c:forEach>

			<c:if test="${requestScope.amountResult > 10}">
				<div class="text-center">
					<ul class="pagination pagination-lg">
						<c:forEach begin="1" end="${requestScope.amountPage}" var="i">
							<c:choose>
								<c:when test="${requestScope.numberPage eq i}">
									<li class="active"><a>${i}</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="Controller?command=get_news_list&page=${i}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</c:if>


		</div>
	</div>
	<%@include file="../../elements/el_footer.jspf"%>
</body>
</html>