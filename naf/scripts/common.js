  var done=false;
  function wait(reqURI,container){
	  if(done)return;
	  $(container).html("请耐心等待"+reqURI+"，时间可能有点长，外面的服务比较慢，不是我慢........要不，给你讲个笑话吧....");
  }
  function  fillResult(reqURI, container)
    {
    	
    	var request = $.ajax({
			url : "/naf/"+reqURI,
			type : "GET",
			dataType : "html"
		});

    	setTimeout(wait,1000,reqURI, container);
    	done=false;
    	
		request.done(function(msg) {
			done=true;
			$(container).html(msg);
		});

		request.fail(function(jqXHR, textStatus,errorThrown) {
			//alert("Request failed: " + textStatus);
			$(container).html("<div style='text-align: left' >"+jqXHR.responseText+"</div>")
		});    	

		

    }


