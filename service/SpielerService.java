package service;

import models.Spieler;
import repository.SpielerRepository;
import java.util.List;


public class SpielerService {
    private final SpielerRepository spielerRepository;

    public SpielerService(SpielerRepository spielerRepository) {
        this.spielerRepository = spielerRepository;
    }

    public boolean addProduct(Spieler spieler) {
        if (spieler != null) {
            spielerRepository.addSpieler(spieler);
            return true;
        }
        return false;
    }

    public List<Spieler> getAllSpieler() {
        return spielerRepository.getAllSpieler();
    }

    public boolean updateSpieler(int spielerId, Spieler updatedSpieler) {
        return spielerRepository.updateSpieler(spielerId, updatedSpieler);
    }

    public boolean deleteProduct(int spielerId) {
        return spielerRepository.deleteSpieler(spielerId);
    }

    public Spieler getProductById(int spielerId) {
        return spielerRepository.getSpielerById(spielerId);
    }
}
