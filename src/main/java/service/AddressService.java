package service;

import model.Address;
import model.AddressHash;
import model.AddressSubmit;
import repo.AddressRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class AddressService {
    @Inject
    AddressRepository addressRepository;

    public Optional<Address> getAddress(String hash) {
        return addressRepository.findByHash(hash);
    }

    public AddressHash persist(AddressSubmit address) {
        AddressHash addressHash = new AddressHash(address.getHash());
        addressRepository.findByHash(address.getHash()).ifPresentOrElse(value -> System.out.println("is present"), () -> addressRepository.persist(address.toMongoAddress()));
        return addressHash;
    }

}
