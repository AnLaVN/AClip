<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Sign In Form -->
	<div class="card m-auto my-5" style="max-width: 35rem; background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<h5 class="card-title"><fmt:message key="SignIn"/></h5>
		</div>
		<div class="card-body">
			<form class="mx-1 mx-md-4 needs-validation" novalidate ng-init="Validation()" action="${url}SignIn" method="post">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtUsernameSI" name="username" placeholder="Username" required>
					<label for="txtUsernameSI" class="form-label"><fmt:message key="Username"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidUsername"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassSI">
					<input type="{{showPassSI?'text':'password'}}" class="form-control form-control-lg" id="txtPass" name="password" placeholder="Password" required>
					<label for="txtPass" class="form-label"><fmt:message key="Password"/></label>
					<div class="invalid-feedback"><fmt:message key="ErrorPassword"/></div>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassSI">
						<label class="form-check-label" for="rdoShowPassSI" ng-click="showPassSI=!showPassSI"><fmt:message key="ShowPassword"/></label>
					</div>
				</div>
				<div class="form-check mb-4">
					<input type="checkbox" class="form-check-input" id="rdoCheck" name="rdoCheck">
					<label class="form-check-label" for="rdoCheck"><fmt:message key="RememberMe"/></label>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-info w-100"><fmt:message key="SignIn"/></button>
				</div>
			</form>
		</div>
	</div>
	



</body>
</html>