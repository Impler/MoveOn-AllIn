<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>控制面板</title>
<style type="text/css">
header, nav, aside, section, footer {
	border: 1px solid;
}
</style>
</head>
<body>
	<!-- header s -->
	<header>
		<h1>控制面板</h1>
	</header>
	<!-- header e -->
	<!-- nav e -->
	<nav>
		<h2>导航区</h2>
	</nav>
	<!-- nav e -->
	<!-- aside e -->
	<aside>
		<div>
			<c:forEach var="topMenu" items="${requestScope.topMenus }">
				<ul>${topMenu.name }</ul>
			</c:forEach>
		</div>
	</aside>
	<!-- aside e -->
	<!-- aside s -->
	<section></section>
	<!-- aside e -->
	<!-- footer e -->
	<footer></footer>
	<!-- footer e -->
</body>
</html>