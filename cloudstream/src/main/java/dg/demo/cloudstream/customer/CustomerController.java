package dg.demo.cloudstream.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(path = "/customers")
    public Iterable<Customer> getCustomers(){
        return customerRepository.findAll();
    }
}
