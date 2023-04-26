package service;

import model.Address;
import model.AddressSubmit;
import repo.AddressRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressService {
    @Inject
    AddressRepository addressRepository;
    private List<Address> addresses = new ArrayList<>();

    public Address getAddress(String id) {
        return addresses.get(0);
    }

    public void persist(AddressSubmit address) {
        addressRepository.findByHash(address.getHash()).ifPresentOrElse(value -> System.out.println("is present"), () -> addressRepository.persist(address.toMongoAddress()));
    }

}
