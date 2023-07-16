package semicolon.africa.updatedVotersApp.service;

import semicolon.africa.updatedVotersApp.Dtos.request.AdminRegistrationRequest;
import semicolon.africa.updatedVotersApp.Dtos.response.AdminRegistrationResponse;
import semicolon.africa.updatedVotersApp.Dtos.response.DeleteAdminResponse;
import semicolon.africa.updatedVotersApp.exception.AdminRegistrationException;
import semicolon.africa.updatedVotersApp.models.Admin;

import java.util.List;

public interface BevasBetaAdminService {

        AdminRegistrationResponse registerAdmin(AdminRegistrationRequest adminRegistrationRequest) throws AdminRegistrationException;
        Admin findById(String id);
        List<Admin> findAllAdmins();
        DeleteAdminResponse deleteById(String id);
    }

