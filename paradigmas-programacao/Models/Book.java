package Models;
import java.util.UUID;
public class Book {
    private String id;
    private String title;
    private Author author;
    private String publishingCompany;
    private String isbn;
    private int pagesNumber;
    private int releaseYear;
    public Book(){}
    public Book(String id, String title, Author author, String publishingCompany,
                String isbn, int pagesNumber, int releaseYear) {
        this.id = id;
        this.title = title;
        this.publishingCompany = publishingCompany;
        this.isbn = isbn;
        this.pagesNumber = pagesNumber;
        this.releaseYear = releaseYear;
        this.author = author;
    }
    public Book(String title, Author author, String publishingCompany,
                String isbn, int pagesNumber, int releaseYear) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.title = title;
        this.publishingCompany = publishingCompany;
        this.isbn = isbn;
        this.pagesNumber = pagesNumber;
        this.releaseYear = releaseYear;
        this.author = author;
    }
    public void getBookInfo(){
        System.out.println("Id Livro: "+this.getId());
        System.out.println("Titulo: "+this.getTitle());
        System.out.println("Autor: "+this.getAuthor().getName());
        System.out.println("Editora: "+this.getPublishingCompany());
        System.out.println("ISBN: "+this.getIsbn());
        System.out.println("Número de páginas: "+this.getPagesNumber());
        System.out.println("Ano de lançamento: "+this.getReleaseYear());
    }
    public String getId() { return id; }
    public String getTitle() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }
    public String getPublishingCompany() {
        return publishingCompany;
    }
    public String getIsbn() {
        return isbn;
    }
    public int getPagesNumber() {
        return pagesNumber;
    }
    public int getReleaseYear() {
        return releaseYear;
    }
}