package Controllers;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuController {
    private final BookController bookController = new BookController();
    private final AuthorController authorController = new AuthorController();
    public void ShowMenu(){
        int input;
        Scanner scanner = new Scanner(System.in);
        try {
            do{
                System.out.println("\nO que deseja fazer?");
                System.out.println("Digite 1 para cadastrar um novo livro");
                System.out.println("Digite 2 para cadastrar um novo autor");
                System.out.println("Digite 3 para vizualizar os livros");
                System.out.println("Digite 4 para vizualizar os autores");
                System.out.println("Digite 5 para alterar um livro");
                System.out.println("Digite 6 para alterar um autor");
                System.out.println("Digite 7 para deletar um livro");
                System.out.println("Digite 8 para deletar um autor");
                System.out.println("Digite 0 para encerrar o programa");
                System.out.println();
                input = scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        if (listAuthorsIsEmpty()) {
                            System.err.println("Cadastre um autor antes de cadastrar um livro! ");
                            break;
                        }
                        System.out.println("Será necessário um id de autor para cadastrar um livro");
                        System.out.println("Deseja listar o nome e id dos autores? ");
                        System.out.println("Digite 1 para sim e 2 para não");
                        if(scanner.nextInt() == 1)
                            authorController.getIdAndName();
                        bookController.register();
                    }
                    case 2 -> authorController.register();
                    case 3 -> {
                        if(listBooksIsEmpty())
                            break;
                        bookController.showAll();
                    }
                    case 4 -> {
                        if(listAuthorsIsEmpty())
                            break;
                        authorController.showAll();
                    }
                    case 5 -> {
                        if(listBooksIsEmpty())
                            break;
                        bookController.update();
                    }
                    case 6 -> {
                        if(listAuthorsIsEmpty())
                            break;
                        authorController.update();
                    }
                    case 7 -> {
                        if(listBooksIsEmpty())
                            break;
                        bookController.delete();
                    }
                    case 8 -> {
                        if(listAuthorsIsEmpty())
                            break;
                        authorController.delete();
                    }
                    case 0 -> {}
                    default -> System.out.println("Digite uma opção válida");
                }
            }while (input!=0);
        }catch (InputMismatchException e){
            System.err.println("Digite um número válido");
            scanner.nextLine();
        }catch (Exception e){
            System.err.println("Ocorreu um erro: " + e.getMessage());
        }
    }
    private boolean listBooksIsEmpty(){
        if(BookController.books.size() == 0){
            System.out.println("Não foi encontrado nenhum livro cadastrado");
            return true;
        }
        return false;
    }
    private boolean listAuthorsIsEmpty(){
        if(AuthorController.authors.size() == 0){
            System.out.println("Não foi encontrado nenhum autor cadastrado");
            return true;
        }
        return false;
    }
}