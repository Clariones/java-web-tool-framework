
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="table-responsive">

	<table class="table table-striped">
		<thead><tr>
		<th>ID</th><th>NAME</th>
		</tr></thead>
		<tbody>
			<c:if test="${not empty result.employeeList}" >
			<c:forEach var="item" items="${result.employeeList}">
				<tr><td>${item.id}</td><td>${item.name}</td></tr>
			</c:forEach></c:if>
		
		</tbody>
	</table>		
</div>


