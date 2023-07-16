package semicolon.africa.updatedVotersApp.repositories.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.Dtos.request.AdminRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.AdminRegistrationResponse;
import semicolon.africa.updatedVotersApp.exception.AdminRegistrationException;
import semicolon.africa.updatedVotersApp.models.Admin;
import semicolon.africa.updatedVotersApp.service.BvasAdminService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static semicolon.africa.updatedVotersApp.utils.AppUtils.*;

class BvasAdminServiceTest {
    private final BvasAdminService adminService = new BvasAdminService();
    private AdminRegistrationRequest adminRegistrationRequest = new AdminRegistrationRequest();


    @BeforeEach
    void setUp(){ adminRegistrationRequest = buildAdminRegistration(); }

    @Test
    void testToRegisterAdmin(){
        try{
            AdminRegistrationResponse adminRegistrationResponse
                    = adminService.registerAdmin(adminRegistrationRequest);
            assertNotNull(adminRegistrationResponse);
        } catch (AdminRegistrationException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void testToFindAdminById() throws AdminRegistrationException {
        adminService.registerAdmin(adminRegistrationRequest);
        List<Admin> adminList = adminService.findAllAdmins();
        Admin lastRegisteredAdmin = adminList.get(adminList.size() - ONE);
        Admin foundAdmin = adminService.findById(lastRegisteredAdmin.getId());
        assertNotNull(foundAdmin);
    }

    @Test
    void testToFindAllAdmins() throws AdminRegistrationException {
        adminService.registerAdmin(adminRegistrationRequest);
        assertNotNull(adminRegistrationRequest);
        List<Admin> adminList = adminService.findAllAdmins();
        assertNotNull(adminList);
        assertEquals(ONE,adminList.size());
    }
    @Test
    void testToDeleteAdmin() throws AdminRegistrationException {
        adminService.registerAdmin(adminRegistrationRequest);
        List<Admin> adminList = adminService.findAllAdmins();
        Admin lastRegisteredAdmin = adminList.get(adminList.size() - ONE);
        Admin foundAdmin = adminService.findById(lastRegisteredAdmin.getId());
        adminService.deleteById(foundAdmin.getId());
        adminList = adminService.findAllAdmins();
        assertEquals(ZERO,adminList.size());
    }

    private AdminRegistrationRequest buildAdminRegistration() {
        AdminRegistrationRequest adminRegistrationRequest
                = new AdminRegistrationRequest();
        adminRegistrationRequest.setFirstName("Ned");
        adminRegistrationRequest.setLastName("Stark");
        adminRegistrationRequest.setUserName("StarkOfJava");
        adminRegistrationRequest.setPassword("LP75");

        return adminRegistrationRequest;
    }
}