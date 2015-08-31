package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import services.BookServices;
import services.CustomerServices;

import bean.Books;
import bean.Customer;

@Controller
public class FormController {
	
	@Autowired
	private CustomerServices custServices;
	
	@Autowired
	private BookServices bookServices;
	
	public CustomerServices getCustServices() {
		return custServices;
	}

	public void setCustServices(CustomerServices custServices) {
		this.custServices = custServices;
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		return "redirect:/customer.htm";
	}*/

	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public String initForm(ModelMap model){
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "newCustomer";
	}
	
	@RequestMapping(value="/customer", method=RequestMethod.POST)
	public String processSubmit(@ModelAttribute("customer") Customer cust,Model model, SessionStatus status, HttpServletRequest request){
		
		Customer customer = new Customer();
		if(custServices.validatelogin(cust.getUname(), cust.getPword())){			
			status.setComplete();
			customer.setUname(cust.getUname());
			HttpSession session = request.getSession();
			session.setAttribute("UN", cust);
			return "redirect:/home";
		}
		
		return "newCustomer";
		
	}
	
	
	
	/*@RequestMapping(value = "/{bid}/edit", method = RequestMethod.GET)
	public String editContact(@PathVariable("bid") int bid, ModelMap model) {
		System.out.println("This is edit controller");
		System.out.println(bid);
	    Books book = bookServices.getBookById(bid);
	    System.out.println(book);

	    model.addAttribute("books", book);
	 
	    return null;
	}
	
	@RequestMapping(value = "/{bid}/delete", method = RequestMethod.POST)
	public String deleteContact(@PathVariable("bid") int bid, Model model) {
		System.out.println("This is delete controller");
	   System.out.println(bid);
	   return "success";
	}*/

}
