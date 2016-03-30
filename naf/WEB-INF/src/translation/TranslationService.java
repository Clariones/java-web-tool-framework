package translation;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;

import baiduservicecommon.BaiduInstantService;
import baiduservicecommon.URLBuilder;

public class TranslationService extends BaiduInstantService {
	
	public TranslationResponse translate(String chineseOrEnglish) throws URISyntaxException, Exception
	{
		
		String urlExpr=buildRequestURL(chineseOrEnglish);
		System.out.println(urlExpr);
		String content=callBaiduAPI(new URI(urlExpr));     
        Gson gson = new Gson();     
        System.out.println(content);
        final TranslationResponse transResponse=gson.fromJson(content,TranslationResponse.class);
        System.out.println(transResponse.getErrMsg());
		return transResponse;
		
	}

	public String buildRequestURL(String chineseOrEnglish) throws UnsupportedEncodingException
	{
		
		URLBuilder builder=new URLBuilder("http://apis.baidu.com/apistore/tranlateservice/translate");
		
		if(chineseOrEnglish.charAt(0)<128){
				
			return builder.parameter("from", "en").parameter("to", "zh").parameter("query", chineseOrEnglish).done();
			
		}

		return builder.parameter("from", "zh").parameter("to", "en").parameter("query", chineseOrEnglish).done();
		
		
	
		
	}
}
