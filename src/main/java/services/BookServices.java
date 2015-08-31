package services;

import java.util.List;

import bean.Books;

import entity.BookEntity;

public interface BookServices {
	
	List<Books> getAllBookS();
	Books getBookById(int id);
	void deleteBook(int bid);
	void saveBook(Books book);
	Books getbookByName(String bname);
}
