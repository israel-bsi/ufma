package Models;
public class PhysicalBook extends Book{
    private double stock;
    public PhysicalBook(String id, String title, Author author, String publishingCompany,
                        String isbn, int pagesNumber, int releaseYear, double stock) {
        super(id, title, author, publishingCompany, isbn, pagesNumber, releaseYear);
        this.stock = stock;
    }
    @Override
    public void getBookInfo() {
        super.getBookInfo();
        System.out.println("Stock: "+this.getStock());
    }
    public double getStock() {
        return stock;
    }
}