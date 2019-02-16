package dg.demo.ordersimulator;

import javax.persistence.*;

@Entity
@Table(name = "orderlines")
public class OrderLine {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int lineNumber;
    private String sku;
    private Integer quantity;

    public String getSku() {
        return sku;
    }

    public OrderLine setSku(String sku) {
        this.sku = sku;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderLine setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
