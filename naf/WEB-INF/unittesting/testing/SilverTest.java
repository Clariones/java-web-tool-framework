package testing;

import static org.junit.Assert.*;

import java.net.URI;
import java.net.URISyntaxException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;



import silver.SilverPriceService;

public class SilverTest {

	
	public void test() throws URISyntaxException, Exception {
		SilverPriceService service =new SilverPriceService();
		String content=service.downloadContent(new URI("http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY"));
		System.out.println(content);
	
	}
	
	@Test
	public void test2() throws URISyntaxException, Exception {
		String urlExpr="http://www.kitco.cn/KitcoDynamicSite/RequestHandler?requestName=getFileContent&AttributeId=SilverPGMPricesCNY";
		Document doc = Jsoup.connect(urlExpr).get();
		Elements elements = doc.select("td");
		int index=0;
		for(Element element: elements){
			//System.out.println(element.html());
			String text=element.html();
			if("白银".equals(text)){
				String priceExpr=elements.get(index+1).html();
				System.out.println(priceExpr);
			}
			index++;
		}
	
	}
	
	
	//curl '' -H 'Accept-Encoding: gzip, deflate, sdch' -H 'Accept-Language: zh-CN,zh;q=0.8,en-US;q=0.6,en;q=0.4' -H 'User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/48.0.2564.116 Chrome/48.0.2564.116 Safari/537.36' -H 'Accept: */*' -H 'Referer: http://www.kitco.cn/' -H 'Cookie: JSESSIONID=2D1B19A9808D76979A435EA442DF60F8; counter=762922432758; __gads=ID=3d9fb7c20ab971d4:T=1458122362:S=ALNI_MbdA_u_1cmx9fdv58nTRLR1JmAcUw; _gat=1; _ga=GA1.2.748078623.1458122360' -H 'Connection: keep-alive' -H 'Cache-Control: max-age=0' --compressed
	

}
