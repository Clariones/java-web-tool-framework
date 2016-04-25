package com.terapico.naf;

public class SimpleMethod {
	private String name;

	public String getName() {
		return name;
	}

	public String getFriendName() {
		
		char [] chs=name.toCharArray();
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<chs.length;i++){
			char ch=chs[i];
			if(i==0){
				sb.append((ch+"").toUpperCase());
				continue;
			}
			
			if(isUpperCase(ch)){
				if(i>0){
					char prevchar=chs[i-1];
					if(isUpperCase(prevchar)){
						sb.append(ch);
						continue;
					}
				}
				sb.append(" ");
			}
			sb.append(ch);
			
		}

		return sb.toString();
	}
	
	public boolean isUpperCase(char ch)
	{
		
		return ch>='A'&&ch<='Z';
		
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
