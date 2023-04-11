<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<body>


	<!-- table-bordered  -->
	<table class="table table-striped table-hover m-0 p-0">
		<thead>
			<tr>
				<th scope="col"><fmt:message key="Username"/></th>
				<th scope="col"><fmt:message key="Fullname"/></th>
				<th scope="col" class="d-none d-sm-table-cell"><fmt:message key="Email"/></th>
				<th scope="col" class="text-center"><fmt:message key="Role"/></th>
				<th scope="col" class="text-center"><fmt:message key="Repair"/></th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach var="user" items="${listUser}">
				<tr>
					<th>${user.username}</th>
					<td>${user.fullname}</td>
					<td class="d-none d-sm-table-cell">${user.email}</td>
					<td class="text-center">
						<c:choose>
							<c:when test="${user.role}"><fmt:message key="RoleAdmin"/></c:when>
							<c:otherwise><fmt:message key="RoleUser"/></c:otherwise>
						</c:choose>
					</td>
					<td class="text-center">
						<button class="btn btn-outline-secondary d-none d-xxl-inline" onclick="location.href=window.location.href.split('?')[0]+'?userId=${user.username}';"><i class="bi bi-gear me-2"></i><fmt:message key="Repair"/></button>
						<button class="btn btn-outline-secondary d-xxl-none d-inline" onclick="location.href=window.location.href.split('?')[0]+'?userId=${user.username}';"><i class="bi bi-gear"></i></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>

</html>