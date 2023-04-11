<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>


	
	<div class="form-floating m-4">
		<select class="form-select" id="cboVideo" name="cboVideo" onchange="location.href=window.location.href.split('?')[0]+'?TabContent=3&videoId='+this.value">
			<option selected disabled value=""></option>
			<c:forEach var="video" items="${listVideo}">
				<option value="${video.idYoutube}" ${videoId==video.idYoutube?'selected':''}>${video.title}</option>
			</c:forEach>
		</select>
		<label for="cboVideo"><fmt:message key="VideoTitle"/></label>
	</div>

	<!-- table-bordered  -->
	<table class="table table-striped table-hover m-0 p-0">
		<thead>
			<tr>
				<th scope="col"><fmt:message key="Username"/></th>
				<th scope="col"><fmt:message key="Fullname"/></th>
				<th scope="col" class="d-none d-sm-table-cell"><fmt:message key="Email"/></th>
				<th scope="col"><fmt:message key="Views"/></th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach var="user" items="${listViewedDetail.keySet()}">
				<tr>
					<th>${user.username}</th>
					<td>${user.fullname}</td>
					<td class="d-none d-sm-table-cell">${user.email}</td>
					<th>${listViewedDetail.get(user)}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>