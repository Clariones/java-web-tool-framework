package test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.terapico.naf.baseelement.HTMLText;

import chinastock.MarketLimitReport;
import chinastock.ReportItem;
import silver.SilverPriceService;

public class FinacialService {
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
