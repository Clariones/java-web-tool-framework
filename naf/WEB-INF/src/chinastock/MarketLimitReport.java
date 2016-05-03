package chinastock;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;


import com.google.gson.Gson;

public class MarketLimitReport {
	
	private static final String DOWNLOAD_LIMITED_TEMPLATE="http://quotes.money.163.com/hs/service/diyrank.php?host=http%3A%2F%2Fquotes.money.163.com%2Fhs%2Fservice%2Fdiyrank.php&page={0}&query=STYPE%3AEQA&fields=SYMBOL%2CPERCENT%2CNAME%2CCODE%2CPRICE&sort=PERCENT&order={1}&count={2}&type=query";
	
	public ReportItem getReportItem() throws MalformedURLException
	{
		
		int countPerPage=500;
		ReportItem item=new ReportItem();
		for(int i=0;i<10;i++){			
			Page page=downloadLimitedUpPage(i,countPerPage);			
			item.getLimitedUpList().addAll(page.getLimitUpList());			
			if(page.isEndOfLimitUpPage()){				
				break;
			}
		}		
		for(int i=0;i<10;i++){			
			Page page=downloadLimitedDownPage(i,countPerPage);
			item.getLimitedDownList().addAll(page.getLimitDownList());
			if(page.isEndOfLimitDownPage()){				
				break;
			}
		}		
		item.setLimitedDown(item.getLimitedDownList().size());
		item.setLimitedUp(item.getLimitedUpList().size());
		return item;		
	}
	public String getReportURL(int pageNumber, boolean sortByDesc, int countPerPage)
	{
		String sort=sortByDesc?"desc":"asc";
		Object values[]=new Object[]{pageNumber, sort,countPerPage};		
		return MessageFormat.format(DOWNLOAD_LIMITED_TEMPLATE, values);		
	}
	public Page downloadLimitedUpPage(int pageNumber, int countPerPage) throws MalformedURLException
	{		
		return downloadLimitedPage(pageNumber,true,countPerPage);		
	}
	public Page downloadLimitedDownPage(int pageNumber, int countPerPage) throws MalformedURLException
	{		
		return downloadLimitedPage(pageNumber,false,countPerPage);		
	}
	public Page downloadLimitedPage(int pageNumber, boolean sortByDesc,int countPerPage) throws MalformedURLException
	{
		String urlExpr=getReportURL(pageNumber,sortByDesc,countPerPage);		
		String content=getTextFromURL(urlExpr);		
		Gson gson = new Gson();		
		Page page=gson.fromJson(content,Page.class);
		return page;		
	}
	public static String getTextFromURL(String url) throws MalformedURLException {
		return TextTool.getTextFromURL(new URL(url));
	}
}
