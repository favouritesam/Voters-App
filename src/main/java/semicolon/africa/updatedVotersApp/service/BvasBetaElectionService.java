package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.CreateElectionRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.CreateElectionResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteVoterResponse;
import semicolon.africa.updatedVotersApp.models.Election;
import semicolon.africa.updatedVotersApp.repositories.BvasElectionRepository;
import semicolon.africa.updatedVotersApp.repositories.ElectionRepository;

import java.util.List;

public class BvasBetaElectionService implements BevasBetaElectionService{
    private final ElectionRepository electionRepository = new BvasElectionRepository();
    @Override
    public CreateElectionResponse create(CreateElectionRequest createElectionRequest){
        return null;
    }

    @Override
    public Election getUserById(String id) {
        return null;
    }

    @Override
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        return null;
    }
}

