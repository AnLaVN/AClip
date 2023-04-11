<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>


	
	<!-- Sign Up Form -->
	<div class="card m-auto my-5" style="max-width: 35rem; background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<h5 class="card-title"><fmt:message key="SignUp"/></h5>
		</div>
		<div class="card-body">
			<form class="mx-1 mx-md-4 needs-validation" novalidate ng-init="Validation()" name="formSU" action="${url}SignUp" method="post">
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtFullnameSU" name="fullname" placeholder="Fullname" required>
					<label for="txtFullnameSU" class="form-label"><fmt:message key="Fullname"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidFullname"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="text" class="form-control form-control-lg" id="txtUsernameSU" name="username" placeholder="Username" required>
					<label for="txtUsernameSU" class="form-label"><fmt:message key="Username"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidUsername"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="email" class="form-control form-control-lg" id="txtEmailSU" name="email" placeholder="Email" required>
					<label for="txtEmailSU" class="form-label"><fmt:message key="Email"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidEmail"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassSU">
					<input type="{{showPassSU?'text':'password'}}" class="form-control form-control-lg {{formSU.password.$valid?'':'is-invalid'}}"
					id="txtNPassSU" name="password" placeholder="Password" required ng-model="NPassSU" ng-pattern="/^(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/">
					<label for="txtNPassSU" class="form-label"><fmt:message key="Password"/></label>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassSU">
						<label class="form-check-label" for="rdoShowPassSU" ng-click="showPassSU=!showPassSU"><fmt:message key="ShowPassword"/></label>
					</div>
					<div class="invalid-feedback"><fmt:message key="InvalidPassword"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="{{showPassSU?'text':'password'}}" class="form-control form-control-lg {{NPassSU!=CPassSU?'is-invalid':''}}"
					id="txtCPassSU" name="txtCPassSU" placeholder="Password" required ng-model="CPassSU">
					<label for="txtCPassSU" class="form-label"><fmt:message key="CPassword"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidCPassword"/></div>
				</div>
				<div class="form-floating mb-4">
				<select class="form-select" id="cboRole" name="role" required>
					<option value="true" ><fmt:message key="RoleAdmin"/></option>
					<option value="false" selected><fmt:message key="RoleUser"/></option>
				</select>
				<label for="cboRole"><fmt:message key="Role"/></label>
			</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-info w-100"><fmt:message key="SignUp"/></button>
				</div>
			</form>
		</div>
	</div>
	



</body>
</html>