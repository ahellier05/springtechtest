package interview.hellier.heroku.SpringREST.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

/**
 * Represents POJO for User.
 *
 * Bugs: none known
 *
 * @author       Ashley Hellier
 * @version      SNAPSHOT-0.0.1
 *
 */

//To indicate that this is serializable in order specified
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "first_name",
        "last_name",
        "email",
        "ip_address",
        "latitude",
        "longitude"
})

public class User implements Serializable {

    @JsonProperty("id")
    private int id;
    @JsonProperty("first_name")
    private String first_name;
    @JsonProperty("last_name")
    private String last_name;
    @JsonProperty("email")
    private String email;
    @JsonProperty("ip_address")
    private String ip_address;
    @JsonProperty("latitude")
    private double latitude;
    @JsonProperty("longitude")
    private double longitude;

    @JsonCreator //for deserialization
    public User(@JsonProperty("id") int id,
                @JsonProperty("first_name") String first_name,
                @JsonProperty("last_name") String last_name,
                @JsonProperty("email") String email,
                @JsonProperty("ip_address") String ip_address,
                @JsonProperty("latitude") double latitude,
                @JsonProperty("longitude") double longitude) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ip_address = ip_address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "User: [id= "+ id + ", first name= " + first_name + ", last name= " + last_name + ", email= " + email + ", IP Address= " + ip_address + ", latitude= " + latitude + ", longitude= " + longitude + " ]";
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }
}
