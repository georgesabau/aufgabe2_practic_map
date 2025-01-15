package models;

import java.util.List;

public class Vereine {
    private int id;
    private String name;
    private String city;
    private List<Spieler> spieler;

    public Vereine(int id, String name, String city, List<Spieler> spieler) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.spieler = spieler;
    }

    public Vereine(String name, String city, List<Spieler> spieler) {
        this.name = name;
        this.city = city;
        this.spieler = spieler;
    }

    // Getters și setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Spieler> getSpieler() {
        return spieler;
    }

    public void setSpieler(List<Spieler> spieler) {
        this.spieler = spieler;
    }

    @Override
    public String toString() {
        return "Vereine{id=" + id + ", name='" + name + "', city='" + city + "', spieler=" + spieler + '}';
    }
}
