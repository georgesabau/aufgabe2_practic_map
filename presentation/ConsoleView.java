package presentation;

import controller.SpielerController;
import controller.VereineController;
import models.Vereine;
import models.Spieler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final SpielerController spielerController;
    private final VereineController vereineController;
    private final Scanner scanner;

    public ConsoleView(SpielerController spielerController, VereineController vereineController) {
        this.spielerController = spielerController;
        this.vereineController = vereineController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> handleVereineMenu();
                case 2 -> handleSpielerMenu();
                case 0 -> {
                    running = false;
                    System.out.println("Exit application.");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void showMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Vereine");
        System.out.println("2. Spieler");
        System.out.println("0. Exit");
        System.out.print("Choose option: ");
    }

    private void handleVereineMenu() {
        boolean vereineRunning = true;
        while (vereineRunning) {
            System.out.println("\nMenu Vereine:");
            System.out.println("1. Add vereine");
            System.out.println("2. Show vereine");
            System.out.println("3. Update vereine");
            System.out.println("4. Delete vereine");
            System.out.println("0. Back to main menu");
            System.out.print("Choose option: ");
            int vereineChoice = scanner.nextInt();
            scanner.nextLine();

            switch (vereineChoice) {
                case 1 -> addVereine();
                case 2 -> showAllVereine();
                case 3 -> updateVereine();
                case 4 -> deleteVereine();
                case 0 -> vereineRunning = false;
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void handleSpielerMenu() {
        boolean spielerRunning = true;
        while (spielerRunning) {
            System.out.println("\nMenu Spieler:");
            System.out.println("1. Add spieler");
            System.out.println("2. Show all spieler");
            System.out.println("3. Delete spieler");
            System.out.println("4. Update spieler");
            System.out.println("0. Back to main menu");
            System.out.print("Choose option: ");
            int spielerChoice = scanner.nextInt();
            scanner.nextLine();

            /*
            switch (spielerChoice) {
                case 1 -> addSpieler();
                case 2 -> showAllSpieler();
                case 3 -> deleteSpieler();
                case 4 -> updateSpieler();
                case 0 -> spielerRunning = false;
                default -> System.out.println("Invalid choice.");
            }

             */
        }
    }

    private void addVereine() {
        System.out.println("Introduceți numele echipei:");
        String name = scanner.nextLine();
        System.out.println("Introduceți orașul echipei:");
        String city = scanner.nextLine();

        List<Spieler> spielers = new ArrayList<>();
        System.out.println("Adăugați jucatori pentru aceasta echipa (da/nu):");
        String addSpieler = scanner.nextLine();
        while ("da".equalsIgnoreCase(addSpieler)) {
            System.out.println("Introduceți numele jucatorului:");
            String spielerName = scanner.nextLine();
            System.out.println("Introduceți varsta jucatorului:");
            int spielerAge = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Introduceți pozitia jucatorului:");
            String spielerPosition = scanner.nextLine();
            scanner.nextLine();
            System.out.println("Introduceți valoarea jucatorului:");
            int spielerMarktwert = scanner.nextInt();


            spielers.add(new Spieler(spielerName, spielerAge, spielerPosition, spielerMarktwert));
            System.out.println("Doriți să adăugați alt produs? (da/nu)");
            addSpieler = scanner.nextLine();
        }

        int vereineId = generateVereineId();
        Vereine newVereine = new Vereine(vereineId, name, city, spielers);
        vereineController.addVereine(newVereine);
        System.out.println("Vereine adăugat cu succes!");
    }

    private int generateVereineId() {
        return clientIdCounter++;
    }

    private static int clientIdCounter = 1;

    private void showAllVereine() {
        var vereine = vereineController.getAllVereine();
        if (vereine.isEmpty()) {
            System.out.println("Nu sunt echipe.");
        } else {
            vereine.forEach(System.out::println);
        }
    }

    private void updateVereine() {
        System.out.println("Introduceți ID-ul echipei de actualizat:");
        int vereineId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceți noul nume:");
        String name = scanner.nextLine();
        System.out.println("Introduceți noul oraș:");
        String city = scanner.nextLine();

        Vereine existingVereine = vereineController.getVereineById(vereineId);
        if (existingVereine != null) {
            List<Spieler> spielers = existingVereine.getSpieler();
            Vereine updatedVereine = new Vereine(vereineId, name, city, spielers);
            boolean success = vereineController.updateVereine(vereineId, updatedVereine);
            System.out.println(success ? "Echipa actualizata cu succes!" : "Eroare la actualizarea clientului.");
        } else {
            System.out.println("Echipa nu a fost găsita.");
        }
    }

    private void deleteVereine() {
        System.out.println("Introduceți ID-ul echipei de șters:");
        int vereineId = scanner.nextInt();
        scanner.nextLine();

        boolean success = vereineController.deleteVereine(vereineId);
        System.out.println(success ? "Vereine șters cu succes!" : "Echipa nu a fost găsita.");
    }
    /*

    private void addProduct() {
        System.out.println("Introduceți numele produsului:");
        String productName = scanner.nextLine();
        System.out.println("Introduceți prețul produsului:");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Introduceți sezonul produsului:");
        String season = scanner.nextLine();

        produktController.addProduct(new Produkt(productName, price, season));
        System.out.println("Produs adăugat cu succes!");
    }

    private void showAllProducts() {
        var products = produktController.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("Nu sunt produse.");
        } else {
            products.forEach(System.out::println);
        }
    }

    private void sortProducts() {
        System.out.println("Alege ordinea de sortare (1 pentru ascendent, 2 pentru descendent):");
        int sortOrder = scanner.nextInt();
        boolean ascending = sortOrder == 1;

        produktController.sortProductsByPrice(ascending);
    }

    private void updateProduct() {
        System.out.println("Introduceți ID-ul produsului de actualizat:");
        int productId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduceți noul nume:");
        String newName = scanner.nextLine();
        System.out.println("Introduceți noul preț:");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Introduceți noul sezon:");
        String newSeason = scanner.nextLine();

        Produkt updatedProduct = new Produkt(newName, newPrice, newSeason);
        boolean success = produktController.updateProduct(productId, updatedProduct);
        System.out.println(success ? "Produs actualizat cu succes!" : "Eroare la actualizarea produsului.");
    }

    private void deleteProduct() {
        System.out.println("Introduceți ID-ul produsului de șters:");
        int productId = scanner.nextInt();
        scanner.nextLine();

        boolean success = produktController.deleteProduct(productId);
        System.out.println(success ? "Produs șters cu succes!" : "Produsul nu a fost găsit.");
    }

    private void filterClientsByCity() {
        System.out.println("Introduceți orașul pentru filtrare:");
        String city = scanner.nextLine();

        kundeController.displayClientsByCity(city);
    }

    private void displayClientsBySeason() {
        System.out.println("Introduceți sezonul pentru a filtra clienții:");
        String season = scanner.nextLine();
        var clientsBySeason = kundeController.getClientsByProductSeason(season);

        if (clientsBySeason.isEmpty()) {
            System.out.println("Nu sunt clienți care au achiziționat produse din acest sezon.");
        } else {
            clientsBySeason.forEach(System.out::println);
        }
    }

     */


}
