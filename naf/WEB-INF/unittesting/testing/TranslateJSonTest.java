package testing;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.google.gson.Gson;

import webtranslation.WebTranslationResponse;

public class TranslateJSonTest extends TestCaseBase {

	
	public void test() throws IOException {
		String content=this.loadStringFromFile("tmp/jsonload.json");
		Gson gson = new Gson();
		final WebTranslationResponse transResponse = gson.fromJson(content, WebTranslationResponse.class);
		
		
	}
	@Test
	public void test2() throws IOException {
		
		
		
		
		String content=this.loadStringFromFile("tmp/jsonload.json");
		JsonFactory factory = new JsonFactory();
		JsonParser  parser  = factory.createParser(content);
		while(!parser.isClosed()){
		    JsonToken jsonToken = parser.nextToken();

		    if(JsonToken.FIELD_NAME.equals(jsonToken)){
		        String fieldName = parser.getCurrentName();
		        //System.out.println(fieldName);

		        jsonToken = parser.nextToken();

		        if("dst".equals(fieldName)){
		            this.logln(parser.getValueAsString());
		        } 
		    }
		}
		
	}
	
	
	
	
}
