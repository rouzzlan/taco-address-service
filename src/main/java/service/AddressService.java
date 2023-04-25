package service;

import model.Address;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class AddressService {
    private List<Address> addresses = new ArrayList<>();

    public Address getAddress(String id) {
        return addresses.get(0);
    }

    @PostConstruct
    private void setup() {
        addresses.add(new Address("Kloosterstraat 27A", "Emblem", "Antwerp", "Belgium", "2520"));
        addresses.add(new Address("Turnhoutsebaan 333", "Borgerhout", "Antwerp", "Belgium", "2520"));
    }
}
