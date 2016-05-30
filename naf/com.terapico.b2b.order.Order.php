<?php

$file = file_get_contents('./jsp_header', FILE_USE_INCLUDE_PATH);
echo $file;
?>

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

