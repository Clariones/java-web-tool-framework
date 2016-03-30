package testing;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.junit.Test;

import weather.BaiduWeatherService;
import weather.Index;
import weather.Today;
import weather.WeatherResponse;

public class WeatcherTest {

	@Test
	public void testURL() throws URISyntaxException, Exception {
		BaiduWeatherService service=new BaiduWeatherService();
		String x=service.buildRequestURL("成都");
		System.out.println(x);
		 x=service.buildRequestURL("北京");
		System.out.println(x);
		WeatherResponse w=service.buildFromURI("成都");
		
	
	}
	
	@Test
	public void testWeather() throws URISyntaxException, Exception {
		BaiduWeatherService service=new BaiduWeatherService();		
		WeatherResponse w=service.buildFromURI("成都");
		Today x=w.getRetData().getToday();
		

		

		System.out.println(x.getCurTemp());
		
		System.out.println(x.getAqi());
		for(Index index:x.getIndex()){
			System.out.println(index.getName()+index.getDetails());
		}
		
		
		
	}

}
