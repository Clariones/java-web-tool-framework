<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:20px;
}

</style>

 <div class="table-responsive">
Name Value Pair List
<hr/>


<table class="table table-striped">
<thead><tr><th>Index#</th><th>Name</th><th>Value</th></thead>
<tbody>

	<c:forEach var="item" items="${result}" varStatus="status">
           <tr><td> ${status.index}</td><td> ${item.name}</td><td> ${item.value}</td></tr>
	</c:forEach>
	</tbody>
	</table>	

  </div>