package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.VoterRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteVoterResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.VoterRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.VoterRegistrationException;
import semicolon.africa.updatedVotersApp.models.Voter;

import java.util.List;

public interface VoterService {
   VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException;
   Voter getUserById(String id);

   List<Voter> getAllVoters();

   DeleteVoterResponse deleteById(String id);
}
