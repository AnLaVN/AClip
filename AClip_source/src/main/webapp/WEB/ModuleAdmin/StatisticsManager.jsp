<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>



	<!-- Statistics Tab Card -->
	<div class="card mt-5 mx-3" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<ul class="nav nav-tabs card-header-tabs" id="StatisticsTab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent=='1'?'active':''}" id="Video-Liked-Statistics" onclick="location.href=window.location.href.split('?')[0]+'?TabContent=1'" 
						data-bs-toggle="tab" data-bs-target="#VideoLikedStatistics" type="button" role="tab">
						<fmt:message key="VideosLiked"/>
					</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent=='2'?'active':''}" id="User-Liked-Statistics" onclick="location.href=window.location.href.split('?')[0]+'?TabContent=2'" 
					data-bs-toggle="tab" data-bs-target="#UserLikedStatistics" type="button" role="tab">
						<fmt:message key="UsersLiked"/>
					</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link ${TabContent=='3'?'active':''}" id="User-Shared-Statistics" onclick="location.href=window.location.href.split('?')[0]+'?TabContent=3'" 
						data-bs-toggle="tab" data-bs-target="#UserSharedStatistics" type="button" role="tab">
						<fmt:message key="UsersViewed"/>
					</button>
				</li>
			</ul>
		</div>
		<div class="card-body m-0 p-0">
			<div class="tab-content" id="StatisticsTabContent">
				<div class="tab-pane fade ${TabContent=='1'?'show active':''}" id="VideoLikedStatistics" role="tabpanel" tabindex="1">
					<%@include file="ModuleStatistics/VideoLiked.jsp"%>
				</div>
				<div class="tab-pane fade ${TabContent=='2'?'show active':''}" id="UserLikedStatistics" role="tabpanel" tabindex="2">
					<%@include file="ModuleStatistics/UserLiked.jsp"%>
				</div>
				<div class="tab-pane fade ${TabContent=='3'?'show active':''}" id="UserSharedStatistics" role="tabpanel" tabindex="3">
					<%@include file="ModuleStatistics/UserViewed.jsp"%>
				</div>
			</div>
		</div>
		<div class="card-footer text-muted row">
			<c:choose>
				<c:when test="${TabContent=='1'}">
					<div class="col-auto">${totalVideo} video</div>
					<div class="col">
						<ul class="pagination justify-content-end m-0 p-0">
							<c:forEach var="i" begin="1" end="${pageVideo}">
							<li class="page-item ${page==i?'active':''}"><a class="page-link" href="${url}AdStatistics?page=${i}">${i}</a>
							</c:forEach>
						</ul>
					</div>
				</c:when>
				<c:when test="${TabContent=='2'}">
					<div class="col-auto">${listLiked.size()} <fmt:message key="Likeds"/></div>
				</c:when>
				<c:when test="${TabContent=='3'}">
					<div class="col-auto">${listViewedSize} <fmt:message key="Views"/></div>
				</c:when>
			</c:choose>
		</div>
	</div>



</body>

</html>