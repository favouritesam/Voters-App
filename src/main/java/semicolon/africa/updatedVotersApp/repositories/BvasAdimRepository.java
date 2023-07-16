package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Admin;
import semicolon.africa.updatedVotersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class BvasAdimRepository implements AdimRepository{

    List<Admin> admins = new ArrayList<>();
    @Override
    public Admin findById(String id) {
        for (Admin admin: admins){
            if (admin.getId().equals(id))return  admin;


        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return admins;


    }


    @Override
    public Admin save(Admin admin) {
        String id = AppUtils.generatedId();
        admin.setId(id);
        admins.add(admin);
        return admin;
    }

    @Override
    public void deleteById(String id) {
        Admin foundAdmin = findById(id);
        if (foundAdmin != null) admins.remove(foundAdmin);

    }
}
