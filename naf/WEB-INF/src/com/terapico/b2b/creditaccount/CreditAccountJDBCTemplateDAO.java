
package com.terapico.b2b.creditaccount;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import com.terapico.b2b.CommonJDBCTemplateDAO;
import com.terapico.b2b.buyercompany.BuyerCompany;
import com.terapico.b2b.sellercompany.SellerCompany;

import com.terapico.b2b.sellercompany.SellerCompanyDAO;
import com.terapico.b2b.buyercompany.BuyerCompanyDAO;


import org.springframework.dao.EmptyResultDataAccessException;

public class CreditAccountJDBCTemplateDAO extends CommonJDBCTemplateDAO implements CreditAccountDAO{
 
 	
 	private  BuyerCompanyDAO  buyerCompanyDAO;
 	public void setBuyerCompanyDAO(BuyerCompanyDAO buyerCompanyDAO){
	 	this.buyerCompanyDAO = buyerCompanyDAO;
 	}
 	public BuyerCompanyDAO getBuyerCompanyDAO(){
	 	return this.buyerCompanyDAO;
 	}
 
 	
 	private  SellerCompanyDAO  sellerCompanyDAO;
 	public void setSellerCompanyDAO(SellerCompanyDAO sellerCompanyDAO){
	 	this.sellerCompanyDAO = sellerCompanyDAO;
 	}
 	public SellerCompanyDAO getSellerCompanyDAO(){
	 	return this.sellerCompanyDAO;
 	}

		

	public CreditAccount load(String creditAccountId,Map<String,Object> options) throws Exception{
		return loadInternalCreditAccount(creditAccountId, options);
	}
	public CreditAccount save(CreditAccount creditAccount,Map<String,Object> options){
		
		String methodName="save(CreditAccount creditAccount,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(creditAccount, methodName, "creditAccount");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalCreditAccount(creditAccount,options);
	}
	public CreditAccount clone(String creditAccountId,Map<String,Object> options) throws Exception{
	
		String methodName="clone(String creditAccountId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(creditAccountId, methodName, "creditAccountId");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		CreditAccount newCreditAccount = load(creditAccountId, options);
		newCreditAccount.setVersion(0);
		
		
		
		saveInternalCreditAccount(newCreditAccount,options);
		
		return newCreditAccount;
	}
	public int deleteAll() throws Exception{
	
		String methodName="deleteAll()";
		
		String SQL=this.getDeleteAllSQL();
		int affectedNumber = getJdbcTemplateObject().update(SQL);
		return affectedNumber;
		
	
	}
	
