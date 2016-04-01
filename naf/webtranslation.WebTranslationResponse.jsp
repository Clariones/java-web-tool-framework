<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<style>
.message{
	font-size:30px;
  padding-top: 100px;
}

</style>
<c:set var="ret" value="${result}"/>


<div class="message">


${ret.src} => ${ret.dst}



</div>
