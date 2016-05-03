package chinastock;


import java.util.ArrayList;
import java.util.List;

public class Page implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2942680701341139985L;
	private int page;
	private int count;
	private String order;
	private int total;
	private int pagecount;
	private String time;
	private List<Record> list;
	
	/**
	 * @return the list
	 */
	public List<Record> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Record> list) {
		this.list = list;
	}
	/**
	 * @return the page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}
	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the pagecount
	 */
	public int getPagecount() {
		return pagecount;
	}
	/**
	 * @param pagecount the pagecount to set
	 */
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	public boolean isAllLimitedUp()
	{
		int length=this.getList().size();		
		return this.getList().get(length-1).getPERCENT()>=0.10;		
	}
	public boolean isEndOfLimitUpPage()
	{
		int length=this.getList().size();		
		return this.getList().get(length-1).getPERCENT()<0.05;		
	}
	public boolean isEndOfLimitDownPage()
	{
		int length=this.getList().size();		
		return this.getList().get(length-1).getPERCENT()>-0.05;		
	}
	public int getLimitUpCount()
	{		
		int counter=0;
		for(Record record:this.getList()){
			if(record.isLimitedUp()){
				counter++;
			}
		}
		return counter;
	}
	public List<Record> getLimitUpList()
	{		
		List<Record> list=new ArrayList<Record>();
		
		for(Record record:this.getList()){
			if(record.isLimitedUp()){
				list.add(record);
			}
		}
		return list;
		
	}
	public List<Record> getLimitDownList()
	{		
		List<Record> list=new ArrayList<Record>();		
		for(Record record:this.getList()){
			if(record.isLimitedDown()){
				list.add(record);
			}
		}
		return list;
		
	}
	public int getLimitDownCount()
	{		
		int counter=0;
		for(Record record:this.getList()){
			if(record.isLimitedDown()){
				counter++;
			}
		}
		return counter;
	}
}