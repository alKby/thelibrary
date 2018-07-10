package com.benfante.javacourse.thelibrary.core.model;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Library {	
	
	private static File libraryF = null;
	//private static final Logger log = LoggerFactory.getLogger(Book.class);
	private static List <Book> books = new LinkedList<> ();
	static BookCompare bec;
	static BookTitleComparator btc = new BookTitleComparator();
	static BookIsbnComparator bic = new BookIsbnComparator();
	static Library lib = new Library();
	static Map<String , Collection<Book>> map = new HashMap<>();
	static Map<Author , Collection<Book>> map2 = new HashMap<>();
	static Map<String , Book> map3 = new HashMap<>();
	public Library() {
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		libraryF = new File(lib.getClass().getResource("/books.dat").getFile());
		
		if(!libraryF.exists()) {
			libraryF.createNewFile();
		}
		libraryF.createNewFile();
		aggiuntaDaTastiera();
		storeArchive();
		loadArchive();
		System.out.println(lib.toString());
		
	}
	
	public static void storeArchive() throws IOException{
		ObjectOutputStream os = new ObjectOutputStream( new BufferedOutputStream(new FileOutputStream(libraryF)));
			os.writeObject(books);
		os.close();
	}
	
	@SuppressWarnings("unchecked")
	public static void loadArchive() throws IOException, ClassNotFoundException , FileNotFoundException{	
		ObjectInputStream is = new ObjectInputStream( new BufferedInputStream(new FileInputStream(libraryF)));
		books.addAll((Collection<Book>)is.readObject());
		is.close();
	}
	
	public static void loadArchive(InputStream isx) throws IOException, ClassNotFoundException , FileNotFoundException{	
		ObjectInputStream is = new ObjectInputStream( new BufferedInputStream(isx));
		List <Book> temp = new LinkedList<>();
		temp.add((Book) is.readObject()); 
		if(temp != null){
			books = temp;
		}
		is.close();
	}
		
	public  static void inputDaFile(){
		int idB = 0 , idA = 0 , idP = 0, cti=0;
		BigDecimal price = BigDecimal.valueOf(0);
		String nameA="",lastNameA="",nameP="",title="",ct="";
		Author author;
		Publisher publisher;
		try (InputStream is = lib.getClass().getResourceAsStream("/books.txt"); Scanner scan = new Scanner(is);){
			scan.useLocale(Locale.ENGLISH);
			while(idB != -1) {
				System.out.print("\nInserimento Id libro");
				idB = scan.nextInt();
				if(idB == -1) break;
				scan.nextLine();
				System.out.print("\nInserimento titolo libro");
				title = scan.nextLine();
				System.out.print("\nInserimento prezzo libro");
				price = scan.nextBigDecimal();
				scan.nextLine();
				List <Author> authors = new LinkedList<>();
				Book book = new Book(idB,title,authors,price);
				do{
					System.out.print("\nInserimento id autore");
					idA = scan.nextInt();
					scan.nextLine();
					if(idA == -1) break;
					System.out.print("\nInserimento nome autore");
					nameA = scan.nextLine();
					System.out.print("\nInserimento cognome autore");
					lastNameA = scan.nextLine();
					author = new Author(idA,nameA,lastNameA);
					book.addAuthor(author);
				}while(idA != -1);
				do {
					System.out.print("\nInserimento categoria/e");
					for(int i = 0 ; i <BookCategory.values().length; i++) {
						System.out.print("\n("+(i+1)+")"+BookCategory.values()[i]);
					}
					System.out.println();
					ct = scan.nextLine();
					if(ct.equals("x")) break;
					cti = Integer.parseInt(ct);
					book.addCategory(BookCategory.values()[cti-1]);
				}while(!ct.equals("x"));

				System.out.print("\nInserimento id editore: ");
				idP = scan.nextInt();
				scan.nextLine();
				System.out.print("\nInserimento nome editore: ");
				nameP = scan.nextLine();
				publisher = new Publisher(idP , nameP);
				book.addPublisher(publisher);
				lib.addBook(book);
			}
			}
		catch(IOException ioe){
			
		}finally {
			System.out.println(lib.toString()+"\n");
		}
}
	
	public static void aggiuntaDaTastiera() {
		int idB = 0 , idA = 0 , idP = 0, cti;
		BigDecimal price;
		String nameA,lastNameA,nameP,title,ct;
		Author author;
		Publisher publisher;
		
		try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
			
			while(idB != -1) {
				System.out.print("\nInserisci l'Id del libro: ");
				idB = Integer.parseInt(bf.readLine());
				if(idB == -1) break;
				System.out.print("\nInserisci il titolo del libro: ");
				title = bf.readLine();
				System.out.print("\nInserisci il prezzo del libro: ");
				price = BigDecimal.valueOf(Double.parseDouble(bf.readLine()));
				List <Author> authors = new LinkedList<>();
				Book book = new Book(idB,title,authors ,price);
				do{
					System.out.print("\nInserisci id autore: ");
					idA = Integer.parseInt(bf.readLine());
					if(idA == -1) break;
					System.out.print("\nInserisci nome autore: ");
					nameA = bf.readLine();
					System.out.print("\nInserisci cognome autore: ");
					lastNameA = bf.readLine();
					author = new Author(idA,nameA,lastNameA);
					book.addAuthor(author);
				}while(idA != -1);
				
				do {
					System.out.print("\nInserisci una categoria: ");
					for(int i = 0 ; i <BookCategory.values().length; i++) {
						System.out.print("\n("+(i+1)+")"+BookCategory.values()[i]);
					}
					System.out.println("\n(X)Exit.");
					System.out.println();
					ct = bf.readLine();
					if(ct.equals("x")) break;
					cti = Integer.parseInt(ct);
					book.addCategory(BookCategory.values()[cti-1]);
				}while(!ct.equals("x"));

				System.out.print("\nInserisci l'id dell'editore: ");
				idP = Integer.parseInt(bf.readLine());
				System.out.print("\nInserisci nome editore: ");
				nameP = bf.readLine();
				publisher = new Publisher(idP , nameP);
				book.addPublisher(publisher);
				lib.addBook(book);
				/*
				 * books.sort(btc);
				 * books.sort(btc.reversed());
				 * books.sort(bic);
				 * books.sort(bic.reversed());
				*/
			}
			
		}catch(IOException ioe){
			
		}finally{
			System.out.println(lib.toString()+"\n");
		}
		
	}

	public  void addBook(Book book) {
		books.add(book);
		Collection <Book> b = new HashSet<>();
		map3.put(book.getISBN(), book);
		
		if(map.containsKey(book.getTitle())) {
			for(Book x : books) {
				b.add(x);
			}
			b.add(book);
		map.put(book.getTitle(), b);
		}
		b.clear();
		for(Author a : book.getAuthor()) {
		if(map2.containsKey(a)) {
			for(Book x : books) {
				b.add(x);
			}
			b.add(book);
		map2.put(a , b);
		}
		}
	}
	

	public  void removeBook(Book book) {
		books.remove(book);
	}

	public   Collection <Book> searchBooksById(int id) {
		Collection <Book> res = new LinkedList <>();
		for(Book b : books) {
			if(b.getId()==id) {
				res.add(b);
			}
		}
		return res;
				
	}
	
	public   Collection <Book> searchBooksByTitle(String title) {
		return map.get(title);
	}
	
	public   Collection <Book> searchBooksByAuthor(Author author) {
		return map2.get(author);
	}
	
	public   Collection <Book> searchBooksByAuthor(String isbn) {
		return map.get(isbn);
	}
	
	
	public   Collection <Book> searchBooksByAuthor(List <Author> author) {
		Collection <Book> res = new LinkedList <>();
		for(Book b : books) {
			if(author.equals(b.getAuthor())) {
				res.add(b);
			}
		}
		return res;
	}

	public String toString() {
		String srt = "\n------------------------------------\n";
		for(Book b : books) {
			srt +=  b.toString();
		}
		return srt;
	}
}