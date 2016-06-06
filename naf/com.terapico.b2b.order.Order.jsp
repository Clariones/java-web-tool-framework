
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8"%>


<div>
	<div class="row" style="font-size: 30px; padding-top: 30px">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		#${result.id} 
		   ${result.title }
		
		 </div>
		 
	</div>
	<hr />
	<div class="row" style="font-size: 15px; padding-top: 30px">

		<c:set var="seller" value="${ result.seller}" />
		<c:set var="buyer" value="${ result.buyer}" />

		<div class="col-xs-12 col-md-6">

			<div class="row display-table">
				<div class="col-xs-12 col-sm-4 display-cell"
					style="text-align: right">
					<img src="/naf/bootstrap/dell.png"/>

				</div>
				<div class="col-xs-12 col-sm-8 display-cell">
				<b>FROM</b><br/>
					${seller.id}<br /> ${seller.name}<br /> (310)770-2894(F)<br />
					(310)770-2893(T)<br />

				</div>
			</div>
		</div>
		<div class="col-xs-12 col-md-6">

			<div class="row display-table">
				<div class="col-xs-12 col-sm-4 display-cell"
					style="text-align: right">
					<img src="/naf/bootstrap/adidas.png"/>

				</div>
				<div class="col-xs-12 col-sm-8 display-cell">
				<b>TO</b><br/>
					${buyer.id}<br /> ${buyer.name}<br /> (310)770-2894(F)<br />
					(310)770-2893(T)<br />

				</div>
			</div>
		</div>


	</div>

<hr />

<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		Line Items
		 </div>
	</div>
	


	<div class="table-responsive">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>SKU_ID</th>
					<th>SKU_NAME</th>
					<th>AMOUNT</th>
					<th>QUANTITY</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty result.lineItemList}">
					<c:forEach var="item" items="${result.lineItemList}">
						<tr>
							<td>${item.id}</td>
							<td>${item.skuId}</td>
							<td>${item.skuName}</td>
							<td>${item.amount}</td>
							<td>${item.quantity}</td>
						</tr>
					</c:forEach>
				</c:if>

			</tbody>
		</table>
	</div>


<hr />
<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		Shipping Group
		
		 </div>
		 
	</div>
	<div class="table-responsive">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>NAME</th>
					<th>AMOUNT</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty result.shippingGroupList}">
					<c:forEach var="item" items="${result.shippingGroupList}">
						<tr>
							<td>${item.id}</td>
							<td>${item.name}</td>
							<td>${item.amount}</td>
						</tr>
					</c:forEach>
				</c:if>

			</tbody>
		</table>
	</div>
	
	
	<div class="row" style="font-size: 30px;">
		<div class="col-xs-12 col-md-12" style="padding-left:20px">
		Payment
		 </div>
	</div>
		<div class="table-responsive">

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>CARD</th>
					<th>AMOUNT</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${not empty result.paymentGroupList}">
					<c:forEach var="item" items="${result.paymentGroupList}">
						<tr>
							<td>${item.id}</td>
							<td>${item.cardNumber}</td>
							<td>${item.billingAddress.id}</td>
						</tr>
					</c:forEach>
				</c:if>

			</tbody>
		</table>
	</div>
	
	
	<hr />
	<div class="row" style="font-size: 20px; padding-top: 30px">
		<div class="col-xs-12 col-md-12">
			<c:if test="${not empty result.actionList}">
				<c:forEach var="item" items="${result.actionList}">

					<input href="#${item.name}" type="button"
						class="btn btn-warning active" value="${item.name}"></input>
				</c:forEach>
			</c:if>
		</div>
	</div>

</div>

