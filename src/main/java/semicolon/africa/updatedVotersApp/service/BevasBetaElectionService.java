package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.CreateElectionRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.CreateElectionResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteVoterResponse;
import semicolon.africa.updatedVotersApp.models.Election;

import java.util.List;

public interface BevasBetaElectionService {
    CreateElectionResponse create (CreateElectionRequest createElectionRequest);

    Election getUserById(String id);

    List<Election> getAllElections();

    DeleteVoterResponse deleteById(String id);
}
