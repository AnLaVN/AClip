<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>


	<!-- table-bordered  -->
	<table class="table table-striped table-hover m-0 p-0">
		<thead>
			<tr>
				<th scope="col" class="text-center">ID Video</th>
				<th scope="col" class="text-start"><fmt:message key="VideoTitle"/></th>
				<th scope="col" class="text-center"><fmt:message key="Views"/></th>
				<th scope="col" class="text-center"><fmt:message key="Repair"/></th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach var="video" items="${listVideo}">
				<tr>
					<th class="text-center" scope="row">${video.idYoutube}</th>
					<td>${video.title}</td>
					<td class="text-center">${video.listViewed.size()}</td>
					<td class="text-center">
						<button class="btn btn-outline-secondary d-none d-xxl-inline" onclick="location.href=window.location.href.split('?')[0]+'?videoId=${video.idYoutube}';"><i class="bi bi-gear me-2"></i><fmt:message key="Repair"/></button>
						<button class="btn btn-outline-secondary d-xxl-none d-inline" onclick="location.href=window.location.href.split('?')[0]+'?videoId=${video.idYoutube}';"><i class="bi bi-gear"></i></button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>