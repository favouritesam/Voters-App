package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.UserInformation;
import semicolon.africa.updatedVotersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasUserInformationRepository implements  UserInformationRepository{
    ArrayList<UserInformation>userInformations = new ArrayList<>();
    @Override
    public UserInformation findById(String id) {
        for (UserInformation userInformation:userInformations){
            if (userInformation.getUserId().equals(id))return userInformation;
        }
        return null;
    }

    @Override
    public List<UserInformation> findAll() {
        return userInformations;
    }

    @Override
    public UserInformation save(UserInformation userInformation) {
        userInformation.setUserId(AppUtils.generatedId());
        userInformations.add(userInformation);
        return userInformation;
    }

    @Override
    public void deleteById(String id) {
        UserInformation foundUserInformation = findById(id);
        if (foundUserInformation != null) userInformations.remove(foundUserInformation);

    }
}
