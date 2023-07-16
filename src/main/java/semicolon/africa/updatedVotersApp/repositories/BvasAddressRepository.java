package semicolon.africa.updatedVotersApp.repositories;

import semicolon.africa.updatedVotersApp.models.Address;
import semicolon.africa.updatedVotersApp.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BvasAddressRepository implements AddressRepository{
    List<Address>addressList = new ArrayList<>();

        @Override
    public Address findById(String id) {
            for(Address address: addressList){
                boolean sameAddress = Objects.equals(address.getId(), id);
                if (sameAddress) return address;
            }
        return null;
    }

    @Override
    public List<Address> findAll() {
        return addressList;
    }

    @Override
    public Address save(Address address) {
            String id = AppUtils.generatedId();
            address.setId(id);
            addressList.add(address);
        return  address;
    }

    @Override
    public void deleteById(String id) {
            Address foundAddress = findById(id);
            addressList.remove(foundAddress);
    }
}
