package service;

import model.Address;
import model.AddressSubmit;
import org.bson.types.ObjectId;
import repo.AddressRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AddressService {
    @Inject
    AddressRepository addressRepository;

    public Address getAddress(String id) {
        return addressRepository.findById(new ObjectId(id));
    }

    public void persist(AddressSubmit address) {
        addressRepository.findByHash(address.getHash()).ifPresentOrElse(value -> System.out.println("is present"), () -> addressRepository.persist(address.toMongoAddress()));
    }

}
