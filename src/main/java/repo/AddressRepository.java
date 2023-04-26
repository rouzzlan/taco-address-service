package repo;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import model.Address;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class AddressRepository implements PanacheMongoRepository<Address> {
    public Optional<Address> findByHash(String hash) {
        return find("hash", hash).firstResultOptional();
    }
}
