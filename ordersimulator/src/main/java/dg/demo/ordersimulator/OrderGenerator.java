package dg.demo.ordersimulator;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class OrderGenerator {
    @Autowired
    OrderRepository orderRepository;

    @Scheduled(fixedDelay = 30000)
    public void createOrder(){
        Faker faker = new Faker();
        Order order = new Order();

        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setStreet(faker.address().streetAddress())
                .setCity(faker.address().city())
                .setState(faker.address().stateAbbr())
                .setZip(faker.address().zipCode());

        OrderLine orderLine = new OrderLine();
        orderLine.setSku(faker.number().digits(5))
                .setQuantity(faker.number().randomDigitNotZero());

        order.setCustomerEmail(faker.internet().safeEmailAddress())
                .setShippingAddress(shippingAddress)
                .setOrderLines(Stream.of(orderLine).collect(Collectors.toSet()));

        orderRepository.save(order);
    }
}
