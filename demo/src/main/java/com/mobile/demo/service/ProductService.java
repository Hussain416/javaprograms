package com.mobile.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.mobile.demo.Exception.ProductNotFoundException;
import com.mobile.demo.Exception.UserNotFoundException;
import com.mobile.demo.entity.Product;
import com.mobile.demo.entity.User;
import com.mobile.demo.repository.ProductRepository;

import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
//    @PersistenceContext
//	private EntityManager entityManager;
//	 
//    private void resetAutoIncrement() {
//        // Find the maximum productid currently in the table
//        Long maxId = (Long) entityManager.createQuery("SELECT COALESCE(MAX(p.productid), 0) FROM Product p").getSingleResult();
//        
//        // Reset the auto-increment value to maxId + 1
//        entityManager.createNativeQuery("ALTER TABLE product AUTO_INCREMENT = :newId")
//                     .setParameter("newId", maxId + 1)
//                     .executeUpdate();
//    }
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
		
	public Product getProductById( Long productid) {
		return productRepository.findById(productid).orElseThrow(()-> new ProductNotFoundException("Product with"+ productid + " not found"));
	}	
	
//	public void deleteById(Long productid) {
//        productRepository.deleteById(productid);
//    }


	
//	 @Transactional
//	    public Product updateProductQuantity(Long productId, int quantity) {
//	        Product product = getProductById(productId);
//	        product.setStockQuantity(quantity);
//	        return productRepository.save(product);
//	    }
	@Transactional
	public Product updateProductQuantity(Long productId, int quantity) {
	    Product product = productRepository.findById(productId)
	            .orElseThrow(() -> new RuntimeException("Product not found"));

	    product.setStockQuantity(product.getStockQuantity() + quantity); // Add to the existing quantity
	    return productRepository.save(product);
	}

	public boolean deleteProductById(Long productid) {
		if(!productRepository.existsById(productid)) {
			throw new ProductNotFoundException("Product with ID " + productid + "not found for deletion");
		}
		productRepository.deleteById(productid);
	//	resetAutoIncrement();
		return true;
		
	}
	
	

	
}
