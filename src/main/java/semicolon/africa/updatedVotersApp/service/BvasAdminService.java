package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.AdminRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.AdminRegistrationResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteAdminResponse;
import semicolon.africa.updatedVotersApp.exception.AdminRegistrationException;
import semicolon.africa.updatedVotersApp.mappers.ModelMapper;
import semicolon.africa.updatedVotersApp.models.Admin;
import semicolon.africa.updatedVotersApp.repositories.BvasAdimRepository;

import java.util.List;

public class BvasAdminService implements BevasBetaAdminService{
    private final BvasAdimRepository adminRepository = new BvasAdimRepository();
    @Override
    public AdminRegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException {
        Admin newAdmin = ModelMapper.map(adminRegistrationRequest);
        Admin saveAdmin = adminRepository.save(newAdmin);

        if(saveAdmin == null) throw new AdminRegistrationException("Registration unsuccessful");

        AdminRegistrationResponse adminRegistrationResponse =
                new AdminRegistrationResponse();
        adminRegistrationResponse.setMessage("Registration successful");
        return adminRegistrationResponse;
    }

    @Override
    public Admin findById(String id) {
        return adminRepository.findById(id);
    }

    @Override
    public List<Admin> findAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public DeleteAdminResponse deleteById(String id) {
        adminRepository.deleteById(id);
        return DeleteAdminResponse.builder().message("Admin deleted successfully").build();
    }
}