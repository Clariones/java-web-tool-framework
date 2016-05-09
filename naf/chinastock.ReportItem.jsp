
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=GBK"%>


<div class="container">
  <h3>ÕÇÍ£µøÍ£°å</h3>
  <div class="row">
    <div class="col-sm-4" >
        <table class="table table-striped"><tbody>
		<c:forEach var="record" items="${result.limitedUpList}"><tr>   <td >${record}</td></tr></c:forEach>
		</tbody>
	   </table>
    </div>
    <div class="col-sm-4">
      <table class="table table-striped"><tbody>
	   <c:forEach var="record" items="${result.limitedDownList}"><tr>   <td >${record}</td></tr></c:forEach></tbody></table>
    </div>
  </div>
</div>


