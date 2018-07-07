package com.cg.mypaymentapp.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InvalidInputException;

public class WalletRepoImpl implements WalletRepo{

	private Map<String, Customer> data; 
	{
		data = new HashMap<>();
	}
	
	public Map<String, Customer> getData() {
		return data;
	}

	public void setData(Map<String, Customer> data) {
		this.data = data;
	}
	Customer cust = new Customer();
	public WalletRepoImpl(Map<String, Customer> data) {
	super();
	this.data = data;
}
	public WalletRepoImpl() {
		
	}
	@Override
	public boolean save(Customer customer) {
		// TODO Auto-generated method stub
		String mobileno = customer.getMobileNo();
		data.put(mobileno, customer);
		return true;
		
	}
	@Override
	public Customer findOne(String mobileNo) {
		// TODO Auto-generated method stub
		cust = data.get(mobileNo);
		if(cust == null) throw new InvalidInputException("Account not found");
		else return cust;
	}
	


	

}
