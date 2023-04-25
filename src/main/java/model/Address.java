package model;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.types.ObjectId;

import java.nio.charset.StandardCharsets;

public class Address extends PanacheMongoEntity {
    public ObjectId id;
    public String street;
    public String city;
    public String state;
    public String country;
    public String zip;
    public String hash;

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
}
