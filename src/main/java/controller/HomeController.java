package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import services.BookServices;
import services.CustomerServices;

import bean.Books;
import bean.Customer;

@Controller
/*@RequestMapping(value="/home.htm")*/
public class HomeController {
	
	@Autowired
	private BookServices bookServices;
	
	@Autowired
	private CustomerServices custServices;
	
	
	
	public CustomerServices getCustServices() {
		return custServices;
	}

	public void setCustServices(CustomerServices custServices) {
		this.custServices = custServices;
	}

	public BookServices getBookServices() {
		return bookServices;
	}

	public void setBookServices(BookServices bookServices) {
		this.bookServices = bookServices;
	}
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String processSubmit(Model model, HttpServletRequest request){
		List<Books> bookList = bookServices.getAllBookS();
		model.addAttribute("books", bookList);
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("UN");
		model.addAttribute("customer", obj);
		return "success";
		
	}

	@RequestMapping(value = "/saveData", method=RequestMethod.POST, produces="application/json")
	public @ResponseBody Books populateActivePSwapBasketPUT(Model model, Books books) {
		bookServices.saveBook(books);
		Books book = bookServices.getbookByName(books.getBname());
		book.setBid(books.getBid());
		book.setBname(books.getBname());
		book.setIsbn(books.getIsbn());
		book.setPrice(books.getPrice());
		book.setAuthor(books.getAuthor());
		return book;
	}
	
	@RequestMapping(value = "/delete/{bid}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteContact(@PathVariable("bid") int bid) {
		System.out.println("Tis is delete");
		System.out.println(bid);
		bookServices.deleteBook(bid);
	   return "book deleted";
	}
	
	@RequestMapping(value = "/getAllBook",  method=RequestMethod.GET, produces={"application/json"})
	public @ResponseBody List<Books> populateActivePSwapBasketGET() {		
		
		List<Books> list = bookServices.getAllBookS();
		return list;
	}
	
}
