package chinastock;

import java.text.DecimalFormat;

public class Record implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6811370914972980479L;
	private String CODE;
	private String NAME;
	private String SYMBOL;
	private double PERCENT;
	private double PRICE;
	/**
	 * @return the cODE
	 */
	public String getCODE() {
		return CODE;
	}
	/**
	 * @param cODE the cODE to set
	 */
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	/**
	 * @return the nAME
	 */
	public String getNAME() {
		return NAME;
	}
	/**
	 * @param nAME the nAME to set
	 */
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	/**
	 * @return the sYMBOL
	 */
	public String getSYMBOL() {
		return SYMBOL;
	}
	/**
	 * @param sYMBOL the sYMBOL to set
	 */
	public void setSYMBOL(String sYMBOL) {
		SYMBOL = sYMBOL;
	}
	/**
	 * @return the pERCENT
	 */
	public double getPERCENT() {
		return PERCENT;
	}
	/**
	 * @param pERCENT the pERCENT to set
	 */
	public void setPERCENT(double pERCENT) {
		PERCENT = pERCENT;
	}
	/**
	 * @return the pRICE
	 */
	public double getPRICE() {
		return PRICE;
	}
	/**
	 * @param pRICE the pRICE to set
	 */
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	
	public boolean isLimitedUp()
	{
		if(this.getNAME().indexOf("ST")<0){
			return this.getPERCENT()>=0.10;
		}
		return this.getPERCENT()>=0.05;
				
	}
	public boolean isLimitedDown()
	{
		if(this.getNAME().indexOf("ST")<0){
			return this.getPERCENT()<=-0.10;
		}
		return this.getPERCENT()<=-0.05;				
	}
	public String toString()
	{
		return this.getSYMBOL()+"\t"+this.getNAME()+": "+getPercentExpr();
		
		
	}
	public String getPercentExpr()
	{
		DecimalFormat formatter = new DecimalFormat("00.00");
		return formatter.format(this.getPERCENT()*100)+"%";
		
		
	}
	
}
