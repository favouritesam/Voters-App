package semicolon.africa.updatedVotersApp.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import semicolon.africa.updatedVotersApp.models.Address;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BvasAddressRepositoryTest {
    private final AddressRepository addressRepository = new BvasAddressRepository();

    private Address saveAddress;

    @BeforeEach
    void setUp() {
        Address address = buildTestAddress();
        saveAddress = addressRepository.save(address);
    }
    @DisplayName("Save Addressing")
    @Test
    public  void testSaveAddress(){
        assertNotNull(saveAddress);
        assertNotNull(saveAddress.getId());
    }

    @DisplayName("Find id")
    @Test
    public void testFindById(){
        Address foundAddress = addressRepository.findById(saveAddress.getId());
        assertNotNull(foundAddress);
    }
    @DisplayName("Find All Voter")
    @Test
    public void testFindAllVoter(){
        Address secondAddress = new Address();
        Address thirdAddress = new Address();
        addressRepository.save(secondAddress);
        addressRepository.save(thirdAddress);
        List<Address>addressList = addressRepository.findAll();
        assertEquals(3,addressList.size());
        assertNotNull(addressList.get(0));
        assertNotNull(addressList.get(1));
        assertNotNull(addressList.get(2));
    }
    @DisplayName("Delete Voter By Id")
    @Test
    public void testDeleteVoterById(){
        Address secondAddress = new Address();
        Address secondSaveAddress = addressRepository.save(secondAddress);
        List<Address> addressList = addressRepository.findAll();
        assertEquals(2,addressList.size());
        addressRepository.deleteById(secondSaveAddress.getId());
        addressList = addressRepository.findAll();
        assertEquals(1,addressList.size());

    }

    private Address buildTestAddress() {
        Address address = new Address();
        address.setStreet("ikorodu");
        address.setTown("okoko");
        address.setState("lagos");
        return address;
    }
}