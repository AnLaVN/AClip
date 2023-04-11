<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- User detail -->
	<form class="row justify-content-center mx-0 py-4 needs-validation" novalidate ng-init="Validation()" action="${url}AdUsers" method="post">
		<div class="col-12 col-md-8 col-lg-6 px-4 px-md-0">
			<div class="form-floating mb-4">
				<input type="text" class="form-control form-control-lg" id="txtUsername" name="username" placeholder="Username" value="${user.username}" required readonly>
				<label for="txtUsername" class="form-label"><fmt:message key="Username"/></label>
			</div>
			<div class="form-floating mb-4">
				<select class="form-select" id="cboRole" name="role" required>
					<option value="true"  ${user.role?'selected':''}><fmt:message key="RoleAdmin"/></option>
					<option value="false" ${user.role?'':'selected'}><fmt:message key="RoleUser"/></option>
				</select>
				<label for="cboRole"><fmt:message key="Role"/></label>
			</div>
			<div class="form-floating mb-4">
				<input type="text" class="form-control form-control-lg" id="txtFullname" name="fullname" placeholder="Fullname" value="${user.fullname}" required>
				<label for="txtFullname" class="form-label"><fmt:message key="Fullname"/></label>
				<div class="invalid-feedback"><fmt:message key="InvalidFullname"/></div>
			</div>
			<div class="form-floating mb-4">
				<input type="email" class="form-control form-control-lg" id="txtEmail" name="email" placeholder="Email" value="${user.email}" required>
				<label for="txtEmail" class="form-label"><fmt:message key="Email"/></label>
				<div class="invalid-feedback"><fmt:message key="InvalidEmail"/></div>
			</div>
			<div class="form-floating" ng-init="showPassRP">
				<input type="{{showPassRP?'text':'password'}}" class="form-control form-control-lg" id="txtCPassRP" name="txtCPassRP" placeholder="Pass" required ng-model="CPassRP">
				<label for="txtCPassRP" class="form-label"><fmt:message key="CPassword"/></label>
				<div class="form-check is-valid">
					<input type="checkbox" class="form-check-input" id="rdoShowPassRP">
					<label class="form-check-label" for="rdoShowPassRP" ng-click="showPassRP=!showPassRP"><fmt:message key="ShowPassword"/></label>
				</div>
				<div class="invalid-feedback"><fmt:message key="InvalidCPassword"/></div>
			</div>
		</div>

		<!-- Button -->
		<div class="col-12 text-end px-4 mx-0 mt-5">
			<button type="reset" class="btn btn-lg btn-outline-secondary" onclick="location.href=window.location.href.split('?')[0]"><fmt:message key="Cancel"/></button>
			<button type="submit" class="btn btn-lg btn-outline-primary"><fmt:message key="Update"/></button>
			<button type="submit" class="btn btn-lg btn-outline-danger" ng-click="onDel='delete'"><fmt:message key="Delete"/></button>
			<input type="hidden" name="Del" value="{{onDel}}">
		</div>

	</form>



</body>
</html>