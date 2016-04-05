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
<script>


	$(function() {
		var cache = {};

		$(".action").click(function() {
			
					//alert( );
					//$("#content").text($(this).attr("href"));
					//$("#content").text(event.target+"/"+$(this).attr("href"));
					var reqURI =  $(this).attr("href").substring(1) + "/";
					//$("#content").text(reqURI);
					fillResult(reqURI,"#content");
		});

	});
</script>
	
<div class="paramlist">


<c:if test="${empty result}"> 啥人都没了，<a href="#新建用户" class="action">新建</a>一个吧</c:if>

<c:forEach var="item" items="${result}">


${item.id}---${item.username} ----------------  ${item.password}<br/>


		</c:forEach>
		
		<c:if test="${not empty result}"><a href="#新建用户" class="action">新建用户</a></c:if>
	</div>


