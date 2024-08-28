//package com.mobile.demo;
//
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.doNothing;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//import com.mobile.demo.entity.OrderDetail;
//import com.mobile.demo.entity.Product;
//import com.mobile.demo.entity.User;
//import com.mobile.demo.Exception.OutOfStockException;
//import com.mobile.demo.Exception.ProductNotFoundException;
//import com.mobile.demo.repository.OrderRepository;
//import com.mobile.demo.repository.ProductRepository;
//import com.mobile.demo.repository.UserRepository;
//import com.mobile.demo.service.OrderService;
//
//@SpringBootTest(classes = {OrderServiceMockitoTests.class})
//public class OrderServiceMockitoTests {
//
//    @Mock
//    OrderRepository orderRepository;
//
//    @Mock
//    ProductRepository productRepository;
//
//    @Mock
//    UserRepository userRepository;
//
//    @InjectMocks
//    OrderService orderService;
//
//    @Test
//    @Order(1)
//    public void test_createOrder() {
//        // Create mock data for user, products, and order details
//        User user = new User(Long.valueOf(1), "john_doe", "password123", "john@example.com", "1234567890", "New York");
//        Product product1 = new Product(1L, "BrandA", "ModelA", "DescriptionA", 100.0, 50, "ProductA");
//        Product product2 = new Product(2L, "BrandB", "ModelB", "DescriptionB", 200.0, 30, "ProductB");
//
//        OrderDetail orderDetail1 = new OrderDetail();
//        orderDetail1.setProduct(product1);
//        orderDetail1.setQuantity(2);
//
//        OrderDetail orderDetail2 = new OrderDetail();
//        orderDetail2.setProduct(product2);
//        orderDetail2.setQuantity(1);
//
//        List<OrderDetail> orderDetails = new ArrayList<>();
//        orderDetails.add(orderDetail1);
//        orderDetails.add(orderDetail2);
//
//        Order order = new Order();
//        order.setUser(user);
//        order.setOrderDetails(orderDetails);
//        order.setOrderStatus("Pending");
//        
//        // Mock the repository methods
//        when(userRepository.existsById(user.getUserid())).thenReturn(true);
//        when(productRepository.findById(product1.getProductid())).thenReturn(Optional.of(product1));
//        when(productRepository.findById(product2.getProductid())).thenReturn(Optional.of(product2));
//        when(orderRepository.save(order)).thenReturn(order);
//
//        // Call the service method
//        Order createdOrder = orderService.createOrder(order, orderDetails);
//
//        // Assert the result
//        assertEquals(user.getUserid(), createdOrder.getUser().getUserid());
//        assertEquals(2, createdOrder.getOrderDetails().size());
//        assertEquals(400.0, createdOrder.getTotalAmount()); // 2 * 100.0 + 1 * 200.0
//    }
//}
//
