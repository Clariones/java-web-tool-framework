<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0043)http://getbootstrap.com/examples/dashboard/ -->
<html lang="en" slick-uniqueid="3"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
   
    <title>${result.selectBeanName} | Spring Bean Manage Console</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/bootstrap/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/bootstrap/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/bootstrap/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
 <style type="text/css">* {
 text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; 
}

</style>


</head>

  <body data-feedly-mini="yes">

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          
          <div class="navbar-brand">Spring Beans [${result.selectBeanName}] ： 
          </div>
          
         
          
          
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           <c:forEach var="item" items="${result.beanList}"><li><a href='/naf/navi/index/${item}/' class='bean'> ${item}</a></li></c:forEach>
          
            <li><a href="?__logout__">Logout</a></li>
            <!-- <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li> 
                      <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
            -->
          </ul>

        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
               
            <c:forEach var="item" items="${result.menuItems}">
            <li ><a  href="#${item.beanName}/${item.methodName}" methodName="${item.methodName}" beanName="${item.beanName }" class="action">${item.methodName}</a></li>
            </c:forEach>
          
          </ul>
          
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          

         
          <div class="table-responsive" id="content">
		<textarea rows="30" cols="120">${result.beanExpr}</textarea>
	

          </div>
        </div>
        </div>
        </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="/bootstrap/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="/bootstrap/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="/bootstrap/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/bootstrap/ie10-viewport-bug-workaround.js"></script>
    <script src="/scripts/common.js" type="text/javascript"></script>
    
  <script>

    
	$(function() {
		var cache = {};
		var prevElement;
		var toggleActive=function(element)
		{
			if(element.parent()===prevElement){
				return;
			}
			
			if(prevElement){	
				prevElement.removeClass("active");
			}
			
			element.parent().addClass("active");
			prevElement=element.parent();
			
		};
		$(".action").click(function(event) {
			
			//event.preventDefault();
			
			var methodName=$(this).attr('methodName');
			var beanName=$(this).attr('beanName');
			
			toggleActive($(this));
			
			var reqURI =  encodeURIComponent(beanName) + "/"+encodeURIComponent(methodName) +"/";
			fillResult(reqURI,"#content");
			
		});

	});

	$(document).ready(function() {
		//alert($(location).attr('href'));
		var currentURL=$(location).attr('href');
		var index=currentURL.indexOf("#");
		if(index<0){
			return;
		}
		
		var methodName=currentURL.substring(index+1);
		//reqURI =  encodeURIComponent(methodName) + "/";		
		reqURI =  methodName + "/";		
		console.log("ready!")
		fillResult(reqURI,"#content");
		
		
	});
</script>



</body></html>
