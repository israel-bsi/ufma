package Models;
public class Ebook extends Book{
    private String digitalVersion;
    public Ebook(String id, String title, Author author,String publishingCompany,
                  String isbn, int pagesNumber, int releaseYear, String digitalVersion) {
        super(id, title, author,publishingCompany, isbn, pagesNumber, releaseYear);
        this.digitalVersion = digitalVersion;
    }
    @Override
    public void getBookInfo() {
        super.getBookInfo();
        System.out.println("Update Version: "+this.getDigitalVersion());
    }
    public String getDigitalVersion() {
        return digitalVersion;
    }
}