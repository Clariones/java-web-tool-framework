package weather;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import com.google.gson.Gson;

import baiduservicecommon.BaiduInstantService;

public class BaiduWeatherService extends BaiduInstantService{
	public WeatherResponse buildFromURI(String city) throws URISyntaxException, Exception
	{
		
		String urlExpr=buildRequestURL(city);
		
		String content=callBaiduAPI(new URI(urlExpr));
		
		System.out.println("content\n"+content);
		
        Gson gson = new Gson();     
        final WeatherResponse weatherRequest=gson.fromJson(content,WeatherResponse.class);
		
		return weatherRequest;
		
	}



	
	public String buildRequestURL(String cityName) throws UnsupportedEncodingException
	{
		
		
		String urlprefix="http://apis.baidu.com/apistore/weatherservice/recentweathers?cityname=";
		
		String url=urlprefix+URLEncoder.encode(cityName, "UTF-8");
		
		
		return url;
		
		
		
	}
}
