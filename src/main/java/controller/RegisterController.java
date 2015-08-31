package controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.CustomerServices;
import services.CustomerServicesImpl;
import validation.RegisterValidator;

import dao.CustomerDAO;

import bean.Customer;



@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private CustomerServices custServices;
	
	private RegisterValidator registerValidator;	

	
	@Autowired
	public RegisterController(RegisterValidator registerValidator) {
		this.registerValidator = registerValidator;
	}

	public CustomerServices getCustServices() {
		return custServices;
	}

	public void setCustServices(CustomerServices custServices) {
		this.custServices = custServices;
	}

	@RequestMapping(method=RequestMethod.GET)
	public String init(ModelMap model){
		Customer cust = new Customer();
		cust.setWebFramework(new String[]{"Spring MVC"});
		
		//Make "Make" as default radio button selected value
	//	cust.setCountry(country)
		cust.setGender("m");
		//command object
		model.addAttribute("customer", cust);
		return "registration";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String registrationSuccess(@ModelAttribute("customer") Customer cust, BindingResult result){
	
		registerValidator.validate(cust, result);
				
		if(result.hasErrors()){
			return "registration";
		}
		
		custServices.addCustomer(cust);
		
		return "newCustomer";
	}
	
	@ModelAttribute("webFramework")
	public List<String> populateModelFramework(){
		List<String> list =new ArrayList<String>();
		list.add("struts1");
		list.add("hibernate");
		list.add("spring");
		list.add("webServices");
		return list;
	}
	
	@ModelAttribute("countryList")
	public Map<String,String> populateCountryList() {
		
		//Data referencing for java skills list box
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		
		return country;
	}
	
	@ModelAttribute("numberList")
	public List<String> populateNumberList() {
		
		//Data referencing for number radiobuttons
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");
		
		return numberList;
	}
}
