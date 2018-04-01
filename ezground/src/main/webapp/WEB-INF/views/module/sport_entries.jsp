<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <nav class="navbar navbar-default navbar-static-top" style="margin-bottom: 0">
    	<ul class="list-inline">
    		<c:forEach var="entry" items="${list}">
				<li>
					<a href="${pageContext.request.contextPath}/?entryNo=${entry.sportEntriesNo-1}">${entry.sportEntriesName}</a>
				</li>
							
			</c:forEach>   	
    	
    	</ul>    
    </nav>