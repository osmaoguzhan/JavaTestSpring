package com.cubic.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cubic.model.Rates;

@Repository
public interface RateDao extends JpaRepository<Rates, Integer> {
	
	@Query(value = "SELECT rate FROM rates WHERE pBarcode= :barcode", nativeQuery = true)
	List<Float>findByBarcode(@Param("barcode")String barcode);
	
	@Query(value = "SELECT AVG(rate) FROM rates WHERE pBarcode= :barcode", nativeQuery = true)
	float findForProduct(@Param("barcode")String barcode);
	
	@Query(value = "INSERT INTO rates VALUES (:barcode,:rate)",nativeQuery = true)
	@Transactional
	boolean insertRate(@Param("rate") float rate,@Param("barcode") String barcode);
	
    @Modifying
    @Query(value = "INSERT INTO rates(pBarcode,rate) VALUES (:barcode,:rate)",nativeQuery = true)
    @Transactional
    void insertRate(
    		@Param("barcode") String barcode,
    		@Param("rate") float rate
    		);

	
}
