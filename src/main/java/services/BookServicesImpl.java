package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bean.Books;

import dao.BookStoreDAO;

import entity.BookEntity;

public class BookServicesImpl implements BookServices{
	
	@Autowired
	private BookStoreDAO bookdao;

	public BookStoreDAO getBookdao() {
		return bookdao;
	}

	public void setBookdao(BookStoreDAO bookdao) {
		this.bookdao = bookdao;
	}

	@Override
	public List<Books> getAllBookS() {
		return bookdao.getAllBookSdao();
	}

	@Override
	public Books getBookById(int id) {
		
		return bookdao.getBookByIddao(id);
	}

	@Override
	public void deleteBook(int bid) {
		bookdao.deleteBookdao(bid);
		
	}

	@Override
	public void saveBook(Books book) {
		bookdao.saveBookdao(book);
		
	}

	@Override
	public Books getbookByName(String bname) {
		return bookdao.getbookByNamedao(bname);
	}

}
