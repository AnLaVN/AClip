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
				<th scope="col" class="text-start"><fmt:message key="Likeds"/></th>
			</tr>
		</thead>
		<tbody class="table-group-divider">
			<c:forEach var="video" items="${listVideo}">
				<tr>
					<th class="text-center" scope="row">${video.idYoutube}</th>
					<td>${video.title}</td>
					<td class="text-center">${video.listLiked.size()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>



</body>
</html>