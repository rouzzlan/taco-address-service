package model;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class Address extends PanacheMongoEntity {
    public ObjectId id;
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
