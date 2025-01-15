package models;
import java.util.List;

public class Spieler {
    private static int idCounter = 1;
    private int id;
    private String name;
    private int age;
    private String position;
    private int marktwert;

    public Spieler(String name, int age, String position, int marktwert) {
        this.id = idCounter++;
        this.name = name;
        this.age = age;
        this.position = position;
        this.marktwert = marktwert;
    }

    // Getter pentru id
    public int getId() {
        return id;
    }

    // Getter și setter pentru name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getMarktwert() {
        return marktwert;
    }

    public void setMarktwert(int marktwert) {
        this.marktwert = marktwert;
    }

    @Override
    public String toString() {
        return "Spieler{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position +
                ", marktwert=" + marktwert +'\'' +
        '}';
    }
}
