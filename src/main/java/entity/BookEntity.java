package entity;

import javax.persistence.*;


@Entity
@NamedQueries({
	@NamedQuery(name="bookstore.findAll",query="SELECT c FROM BookEntity c"),
	@NamedQuery(name="bookstore.findByBid",query="SELECT c FROM BookEntity c WHERE c.bid = :bid"),
	@NamedQuery(name="bookstore.findByBname",query="SELECT c FROM BookEntity c WHERE c.bname = :bname"),
	@NamedQuery(name="bookstore.findByAuthor",query="SELECT c FROM BookEntity c WHERE c.author = :author"),
	@NamedQuery(name="bookstore.findByISBN",query="SELECT c FROM BookEntity c WHERE c.isbn = :isbn")
})
@Table(name="bookstore")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bid")
	private int bid;
	
	@Column(name="bname")
	private String bname;
	
	@Column(name="isbn")
	private long isbn;
	
	@Column(name="price")
	private int price;
	
	@Column(name="author")
	private String author;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookEntity(String bname, long isbn, int price, String author) {
		super();
		this.bname = bname;
		this.isbn = isbn;
		this.price = price;
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookEntity [bid=" + bid + ", bname=" + bname + ", isbn=" + isbn
				+ ", price=" + price + ", author=" + author + "]";
	}
	
	
	

}
