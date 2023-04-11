<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" ng-app="MyApp" ng-controller="MyCtrl" data-bs-theme="{{Theme}}">
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<fmt:setLocale value="${sessionScope.lang}" scope="request"/>
<fmt:setBundle basename="Form" scope="request"/>

<head>
	<base href="${pageContext.request.contextPath}/">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
	<link rel="icon" type="image/x-icon" href="https://cdn-icons-png.flaticon.com/512/5510/5510342.png">
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.8.2/angular-route.js"></script>
	<title>AClip | ASM Java4</title>
	<script src="WEB/script.js"></script>
	<link rel="stylesheet" type="text/css" href="WEB/Button.css">
	<style>
		#Image{
			background: url("{{getImageOnTime()}}") no-repeat center center fixed;
			-webkit-background-size: cover;
			-moz-background-size: cover;
			-o-background-size: cover;
			background-size: cover;
		}
	</style>
</head>

<body id="{{BGImg}}">

	<c:url var="url" value="/"/>

	<!-- Include HTML-->
	<c:choose>
		<c:when test="${!sessionScope.user.role}"><%@include file="ModuleUser/index.jsp"%></c:when>
		<c:when  test="${sessionScope.user.role}"><%@include file="ModuleAdmin/index.jsp"%></c:when>
	</c:choose>
	
	
	<!-- Toast -->
	<div class="toast-container position-fixed top-0 end-0 p-3"  >
		<div id="Toast" class="toast align-items-center" role="alert" aria-live="assertive" aria-atomic="true">
			<div class="d-flex">
				<div class="toast-body text-${contentColor}">${content}</div>
				<button type="button" class="btn-close me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">
	</script>
	<c:if test="${Toast}">
	    <script>new bootstrap.Toast(document.getElementById('Toast')).show()</script>
	</c:if>
</body>

</html>