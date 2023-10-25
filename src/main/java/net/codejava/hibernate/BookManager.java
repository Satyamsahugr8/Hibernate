package net.codejava.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookManager {

	protected SessionFactory sessionFactory;
	protected Session session;

	protected void setup() {
		// code to load Hibernate Session factory

		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

	}

	protected void exit() {
		// code to close Hibernate Session factory
		sessionFactory.close();

	}

	protected void create() {
		// code to save a book

//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();

		Book book = new Book();
		
//		book.setTitle("Effective Java");
//		book.setAuthor("Joshua Bloch");
//		book.setPrice(32.59f);
		
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);

		session.save(book);

		session.getTransaction().commit();
		session.close();

	}

	protected void read() {
		// code to get a book
		session = sessionFactory.openSession();

		long bookId = 1;
		Book book = session.get(Book.class, bookId);
		

		System.out.println("Book_Id" + book.getId());
		System.out.println("Title: " + book.getTitle());
		System.out.println("Author: " + book.getAuthor());
		System.out.println("Price: " + book.getPrice());

		session.close();
	}

	protected void update() {
		// code to modify a book
		Book book = new Book();
		book.setId(1);
		book.setTitle("Ultimate Java Programming");
		book.setAuthor("Nam Ha Minh");
		book.setPrice(19.99f);

//		book.setId(1);
//		book.setTitle("Effective Java");
//		book.setAuthor("Joshua Bloch");
//		book.setPrice(32.59f);
		
		session.update(book);

		session.getTransaction().commit();
		session.close();
	}

	protected void delete() {
		// code to remove a book
		Book book = new Book();
	    book.setId(2);
	 
	    session.delete(book);
	 
	    session.getTransaction().commit();
	    session.close();
	}

	public static void main(String[] args) {
		// code to run the program

		BookManager manager = new BookManager();

		manager.setup();

		manager.create();

//		manager.read();
		
//		manager.update();
		
//		manager.delete();

		manager.exit();

	}
}