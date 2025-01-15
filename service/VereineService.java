package service;

import models.Vereine;
import repository.VereineRepository;
import java.util.List;

public class VereineService {
    private final VereineRepository vereineRepository;

    public VereineService(VereineRepository vereineRepository) {
        this.vereineRepository = vereineRepository;
    }

    /**
     * Adaugă un vereine în repository.
     * @param vereine Obiectul de tip Vereine care reprezintă echipa de adăugat.
     */
    public void addVereine( Vereine vereine) {
        if (vereine != null) {
            vereineRepository.addVereine(vereine);
        } else {
            System.out.println("Vereine kann nicht null sein!");
        }
    }

    /**
     * Obține toate echipele din repository.
     * @return Lista cu toate echipele.
     */
    public List<Vereine> getAllVereine() {
        return vereineRepository.getAllVereine();
    }

    /**
     * Actualizează datele unui vereine existent.
     * @param vereineId ID-ul cechipei care trebuie actualizat.
     * @param updatedVereine Obiectul de tip Vereine cu noile date ale echipei.
     * @return true dacă actualizarea a avut succes, false în caz contrar.
     */
    public boolean updateVereine(int vereineId, Vereine updatedVereine) {
        if (updatedVereine != null) {
            return vereineRepository.updateVereine(vereineId, updatedVereine);
        }
        System.out.println("Vereine ist null!");
        return false;
    }

    /**
     * Șterge un vereine pe baza ID-ului.
     * @param vereineId ID-ul echipei de șters.
     * @return true dacă ștergerea a avut succes, false în caz contrar.
     */
    public boolean deleteVereine(int vereineId) {
        Vereine vereine = vereineRepository.getVereineById(vereineId);
        if (vereine != null) {
            return vereineRepository.deleteVereine(vereineId);
        }
        return false;
    }

    /**
     * Căutăm un vereine după ID.
     * @param vereineId ID-ul echipei de căutat.
     * @return Vereine găsit sau null dacă nu a fost găsit.
     */
    public Vereine getVereineById(int vereineId) {
        return vereineRepository.getVereineById(vereineId);
    }

}
