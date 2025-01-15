package repository;

import models.Vereine;
import java.util.ArrayList;
import java.util.List;

public class VereineRepository {
    private List<Vereine> vereineList = new ArrayList<>();

    public void addVereine(Vereine vereine) {
        vereineList.add(vereine);
    }

    public List<Vereine> getAllVereine() {
        return vereineList;
    }

    public boolean updateVereine(int vereineId, Vereine updatedVereine) {
        for (int i = 0; i < vereineList.size(); i++) {
            Vereine existingClient = vereineList.get(i);
            if (existingClient.getId() == vereineId) {
                vereineList.set(i, updatedVereine);
                return true;
            }
        }
        return false;
    }

    public boolean deleteVereine(int vereineId) {
        Vereine vereine = getVereineById(vereineId);
        if (vereine != null) {
            vereineList.remove(vereine);
            return true;
        }
        return false;
    }

    public Vereine getVereineById(int clientId) {
        for (Vereine vereine : vereineList) {
            if (vereine.getId() == clientId) {
                return vereine;
            }
        }
        return null;
    }
}
