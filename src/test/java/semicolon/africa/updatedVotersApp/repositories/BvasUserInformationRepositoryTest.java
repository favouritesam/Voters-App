package semicolon.africa.updatedVotersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.models.UserInformation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasUserInformationRepositoryTest {
    private UserInformationRepository userInformationRepository = new BvasUserInformationRepository();

    private UserInformation savedUser;

    @BeforeEach
    void setUp() {
        UserInformation userInformation = buildTestVoter();
        savedUser = userInformationRepository.save(userInformation);
    }
    @DisplayName("Save User")
    @Test
    public void testSaveUserInformation(){
        assertNotNull(savedUser);
        assertNotNull(savedUser.getUserId());
    }

    @DisplayName("Find Id")
    @Test
    public void testFindById(){
        UserInformation foundUser = userInformationRepository.findById(savedUser.getUserId());
        assertNotNull(foundUser);
    }

    @DisplayName("Find All Voter")
    @Test
    public void testFindAllVoter(){
        UserInformation secondUserInformation = new UserInformation();
        UserInformation thirdUserInformation = new UserInformation();
        userInformationRepository.save(secondUserInformation);
        userInformationRepository.save(thirdUserInformation);

        List<UserInformation> userInformationList = userInformationRepository.findAll();
        assertEquals(3, userInformationList.size());
        assertNotNull(userInformationList.get(0));
        assertNotNull(userInformationList.get(1));
        assertNotNull(userInformationList.get(2));

    }
//

    @DisplayName("Delete UserInformation By Id")
    @Test
    public void testDeleteUserInformationById(){
        UserInformation secondUserInformation = new UserInformation();
        UserInformation thirdUserInformation = userInformationRepository.save(secondUserInformation);
        List<UserInformation> userInformationList = userInformationRepository.findAll();
        assertEquals(2,userInformationList.size());
        userInformationRepository.deleteById(thirdUserInformation.getUserId());
        userInformationList = userInformationRepository.findAll();
        assertEquals(1, userInformationList.size());
    }

    private UserInformation buildTestVoter(){
        UserInformation userInformation = new UserInformation();
        userInformation.setUserName("Jos pink");
        userInformation.setPassword("ab1246@3");
        userInformation.setUserId("1");
        return userInformation;
    }
}