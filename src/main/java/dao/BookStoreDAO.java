package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import bean.Books;

import entity.BookEntity;

public class BookStoreDAO extends BaseDAO{
	
	public List<Books> getAllBookSdao(){
		List<Books> list = new ArrayList<Books>();
		try{
			Query query=em.createNamedQuery("bookstore.findAll");
			List<BookEntity> listentity = query.getResultList();
			for(BookEntity be : listentity){
				list.add(returnBookFromBookEntity(be));
			}
			
		}catch(Exception e){
			System.err.println("unable to load data");
		}
		em.flush();
		return list;
		
	}
	
	public Books getBookByIddao(int id){
		Books book =new Books();
		try{
			book  = returnBookFromBookEntity(em.find(BookEntity.class, id));
			System.out.println(book);
		}catch(Exception e){
			System.err.println("Unable to load data");
		}
		return book;
	}
	
	public Books getbookByNamedao(String bname){
		Books book = new Books();
		try{
			Query query = em.createNamedQuery("bookstore.findByBname").setParameter("bname", bname);
			List<BookEntity> bookEntity= query.getResultList();
			for(BookEntity be : bookEntity){
				book = returnBookFromBookEntity(be);
			}
			
		}catch(Exception e){
			System.err.println("unable to load book");
		}
		return book;
	}
	
	private Books returnBookFromBookEntity(BookEntity be){
		Books book = new Books();
		book.setBid(be.getBid());
		book.setBname(be.getBname());
		book.setAuthor(be.getAuthor());
		book.setIsbn(be.getIsbn());
		book.setPrice(be.getPrice());
		return book;
	}
	
	public void deleteBookdao(int bid){
		try{
			BookEntity bookentity = em.find(BookEntity.class, bid);
			em.remove(bookentity);
		}catch(Exception e){
			System.err.println("unable to load data"+e.getMessage());
		}
	}
	
	public void saveBookdao(Books book){
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBname(book.getBname());
		bookEntity.setIsbn(book.getIsbn());
		bookEntity.setPrice(book.getPrice());
		bookEntity.setAuthor(book.getAuthor());
		try{
			if(validateBookId(book.getBid())){
				bookEntity.setBid(book.getBid());
				em.merge(bookEntity);
			}else{
				em.persist(bookEntity);
			}
		}catch(Exception e){
			System.err.println("Unable to save book data"+e.getMessage());
		}
	}
	
	public boolean validateBookId(int bid){
		boolean flag=false;
		try{
			BookEntity bookEntity = em.find(BookEntity.class, bid);
			if(bookEntity!=null){
				flag=true;
			}
		}catch(Exception e){
			System.err.println("Unable to load data");
		}
		
		return flag;
	}
	
}
