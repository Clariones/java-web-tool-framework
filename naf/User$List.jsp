<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>



<script>


	$(function() {
		var cache = {};

		$(".jumpurl").click(function() {
			
			//alert( );
			//$("#content").text($(this).attr("href"));
			//$("#content").text(event.target+"/"+$(this).attr("href"));
			var reqURI =  $(this).attr("href").substring(1) + "/";
			//$("#content").text(reqURI);
			fillResult(reqURI,"#content");
		});

	});
	
	
	
</script>





 <div class="table-responsive">


<c:if test="${empty result}"> 啥人都没了，
	<a href="#privilege/新建用户" class="goto">新建</a>一个吧
</c:if>

<c:if test="${not empty result}"><a href="#privilege/新建用户" class="jumpurl">新建用户</a></c:if>
	
<table class="table table-striped">
<thead><tr><th>ID</th><th>NAME</td><th>PASS</td></tr></thead>
<tbody>
<c:forEach var="item" items="${result}">


<tr><td>${item.id}</td><td>${item.username}</td><td>${item.password}</td></tr>


		</c:forEach>
		
</tbody></table>		
	</div>


