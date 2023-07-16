package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.VoterRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteVoterResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.VoterRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.VoterRegistrationException;
import semicolon.africa.updatedVotersApp.mappers.ModelMapper;
import semicolon.africa.updatedVotersApp.mappers.ModelMapper;
import semicolon.africa.updatedVotersApp.models.Voter;
import semicolon.africa.updatedVotersApp.repositories.BvasVoterRepository;
import semicolon.africa.updatedVotersApp.repositories.VoterRepository;


import java.util.UUID;
import java.util.List;
import static semicolon.africa.updatedVotersApp.utils.AppUtils.*;


public class BvasBetaVoterService implements VoterService{
    public final VoterRepository voterRepository = new BvasVoterRepository();
    @Override
    public VoterRegistrationResponse register(VoterRegistrationRequest voterRegistrationRequest) throws VoterRegistrationException {
        Voter voter = ModelMapper.map(voterRegistrationRequest);
        String vin = generateVoterIdentificationNumber();
        voter.setVoterIdentificationNumber(vin);
        Voter savedVoter = voterRepository.save(voter);
        if (savedVoter == null) throw  new VoterRegistrationException("Voter registration failed");

        VoterRegistrationResponse voterRegistrationResponse = new VoterRegistrationResponse();
        voterRegistrationResponse.setMessage("Registration successful. May your vote count");
        voterRegistrationResponse.setVotersIdentificationNumber(savedVoter.getVoterIdentificationNumber());

        return voterRegistrationResponse;
    }

    @Override
    public Voter getUserById(String id) {
        return voterRepository.findById(id);
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public DeleteVoterResponse deleteById(String id) {
        voterRepository.deleteById(id);
        return DeleteVoterResponse.builder().message("vote deleted").build();
    }

   private static String generateVoterIdentificationNumber() {
       String uuid = generateUUID();
       String validUUID = stripInvalidCharacterForm(uuid);
       return buildVoterIdentificationNumberForm(validUUID);
   }
    private static String buildVoterIdentificationNumberForm(String ValidUuid) {
        String result = "";
        for (int index = ZERO; index < ValidUuid.length(); index++) {
            if (index % FIVE == ZERO) result += "";
            else result += ValidUuid.charAt(index);
        }
        int endIndex = result.length() - EIGHT;
        return result.substring(ZERO, endIndex).strip();
    }
    private static String stripInvalidCharacterForm(String randomUUID) {
        String validUuid = "";
        for (int index = ZERO; index < randomUUID.length(); index++) {
            if (randomUUID.charAt(index) != '-') validUuid += randomUUID.charAt(index);
        }
            return validUuid;

        }
        private static String generateUUID() {
            UUID randomUuid = UUID.randomUUID();
            String uuid = randomUuid.toString();
            return uuid.toUpperCase();
        }
    }
