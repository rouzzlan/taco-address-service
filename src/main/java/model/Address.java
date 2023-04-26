package model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Address extends PanacheMongoEntity {
    public String street;
    public String city;
    public String state;
    public String country;
    public String zip;
    public String hash;

    public Address(String street, String city, String state, String country, String zip, String hash) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.hash = hash;
    }

    public Address() {
    }

}
