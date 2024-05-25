package Controllers;
import Models.Author;
import Models.IController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AuthorController implements IController {
    public static List<Author> authors = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    public void register(){
        Author author = createAuthor(null);
        authors.add(author);
        System.out.println("\nAutor "+author.getName() + " cadastrado com sucesso!");
    }
    private Author createAuthor(String id){
        System.out.print("Informe o nome do autor: ");
        String name = input.nextLine();
        System.out.print("Informe a data de nascimento no formato dd/mm/aaaa: ");
        String birthday = input.nextLine();
        System.out.print("Informe sua nacionalidade: ");
        String nationality = input.nextLine();
        System.out.print("Informe seu website: ");
        String site = input.nextLine();

        if(id != null)
            return new Author(id, name, birthday, nationality, site);
        return new Author(name, birthday, nationality, site);
    }
    public void update(){
        System.out.print("Informe o id do autor que deseja alterar: ");
        String id = input.nextLine();
        int indexAuthor = getIndex(id);
        if(indexAuthor == -1){
            System.out.println("Não foi possível encontrar esse autor");
            return;
        }
        Author author = createAuthor(id);
        authors.set(indexAuthor, author);
        System.out.println("\nAutor "+author.getName()+" atualizado com sucesso!");
    }
    public void delete(){
        System.out.print("Informe o id do autor que deseja deletar: ");
        int indexAuthor = getIndex(input.nextLine());
        if(indexAuthor == -1){
            System.out.println("Não foi possível encontrar esse autor");
            return;
        }
        authors.remove(indexAuthor);
        System.out.println("Removido som sucesso");
    }
    public void showAll(){
        System.out.println("---------------------------------------");
        for (Author author : authors){
            author.getAuthorInfo();
            System.out.println("---------------------------------------");
        }
    }
    public void getIdAndName(){
        System.out.println("---------------------------------------");
        for (Author author : authors){
            System.out.println("Id: "+author.getId());
            System.out.println("Nome: "+author.getName());
            System.out.println("---------------------------------------");
        }
    }
    private int getIndex(String id){
        int index = -1;
        for(int i = 0; i < authors.size(); i++){
            if(authors.get(i).getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }
}