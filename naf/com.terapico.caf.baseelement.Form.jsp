<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=UTF-8"%>

<script type="text/javascript">
	$(function() {
		var action="";
		
		$(".submit").click(function(){
			action=$(this).attr("action");
		});
		/*
		$(":input").dblclick(function(){		
			//alert("sdfsdf");	
			//$( ".parameters" ).toggle();
			
			var pos = $(this).position();

		    // .outerWidth() takes into account border and padding.
		   
		    //show the menu directly over the placeholder
		    
		    if(!$("#parameters").is(":visible")){
		    	// var width = $(this).outerWidth();
				var parameterType=$(this).attr("parameterType");
				var parameterName=$(this).attr("parameterName");
		    
		    	fillResult("suggestParameter/"+parameterType+"/"+parameterName+"/","#parameters");
		    }
		    
		    $("#parameters").css({
		        position: "absolute",
		        top: pos.top + pos.height+"px",
		        left: (pos.left) + "px",
				    overflow: "scroll"
		    }).toggle();
			
		
		});
		
		$( window ).resize(function() {
			 // $( "#log" ).append( "<div>Handler for .resize() called.</div>" );
			var currentTargetId= $("#parameters").attr("targetInputId");
			console.log(currentTargetId)	;
			var pos = $("#"+currentTargetId).position();
			 $("#parameters").css({
			        position: "absolute",
			        top: pos.top + pos.height+"px",
			        left: (pos.left) + "px",
				      overflow: "scroll"
			   });
		});
	*/
		
		var cache = {};

		$(".mainform").submit(function(event) {
			
			if(action==""){
				return;
			}
			$(this).find(":input").attr("disabled", true);
			event.preventDefault();
			var parameters = "";
			var valid=true;
			$(".mainform :input").each(function() {
				//console.log("-------------"+$(this).val());
				if ($(this).val()==""){
					console.log("--eee-----------"+$(this).val());
					$(this).parent().addClass("has-error");
					//$(this).addClass("input-danger");
					valid=false;
				}
				if ($(this).attr("append") == "true") {
					parameters += encodeURIComponent($(this).val()) + "/";
				}				
			});
			if(!valid){
				$(this).find(":input").attr("disabled", false);
				return true;
			}
			var reqURI =  action + "/" + parameters;
			fillResult(reqURI,"#result");
			$(this).find(":input").attr("disabled", false);
			
		});
		//var currentTargetId="";
		 $( "form input:text" ).focus(function() {
			 
			 //currentTargetId=$(this).attr("id");
			 //console.log("form input:text clicked: "+currentTargetId)	;
			 $("#parameters").attr("targetInputId",$(this).attr("id"));
			 
		});
		
		//


	});
		
	$(document).ready(function() {
		 $(".mainform:not(.filter) :input:visible:enabled:first").focus();
		 //$(".mainform").elements().first().focus();
	
	});	
		
</script>



<style>
.form {
	font-size: 20px;
}
#parameters {
	display: none;
	border: 1px solid grey; 
	width: 400px;
	height: 400px;
	overfollow:auto;
	padding-left: 20px;
	padding-right: 20px;
	background: white;
#	opacity: 0.5;
	background-color:rgba(255,255,255,0.8);
}
</style>

<div class="form">





</div>


<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">
    
    <c:forEach var="action" items="${result.actions}">
			${action.name}
		</c:forEach>
    
    </h3>
  </div>
  
  <div class="panel-body">
    <!-- parameterName="${field.name}" parameterType="${field.type.name}" autocomplete="off" -->
    <form class="mainform">
		<c:forEach var="field" items="${result.fields}" varStatus="status">
		<div class="col-sm-3">
			<input id="fl${status.index}" class="form-control input-sm" 
			placeHolder="${field.name}" value="${field.defaultValue}"
			title="${field.name}" type="text" append="true" />
			
		</div>
		</c:forEach>
		
		<c:forEach var="action" items="${result.actions}">
		<div class="col-sm-2">
			<input type="submit" class="btn btn-primary btn-sm action submit" value="${action.name}" action="${action.name }"  />
			 
		</div>
		</c:forEach>
		
	</form>
	<br/>
    <hr/>
    <div id="result" >  </div>
  </div>
</div>


<div id="parameters" > Parameters </div>