	protected void handleDeleteOneError(String creditAccountId, int version) throws  CreditAccountVersionChangedException,  CreditAccountNotFoundException {
		// the version has been changed, the client should reload it and ensure
		// this can be deleted
		String SQL = "select count(1) from " + this.getTableName() + " where id = ? ";
		Object[]  parameters = new Object[]{creditAccountId};
		int count = getJdbcTemplateObject().queryForObject(SQL, Integer.class, parameters);
		if (count == 1) {
			throw new CreditAccountVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CreditAccountNotFoundException(
					"The " + this.getTableName() + "(" + creditAccountId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	public void delete(String creditAccountId, int version) throws Exception{
	
		String methodName="delete(String creditAccountId, int version)";
		assertMethodArgumentNotNull(creditAccountId, methodName, "creditAccountId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{creditAccountId,version};
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(creditAccountId,version);
		}
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {
		
		return new String[]{"name","buyer","seller","authorized","remain"};
	}
	@Override
	protected String getName() {
		
		return "credit_account";
	}
	
	
	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
		if(options==null){
 			return false;
 		}
 		if(options.containsKey(optionToCheck)){
 			options.remove(optionToCheck);//consume the key, can not use any more to exactract the data.
 			return true;
 		}
 		if(options.containsKey(ALL)){
 			return true;
 		}
 		return false;
	
	}

 
 	//private boolean extractBuyerEnabled = true;
 	//private static final String BUYER = "buyer";
 	protected boolean isExtractBuyerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CreditAccountTokens.BUYER);
 	}
 	
 	
 	//private boolean saveBuyerEnabled = true;
 	protected boolean isSaveBuyerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CreditAccountTokens.BUYER);
 	}
 	

 	
  
 	//private boolean extractSellerEnabled = true;
 	//private static final String SELLER = "seller";
 	protected boolean isExtractSellerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CreditAccountTokens.SELLER);
 	}
 	
 	
 	//private boolean saveSellerEnabled = true;
 	protected boolean isSaveSellerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CreditAccountTokens.SELLER);
 	}
 	

 	
 
		
	

	protected CreditAccountMapper getMapper(){
		return new CreditAccountMapper();
	}
	protected CreditAccount extractCreditAccount(String creditAccountId) throws Exception{
		String SQL = "select * from credit_account_data where id=?";	
		try{
		
			CreditAccount creditAccount = getJdbcTemplateObject().queryForObject(SQL, new Object[]{creditAccountId}, getMapper());
			return creditAccount;
		}catch(EmptyResultDataAccessException e){
			throw new CreditAccountNotFoundException("CreditAccount("+creditAccountId+") is not found!");
		}
		
		
	}

	protected CreditAccount loadInternalCreditAccount(String creditAccountId, Map<String,Object> loadOptions) throws Exception{
		
		CreditAccount creditAccount = extractCreditAccount(creditAccountId);
 	
 		if(isExtractBuyerEnabled(loadOptions)){
	 		extractBuyer(creditAccount, loadOptions);
 		}
  	
 		if(isExtractSellerEnabled(loadOptions)){
	 		extractSeller(creditAccount, loadOptions);
 		}
 
		
		return creditAccount;
		
	}
	
	
	 

 	protected CreditAccount extractBuyer(CreditAccount creditAccount, Map<String,Object> options) throws Exception{

		if(creditAccount.getBuyer() == null){
			return creditAccount;
		}
		String buyerId = creditAccount.getBuyer().getId();
		if( buyerId == null){
			return creditAccount;
		}
		BuyerCompany buyer = getBuyerCompanyDAO().load(buyerId,options);
		if(buyer != null){
			creditAccount.setBuyer(buyer);
		}
		
 		
 		return creditAccount;
 	}
 		
  

 	protected CreditAccount extractSeller(CreditAccount creditAccount, Map<String,Object> options) throws Exception{

		if(creditAccount.getSeller() == null){
			return creditAccount;
		}
		String sellerId = creditAccount.getSeller().getId();
		if( sellerId == null){
			return creditAccount;
		}
		SellerCompany seller = getSellerCompanyDAO().load(sellerId,options);
		if(seller != null){
			creditAccount.setSeller(seller);
		}
		
 		
 		return creditAccount;
 	}
 		
 
		
		
  	
 	public List<CreditAccount> findCreditAccountByBuyer(String buyerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where buyer = ?";
		List<CreditAccount> creditAccountList = getJdbcTemplateObject().query(SQL, new Object[]{buyerCompanyId}, getMapper());
		
 	
 		return creditAccountList;
 	}
  	
 	public List<CreditAccount> findCreditAccountBySeller(String sellerCompanyId){
 	
 		String SQL = "select * from "+this.getTableName()+" where seller = ?";
		List<CreditAccount> creditAccountList = getJdbcTemplateObject().query(SQL, new Object[]{sellerCompanyId}, getMapper());
		
 	
 		return creditAccountList;
 	}
 	
		
		
		
	

	protected CreditAccount saveCreditAccount(CreditAccount  creditAccount){
	
		String SQL=this.getSaveCreditAccountSQL(creditAccount);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCreditAccountParameters(creditAccount);
		int affectedNumber = getJdbcTemplateObject().update(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		int newVersion = creditAccount.getVersion() + 1;
		creditAccount.setVersion(newVersion);
		return creditAccount;
	
	}
	public List<CreditAccount> saveList(List<CreditAccount> creditAccountList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCreditAccountList(creditAccountList);
		
		batchCreate((List<CreditAccount>)lists[CREATE_LIST_INDEX]);
		
		batchUpdate((List<CreditAccount>)lists[UPDATE_LIST_INDEX]);

		return creditAccountList;
	}

	
	protected List<Object[]> prepareBatchCreateArgs(List<CreditAccount> creditAccountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CreditAccount creditAccount:creditAccountList ){
			Object [] parameters = prepareCreateCreditAccountParameters(creditAccount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareBatchUpdateArgs(List<CreditAccount> creditAccountList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CreditAccount creditAccount:creditAccountList ){
			Object [] parameters = prepareUpdateCreditAccountParameters(creditAccount);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchCreate(List<CreditAccount> creditAccountList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareBatchCreateArgs(creditAccountList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
	}
	
	
	protected void batchUpdate(List<CreditAccount> creditAccountList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareBatchUpdateArgs(creditAccountList);
		
		int affectedNumbers[] = getJdbcTemplateObject().batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitCreditAccountList(List<CreditAccount> creditAccountList){
		
		List<CreditAccount> creditAccountCreateList=new ArrayList<CreditAccount>();
		List<CreditAccount> creditAccountUpdateList=new ArrayList<CreditAccount>();
		
		for(CreditAccount creditAccount: creditAccountList){
			if(isUpdateRequest(creditAccount)){
				creditAccountUpdateList.add( creditAccount);
				continue;
			}
			creditAccountCreateList.add(creditAccount);
		}
		
		return new Object[]{creditAccountCreateList,creditAccountUpdateList};
	}
	
	protected boolean isUpdateRequest(CreditAccount creditAccount){
 		return creditAccount.getVersion() > 0;
 	}
 	protected String getSaveCreditAccountSQL(CreditAccount creditAccount){
 		if(isUpdateRequest(creditAccount)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveCreditAccountParameters(CreditAccount creditAccount){
 		if(isUpdateRequest(creditAccount) ){
 			return prepareUpdateCreditAccountParameters(creditAccount);
 		}
 		return prepareCreateCreditAccountParameters(creditAccount);
 	}
 	protected Object[] prepareUpdateCreditAccountParameters(CreditAccount creditAccount){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = creditAccount.getName(); 	
 		if(creditAccount.getBuyer() != null){
 			parameters[1] = creditAccount.getBuyer().getId();
 		}
  	
 		if(creditAccount.getSeller() != null){
 			parameters[2] = creditAccount.getSeller().getId();
 		}
 
 		parameters[3] = creditAccount.getAuthorized();
 		parameters[4] = creditAccount.getRemain();		
 		parameters[5] = creditAccount.getId();
 		parameters[6] = creditAccount.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareCreateCreditAccountParameters(CreditAccount creditAccount){
		Object[] parameters = new Object[6];
		String newCreditAccountId=getNextId();
		creditAccount.setId(newCreditAccountId);
		parameters[0] =  creditAccount.getId();
 
 		parameters[1] = creditAccount.getName(); 	
 		if(creditAccount.getBuyer() != null){
 			parameters[2] = creditAccount.getBuyer().getId();
 		
 		}
 		 	
 		if(creditAccount.getSeller() != null){
 			parameters[3] = creditAccount.getSeller().getId();
 		
 		}
 		
 		parameters[4] = creditAccount.getAuthorized();
 		parameters[5] = creditAccount.getRemain();		
 				
 		return parameters;
 	}
 	
	protected CreditAccount saveInternalCreditAccount(CreditAccount creditAccount, Map<String,Object> options){
		
		saveCreditAccount(creditAccount);
 	
 		if(isSaveBuyerEnabled(options)){
	 		saveBuyer(creditAccount, options);
 		}
  	
 		if(isSaveSellerEnabled(options)){
	 		saveSeller(creditAccount, options);
 		}
 
		
		return creditAccount;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected CreditAccount saveBuyer(CreditAccount creditAccount, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getBuyerCompanyDAO().save(creditAccount.getBuyer(),options);
 		return creditAccount;
 		
 	}
	
  
 
 	protected CreditAccount saveSeller(CreditAccount creditAccount, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		getSellerCompanyDAO().save(creditAccount.getSeller(),options);
 		return creditAccount;
 		
 	}
	
 
		

	
}


