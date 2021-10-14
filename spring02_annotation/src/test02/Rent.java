package test02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component //bean등록
public class Rent {
	
	@Autowired //의존성 자동주입
	private Book rentBook;
	
	public Rent() {
		// TODO Auto-generated constructor stub
	}

	public Rent(Book rentBook) {
		super();
		this.rentBook = rentBook;
	}

	public Book getRentBook() {
		return rentBook;
	}

	public void setRentBook(Book rentBook) {
		this.rentBook = rentBook;
	}

	@Override
	public String toString() {
		return "Rent [rentBook=" + rentBook + "]";
	}
	
	
	
	

}
