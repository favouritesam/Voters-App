package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Address;
import semicolon.africa.updatedVotersApp.models.UserInformation;

import java.util.List;

public interface UserInformationRepository {
    UserInformation findById(String id);
    List<UserInformation> findAll();
    UserInformation save(UserInformation userInformation);
    void deleteById(String id);
}
