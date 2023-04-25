package service;

import com.mongodb.client.MongoClient;
import model.Address;
import repo.AddressRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class AddressService {
    @Inject
    AddressRepository addressRepository;
    private List<Address> addresses = new ArrayList<>();

    public Address getAddress(String id) {
        return addresses.get(0);
    }

    public void persist(Address address) {
        addressRepository.persist(address);
    }

}
