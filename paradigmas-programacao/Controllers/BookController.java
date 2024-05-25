package Controllers;
import Models.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
public class BookController implements IController {
    public static List<Book> books = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    public void register(){
        try{
            System.out.println("O livro é ebook ou físico? ");
            System.out.print("Digite 1 para físico e 2 para ebook: ");
            int type = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (type) {
                case 1 -> {
                    PhysicalBook physicalBook = createPhysicalBook(null);
                    books.add(physicalBook);
                    System.out.println("Livro "+physicalBook.getTitle()+" cadastrado som sucesso!");
                }
                case 2 -> {
                    Ebook ebook = createEbook(null);
                    books.add(ebook);
                    System.out.println("Livro "+ebook.getTitle()+" cadastrado som sucesso!");
                }
                default -> System.out.println("Numero inválido");
            }
        }catch (InputMismatchException e){
            System.err.println("Valor inválido, tente novamente");
        }catch (Exception e){
            System.err.println("Erro: " +e.getMessage());
        }
    }
    private Book createBook(){
        System.out.print("Digite o título do livro: ");
        String title = input.nextLine();
        System.out.print("Informe o id do autor: ");
        String idAuthor = input.nextLine();
        System.out.print("Informe o nome da editora: ");
        String publishingCompany = input.nextLine();
        System.out.print("Informe o ISBN: ");
        String isbn = input.nextLine();
        System.out.print("Informe o número de páginas: ");
        int pagesNumber = input.nextInt();
        input.nextLine();
        System.out.print("Informe o ano de lançamento: ");
        int releaseYear = input.nextInt();
        input.nextLine();
        Author author = new Author();
        for (Author a: AuthorController.authors) {
            if(idAuthor.equals(a.getId()))
                author = a;
        }
        return new Book(title, author, publishingCompany, isbn, pagesNumber, releaseYear);
    }
    private Ebook createEbook(String id){
        Book book = createBook();
        System.out.print("Informe a versão do livro: ");
        String updateVersion = input.nextLine();
        System.out.println();
        if(id != null)
            return new Ebook(id, book.getTitle(), book.getAuthor(), book.getPublishingCompany(),
                book.getIsbn(), book.getPagesNumber(), book.getReleaseYear(), updateVersion);

        return new Ebook(book.getId(), book.getTitle(), book.getAuthor(), book.getPublishingCompany(),
                book.getIsbn(), book.getPagesNumber(), book.getReleaseYear(), updateVersion);
    }
    private PhysicalBook createPhysicalBook(String id){
        Book book = createBook();
        System.out.print("Informe o estoque atual do livro: ");
        int stock = input.nextInt();
        System.out.println();
        if(id != null)
            return new PhysicalBook(id, book.getTitle(), book.getAuthor(), book.getPublishingCompany(),
                book.getIsbn(), book.getPagesNumber(), book.getReleaseYear(), stock);

        return new PhysicalBook(book.getId(), book.getTitle(), book.getAuthor(), book.getPublishingCompany(),
                book.getIsbn(), book.getPagesNumber(), book.getReleaseYear(), stock);
    }
    public void showAll(){
        System.out.println("---------------------------------------");
        for (Book book : books){
            book.getBookInfo();
            System.out.println("---------------------------------------");
        }
    }
    public void update(){
        Book localBook = new Book();
        System.out.print("Informe o id do livro que deseja alterar: ");
        String id = input.nextLine();
        int indexBook = getIndex(id);
        if(indexBook == -1){
            System.out.println("Não foi possível encontrar esse livro");
            return;
        }
        for (Book book: books) {
            if(id.equals(book.getId())){
                if(book instanceof PhysicalBook)
                    localBook = createPhysicalBook(id);
                else
                    localBook = createEbook(id);
            }
        }
        books.set(indexBook, localBook);
        System.out.println("\nLivro "+localBook.getTitle()+" atualizado com sucesso!");
    }
    public void delete(){
        System.out.print("Informe o id do autor que deseja deletar: ");
        int indexBook = getIndex(input.nextLine());
        if(indexBook == -1){
            System.out.println("Não foi possível encontrar esse livro");
            return;
        }
        books.remove(indexBook);
        System.out.println("Removido som sucesso");
    }
    private int getIndex(String id){
        int index = -1;
        for(int i = 0; i < books.size(); i++){
            if(books.get(i).getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
}