<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>



	<!-- Menu -->
	<div class="offcanvas offcanvas-start" tabindex="-1" id="NavMC2" style="background-color: #171615;">
		<div class="offcanvas-header">
			  <h5 class="offcanvas-title text-light" id="NavMC2Label">Menu</h5>
			  <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<div class="offcanvas-body">
			<div class="col-auto">
				<div class="text-light fs-5"><i class="bi bi-person me-2"></i>
				<c:choose>
					<c:when test="${!empty sessionScope.user}">${sessionScope.user.username}</c:when>
					<c:otherwise><fmt:message key="Account"/></c:otherwise>
				</c:choose>
					<ul style="list-style-type: none;">
						<li><a class="text-decoration-none text-light link-info fs-6" href="${url}SignIn" ng-click="ScrollUp()"><i class="bi bi-person-check me-2"></i><fmt:message key="SignIn"/></a></li>
						<li><a class="text-decoration-none text-light link-info fs-6" href="${url}SignUp" ng-click="ScrollUp()"><i class="bi bi-person-add me-2"></i><fmt:message key="SignUp"/></a></li>
						<li><a class="text-decoration-none text-light link-info fs-6" href="${url}MyAccount" ng-click="ScrollUp()"><i class="bi bi-person-gear me-2"></i><fmt:message key="MyAccount"/></a></li>
						<li><a class="text-decoration-none text-light link-info fs-6" href="${url}ResetPass" ng-click="ScrollUp()"><i class="bi bi-person-lock me-2"></i><fmt:message key="ResetPass"/></a></li>
						<li><a class="text-decoration-none text-light link-info fs-6" href="${url}SignOut" ng-click="ScrollUp()"><i class="bi bi-person-slash me-2"></i><fmt:message key="SignOut"/></a></li>
					</ul>
				</div>
			</div>
			<hr class="border border-secondary border-1 opacity-75">
			<div class="col-auto"><a class="text-decoration-none text-light link-info fs-5" href="${url}Liked"><i class="bi bi-heart me-2"></i><fmt:message key="Liked"/></a></div>
		</div>
	</div>



	<!-- Header -->
	<div class="row navbar navbar-expand-md align-items-center m-0 py-3 text-center navbar-dark" style="background-color: #171615;">
		<a class="col-1 navbar-toggler border-0" type="button" data-bs-toggle="offcanvas" data-bs-target="#NavMC2"><span class="navbar-toggler-icon"></span></a>
		<div class="col-md-6 col-xl-6 collapse navbar-collapse p-0" id="NavMC">
			<div class="col-4 col-lg-3"><a class="text-decoration-none text-light link-info navitem" href="${url}Home"><i class="bi bi-house me-2"></i><fmt:message key="Home"/></a></div>
			<div class="col-4 col-lg-3"><a class="text-decoration-none text-light link-info navitem" href="${url}Liked"><i class="bi bi-heart me-2"></i><fmt:message key="Liked"/></a></div>
			<div class="col-4 col-lg-3">
				<div class="dropdown">
					<button class="btn dropdown-toggle text-light py-0 navitem" type="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="bi bi-person me-2"></i>
						<c:choose>
							<c:when test="${!empty sessionScope.user}">${sessionScope.user.username}</c:when>
							<c:otherwise><fmt:message key="Account"/></c:otherwise>
						</c:choose>
					</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="${url}SignIn" ng-click="ScrollUp()"><i class="bi bi-person-check me-2"></i><fmt:message key="SignIn"/></a></li>
						<li><a class="dropdown-item" href="${url}SignUp" ng-click="ScrollUp()"><i class="bi bi-person-add me-2"></i><fmt:message key="SignUp"/></a></li>
						<li><a class="dropdown-item" href="${url}MyAccount" ng-click="ScrollUp()"><i class="bi bi-person-gear me-2"></i><fmt:message key="MyAccount"/></a></li>
						<li><a class="dropdown-item" href="${url}ResetPass" ng-click="ScrollUp()"><i class="bi bi-person-lock me-2"></i><fmt:message key="ResetPass"/></a></li>
						<li><a class="dropdown-item" href="${url}SignOut" ng-click="ScrollUp()"><i class="bi bi-person-slash me-2"></i><fmt:message key="SignOut"/></a></li>
					</ul>
				</div>
			</div>
		</div>
		<form class="col-11 col-md-6 col-xl-6 d-flex dropstart needs-validation" role="search" novalidate ng-init="Validation()" action="${url}Home" method="post">
			<input class="form-control me-2" type="search" name="txtSearch" placeholder='<fmt:message key="Search"/>' required>
			<button class="btn btn-outline-info me-2" type="submit"><fmt:message key="SearchBTN"/></button>
			<i class="bi bi-{{Theme=='dark'?'moon-stars':'sun'}} fs-4 text-light link-info me-2" ng-click="ChangeTheme()" role="button"></i>
			<div class="dropdown">
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" role="button" onclick="window.location = window.location.href.split('?')[0] + '?lang=vi'">Tiếng Việt</a></li>
					<li><a class="dropdown-item" role="button" onclick="window.location = window.location.href.split('?')[0] + '?lang=en'">English</a></li>
				</ul>
			</div>
			<i class="bi bi-globe2 fs-4 text-light link-info me-2" role="button" data-bs-toggle="dropdown"></i>
			<i class="bi bi-palette fs-4 text-{{BGImg=='Image'?'info':'light'}} link-info" ng-click="ChangeBGImg()" role="button"></i>
		</form>
	</div>



</body>
</html>