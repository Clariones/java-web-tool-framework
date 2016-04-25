package webtranslation;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TextNode;
import com.google.gson.Gson;

import baiduservicecommon.BaiduInstantService;
import baiduservicecommon.URLBuilder;

public class WebTranslationService extends BaiduInstantService {

	public WebTranslationResponse translate2(String chineseOrEnglish) throws URISyntaxException, Exception {

		String urlExpr = buildRequestURL(chineseOrEnglish);
		log(urlExpr);
		String content = callBaiduAPI(new URI(urlExpr));
		log(content);
		
		JsonFactory factory = new JsonFactory();
		JsonParser  parser  = factory.createParser(content);
		while(!parser.isClosed()){
		    JsonToken jsonToken = parser.nextToken();

		    if(!JsonToken.FIELD_NAME.equals(jsonToken)){
		        continue;
		    }
		    
		    String fieldName = parser.getCurrentName();
	        //System.out.println(fieldName);

	        jsonToken = parser.nextToken();

	        if("dst".equals(fieldName)){
	            //this.logln(parser.getValueAsString());
	    		final WebTranslationResponse transResponse = new WebTranslationResponse();
	    		transResponse.setSrc(chineseOrEnglish);
	    		transResponse.setDst(parser.getValueAsString());
	    		
	    		// log(transResponse.getErrMsg());
	    		return transResponse;
	        	
	        } 
		    
		}
		
		throw new IOException("Fail to translate: "+content);
		
		

	}
	
	
	public WebTranslationResponse translate(String chineseOrEnglish) throws URISyntaxException, Exception {

		String urlExpr = buildRequestURL(chineseOrEnglish);
		log(urlExpr);
		String content = callBaiduAPI(new URI(urlExpr));
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode rootNode = mapper.readValue(content, JsonNode.class);
		TextNode resultNode=(TextNode) rootNode.with("trans_result").get("data").path(0).get("dst");
		
		
		final WebTranslationResponse transResponse = new WebTranslationResponse();
		transResponse.setSrc(chineseOrEnglish);
		transResponse.setDst(resultNode.asText());
		return transResponse;
		
		//throw new IOException("Fail to translate: "+content);
		
		

	}

	/*
	 * { "dict_result": { "baike_means": [], "edict": "", "from": "netdata",
	 * "lang": "0", "simple_means": { "from": "netdata", "symbols": [ { "parts":
	 * [ { "means": [ "I ate too much", "I ate too much." ], "part_name":
	 * "\u7f51\u7edc" } ] } ], "word_name":
	 * "\u6211\u5403\u5f97\u592a\u591a\u4e86" }, "zdict": "" }, "liju_result": {
	 * "double": "", "single": "" }, "trans_result": { "data": [ { "dst":
	 * "I ate too much.", "relation": [], "result": [ [ 0, "I ate too much.", [
	 * "0|18" ], [], [ "0|18" ], [ "0|15" ] ] ], "src":
	 * "\u6211\u5403\u5f97\u592a\u591a\u4e86" } ], "domain": "all", "from":
	 * "zh", "status": 0, "to": "en", "type": 2 } }
	 * 
	 * 
	 */

	// curl
	// 'http://fanyi.baidu.com/v2transapi?from=zh&to=en&query=%E6%88%91%E5%90%83%E5%BE%97%E5%A4%AA%E5%A4%9A%E4%BA%86&transtype=realtime&simple_means_flag=3'

	public String buildRequestURL(String chineseOrEnglish) throws UnsupportedEncodingException {
		// http://fanyi.baidu.com/v2transapi?from=zh&to=en&query=%E6%88%91%E5%90%83%E5%BE%97%E5%A4%AA%E5%A4%9A%E4%BA%86&transtype=realtime&simple_means_flag=3

		URLBuilder builder = new URLBuilder("http://fanyi.baidu.com/v2transapi");

		if (chineseOrEnglish.charAt(0) < 128) {
			builder.parameter("from", "en").parameter("to", "zh").parameter("query", chineseOrEnglish);
			return builder.parameter("transtype", "realtime").parameter("simple_means_flag", "3").done();
		}

		builder.parameter("from", "zh").parameter("to", "en").parameter("query", chineseOrEnglish).done();

		return builder.parameter("transtype", "realtime").parameter("simple_means_flag", "3").done();

	}

}
