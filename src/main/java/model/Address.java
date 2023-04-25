package model;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class Address {
    private String id;
    private String street;
    private String city;
    private String state;
    private String country;
    private String zip;
    private String hash;

    public Address(String street, String city, String state, String country, String zip) {
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

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getZip() {
        return zip;
    }

    public String getHash() {
        return hash;
    }

    public String getId() {
        return id;
    }
}
