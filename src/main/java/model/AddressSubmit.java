package model;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class AddressSubmit {
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String zip;
    private String hash;

    public AddressSubmit(String street, String city, String state, String country, String zip) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        setHash();
    }

    private void setHash() {
        String hashValues = (new StringBuffer()).append(street).append(city).append(state).append(country).append(zip).toString();
        this.hash = Hashing.sha256().hashString(hashValues, StandardCharsets.UTF_8).toString();
    }

    public Address toMongoAddress() {
        Address address = new Address();
        address.street = this.street;
        address.city = this.city;
        address.state = this.state;
        address.country = this.country;
        address.hash = this.hash;
        address.zip = this.zip;
        return address;
    }

    public String getHash() {
        return hash;
    }
}
