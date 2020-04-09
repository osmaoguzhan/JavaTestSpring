package com.cubic.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.model.Product;
import com.cubic.service.Wrapper;
import com.cubic.service.WrapperRatesOfProduct;
import com.sipios.springsearch.anotation.SearchSpec;
import com.cubic.service.ProductService;




@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/products")
	public List<WrapperRatesOfProduct> getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo, 
            @RequestParam(defaultValue = "5") Integer pageSize,@SearchSpec Specification<Product> specs){
		List<WrapperRatesOfProduct> allProducts = productService.allProducts(pageNo,pageSize,Specification.where(specs));
		return allProducts;
	}
	@RequestMapping(method = RequestMethod.PUT, value="/product/update/{barcode}")
	public String updateProduct(@RequestBody Product product,@PathVariable String barcode) {
		String username= getName();
		return productService.updateProduct(product,barcode,username);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/products/{barcode}")
	public Wrapper getProduct(@PathVariable String barcode) {
		return productService.getProduct(barcode);
	}
	
	public String getName() {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		return user.getUsername();
	}
	
}
