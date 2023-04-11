<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>


	<!-- Reset Password Form -->
	<div class="card m-auto my-5" style="max-width: 35rem; background: rgb(var(--bs-body-bg-rgb), 0.75); backdrop-filter: blur(5px);">
		<div class="card-header">
			<h5 class="card-title"><fmt:message key="ResetPass"/></h5>
		</div>
		<div class="card-body">
			<form class="mx-1 mx-md-4 needs-validation" novalidate ng-init="Validation()" name="formRP" action="${url}ResetPass" method="post">
				<div class="form-floating mb-4">
					<input type="email" class="form-control form-control-lg" id="txtEmailRP" name="txtEmailRP" placeholder="Email" required>
					<label for="txtEmailRP" class="form-label"><fmt:message key="Email"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidEmail"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="number" class="form-control form-control-lg" id="txtOTP" name="txtOTP" placeholder="OTP" required>
					<label for="txtOTP" class="form-label"><fmt:message key="OTPCode"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidOTP"/></div>
				</div>
				<div class="form-floating mb-4" ng-init="showPassRP">
					<input type="{{showPassRP?'text':'password'}}" class="form-control form-control-lg {{formRP.txtNPassRP.$valid?'':'is-invalid'}}"
					id="txtNPassRP" name="txtNPassRP" placeholder="Pass" required ng-model="NPassRP" ng-pattern="/^(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,20}$/">
					<label for="txtNPassRP" class="form-label"><fmt:message key="NPassword"/></label>
					<div class="form-check is-valid">
						<input type="checkbox" class="form-check-input" id="rdoShowPassRP">
						<label class="form-check-label" for="rdoShowPassRP" ng-click="showPassRP=!showPassRP"><fmt:message key="ShowPassword"/></label>
					</div>
					<div class="invalid-feedback"><fmt:message key="InvalidPassword"/></div>
				</div>
				<div class="form-floating mb-4">
					<input type="{{showPassRP?'text':'password'}}" class="form-control form-control-lg {{NPassRP!=CPassRP?'is-invalid':''}}"
					id="txtCPassRP" name="txtCPassRP" placeholder="Pass" required ng-model="CPassRP">
					<label for="txtCPassRP" class="form-label"><fmt:message key="CPassword"/></label>
					<div class="invalid-feedback"><fmt:message key="InvalidCPassword"/></div>
				</div>
				<div class="mt-5">
					<button type="submit" class="btn btn-lg btn-info w-100"><fmt:message key="ResetPass"/></button>
				</div>
			</form>
		</div>
	</div>
	



</body>
</html>