package services;

import bean.Customer;

public interface CustomerServices {
	
	void addCustomer(Customer cust);
	boolean validatelogin(String uname, String pword);

}
