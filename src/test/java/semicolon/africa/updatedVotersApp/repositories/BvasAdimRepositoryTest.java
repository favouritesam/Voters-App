package semicolon.africa.updatedVotersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.models.Admin;
import semicolon.africa.updatedVotersApp.models.UserInformation;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAdimRepositoryTest {
    private Admin savedAdmin;
    UserInformation userInformation = new UserInformation();

    private  final AdimRepository adimRepository = new BvasAdimRepository();

    @BeforeEach
    void setUp() {
        Admin admin = buildTestAdmin();
        savedAdmin = adimRepository.save(admin);
    }
    @Test
    public  void testSaveAdmin(){
        assertNotNull(savedAdmin);
        assertNotNull(savedAdmin.getId());
    }
    @Test
    public  void testFindById(){
        Admin foundAdmin = adimRepository.findById(savedAdmin.getId());
        assertNotNull(foundAdmin);
    }
    @Test
    public void testFindAllAdmins(){
        Admin firstAdmin = new Admin();
        Admin secondAdmin = new Admin();
        adimRepository.save(firstAdmin);
        adimRepository.save(secondAdmin);
        List<Admin> admins = adimRepository.findAll();
        assertEquals(3,admins.size());
        assertNotNull(admins.get(1));
        assertNotNull(admins.get(2));
    }
    @Test
    public void testDeleteAdminById(){
        Admin firstAdmin = new Admin();
        Admin savedFirstAdmin = adimRepository.save(firstAdmin);
        List<Admin> admins = adimRepository.findAll();
        assertEquals(2,admins.size());
        adimRepository.deleteById(savedFirstAdmin.getId());
        admins = adimRepository.findAll();
        assertEquals(1,admins.size());
    }

    private Admin buildTestAdmin() {
        Admin admin = new Admin();
        userInformation.setUserName("Favour");
        admin.setUserInformation(userInformation);

        return admin;
    }
}