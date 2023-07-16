package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.PartyRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.DeletePartyResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.PartyRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.PartyRegistrationException;
import semicolon.africa.updatedVotersApp.models.Party;

import java.util.List;

public interface BevasBetaPartyService {
        PartyRegistrationResponse registerParty(PartyRegistrationRequest partyRegistrationRequest) throws PartyRegistrationException;
        Party findById(String id);
        List<Party> findAllParties();
        Party findByName(String name);
        DeletePartyResponse deleteById(String id);
}
