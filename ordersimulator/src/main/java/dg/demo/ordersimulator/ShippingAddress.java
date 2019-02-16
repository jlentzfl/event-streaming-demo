package dg.demo.ordersimulator;

import javax.persistence.*;

@Entity
@Table(name = "shippingAddress")
public class ShippingAddress {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long shippingAddressId;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zip;

    public String getFirstName() {
        return firstName;
    }

    public ShippingAddress setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ShippingAddress setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public ShippingAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ShippingAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public ShippingAddress setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public ShippingAddress setZip(String zip) {
        this.zip = zip;
        return this;
    }
}
