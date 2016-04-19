package telecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TeleCodeDict {
	static Map<Character, String> dict=null;
	static {
		try {
			dict = loadTeleCodeTable("chinese-tele-code.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getTelecode(String stringToCoding) throws IOException {

		StringBuilder sb = new StringBuilder();

		char[] chs = stringToCoding.toCharArray();

		for (char ch : chs) {
			sb.append(dict.get(ch) + " ");
		}
		return sb.toString();

	}

	protected static Map<Character, String> parseMap(String line, Map<Character, String> dicmap) {
		String[] values = line.split("\\s");
		// Map<String, String> dicmap=new HashMap<String,String>();

		int length = values.length;
		if (length != 16) {
			throw new IllegalArgumentException("Illegal line: " + line +", the length got: "+length);
		}

		for (int i = 0; i < length; i += 2) {
			char ch=values[i].charAt(0);
			dicmap.put(ch, values[i + 1]);

		}

		return dicmap;

	}

	protected static Map<Character, String> loadTeleCodeTable(String fileName) throws IOException {

		// ClassLoader classloader =
		// Thread.currentThread().getContextClassLoader();

		
		// ClassLoader classloader = this.getClass().getClassLoader();
		Map<Character, String> dicmap = new HashMap<Character, String>();
		InputStream is = TeleCodeDict.class.getResourceAsStream(fileName);

		if (is == null) {
			throw new IllegalArgumentException("Could not set up an input stream from resource: " + fileName);
		}		

		BufferedReader in = new BufferedReader(new InputStreamReader(is,"utf-8"));
		String str;
		while ((str = in.readLine()) != null) {
			parseMap(str, dicmap);
		}
		in.close();

		return dicmap;

	}
}
