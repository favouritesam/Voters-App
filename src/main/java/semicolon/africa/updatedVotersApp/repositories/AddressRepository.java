package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Address;

import java.util.List;

public interface AddressRepository {
    Address findById(String id);
    List<Address> findAll();
    Address save(Address address);
    void deleteById(String id);
}
