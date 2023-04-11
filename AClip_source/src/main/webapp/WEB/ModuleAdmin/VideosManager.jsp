<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>



	<!-- Videos Tab Card -->
	<div class="card my-4 mx-3" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<ul class="nav nav-tabs card-header-tabs" id="VideosTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent?'':'active'}" id="List-Videos-Tab" data-bs-toggle="tab" data-bs-target="#ListVideos" type="button" role="tab"><fmt:message key="ListVideos"/></button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent?'active':''}" id="Videos-Detail-Tab" data-bs-toggle="tab" data-bs-target="#VideosDetail" type="button" role="tab"><fmt:message key="DetailsVideo"/></button>
				</li>
			</ul>
		</div>
		<div class="card-body m-0 p-0">
			<div class="tab-content" id="VideosTabContent">
				<div class="tab-pane fade ${TabContent?'':'show active'}" id="ListVideos" role="tabpanel" tabindex="1">
					<%@include file="ModuleVideos/List.jsp"%>
				</div>
				<div class="tab-pane fade ${TabContent?'show active':''}" id="VideosDetail" role="tabpanel" tabindex="2">
					<%@include file="ModuleVideos/Detail.jsp"%>
				</div>
			</div>
		</div>
		<div class="card-footer text-muted row">
			<div class="col-auto">${totalVideo} video</div>
			<div class="col">
				<ul class="pagination justify-content-end m-0 p-0">
					<c:forEach var="i" begin="1" end="${pageVideo}">
					<li class="page-item ${page==i?'active':''}"><a class="page-link" href="${url}AdVideos?page=${i}">${i}</a>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>



</body>

</html>