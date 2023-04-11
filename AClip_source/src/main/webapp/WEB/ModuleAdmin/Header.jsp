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
		<div class="offcanvas-body" role="tablist">
			<div class="col-auto" role="presentation">
				<a class="text-decoration-none text-light link-primary fs-5" href="${url}Home"><i class="bi bi-house me-2"></i><fmt:message key="Home"/></a>
			</div>
			<div class="col-auto" role="presentation">
				<a class="text-decoration-none text-light link-primary fs-5" href="${url}AdVideos"><i class="bi bi-film me-2"></i><fmt:message key="VideosManager"/></a>
			</div>
			<div class="col-auto" role="presentation">
				<a class="text-decoration-none text-light link-primary fs-5" href="${url}AdUsers"><i class="bi bi-people me-2"></i><fmt:message key="UsersManager"/></a>
			</div>
			<div class="col-auto" role="presentation">
				<a class="text-decoration-none text-light link-primary fs-5" href="${url}AdStatistics"><i class="bi bi-graph-up me-2"></i><fmt:message key="StatisticsManager"/></a>
			</div>
			<div class="col-auto" role="presentation">
				<a class="text-decoration-none text-light link-primary fs-5" href="${url}SignOut"><i class="bi bi-person-slash me-2"></i><fmt:message key="SignOut"/></a>
			</div>
		</div>
	</div>


	<!-- Header -->
	<div class="row navbar navbar-expand-lg align-items-center m-0 py-3 text-center navbar-dark" style="background-color: #171615;">
		<a class="col-1 navbar-toggler border-0" type="button" data-bs-toggle="offcanvas" data-bs-target="#NavMC2"><span class="navbar-toggler-icon"></span></a>
		<a class="col navbar-toggler border-0 text-decoration-none text-light link-primary navitem" href="${url}Home"><i class="bi bi-house me-2"></i>AClip Manager</a>
		<div class="col-auto collapse navbar-collapse p-0" id="NavMC" role="tablist">
			<div class="col">
				<a class="text-decoration-none text-light link-primary navitem" href="${url}Home"><i class="bi bi-house me-2"></i><fmt:message key="Home"/></a>
			</div>
			<div class="col" role="presentation">
				<a class="text-decoration-none text-light link-primary navitem" href="${url}AdVideos"><i class="bi bi-film me-2"></i><fmt:message key="VideosManager"/></a>
			</div>
			<div class="col" role="presentation">
				<a class="text-decoration-none text-light link-primary navitem" href="${url}AdUsers"><i class="bi bi-people me-2"></i><fmt:message key="UsersManager"/></a>
			</div>
			<div class="col" role="presentation">
				<a class="text-decoration-none text-light link-primary navitem" href="${url}AdStatistics"><i class="bi bi-graph-up me-2"></i><fmt:message key="StatisticsManager"/></a>
			</div>
			<div class="col" role="presentation">
				<a class="text-decoration-none text-light link-primary navitem" href="${url}SignOut"><i class="bi bi-person-slash me-2"></i><fmt:message key="SignOut"/></a>
			</div>
		</div>
		<form class="col-auto dropstart">
			<div class="dropdown">
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" role="button" onclick="window.location = window.location.href.split('?')[0] + '?lang=vi'">Tiếng Việt</a></li>
					<li><a class="dropdown-item" role="button" onclick="window.location = window.location.href.split('?')[0] + '?lang=en'">English</a></li>
				</ul>
			</div>
			<i class="bi bi-{{Theme == 'dark'?'moon-stars':'sun'}} fs-4 text-light link-primary me-2" ng-click="ChangeTheme()" role="button"></i>
			<i class="bi bi-globe2 fs-4 text-light link-primary me-2" role="button" data-bs-toggle="dropdown"></i>
			<i class="bi bi-palette fs-4 text-{{BGImg=='Image'?'primary':'light'}} link-primary" ng-click="ChangeBGImg()" role="button"></i>
		</form>
	</div>



</body>
</html>