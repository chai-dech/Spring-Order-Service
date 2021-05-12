package spring.orderservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import spring.orderservice.Model.Order;

import java.util.Arrays;
import java.util.List;

@RestController
public class OrderServiceController {


    List<Order> orders = Arrays.asList( new Order(1, 1, "order1"),
                                        new Order(2, 1, "order2"),
                                        new Order(3, 2, "order3"),
                                        new Order(4, 2, "order4"),
                                        new Order(5, 1, "order5"));


    @GetMapping
    public List<Order> getAllOrders(){
        return orders;
    }

    @GetMapping("{/id}")
    public Order getOrderById(@PathVariable int id){
       return orders.stream()
                .filter(orders -> orders.getId() == id)
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
