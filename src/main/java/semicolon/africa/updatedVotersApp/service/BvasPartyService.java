package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.PartyRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.DeletePartyResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.PartyRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.PartyRegistrationException;
import semicolon.africa.updatedVotersApp.mappers.ModelMapper;
import semicolon.africa.updatedVotersApp.models.Party;
import semicolon.africa.updatedVotersApp.repositories.BvasPartyRepository;
import semicolon.africa.updatedVotersApp.repositories.PartyRepository;

import java.util.List;

public class BvasPartyService implements BevasBetaPartyService{
    private final PartyRepository partyRepository = new BvasPartyRepository();
    @Override
    public PartyRegistrationResponse registerParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationException {
        Party newParty = ModelMapper.map(partyRegistrationRequest);
        Party savedParty = partyRepository.save(newParty);

        if(savedParty == null) throw new PartyRegistrationException("Registration unsuccessful");

        PartyRegistrationResponse partyRegistrationResponse =
                new PartyRegistrationResponse();
        partyRegistrationResponse.setMessage("Registration successful.");
        return partyRegistrationResponse;
    }

    @Override
    public Party findById(String id) {
        return partyRepository.findById(id);
    }

    @Override
    public List<Party> findAllParties() {
        return partyRepository.findAll();
    }

    @Override
    public Party findByName(String name) {
        return partyRepository.findByName(name);
    }

    @Override
    public DeletePartyResponse deleteById(String id) {
        partyRepository.deleteById(id);
        return DeletePartyResponse.builder().message("Party deleted successfully").build();
    }
}