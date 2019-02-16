package dg.demo.cloudstream.orderprocessing;

import dg.demo.cloudstream.customer.Customer;
import dg.demo.cloudstream.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrderToCustomerProcessor {

    @Autowired
    CustomerRepository customerRepository;

    @StreamListener(Sink.INPUT)
    public void createCustomerFromOrder(OrderCustomerMessage orderCustomerMessage){
        Customer customer = new Customer(orderCustomerMessage.getFirstName(),
                    orderCustomerMessage.getLastName(),
                    orderCustomerMessage.getCustomerEmail());

        customerRepository.save(customer);
    }
}
