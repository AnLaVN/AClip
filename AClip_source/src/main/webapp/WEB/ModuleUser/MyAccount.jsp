<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- My Account Form -->
	<div class="card m-auto my-5" style="max-width: 35rem; background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<h5 class="card-title"><fmt:message key="MyAccount"/></h5>
		</div>
		<div class="card-body">
			<form class="mx-1 mx-md-4 needs-validation" novalidate ng-init="Validation()" action="${url}MyAccount" method="post">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg is-valid" id="txtUsernameMA" name="username" placeholder="Username" value="${sessionScope.user.username}" disabled readonly>
					<label for="txtUsernameMA" class="form-label"><fmt:message key="Username"/></label>
				</div>
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtFullnameMA" name="fullname" placeholder="Fullname" value="${sessionScope.user.fullname}" required>
					<label for="txtFullnameMA" class="form-label"><fmt:message key="Fullname"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidFullname"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="email" class="form-control form-control-lg" id="txtEmailMA" name="email" placeholder="Email" value="${sessionScope.user.email}" required>
					<label for="txtEmailMA" class="form-label"><fmt:message key="Email"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidEmail"/></div>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-info w-100"><fmt:message key="UpdateAccount"/></button>
				</div>
			</form>
		</div>
	</div>



</body>
</html>