<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<body>



	<!-- Include Hearder User-->
	<%@include file="Header.jsp"%>


	<!-- Include Content -->
	<c:choose>
		<c:when test="${WebView == 'Home'}"><%@include file="Home.jsp"%></c:when>
		<c:when test="${WebView == 'SignIn'}"><%@include file="SignIn.jsp"%></c:when>
		<c:when test="${WebView == 'SignUp'}"><%@include file="SignUp.jsp"%></c:when>
		<c:when test="${WebView == 'MyAccount'}"><%@include file="MyAccount.jsp"%></c:when>
		<c:when test="${WebView == 'ResetPass'}"><%@include file="ResetPass.jsp"%></c:when>
		<c:when test="${WebView == 'Video'}"><%@include file="VideoDetail.jsp"%></c:when>
		<c:when test="${WebView == 'Liked'}"><%@include file="Home.jsp"%></c:when>
		<c:otherwise><%@include file="../Error.jsp"%></c:otherwise>
	</c:choose>



</body>
</html>