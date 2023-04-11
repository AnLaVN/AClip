<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Video detail -->
	<form class="row justify-content-center mx-0 py-4 needs-validation" novalidate ng-init="Validation()" action="${url}AdVideos" method="post" enctype="multipart/form-data">

		<!-- Video ID -->
		<div class="col-12 px-4 mx-0">
			<label class="form-label">ID Video Youtube</label>
			<div class="input-group mb-4 has-validation">
				<span class="input-group-text d-none d-md-flex">https://www.youtube.com/watch?v=</span>
				<input type="text" class="form-control form-control-lg" name="idYoutube" ng-init="IDVideo='${video.idYoutube}'" ng-model="IDVideo" placeholder="IDYoutube" required>
				<div class="invalid-feedback"><fmt:message key="InvalidIDVideo"/></div>
			</div>
		</div>

		<!-- Video Detail -->
		<div class="col-12 col-lg-8 ps-4 pe-4 pe-lg-2 mx-0">
			<div class="form-floating mb-4">
				<input type="text" class="form-control form-control-lg" id="txtVideoTitle" name="title" ng-init="TitleVideo='${video.title}'" ng-model="TitleVideo" placeholder="VideoTitle" required>
				<label for="txtVideoTitle" class="form-label"><fmt:message key="VideoTitle"/></label>
				<div class="invalid-feedback"><fmt:message key="InvalidVideoTitle"/></div>
			</div>
			<div class="form-floating mb-4">
				<textarea class="form-control form-control-lg" id="txtDescription" name="description" placeholder="Mô tả" style="height: 200px">${video.description}</textarea>
				<label for="txtDescription"><fmt:message key="Descp"/></label>
			</div>
			<div class="input-group has-validation">
				<input type="file" class="form-control form-control-lg" name="inpThumbnail" id="inpThumbnail">
				<div class="invalid-feedback"><fmt:message key="InvalidThumbnail"/></div>
			</div>
		</div>

		<!-- Video Demo -->
		<div class="col-12 col-lg-4 pt-4 pt-lg-0 ps-4 ps-lg-2 pe-4 mx-0">
			<c:choose>
				<c:when test="${video.thumbnail != null}"><img class="img-fluid" src="${video.thumbnail}"></c:when>
				<c:otherwise><img class="img-fluid" src="{{'https://i3.ytimg.com/vi/'+IDVideo+'/maxresdefault.jpg'}}"></c:otherwise>
			</c:choose>
			<div class="p-0 my-4"><div class="fs-5">{{TitleVideo}}</div></div>
		</div>

		<!-- Button -->
		<div class="col-12 text-end px-4 mx-0 mt-5">
			<button type="reset" class="btn btn-lg btn-outline-secondary" onclick="location.href=window.location.href.split('?')[0]"><fmt:message key="Cancel"/></button>
			<button type="submit" class="btn btn-lg btn-outline-success"><fmt:message key="Upload"/></button>
			<button type="submit" class="btn btn-lg btn-outline-danger" ng-click="onDel='delete'"><fmt:message key="Delete"/></button>
			<input type="hidden" name="Del" value="{{onDel}}">
		</div>

	</form>



</body>
</html>