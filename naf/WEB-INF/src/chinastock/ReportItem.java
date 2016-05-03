package chinastock;

import java.util.LinkedList;
import java.util.List;

public class ReportItem implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limitedUp;
	private int limitedDown;
	
	private List<Record> limitedUpList;
	/**
	 * @return the limitedUpList
	 */
	public List<Record> getLimitedUpList() {
		if(limitedUpList==null){
			limitedUpList=new LinkedList<Record>();
		}
		return limitedUpList;
	}
	/**
	 * @param limitedUpList the limitedUpList to set
	 */
	public void setLimitedUpList(List<Record> limitedUpList) {
		this.limitedUpList = limitedUpList;
	}
	/**
	 * @return the limitedDownList
	 */
	public List<Record> getLimitedDownList() {
		if(limitedDownList==null){
			limitedDownList=new LinkedList<Record>();
		}
		return limitedDownList;
	}
	/**
	 * @param limitedDownList the limitedDownList to set
	 */
	public void setLimitedDownList(List<Record> limitedDownList) {
		this.limitedDownList = limitedDownList;
	}
	private List<Record> limitedDownList;
	
	/**
	 * @return the limitedUp
	 */
	public int getLimitedUp() {
		return limitedUp;
	}
	/**
	 * @param limitedUp the limitedUp to set
	 */
	public void setLimitedUp(int limitedUp) {
		this.limitedUp = limitedUp;
	}
	/**
	 * @return the limitedDown
	 */
	public int getLimitedDown() {
		return limitedDown;
	}
	/**
	 * @param limitedDown the limitedDown to set
	 */
	public void setLimitedDown(int limitedDown) {
		this.limitedDown = limitedDown;
	}
	
}
