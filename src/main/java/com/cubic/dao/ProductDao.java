package com.cubic.dao;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cubic.model.Product;
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>,JpaSpecificationExecutor<Product>{
	
    
    @Query(value = "SELECT userID FROM product WHERE barcode=?1", nativeQuery = true)
	int findByBarcode(String barcode);
    
    @Query(value = "SELECT barcode,name,description,price FROM product WHERE barcode=?1", nativeQuery = true)
	Product getProductByBarcode(String barcode);
    
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE product SET name = :name , description = :description, price= :price WHERE barcode= :barcode", nativeQuery = true)
    @Transactional
	void updateProduct(
			@Param("name") String name,
			@Param("description") String description,
			@Param("price") float price,
			@Param("barcode") String barcode
			);

	Page<Product> findAll(@SuppressWarnings("rawtypes") Specification spec,Pageable paging);

}



    


