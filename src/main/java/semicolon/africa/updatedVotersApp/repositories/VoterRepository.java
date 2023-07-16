package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Address;
import semicolon.africa.updatedVotersApp.models.Voter;

import java.util.List;

public interface VoterRepository {
     Voter findById(String id);
    List<Voter> findAll();
     void deleteById(String id);
   Voter save(Voter voter);
}
