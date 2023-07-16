package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Admin;

import java.util.List;

public interface AdimRepository {
    Admin findById(String id);
    List<Admin> findAll();

     Admin save(Admin admin);

    void deleteById(String id);


}
