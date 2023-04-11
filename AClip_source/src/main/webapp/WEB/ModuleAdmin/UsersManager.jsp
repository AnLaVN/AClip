<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>



	<!-- Users Tab Card -->
	<div class="card mt-5 mx-3" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<ul class="nav nav-tabs card-header-tabs" id="UsersTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent?'':'active'}" id="List-Users-Tab" data-bs-toggle="tab" data-bs-target="#ListUsers" type="button" role="tab"><fmt:message key="ListUsers"/></button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent?'active':''}" id="Users-Detail-Tab" data-bs-toggle="tab" data-bs-target="#UsersDetail" type="button" role="tab"><fmt:message key="DetailsUser"/></button>
				</li>
			</ul>
		</div>
		<div class="card-body m-0 p-0">
			<div class="tab-content" id="UsersTabContent">
				<div class="tab-pane fade ${TabContent?'':'show active'}" id="ListUsers" role="tabpanel" tabindex="1">
					<%@include file="ModuleUsers/List.jsp"%>
				</div>
				<div class="tab-pane fade ${TabContent?'show active':''}" id="UsersDetail" role="tabpanel" tabindex="2">
					<%@include file="ModuleUsers/Detail.jsp"%>
				</div>
			</div>
		</div>
		<div class="card-footer text-muted row">
			<div class="col-auto">${totalUser} user</div>
			<div class="col">
				<ul class="pagination justify-content-end m-0 p-0">
					<c:forEach var="i" begin="1" end="${pageUser}">
					<li class="page-item ${page==i?'active':''}"><a class="page-link" href="${url}AdUsers?page=${i}">${i}</a>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>



</body>

</html>