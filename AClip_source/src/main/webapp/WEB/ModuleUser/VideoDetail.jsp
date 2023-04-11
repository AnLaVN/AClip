<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>




	<!-- Modal -->
	<div class="modal fade" id="ModalShare" tabindex="-1" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="ShareModal"><fmt:message key="ShareToViewer"/></h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>
				<form class="needs-validation" novalidate ng-init="Validation()" ng-submit="Share()">
					<div class="modal-body">
						<div class="form-floating">
							<input type="email" class="form-control form-control-lg" id="txtEmailSH" ng-model="EmailAdd" placeholder="Email" required>
							<label for="txtEmailSH" class="form-label"><fmt:message key="Email"/></label>
							<div class="invalid-feedback"><fmt:message key="InvalidEmail"/></div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="reset" class="btn btn-secondary" data-bs-dismiss="modal"><fmt:message key="Cancel"/></button>
						<button type="submit" class="btn btn-info" data-bs-dismiss="modal"><fmt:message key="Share"/></button>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	
	
	<!-- Video detail -->
	<div class="row justify-content-center m-0 mt-4 mx-xxl-5">

		<!-- Main video -->
		<div class="col-12 col-md-8 m-0 p-0 mb-5">
			<div class="m-0 p-0 px-4 px-md-3">
				<div class="ratio ratio-16x9">
					<iframe src="https://www.youtube.com/embed/${video.idYoutube}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
				</div>
				<div class="p-2 m-0 py-3 border rounded-bottom" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);"><!-- Body -->
					<h5 class="fs-5 fw-bold">${video.title}</h5>
					<a data-bs-toggle="collapse" href="#Description" role="button" ng-click="viewDescrip = true" ng-hide="viewDescrip"><fmt:message key="Descp"/></a>
					<span class="collapse" id="Description">${video.description}</span>
					<div class="row justify-content-center m-0 p-0">
						<div class="col text-start m-0 p-0 align-self-center">
							<i class="bi bi-upload me-2"></i><fmt:formatDate value="${video.time}" pattern="hh:mm dd/MM/yyyy"/>
							<i class="bi bi-eye ms-2 ms-sm-5 ms-md-2 ms-lg-5 me-2"></i>${video.listViewed.size()}
							<i class="bi bi-hand-thumbs-up ms-2 ms-sm-5 ms-md-2 ms-lg-5 me-2"></i>${video.listLiked.size()}
						</div>
						<div class="col-auto text-end m-0 p-0 align-self-center row">
							<div class="like-button {{LikeStatus ? 'actived' : ''}} fs-2" ng-init="LikeStatus = ${liked}" ng-click="Like('${video.idYoutube}')">
								<div class="like-wrapper">
									<div class="ripple"></div>
									<svg class="heart" width="24" height="24" viewBox="0 0 24 24">
										<path d="M12,21.35L10.55,20.03C5.4,15.36 2,12.27 2,8.5C2,5.41 4.42,3 7.5,3C9.24,3 10.91,3.81 12,5.08C13.09,3.81 14.76,3 16.5,3C19.58,3 22,5.41 22,8.5C22,12.27 18.6,15.36 13.45,20.03L12,21.35Z"/>
									</svg>
									<div class="particles" style="--total-particles: 6">
										<div class="particle" style="--i: 1; --color: #7642F0"></div>
										<div class="particle" style="--i: 2; --color: #AFD27F"></div>
										<div class="particle" style="--i: 3; --color: #DE8F4F"></div>
										<div class="particle" style="--i: 4; --color: #D0516B"></div>
										<div class="particle" style="--i: 5; --color: #5686F2"></div>
										<div class="particle" style="--i: 6; --color: #D53EF3"></div>
									</div>
								</div>
							</div>
							<button class="share-button ms-1 fs-2" data-bs-toggle="modal" data-bs-target="#ModalShare">
								<div class="share-wrapper">
									<div class="ripple"></div>
									<svg class="share" xmlns="http://www.w3.org/2000/svg" width="16" height="16" class="bi bi-share-fill" viewBox="0 0 16 16" style="overflow: visible;">
										<path d="M11 2.5a2.5 2.5 0 1 1 .603 1.628l-6.718 3.12a2.499 2.499 0 0 1 0 1.504l6.718 3.12a2.5 2.5 0 1 1-.488.876l-6.718-3.12a2.5 2.5 0 1 1 0-3.256l6.718-3.12A2.5 2.5 0 0 1 11 2.5z"/>
									</svg>
									<div class="particles" style="--total-particles: 6">
										<div class="particle" style="--i: 1; --color: #7642F0"></div>
										<div class="particle" style="--i: 2; --color: #AFD27F"></div>
										<div class="particle" style="--i: 3; --color: #DE8F4F"></div>
										<div class="particle" style="--i: 4; --color: #D0516B"></div>
										<div class="particle" style="--i: 5; --color: #5686F2"></div>
										<div class="particle" style="--i: 6; --color: #D53EF3"></div>
									</div>
								</div>
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Recommend video -->
		<div class="col-12 col-md-4 m-0 px-4 px-md-3">
			<c:forEach var="video" items="${listVideo}" varStatus="loop">
				<div class="card mb-3" onclick="location.href='Video/${video.idYoutube}';" style="background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px); cursor: pointer;">
					<div class="row m-0 p-0">
						<div class="col-4 m-0 p-0">
							<img src="${video.thumbnail}" class="img-fluid rounded">
						</div>
						<div class="col-8 m-0 p-2 row">
							<div class="align-self-start m-0 p-0 text-truncate">${video.title}</div>
							<p class="card-text align-self-end m-0 p-0"><small class="text-muted"><fmt:formatDate value="${video.time}" pattern="hh:mm dd/MM/yyyy"/></small></p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>



</body>
</html>