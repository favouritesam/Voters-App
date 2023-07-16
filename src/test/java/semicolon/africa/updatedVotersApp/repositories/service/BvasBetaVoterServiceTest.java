package semicolon.africa.updatedVotersApp.repositories.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.Dtos.request.VoterRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.VoterRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.VoterRegistrationException;
import semicolon.africa.updatedVotersApp.models.Voter;
import semicolon.africa.updatedVotersApp.service.BvasBetaVoterService;
import semicolon.africa.updatedVotersApp.service.VoterService;

import java.util.List;

import static semicolon.africa.updatedVotersApp.utils.AppUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class BvasBetaVoterServiceTest {
    private final VoterService voterService = new BvasBetaVoterService();
    private  VoterRegistrationRequest registrationRequest;


    @BeforeEach
    void setUp() {
        registrationRequest = buildVoterRegistrationRequest();
    }
    @Test
    void registerTest(){
        try{
        VoterRegistrationResponse registrationResponse = voterService.register(registrationRequest);
        assertNotNull(registrationResponse);
        assertNotNull(registrationResponse.getVotersIdentificationNumber());
    }catch (VoterRegistrationException exception){
            System.out.println(exception);
        }
    }
    @Test
    void getAllVotersTest()throws VoterRegistrationException{
        var response = voterService.register(registrationRequest);
        assertNotNull(response);
        List<Voter>voter = voterService.getAllVoters();
        assertEquals(1,voter.size());
        assertNotNull(voter);

    }
    @Test
    void getVoterById()throws VoterRegistrationException{
        var registrationResponse = voterService.register(registrationRequest);
        Voter foundVoter = voterService.getUserById("1");
    }
    @Test
    public void deleteVoterByIdTest()throws  VoterRegistrationException{
        voterService.register(registrationRequest);
        List<Voter> voters = voterService.getAllVoters();
        assertNotNull(voters);
        assertEquals(ZERO,voters.size());
        Voter lastRegistrationVoter = voters.get(voters.size() -ONE );
        Voter foundVoter = voterService.getUserById(lastRegistrationVoter.getId());
        voterService.deleteById(foundVoter.getId());
        voters = voterService.getAllVoters();
        assertEquals(ZERO,voters.size());


    }

    private static  VoterRegistrationRequest buildVoterRegistrationRequest(){
     VoterRegistrationRequest registrationRequest = new VoterRegistrationRequest();
        registrationRequest.setAge(100);
        registrationRequest.setName("fav");
        registrationRequest.setLocalGovernmentArea("townhall");
        registrationRequest.setGender("FEMALE");
        registrationRequest.setPassword("999defvgh");
        registrationRequest.setUserName("favzy");
        registrationRequest.setTown("sabo");
        registrationRequest.setState("imo");
        registrationRequest.setStreet("12,ibghvcvnn");
        registrationRequest.setHouseNumber("12 nnkhgxx");
        return  registrationRequest;
    }
}