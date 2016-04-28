package com.terapico.caf;

import java.util.ArrayList;
import java.util.List;

import com.terapico.naf.baseelement.MenuItem;

public class Navigator {
	
	List<MenuItem> menuItems;
	List<String> beanList;
	private String selectBeanName;


	public String getSelectBeanName() {
		return selectBeanName;
	}

	
	public void setSelectBeanName(String selectBeanName) {
		this.selectBeanName = selectBeanName;
	}

	public List<MenuItem> getMenuItems() {
		
		
		if(menuItems==null){
			menuItems=new ArrayList<MenuItem>();
		}
		return menuItems;

	}
	
	public List<String> getBeanList() {
		
		if(beanList==null){
			beanList=new ArrayList<String>();
		}
		
		return beanList;
	}

	public void setBeanList(List<String> beanList) {
		this.beanList = beanList;
	}
	
	public void addToBeanList(String value) {
		getBeanList().add(value);
	}
	public void addToBeanList(String []values) {
		for(String value:values){
			getBeanList().add(value);
		}
		
	}
	
	
	
	public void setBeanList(String []beanList) {
		//this.beanList = beanList;
	}

	public void addItem(MenuItem item) {
		getMenuItems().add(item);
	}

	public void addItem(String beanName, String methodName) {
		getMenuItems().add(createItem(beanName,methodName));
	}
	
	protected MenuItem createItem(String beanName, String methodName){
		MenuItem item=createEmtryItem();
		item.setBeanName(beanName);
		item.setLink(methodName);
		return item;
		
	}
	
	protected MenuItem createEmtryItem(){
		MenuItem item=new MenuItem();
		return item;
		
	}
	
	public void setMenuItems(List<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public void setSelectBean(String selectedBean) {
		// TODO Auto-generated method stub
		this.selectBeanName=selectedBean;
	}
	
}
