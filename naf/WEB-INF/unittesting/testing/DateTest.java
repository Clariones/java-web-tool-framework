package testing;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.terapico.caf.DateTime;

public class DateTest {

	@Test
	public void test() throws ParseException {
		String defaultFormat = "yyyy-MM-dd";
		
		DateFormat formatter = new SimpleDateFormat(defaultFormat);
		DateTime dateTime = new DateTime();
		java.util.Date date = formatter.parse("2009-12-09");
		dateTime.setTime(date.getTime());
		System.out.println(date);
		
	}
	@Test
	public void test2() throws ParseException {
		//String defaultFormat = "yyyy-MM-DD";
		
		DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		DateTime dateTime = new DateTime();
		java.util.Date date = formatter.parse("2009/12/09");
		dateTime.setTime(date.getTime());
		System.out.println(date);
		
	}
	
	

}
