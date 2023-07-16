package semicolon.africa.updatedVotersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.models.Admin;
import semicolon.africa.updatedVotersApp.models.Party;
import semicolon.africa.updatedVotersApp.models.UserInformation;
import semicolon.africa.updatedVotersApp.models.Voter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasPartyRepositoryTest {
    UserInformation userInformation;
    private  final  PartyRepository partyRepository = new BvasPartyRepository();

    @BeforeEach void setUp() {
        userInformation = new UserInformation();
    }
    @Test public void testSaveParty(){
        Party firstParty = new Party();
        userInformation.setPassword("fghjfyu");
        userInformation.setUserName("suhkfjgk");
        firstParty.setUserInformation(userInformation);
        Party savedFirstParty = partyRepository.save(firstParty);
        assertNotNull(savedFirstParty);
    }

    @Test void findByIdTest(){
        Party firstParty = new Party();
        userInformation.setPassword("fghjfyu");
        userInformation.setUserName("suhkfjgk");
        firstParty.setUserInformation(userInformation);
        Party savedFirstParty = partyRepository.save(firstParty);
        Party foundParty = partyRepository.findById(savedFirstParty.getId());
        assertNotNull(foundParty);
    }

    @Test public void testFindAllParty(){
        Party secondParty = new Party();
        Party thirdParty = new Party();
        partyRepository.save(secondParty);
        partyRepository.save(thirdParty);
        List<Party> parties = partyRepository.findAll();
        assertEquals(2, parties.size());
        assertNotNull(parties.get(0));
        assertNotNull(parties.get(1));



    }

    @Test void testDeleteByIdParty(){
        Party firstParty = new Party();
        userInformation.setPassword("fghjfyu");
        userInformation.setUserName("suhkfjgk");
        firstParty.setUserInformation(userInformation);
        Party savedFirstParty = partyRepository.save(firstParty);
        partyRepository.deleteById(savedFirstParty.getId());
        assertNull(partyRepository.findById(savedFirstParty.getId()));

    }

    private Party buildTestParty() {
        Party party = new Party();
        userInformation.setUserName("Favour");
        party.setUserInformation(userInformation);
        return party;
    }
}