package dg.demo.ordersimulator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private long orderNumber;

    private String customerEmail;

    @OneToOne(cascade=CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @OneToMany(cascade=CascadeType.ALL)
    private Set<OrderLine> orderLines;

    private boolean processed;


    public long getOrderNumber() {
        return orderNumber;
    }

    public Order setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
        return this;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Order setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
        return this;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public Order setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
        return this;
    }

    public Set<OrderLine> getOrderLines() {
        return orderLines;
    }

    public Order setOrderLines(Set<OrderLine> orderLines) {
        this.orderLines = orderLines;
        return this;
    }

    public boolean isProcessed() {
        return processed;
    }

    public Order setProcessed(boolean processed) {
        this.processed = processed;
        return this;
    }
}
