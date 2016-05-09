package test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.terapico.caf.baseelement.HTMLText;
import com.terapico.caf.baseelement.NameValuePair;

import chinastock.MarketLimitReport;
import chinastock.ReportItem;
import silver.SilverPriceService;

public class FinacialService {
	
	

	
	public List<NameValuePair> valuesAtTargetTime(double start, double increaseRatePercent) throws Exception {

		if (Math.abs(increaseRatePercent) < 0.000001) {
			throw new IllegalArgumentException(
					"calcCompoundInterest(double start, double increaseTo, double increaseRate): increaseRate can not be 0!!!");
		}
		List<NameValuePair> stringList=new ArrayList<NameValuePair>();
		int []yearList={1,2,5,10,15,20,25,30,40,50,60,70,80,90};
		//int []yearList={90,80,70,60,50,40,30,20,10,5,2,1};
		
		for(int years:yearList){
			
			double valueFuture = start*Math.pow(1+increaseRatePercent/100, years);
			//String twoDigYear=years<10?"0"+years:""+years;
			stringList.add(new NameValuePair("after "+years+" years",String.format("%6.02f", valueFuture)));
		}
		
		return stringList;
	
	}

	
	
	public List<NameValuePair> everyPeriodOverview(double payAmountEachPeriod,  double ratePercent) throws Exception {

		if (Math.abs(ratePercent) < 0.000000001) {
			throw new IllegalArgumentException(
					"everyPeriodOverview(double payAmountEachPeriod,  double ratePercent): increaseRate can not be 0!!!");
		}
		List<NameValuePair> stringList=new ArrayList<NameValuePair>();
		int []yearList={1,2,5,10,15,20,25,30,40,50,60,70,80,90};
		//int []yearList={90,80,70,60,50,40,30,20,10,5,2,1};
		
		for(int years:yearList){
			
			double valueFuture = periodPayTotal(years,payAmountEachPeriod,ratePercent);
			//String twoDigYear=years<10?"0"+years:""+years;
			stringList.add(new NameValuePair("end of "+years+" year",String.format("%6.02f", valueFuture)));
		}
		
		return stringList;
	}
	
	protected double periodPayTotal(int year, double amountPerPeriod, double increasePercent)
	{
		double sum=0;
		double base=amountPerPeriod;
		for(int i=1;i<=year;i++){
			base = base*(1+increasePercent/100);
			sum += base;
		}
		return sum;
	}
	public List<NameValuePair> valueInFuture(double valueToday,  double decreaseRatePercent) throws Exception {

		if (Math.abs(decreaseRatePercent) < 0.000000001) {
			throw new IllegalArgumentException(
					"calcCompoundInterest(double start, double increaseTo, double increaseRate): increaseRate can not be 0!!!");
		}
		List<NameValuePair> stringList=new ArrayList<NameValuePair>();
		//int []yearList={1,2,5,10,20,30,40,50,60,70,80,90};
		int []yearList={90,80,70,60,50,40,30,20,10,5,2,1};
		
		for(int years:yearList){
			
			double valueFuture = valueToday * Math.pow(1 - decreaseRatePercent/100, years);
			//String twoDigYear=years<10?"0"+years:""+years;
			stringList.add(new NameValuePair("after "+years+" years",String.format("%6.02f", valueFuture)));
		}
		
		return stringList;
	}
	
	public Object notibleStocks() throws MalformedURLException
	{
		
		MarketLimitReport pageReport=new MarketLimitReport();		
		ReportItem item=pageReport.getReportItem();
		return item;
		
	}
	public boolean sendEmailIfLowerThan(double value) throws URISyntaxException, Exception {

		double price = this.silverCurrentPrice();
		if (price > value) {
			return false;
		}
		Session session = Session.getDefaultInstance(System.getProperties(), null);
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("pricenear@aaxischina.com"));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress("pzhang@aaxischina.com"));
		String content = price + "! product price has been changed ";
		msg.setSubject(content);
		msg.setText(content);

		// Send the message
		Transport.send(msg);
		return true;

	}
	public HTMLText allMetalPrice() throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		String content =  service.allMetalPrice();
		
		
		HTMLText text=new HTMLText();
		text.append(content);
		return text;

	}
	public Double metalPrice(String 白银或钯或铑或铂) throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		return service.currentPrice(白银或钯或铑或铂);

	}
	public Double glodCurrentPrice() throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		return service.currentGoldPrice();

	}
	public Double silverCurrentPrice() throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		return service.currentPrice();

	}

}
