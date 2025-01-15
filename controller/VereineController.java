package controller;

import models.Vereine;
import models.Spieler;
import service.VereineService;

import java.util.ArrayList;
import java.util.List;

public class VereineController {
    private final VereineService vereineService;

    public VereineController(VereineService vereineService) {
        this.vereineService = vereineService;
    }

    public void addVereine(Vereine vereine) {
        if (vereine != null) {
            vereineService.addVereine(vereine);
            System.out.println("Die Vereine war hinzugefugt.");
        } else {
            System.out.println("Vereine ist invalid.");
        }
    }

    public void displayAllVereine() {
        List<Vereine> vereine = getAllVereine();
        if (vereine.isEmpty()) {
            System.out.println("Nu există clienți în sistem.");
        } else {
            vereine.forEach(v -> System.out.println("ID: " + v.getId() + ", Nume: " + v.getName() + ", Oraș: " + v.getCity()));
        }
    }

    public Vereine getVereineById(int vereineId) {
        List<Vereine> vereine = getAllVereine();
        return vereine.stream().filter(v -> v.getId() == vereineId).findFirst().orElse(null);
    }

    public boolean updateVereine(int vereineId, Vereine updatedVereine) {
        Vereine existingVereine = getVereineById(vereineId);
        if (existingVereine != null && updatedVereine != null) {
            existingVereine.setName(updatedVereine.getName());
            existingVereine.setCity(updatedVereine.getCity());
            existingVereine.setSpieler(updatedVereine.getSpieler());
            System.out.println("Vereine mit ID " + vereineId + " wurde aktualiziert.");
            return true;
        }
        System.out.println("Vereine nicht gefunden.");
        return false;
    }

    public boolean deleteVereine(int vereineId) {
        Vereine client = getVereineById(vereineId);
        if (client != null) {
            vereineService.deleteVereine(vereineId);
            System.out.println("Vereine mit ID " + vereineId + " war geloscht.");
            return true;
        }
        System.out.println("Vereine mit ID " + vereineId + " wurde nicht gefunden.");
        return false;
    }

/*
    // Sortează produsele unui client după preț (ascendent / descendent)
    public void sortClientProducts(int clientId, boolean ascending) {
        Kunde client = getClientById(clientId);

        if (client != null) {
            List<Produkt> products = client.getProducts();

            if (products != null && !products.isEmpty()) {
                // Sortează produsele pe baza prețului
                products.sort((p1, p2) -> ascending ? Double.compare(p1.getPrice(), p2.getPrice()) : Double.compare(p2.getPrice(), p1.getPrice()));

                // Afișează produsele sortate
                System.out.println("Produse pentru clientul " + client.getName() + " (ID: " + client.getId() + "):");
                products.forEach(product -> System.out.println("Nume produs: " + product.getName() + ", Preț: " + product.getPrice() + ", Sezon: " + product.getSeason()));
            } else {
                System.out.println("Clientul nu are produse.");
            }
        } else {
            System.out.println("Clientul cu ID-ul " + clientId + " nu a fost găsit!");
        }
    }

 */

    public List<Vereine> getAllVereine() {
        return vereineService.getAllVereine();
    }

}
