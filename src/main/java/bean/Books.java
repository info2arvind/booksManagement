package bean;


public class Books {
	private int bid;
	private String bname;	
	private long isbn;	
	private int price;	
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

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(String bname, long isbn, int price, String author) {
		super();
		this.bname = bname;
		this.isbn = isbn;
		this.price = price;
		this.author = author;
	}

	@Override
	public String toString() {
		return "Books [bname=" + bname + ", isbn=" + isbn + ", price=" + price
				+ ", author=" + author + "]";
	}
	
	
	
	

}
