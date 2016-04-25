package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.terapico.naf.baseelement.PlainText;

import calculator.CalculatorService;
import silver.SilverPriceService;
import telecode.TeleCodeDict;
import translation.TranslationResponse;
import translation.TranslationService;
import weather.BaiduWeatherService;
import weather.WeatherResponse;
import webtranslation.WebTranslationResponse;
import webtranslation.WebTranslationService;

public class ServiceBeanTest {

	public Date currentTime() throws Exception {
		return new CurrentTime();
	}

	/*
	 * public Date getException() throws Exception{ if(true){ throw new
	 * Exception("exception!"); } return new CurrentTime(); }
	 */
	public PlainText httpHeader(URI uri) throws Exception {
		PlainText text = new PlainText();

		URLConnection conn = uri.toURL().openConnection();
		HttpURLConnection.setFollowRedirects(false);
		if (conn instanceof HttpURLConnection) {
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			httpConn.setRequestMethod("HEAD");

			text.append("CODE: " + httpConn.getResponseCode() + "\r\n");

		}

		// get all headers
		Map<String, List<String>> map = conn.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getKey() == null) {
				continue;
			}
			text.append(entry.getKey() + ": " + entry.getValue().get(0));
			text.append("\r\n");
		}

		return text;

	}

	protected TranslationResponse translateAPI(String englishOrChineseString) throws URISyntaxException, Exception {

		TranslationService service = new TranslationService();

		return service.translate(englishOrChineseString);

	}

	public WebTranslationResponse translateWeb(String englishOrChineseString) throws URISyntaxException, Exception {

		WebTranslationService service = new WebTranslationService();
		return service.translate(englishOrChineseString);

	}

	public String teleCode(String stringToCoding) throws URISyntaxException, Exception {

		TeleCodeDict service = new TeleCodeDict();
		return service.getTelecode(stringToCoding);

	}
	public Double silverCurrentPrice() throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		return service.currentPrice();

	}
	public BigDecimal add(BigDecimal number1, BigDecimal number2)
	{
		//number1
		return number1.add(number2);
	}

	public WeatherResponse today() throws URISyntaxException, Exception {
		BaiduWeatherService service = new BaiduWeatherService();
		WeatherResponse response = service.buildFromURI("成都");

		return response;

	}

	public Double metalPrice(String 白银或钯或铑或铂) throws URISyntaxException, Exception {
		SilverPriceService service = new SilverPriceService();
		return service.currentPrice(白银或钯或铑或铂);

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

	protected String getValueInExpr(String contentType, String prefix) {
		Pattern pattern = Pattern.compile(prefix + "=\\S+(;)?");
		Matcher matcher = pattern.matcher(contentType);
		if (!matcher.find()) {
			return null;
		}
		String temp = matcher.group();
		temp = temp.replace(prefix + "=", "");
		temp = temp.replace(";", "");
		return temp;
	}

	protected String getEncoding(String contentType) {
		String encoding = getValueInExpr(contentType, "charset");
		if (encoding != null) {
			return encoding;
		}
		encoding = getValueInExpr(contentType, "encoding");
		if (encoding != null) {
			return encoding;
		}
		return "UTF-8";
	}

	public int length(String strToTest) {
		return strToTest.length();
	}
	//test case 2136008809＝》zbq2y1
	
	public String thirtySixStepValue(long octValue) {
		// return strToTest.length();
		return otherStepFromOct(octValue,36);
		
	}

	public String binaryValue(long octValue) {
		// return strToTest.length();
		return otherStepFromOct(octValue,2);
		
	}
	
	public String hexValue(long octValue) {
		// return strToTest.length();
		return "0x"+otherStepFromOct(octValue,16);
		
	}
	
	public String otherStepFromOct(long octValue,long step) {
		// return strToTest.length();

		if(!inCloseRange(step,0L,64L)){
			throw new IllegalArgumentException("The step '"+step+"' is greater than 64, not supported");
		}
		
		if(inCloseRange(octValue,0L,step-1)){
			return getIndex(octValue)+"";
		}
		
		StringBuilder resultBuffer = new StringBuilder(10);
		long divider = 1;
		while (true) {
			long remainNumber=octValue / divider;
			if(remainNumber==0){
				break;
			}
			long index = (remainNumber) % step;
			//resultBuffer.append(getIndex(index));
			resultBuffer.insert(0, getIndex(index));
			
			divider *= step;

		}

		return resultBuffer.toString();
	}
	
	protected final boolean inCloseRange(long testNumber, long start, long end) {
		if (testNumber < start) {
			return false;
		}

		if (testNumber > end) {
			return false;
		}
		return true;

	}

	protected char getIndex(long value) {
		if (value < 0) {
			throw new IllegalArgumentException("The vaue: '" + value + "' less than 0, could not get a index");
		}

		if (inCloseRange(value, 0, 9)) {
			return (char) ('0' + value);
		}

		if (inCloseRange(value, 10, 35)) {
			return (char) ('a' + value - 10);
		}
		
		if (inCloseRange(value, 36, 61)) {
			return (char) ('A' + value - 36);
		}
		if(value==62){
			return '_';
		}

		if(value==63){
			return '@';
		}
		throw new IllegalArgumentException("The vaue: '" + value + "' greater or equal than 64");

	}

	public double timeOfPI(int piTimes) {
		return Math.PI * piTimes;
	}

	public String echo(String stringToEcho) {
		return stringToEcho;
	}

	public boolean testRegex(String regex, String stringToTest) {
		return stringToTest.matches(regex);

		// return stringToEcho;
	}

	protected PlainText getContent(URI uri) throws Exception {
		PlainText text = new PlainText();

		URLConnection conn = uri.toURL().openConnection();

		String encoding = null;
		// conn.
		// get all headers
		Map<String, List<String>> map = conn.getHeaderFields();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			if (entry.getKey() == null) {
				continue;
			}

			text.append(entry.getKey() + ": " + entry.getValue().get(0));
			text.append("\r\n");
			if ("Content-Type".equalsIgnoreCase(entry.getKey())) {
				encoding = getEncoding(entry.getValue().get(0));
				System.out.println(encoding);
			}
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), encoding));
		String line;
		while ((line = reader.readLine()) != null) {
			text.append(line);
			text.append("\r\n");
		}

		return text;

	}

	public DoubleResult timeToReachTarget(double start, double target, double increaseRate) throws Exception {

		if (Math.abs(increaseRate) < 0.000001) {
			throw new IllegalArgumentException(
					"calcCompoundInterest(double start, double increaseTo, double increaseRate): increaseRate can not be 0!!!");
		}
		DoubleResult result = new DoubleResult();
		double times = target / start;
		// double div=log(1+increaseRate);

		double period = log(times) / log(1 + increaseRate);
		result.setValue(period);

		return result;
	}

	public DoubleResult valueAtTargetTime(double start, double increaseRate, double time) throws Exception {

		if (Math.abs(increaseRate) < 0.000001) {
			throw new IllegalArgumentException(
					"calcCompoundInterest(double start, double increaseTo, double increaseRate): increaseRate can not be 0!!!");
		}
		DoubleResult result = new DoubleResult();

		double valueAtTargetTime = start * Math.pow(1 + increaseRate, time);

		result.setValue(valueAtTargetTime);

		return result;
	}

	public DoubleResult valueToday(double target, double years, double increaseRate) throws Exception {

		if (Math.abs(increaseRate) < 0.00000000001) {
			throw new IllegalArgumentException(
					"calcCompoundInterest(double start, double increaseTo, double increaseRate): increaseRate can not be 0!!!");
		}
		DoubleResult result = new DoubleResult();
		double valueToday = target * Math.pow(1 - increaseRate, years);
		// double div=log(1+increaseRate);
		result.setValue(valueToday);

		return result;
	}

	private double log(double d) {
		// TODO Auto-generated method stub
		return Math.log10(d);
	}
	
	public double expr(String expr) throws IOException{
		
		CalculatorService service = new CalculatorService();
		return service.calc(expr);
		
		
	}

	/*
	 * public CalculateResult fetchValue(URI uri, String name, int number)
	 * throws Exception{ CalculateResult result=new CalculateResult();
	 * result.setValue(number); return result; } public CalculateResult
	 * searchPerson(String name, int age) throws Exception{ CalculateResult
	 * result=new CalculateResult(); result.setValue(age); return result; }
	 * 
	 * public List<String> testListOfString() throws Exception{ List<String>
	 * list=new ArrayList<String>(); list.add("1"); list.add("2");
	 * list.add("3"); return list ; } public Map<String,String>
	 * testMapOfString() throws Exception{ Map<String,String> map=new
	 * HashMap<String,String>(); map.put("k1","v1"); map.put("k2","v2");
	 * 
	 * return map ; }
	 * 
	 * public List<String> testListOfStringArgOne(String name) throws Exception{
	 * List<String> list=new ArrayList<String>(); list.add("1"); list.add("2");
	 * list.add("3"); return list ; }
	 */

}