<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<style>
.message {
	font-size: 20px;
	overflow: auto;
}

.paramlist {
	font-size: 20px;
	text-align: left;
	overflow-x: hidden;
  overflow: auto;
}
</style>


<div class="paramlist">

<c:forEach var="item" items="${result}">


${item.id}---${item.username} ----------------  ${item.password}<br/>


		</c:forEach>
	</div>


