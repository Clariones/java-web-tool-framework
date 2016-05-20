<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8"%>







 <div class="table-responsive">


<c:if test="${empty result}"> 啥人都没了，
	<a href="#privilege/新建用户" class="jumpurl">新建</a>一个吧
</c:if>

<c:if test="${not empty result}">

${ result.seller.name} sell to ${ result.buyer.name} <br/>
订单总额： <fmt:formatNumber value="${ result.totalAmount}" type="currency"/><br/>
<a href="#privilege/新建用户" class="jumpurl">Line Items(${fn:length(result.commerceItemList)})</a>
	
<table class="table table-striped">
<thead><tr><th>ID</th><th>SKU</th><th>AMOUNT</th><th>QTY#</th></tr></thead>
<tbody>
<c:forEach var="item" items="${result.commerceItemList}">


<tr><td>${item.id}</td><td>${item.skuName}</td><td><fmt:formatNumber value="${item.amount}" type="currency"/></td>

<td>

${item.quantity}




</td></tr>


		</c:forEach>
		
</tbody></table>		
	</div>


 <div class="table-responsive">
<c:if test="${empty result}"> 啥人都没了，
	<a href="#privilege/新建用户" class="jumpurl">新建</a>一个吧
</c:if>

<c:if test="${not empty result}">
<a href="#privilege/新建用户" class="jumpurl">Shipment</a>
<table class="table table-striped">
<thead><tr><th>Shipment#</th><th>NAME</th><th>AMOUNT</th><th>ADDRESS</th></tr></thead>
<tbody>
<c:forEach var="item" items="${result.shippingGroupList}">


<tr><td>${item.id}</td><td>${item.name}</td><td><fmt:formatNumber value="${item.amount}" type="currency"/></td>

<td>

${item.address.id}




</td></tr>


		</c:forEach>
		
</tbody></table>		
	</div>


 <div class="table-responsive">
<c:if test="${empty result}"> 啥人都没了，
	<a href="#privilege/新建用户" class="jumpurl">新建</a>一个吧
</c:if>

<c:if test="${not empty result}">

<a href="#privilege/新建用户" class="jumpurl">Payment Groups</a>
<table class="table table-striped">
<thead><tr><th>ID</th><th>NAME</th><th>CARD</th><th>ADRESS</th></tr></thead>
<tbody>
<c:forEach var="item" items="${result.paymentGroupList}">


<tr><td>${item.id}</td><td>${item.name}</td><td>${item.cardNumber}</td>

<td>

${item.billingAddress.id}




</td></tr>
		</c:forEach>
		
</tbody></table>		
	</div>

</c:if>

