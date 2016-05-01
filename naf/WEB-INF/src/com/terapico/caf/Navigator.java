package com.terapico.caf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.terapico.naf.baseelement.MenuItem;

public class Navigator {
	
	List<MenuItem> menuItems;
	List<String> beanList;
	private String selectBeanName;
	private String beanExpr;


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
		
		Collections.sort(this.menuItems, new Comparator<MenuItem>() {
			public int compare(MenuItem item1, MenuItem item2) {			
				return item1.getMethodName().compareTo(item2.getMethodName());
			}
		});
		
		return menuItems;

	}
	
	public List<String> getBeanList() {
		
		if(beanList==null){
			beanList=new ArrayList<String>();
		}
		
		Collections.sort(this.beanList);
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


	public void setBeanExpr(String beanExpr) {
		// TODO Auto-generated method stub
		this.beanExpr=beanExpr;
	}


	public String getBeanExpr() {
		return beanExpr;
	}


	public void addItems(List<MenuItem> items) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
