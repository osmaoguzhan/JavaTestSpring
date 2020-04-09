package com.cubic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cubic.dao.ProductDao;
import com.cubic.dao.RateDao;
import com.cubic.dao.UserDao;
import com.cubic.exceptions.ApiRequestException;
import com.cubic.model.Product;



@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired 
	private RateDao rateDao;

	
	public String updateProduct(Product product,String barcode,String username) {
		int userID;
		try {
			userID= productDao.findByBarcode(barcode);
		}catch(Exception e) {
			throw new ApiRequestException("UserID couldn't have been found!");
			}
		
		if(userID!=userDao.findUserByUsername(username).getId()) {
			throw new ApiRequestException("You don't have permission to update products' details!");
		}else {
			productDao.updateProduct(
					product.getName(),
					product.getDescription(),
					product.getPrice(),
					barcode
					);
		}
		return HttpStatus.OK.toString();
	}

	public List<WrapperRatesOfProduct> allProducts(Integer pageNo, Integer pageSize,Specification<Product> specs){
		Pageable paging = PageRequest.of(pageNo, pageSize);
		final List<WrapperRatesOfProduct> mergedProducts = new ArrayList<WrapperRatesOfProduct>(); 
		try {
			Page<Product> products = productDao.findAll(specs,paging);
			float defaultRate = 0;
			
			for (Product product : products) {
				float avgOfRates = 0;
				WrapperRatesOfProduct mergeInf = new WrapperRatesOfProduct();
				List<Float>rate = rateDao.findByBarcode(product.getBarcode());
				if(rate.isEmpty()) {
					mergeInf.setRate(defaultRate);
				}else {
					for (int i = 0; i < rate.size(); i++) {
						avgOfRates = avgOfRates + rate.get(i);
					}
					mergeInf.setRate(avgOfRates/rate.size());
				}
			
				mergeInf.setBarcode(product.getBarcode());
				mergeInf.setName(product.getName());
				mergeInf.setDescription(product.getDescription());
				mergeInf.setPrice(product.getPrice());
				mergedProducts.add(mergeInf);
			}
				
			}catch (Exception e) {
				throw new ApiRequestException("Got an error while fetching products and rates!");
			}
		
		
		return mergedProducts;
	}

	public Wrapper getProduct(String barcode) {
		Wrapper productRate = new Wrapper();
		try {
			Product product = productDao.getProductByBarcode(barcode);
			try{
				List<Float> rates = rateDao.findByBarcode(barcode);
				
				productRate.setBarcode(barcode);
				productRate.setName(product.getName());
				productRate.setDescription(product.getDescription());
				productRate.setPrice(product.getPrice());
				productRate.setRate(rates);
			}catch (Exception e) {
				throw new ApiRequestException("Rates couldn't have been fetched by barcode!");
			}

		}catch (Exception e) {
			throw new ApiRequestException("Product couldn't have been fetched by barcode!");
		}
		
		return productRate;
	}


}
