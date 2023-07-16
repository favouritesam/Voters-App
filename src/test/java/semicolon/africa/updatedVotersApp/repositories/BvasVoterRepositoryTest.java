package semicolon.africa.updatedVotersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.models.Address;
import semicolon.africa.updatedVotersApp.models.Gender;
import semicolon.africa.updatedVotersApp.models.Voter;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasVoterRepositoryTest {
    private Voter savedVoter;

    private final VoterRepository voterRepository = new BvasVoterRepository();

    @BeforeEach
    public void setUp() {
        Voter voter = buildTestVoter();
        savedVoter = voterRepository.save(voter);

    }


    @Test
    public void testSaveVoter() {

        assertNotNull(savedVoter);
        assertNotNull(savedVoter.getId());

    }

    @Test
    public void testFindById() {
        Voter foundVoter = voterRepository.findById(savedVoter.getId());
        assertNotNull(foundVoter);

    }

    @Test
    public void testFindAllVoters() {
        Voter secondVoter = new Voter();
        Voter thirdVoter = new Voter();
        voterRepository.save(secondVoter);
        voterRepository.save(thirdVoter);
        List<Voter> voters = voterRepository.findAll();
        assertEquals(3, voters.size());
        assertNotNull(voters.get(0));
        assertNotNull(voters.get(1));
        assertNotNull(voters.get(2));

    }

    @Test
    public void testDeleteVoterById() {
        Voter secondVoter = new Voter();
        Voter savedSecondVoter = voterRepository.save(secondVoter);
        List<Voter> voters = voterRepository.findAll();
        assertEquals(2, voters.size());
        voterRepository.deleteById(savedSecondVoter.getId());
        voters = voterRepository.findAll();
        assertEquals(1, voters.size());
    }

    private Voter buildTestVoter() {
        Voter voter = new Voter();
        voter.setName("fav dan");
        voter.setAge(12);
        voter.setGender(Gender.FEMALE);
        return voter;


    }
}
