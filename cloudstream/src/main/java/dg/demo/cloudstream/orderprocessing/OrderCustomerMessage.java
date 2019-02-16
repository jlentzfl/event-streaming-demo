package dg.demo.cloudstream.orderprocessing;

import com.fasterxml.jackson.annotation.JsonAlias;

public class OrderCustomerMessage {

    @JsonAlias("order_number")
    private String orderNumber;

    @JsonAlias("customer_email")
    private String customerEmail;

    @JsonAlias("first_name")
    private String firstName;

    @JsonAlias("last_name")
    private String lastName;

    private String street;

    private String city;

    private String state;

    private String zip;

    public String getOrderNumber() {
        return orderNumber;
    }

    public OrderCustomerMessage setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public OrderCustomerMessage setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public OrderCustomerMessage setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public OrderCustomerMessage setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public OrderCustomerMessage setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public OrderCustomerMessage setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public OrderCustomerMessage setState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public OrderCustomerMessage setZip(String zip) {
        this.zip = zip;
        return this;
    }
}
