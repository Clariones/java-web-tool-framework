<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title> ${result.selectBeanName} | Spring Bean Manage Console: </title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="/scripts/common.js" type="text/javascript"></script>


<style>
.toolbar {
	width: 100%; height: 40px; 	float:left; 	
	font-size: 20px; text-align: left; 	padding-left: 10px;
	padding-top: 10px; background: #111111; 	
	overflow:auto; 	border: 1px solid black;
	color: white; letter-spacing:2px
}

.bean {
		
	font-size: 20px; text-align: left; 	padding-left: 10px;
	padding-top: 10px; background: #111111; 	
	overflow:auto; 	border: 1px solid black;
	color: white; letter-spacing:2px
}

.menu {
	width: 20%; 	 	
	float:left; 	
	font-size: 20px; text-align: left; 	padding-left: 30px;
	padding-top: 30px; 	background: #eeeeee; 	overflow:auto;
	margin: 0; height: 100%
}
.content {
	width: 70%; 	height: 630px; 	text-align: center; 	
	#border: 1px solid grey; 
	#padding-top: 800px;
	float:right; 	background: #ffffff;
	padding-top: 30px; 
}


</style>


</head>

<body>
	<div class="toolbar" >Spring Beans [${result.selectBeanName}] ：  <c:forEach var="item" items="${result.beanList}"><a href='/naf/navi/index/${item}/' class='bean'> ${item}</a></c:forEach></div>
	<div class="menu" >

          <c:forEach var="item" items="${result.menuItems}">
            <a href="#${item.beanName}/${item.methodName}" methodName="${item.methodName}" beanName="${item.beanName }" class="action">${item.methodName}</a><br/>
            </c:forEach>
	</div>
	<div class="content" id="content">
	<textarea rows="40" cols="80">${result.beanExpr}</textarea>
	
	
	</div>
</body>
</html>
