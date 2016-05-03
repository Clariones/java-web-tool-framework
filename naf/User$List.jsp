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
	padding-top: 40px;

}
.table{
	width:80%
}

table, th, td {
   border: 1px solid black;
   border-collapse: collapse;
}




tr:nth-child(even){background-color: #f2f2f2}

th, td {
    text-align: left;
    padding: 8px;
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


<c:if test="${empty result}"> 啥人都没了，<a href="#privilege/新建用户" class="action">新建</a>一个吧</c:if>

<c:if test="${not empty result}"><a href="#privilege/新建用户" class="action">新建用户</a></c:if>
	
<table class="table">
<tr><th>ID</th><th>NAME</td><th>PASS</td></tr>
<c:forEach var="item" items="${result}">


<tr><td>${item.id}</td><td>${item.username}</td><td>${item.password}</td></tr>


		</c:forEach>
</table>		
	</div>


