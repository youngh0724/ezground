<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<div class="row">
	<div class="col-sm-12">
		<ul class="nav nav-pills">
			<c:forEach var="entry" items="${sportEntry}">				
				<c:if test="${entry.sportEntriesNo == currentSportEntry.sportEntriesNo}">
					<li class="active"><a href="${pageContext.request.contextPath}/?entryNo=${entry.sportEntriesNo-1}">${entry.sportEntriesName}</a></li>						
				</c:if>				
				<c:if test="${entry.sportEntriesNo != currentSportEntry.sportEntriesNo}">
					<li><a href="${pageContext.request.contextPath}/?entryNo=${entry.sportEntriesNo-1}">${entry.sportEntriesName}</a></li>						
				</c:if>
			
			</c:forEach>
		</ul>
	</div>
</div>

<script type="text/javascript">

	console.log("sportEntry", '${sportEntry}');
	console.log("currentSportEntry", '${currentSportEntry}');

</script>
