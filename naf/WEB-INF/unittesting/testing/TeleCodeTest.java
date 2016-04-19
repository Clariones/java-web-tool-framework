package testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import telecode.TeleCodeDict;

public class TeleCodeTest extends TestCaseBase {


	public void test() throws IOException {
		Map<String, String> dict=this.loadDict("/resources/chinese-tele-code.txt");
		
		logln(dict.get("张"));
		logln(dict.get("喜"));
		logln(dict.get("来"));
		
		
		
	}
	
	@Test
	public void test2() throws IOException {
		TeleCodeDict service = new TeleCodeDict();
		logln(service.getTelecode("张喜来"));
		
		
	}
	
	public String getTelecode(String stringToCoding) throws IOException {
		
		Map<String, String> dict=this.loadDict("/resources/chinese-tele-code.txt");
		
		StringBuilder sb=new StringBuilder();
		
		char[] chs=stringToCoding.toCharArray();
		
		for(char ch:chs){
			sb.append(dict.get(ch)+" ");
		}
		return sb.toString();
		
		
	}
	
	protected Map<String, String> parseMap(String line, Map<String, String> dicmap)
	{
		String [] values=line.split("\\s");
		//Map<String, String> dicmap=new HashMap<String,String>();
		
		int length=values.length;
		if(length!=16){
			throw new IllegalArgumentException("Illegal line: "+ line);
			//logln("Illegal line: "+ line);
		}
		
		for(int i=0;i<length;i+=2){
			dicmap.put(values[i], values[i+1]);
			
		}
		
		return dicmap;
		
	}
	
	
	protected Map<String, String> loadDict(String fileName) throws IOException {

		//ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		
		//ClassLoader classloader = this.getClass().getClassLoader();
		Map<String, String> dicmap=new HashMap<String,String>();
		InputStream is = this.getClass().getResourceAsStream(fileName);
		
		
		if(is==null){
			throw new IllegalArgumentException("Could not set up an input stream from resource: "+fileName);
		}
		
		StringBuffer stringBuffer = new StringBuffer();

		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		String str;
		while ((str = in.readLine()) != null) {
			parseMap(str,dicmap);
			
			
			//stringBuffer.append(newLine());
		}
		in.close();

		return dicmap;

	}

}
