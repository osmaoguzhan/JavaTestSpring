package com.cubic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.cubic.model.Rates;
import com.cubic.service.RateService;


@RestController
public class RateController {
	@Autowired 
	RateService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/rate/{barcode}")
	public String productRate(@RequestBody Rates rate,@PathVariable String barcode) {
		service.productRate(rate,barcode);
		return HttpStatus.OK.toString();
		
	}
}
