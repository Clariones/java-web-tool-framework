<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8"%>



 <div class="table-responsive">




<c:if test="${not empty result}">


<table class="table table-striped">
<thead><tr><th>ID</th><th>SKU</th><th>AMOUNT</th><th>QTY#</th></tr></thead>
<tbody>
<c:forEach var="item" items="${result.lineItemList}">

	<tr><td>${item.id}</td><td>${item.skuName}</td><td><fmt:formatNumber value="${item.amount}" type="currency"/></td><td>${item.quantity}</td></tr>

</c:forEach>
		
</tbody></table>		
	</div>



</c:if>

