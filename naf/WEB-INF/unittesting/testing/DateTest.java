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
		
		String pattern = "^(13|15|18)[0-9]{9}$";
		
		assertTrue("should match","18699084765".matches(pattern));
		
		
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
