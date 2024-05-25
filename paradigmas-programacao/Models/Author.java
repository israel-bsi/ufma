package Models;
import java.util.UUID;
public class Author {
    private String id;
    private String name;
    private String birthDay;
    private String nationality;
    private String site;
    public Author(){}
    public Author(String id, String name, String birthDay, String nationality, String site) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.nationality = nationality;
        this.site = site;
    }
    public Author(String name, String birthDay, String nationality, String site) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.birthDay = birthDay;
        this.nationality = nationality;
        this.site = site;
    }
    public void getAuthorInfo(){
        System.out.println("Id Autor: "+this.getId());
        System.out.println("Nome: "+this.getName());
        System.out.println("Data de Nascimento: "+this.getBirthDay());
        System.out.println("Nacionalidade: "+this.getNationality());
        System.out.println("Site: "+this.getSite());
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getBirthDay() {
        return birthDay;
    }
    public String getNationality() {
        return nationality;
    }
    public String getSite() {
        return site;
    }
}