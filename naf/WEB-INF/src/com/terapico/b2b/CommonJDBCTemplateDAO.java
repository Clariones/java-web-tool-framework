package com.terapico.b2b;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class CommonJDBCTemplateDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public JdbcTemplate getJdbcTemplateObject() {
		return jdbcTemplateObject;
	}

	public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
		this.jdbcTemplateObject = jdbcTemplateObject;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);

		jdbcTemplateObject.setFetchSize(1000);
	}
	static boolean inCloseCharRang(char test, char start, char end) {
		if (test < start) {
			return false;
		}
		if (test > end) {
			return false;
		}
		return true;
	}
	static Object[] parse(String maxId) {
		
		if(maxId==null){
			return new Object[]{"USER",1L};
		}
		
		Object ret[] = new Object[2];
		StringBuilder prefixBuffer = new StringBuilder();
		StringBuilder numberBuffer = new StringBuilder();

		char[] chs = maxId.toCharArray();
		for (char ch : chs) {
			
			if(inCloseCharRang(ch,'A','Z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'a','z')){
				prefixBuffer.append(ch);
				continue;
			}
			if(inCloseCharRang(ch,'0','9')){
				numberBuffer.append(ch);
				continue;
			}

		}
		ret[0] = prefixBuffer.toString();
		String numberExpr=numberBuffer.toString();
		if(numberExpr.isEmpty()){
			ret[1] = 0L;
			return ret;
		}
		
		ret[1] = Long.parseLong(numberExpr);
		return ret;

	}
	
	//static final String ID_FORMAT="USER%06d"; 
	private long currentMax=-1;
	protected String getNextId()
	{
		if(currentMax > 0){
			return String.format(getIdFormat(),++currentMax);
		}
		try {
			String SQL = "select max(id) from "+getName()+"_data";
			String maxId = getJdbcTemplateObject().queryForObject(SQL, String.class);
			if(maxId==null){
				return  String.format(getIdFormat(),1);
			}
			
			Object ret[]=parse(maxId);
			currentMax = (Long)ret[1]+1;
			return String.format(getIdFormat(),currentMax);
			
			//return  String.format(ID_FORMAT,1);
			//return student;
		} catch (EmptyResultDataAccessException e) {
			return  String.format(getIdFormat(),1);
		}
	}
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	
	public static String getShortName(String name) {
		String ar[] = name.split("_");
		String ret = ar[0].substring(0, 1).toUpperCase();

		for (int i = 1; i < ar.length; i++) {
			ret +=ar[i].substring(0, 1).toUpperCase();
				
		}
		return ret;
	}
	protected String getIdColumnName()
	{
		return "id";
	}
	
	protected String getVersionColumnName()
	{
		return "version";
	}
	abstract protected String[] getNormalColumnNames();
	
	abstract protected String getName();
	protected String getTableName(){
		return this.getName()+"_data";
	}
	protected String getCreateSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("insert into ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append("(id,");
		stringBuilder.append(join());
		stringBuilder.append(",version)values(?,");
		stringBuilder.append(getCreateParametersPlaceHolders());
		stringBuilder.append(",1);");
		
		return stringBuilder.toString();
		//return ++"("++")values("+getCreateParametersPlaceHolder()+")"；
		
	}
	
	protected String getDeleteSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("delete from  ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" where id= ? and version =?;");
			
		return stringBuilder.toString();
		//return ++"("++")values("+getCreateParametersPlaceHolder()+")"；
		
	}

	protected String getUpdateSQL() {
		// TODO Auto-generated method stub
		//return new String[]{"name","bize_order","card_number","billing_address"};
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("update ");
		stringBuilder.append(this.getTableName());
		stringBuilder.append(" set ");
		stringBuilder.append(joinUpdate());
		stringBuilder.append(",version = version+1 ");
		
		stringBuilder.append("where id=? and version=?");
		
		return stringBuilder.toString();
		//return ++"("++")values("+getCreateParametersPlaceHolder()+")"；
		
	}
	
	
	
	protected String getCreateParametersPlaceHolders() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){//version is an constant
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	
	
	protected String getUpdateParametersPlaceHolders() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return null;
	}

	protected String joinUpdateParametersPlaceHolders() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=getNormalColumnNames().length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	protected String joinPlaceHolders(String []parameters) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		int length=parameters.length;
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append("?");
		}
		return stringBuilder.toString();
	}
	
	protected String join() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		String columNames[]=getNormalColumnNames();
		int length=columNames.length;
		
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append(columNames[i]);
		}
		
		return stringBuilder.toString();
	}
	protected String joinUpdate() {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder=new StringBuilder();
		String columNames[]=getNormalColumnNames();
		int length=columNames.length;
		
		for(int i=0;i<length;i++ ){
			if(i>0){
				stringBuilder.append(",");
			}
			stringBuilder.append(columNames[i]+" = ? ");
		}
		
		return stringBuilder.toString();
	}
	
	
}
