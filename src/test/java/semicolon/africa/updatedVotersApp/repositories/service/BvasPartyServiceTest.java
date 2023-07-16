package semicolon.africa.updatedVotersApp.repositories.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.Dtos.request.PartyRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.PartyRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.PartyRegistrationException;
import semicolon.africa.updatedVotersApp.models.Party;
import semicolon.africa.updatedVotersApp.service.BvasPartyService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static semicolon.africa.updatedVotersApp.utils.AppUtils.*;

class BvasPartyServiceTest {
    private final BvasPartyService partyService = new BvasPartyService();
    private PartyRegistrationRequest partyRegistrationRequest;

    @BeforeEach
    void setUp(){
        partyRegistrationRequest = buildPartyRegistration();
    }


    @Test
    void testToRegisterParty(){
        try{
            PartyRegistrationResponse registrationResponse =
                    partyService.registerParty(partyRegistrationRequest);
            assertNotNull(registrationResponse);
        } catch (PartyRegistrationException ex){
            System.out.println(ex.getMessage());
        }
    }
    @Test
    void testToFindPartyById() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size()-ONE);
        Party foundParty = partyService.findById(lastRegisteredParty.getId());
        assertNotNull(foundParty);
    }
    @Test
    void testToFindPartyByName() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size()-1);
        Party foundParty = partyService.findByName(lastRegisteredParty.getName());
        assertNotNull(foundParty);
        assertEquals(partyRegistrationRequest.getName(),foundParty.getName());
    }


    @Test
    void testToFindAllParties() throws PartyRegistrationException {
        var registrationResponse = partyService.registerParty(partyRegistrationRequest);
        assertNotNull(registrationResponse);
        List<Party> parties = partyService.findAllParties();
        assertNotNull(parties);
        assertEquals(ONE,parties.size());
    }
    @Test
    void testToDeleteParty() throws PartyRegistrationException {
        partyService.registerParty(partyRegistrationRequest);
        List<Party> parties = partyService.findAllParties();
        Party lastRegisteredParty = parties.get(parties.size() - ONE);
        Party foundParty = partyService.findById(lastRegisteredParty.getId());
        partyService.deleteById(foundParty.getId());
        parties = partyService.findAllParties();
        assertEquals(ZERO,parties.size());

    }

    private static PartyRegistrationRequest buildPartyRegistration() {
        PartyRegistrationRequest partyRegistrationRequest1
                = new PartyRegistrationRequest();
        partyRegistrationRequest1.setName("PDP");
        partyRegistrationRequest1.setHouseNumber("99");
        partyRegistrationRequest1.setStreet("Wadata Plaza");
        partyRegistrationRequest1.setTown("Garki");
        partyRegistrationRequest1.setLga("Abuja Municipal");
        partyRegistrationRequest1.setState("FCT");
        partyRegistrationRequest1.setPassword("16yearsInPower");
        partyRegistrationRequest1.setUserName("myPDP");
        return partyRegistrationRequest1;
    }

}