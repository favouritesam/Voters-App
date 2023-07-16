package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Election;

import java.util.List;

public interface ElectionRepository {
    Election findById(String id);
    List<Election> findAll();
    Election save(Election election);
    void deleteById(String id);
}
