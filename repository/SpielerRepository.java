package repository;

import models.Spieler;
import java.util.ArrayList;
import java.util.List;

public class SpielerRepository {
    private List<Spieler> spielerList = new ArrayList<>();

    public void addSpieler(Spieler spieler) {
        spielerList.add(spieler);
    }

    public List<Spieler> getAllSpieler() {
        return spielerList;
    }

    public boolean updateSpieler(int spielerId, Spieler updatedSpieler) {
        for (int i = 0; i < spielerList.size(); i++) {
            Spieler existingProduct = spielerList.get(i);
            if (existingProduct.getId() == spielerId) {
                spielerList.set(i, updatedSpieler);
                return true;
            }
        }
        return false;
    }

    public boolean deleteSpieler(int spielerId) {
        return spielerList.removeIf(spieler -> spieler.getId() == spielerId);
    }

    public Spieler getSpielerById(int productId) {
        for (Spieler product : spielerList) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }
}
