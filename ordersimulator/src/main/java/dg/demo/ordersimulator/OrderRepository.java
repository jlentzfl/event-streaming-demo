package dg.demo.ordersimulator;

import org.springframework.data.repository.CrudRepository;


public interface OrderRepository extends CrudRepository<Order,String> {
}
