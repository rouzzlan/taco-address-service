package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Address;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddressRepository implements PanacheMongoRepository<Address> {
    public Address findByHash(String hash) {
        return find("hash", hash).firstResult();
    }
}
