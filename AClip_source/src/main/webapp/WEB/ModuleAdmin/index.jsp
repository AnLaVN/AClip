<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Include Hearder Admin-->
	<%@include file="Header.jsp"%>


	<!-- Include Content -->
	<c:choose>
		<c:when test="${WebView == 'Home'}"><%@include file="../ModuleUser/Home.jsp"%></c:when>
		<c:when test="${WebView == 'AdVideos'}"><%@include file="VideosManager.jsp"%></c:when>
		<c:when test="${WebView == 'AdUsers'}"><%@include file="UsersManager.jsp"%></c:when>
		<c:when test="${WebView == 'AdStatistics'}"><%@include file="StatisticsManager.jsp"%></c:when>
		<c:when test="${WebView == 'Video'}"><%@include file="../ModuleUser/VideoDetail.jsp"%></c:when>
		<c:otherwise><%@include file="../Error.jsp"%></c:otherwise>
	</c:choose>



</body>
</html>