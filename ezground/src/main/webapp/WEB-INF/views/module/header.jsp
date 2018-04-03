<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Header -->
<header id="header">
	<a href="${pageContext.request.contextPath}/" class="logo">EZGround</a>
	<ul class="icons">
		<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
		<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
		<li><a href="#" class="icon fa-snapchat-ghost"><span class="label">Snapchat</span></a></li>
		<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
		<li><a href="#" class="icon fa-medium"><span class="label">Medium</span></a></li>
	</ul>
</header>
<div class="btn-group btn-group-justified">
	<c:forEach var="entry" items="${list}">
		<a href="${pageContext.request.contextPath}/?entryNo=${entry.sportEntriesNo-1}" class="btn btn-info">${entry.sportEntriesName}</a>
	</c:forEach>
</div>
