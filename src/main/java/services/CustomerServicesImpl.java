package services;

import org.springframework.beans.factory.annotation.Autowired;

import dao.CustomerDAO;
import bean.Customer;

public class CustomerServicesImpl implements CustomerServices{
	
	@Autowired
	private CustomerDAO custdao;

	
	public CustomerDAO getCustdao() {
		return custdao;
	}

	public void setCustdao(CustomerDAO custdao) {
		this.custdao = custdao;
	}

	@Override
	public void addCustomer(Customer cust) {
		custdao.addCustomerdao(cust);
		
	}

	@Override
	public boolean validatelogin(String uname, String pword) {
		return custdao.validatelogindao(uname, pword);
	}

}
