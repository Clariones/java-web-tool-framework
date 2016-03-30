   function  fillResult(reqURI, container)
    {
    	
    	var request = $.ajax({
			url : "/naf/"+reqURI,
			type : "GET",
			dataType : "html"
		});

		request.done(function(msg) {
			$(container).html(msg);
		});

		request.fail(function(jqXHR, textStatus,errorThrown) {
			//alert("Request failed: " + textStatus);
			$(container).html("<div style='text-align: left' >"+jqXHR.responseText+"</div>")
		});    	

    $(container).html("wait for me .......");

    }


