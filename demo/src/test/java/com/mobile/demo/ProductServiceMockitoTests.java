//package com.mobile.demo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.mobile.demo.entity.Product;
//import com.mobile.demo.repository.ProductRepository;
//import com.mobile.demo.service.ProductService;
//
//@SpringBootTest(classes= {ProductServiceMockitoTests.class})
//public class ProductServiceMockitoTests {
//	
//	@Mock
//	ProductRepository productRepository;
//	
//	@InjectMocks
//	ProductService productService;
//
//	   public List<Product> myProducts;
//
////	   @Test
////	    @Order(1)
////	    public void test_getAllProducts() {
////	        List<Product> myProducts = new ArrayList<>();
////	        myProducts.add(new Product(1L, "Product1", "Brand1", "Model1", 100.0, "Description1", 10));
////	        myProducts.add(new Product(2L, "Product2", "Brand2", "Model2", 200.0, "Description2", 20));
////
////	        when(productRepository.findAll()).thenReturn(myProducts);
////
////	     //   assertEquals(2, productService.getAllProducts().size());
////	   assertEquals(2,productService.getAllProducts().size() ); 
////	   }
//}
package com.mobile.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mobile.demo.entity.Product;
import com.mobile.demo.repository.ProductRepository;
import com.mobile.demo.service.ProductService;

@SpringBootTest(classes = {ProductServiceMockitoTests.class})
public class ProductServiceMockitoTests {

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductService productService;

    @Test
    @Order(1)
    public void test_getAllProducts() {
        List<Product> myProducts = new ArrayList<>();
        myProducts.add(createProduct(1L, "BrandA", "ModelA", "DescriptionA", 100.0, 50, "ProductA"));
        myProducts.add(createProduct(2L, "BrandB", "ModelB", "DescriptionB", 200.0, 30, "ProductB"));

        when(productRepository.findAll()).thenReturn(myProducts);
        assertEquals(2, productService.getAllProducts().size());
    }

    @Test
    @Order(2)
    public void test_getProductById() {
        List<Product> myProducts = new ArrayList<>();
        myProducts.add(createProduct(1L, "BrandA", "ModelA", "DescriptionA", 100.0, 50, "ProductA"));
        myProducts.add(createProduct(2L, "BrandB", "ModelB", "DescriptionB", 200.0, 30, "ProductB"));

        when(productRepository.findById(1L)).thenReturn(Optional.of(myProducts.get(0)));
        when(productRepository.findById(2L)).thenReturn(Optional.of(myProducts.get(1)));

        assertEquals(1L, productService.getProductById(1L).getProductid());
        assertEquals(2L, productService.getProductById(2L).getProductid());
    }

    @Test
    @Order(3)
    public void test_saveProduct() {
        Product product = createProduct(3L, "BrandC", "ModelC", "DescriptionC", 300.0, 20, "ProductC");
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product, productService.saveProduct(product));
    }

    @Test
    @Order(4)
    public void test_deleteProductById() {
        Product product = createProduct(3L, "BrandC", "ModelC", "DescriptionC", 300.0, 20, "ProductC");

        // Mock the existence check and deletion behavior
        when(productRepository.existsById(3L)).thenReturn(true);
        when(productRepository.findById(3L)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).deleteById(3L);

        assertEquals(true, productService.deleteProductById(3L));
    }

    //The below method is helpful to create Product instances, making the test code cleaner and more readable.
    private Product createProduct(Long productid, String brand, String model, String description, double price, int stockQuantity, String productName) {
        Product product = new Product(productid, brand, model, description, price, stockQuantity, productName);
        return product;
    }
}
