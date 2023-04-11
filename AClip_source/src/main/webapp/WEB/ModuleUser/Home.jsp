<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>




	<!-- Home Video-->
	<div class="row justify-content-center m-0 overflow-x-hidden"> 
		<c:forEach var="video" items="${listVideo}" varStatus="loop">
			<div class="card m-3 p-0 col-11 col-md-5 col-xl-3" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
				<img class="card-img-top" src="${video.thumbnail}" onclick="location.href='Video/${video.idYoutube}';" style="cursor: pointer;">
				<div class="card-body">
					<h5 class="card-title fs-6">${video.title}</h5>
				</div>
				<div class="card-footer text-start"><fmt:formatDate value="${video.time}" pattern="hh:mm dd/MM/yyyy"/></div>
			</div>
		</c:forEach>
	</div>

	<!-- Nav bar -->
	<nav>
		<ul class="pagination m-0 p-0 pb-5 justify-content-center">
			<c:forEach var="i" begin="1" end="${pageVideo}">
			<li class="page-item ${page==i?'active':''}"><a class="page-link" href="${url}${WebView}?page=${i}">${i}</a>
			</c:forEach>
		</ul>
	</nav>



</body>
</html>