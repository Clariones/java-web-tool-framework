package testing.org;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class SingleFileSplitter {

	protected void appendLine(BufferedWriter out, String line) throws IOException {
		// BufferedWriter out = new BufferedWriter(new
		// FileWriter("outfilename"));
		if(out==null){
			return;
		}
		if(line==null){
			return;
		}
		out.write(line);
		out.write(newLine());

	}

	protected String newLine() {
		// TODO Auto-generated method stub
		return "\r\n";
	}
	static  final String NEW_FILE_FLAG="@savefile: ";
	protected Boolean isNewFileLine(String line) {
		// TODO Auto-generated method stub
		return line.startsWith(NEW_FILE_FLAG);
	}
	
	protected String getFileName(String line) {
		// TODO Auto-generated method stub
		if(!isNewFileLine(line)){
			return null;
		}
		String fileNamePart=line.substring(NEW_FILE_FLAG.length());
		return fileNamePart;
	}
	
	protected void splitIntoFiles(URI uri, File directory) throws Exception {

		URLConnection conn;

		conn = uri.toURL().openConnection();

		if (!(conn instanceof HttpURLConnection)) {
			throw new IllegalArgumentException("The URI must be HTTP URI");
		}

		// HttpURLConnection httpConn = (HttpURLConnection) conn;

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		//StringBuilder content = new StringBuilder(1000);
		BufferedWriter out = null;
		
		int lines=0;
		while ((line = reader.readLine()) != null) {
			if(!isNewFileLine(line)){
				lines++;
				appendLine(out,line);
				continue;
			}
			if(out!=null){
				out.close();
			}
			File destFile=new File(directory,getFileName(line));
			if(destFile.exists()){
				destFile.delete();
			}
			boolean result=destFile.getParentFile().mkdirs();
			//System.out.println("file created: "+ result);
			out = new BufferedWriter(new FileWriter(destFile));
			log("save to file: "+destFile.getAbsolutePath());
			
		}
		log("totally "+lines+" lines generated");
		reader.close();
		if(out!=null){
			out.close();
		}
		

		// throw new IOException("重试次数超过"+count+"次，只好放弃了",lastException);

	}

	protected void log(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}
	
	protected static void doSplit(String objectToSplit, String destination) throws Exception
	{
		URI uri=new URI("http://localhost:8080/sky/javaweb/javaobj.jsp?name="+objectToSplit);
		File dir=new File(destination);
		new SingleFileSplitter().splitIntoFiles(uri, dir);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//doSplit("b2b","/opt/resin-3.1.12/webapps/naf/WEB-INF/");
		doSplit("cms","/opt/resin-3.1.12/webapps/naf/WEB-INF/");
	}

}
