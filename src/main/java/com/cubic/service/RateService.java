package com.cubic.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cubic.dao.RateDao;
import com.cubic.exceptions.ApiRequestException;
import com.cubic.model.Rates;




@Service
public class RateService {
	
	@Autowired
	private RateDao rateDao;
	
	public boolean productRate(Rates rate, String barcode) {
		if(rate.getRate()<=10 && rate.getRate()>=0) {
			try {
				rateDao.insertRate(barcode,rate.getRate());
				return true;
			}catch (Exception e) {
				throw new ApiRequestException("The rate couldn't have been inserted!");
			}
			
			
		}else {
			throw new ApiRequestException("Rate should be in 1-10 range!");
		}
	}

	}
