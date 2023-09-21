package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.ProductDto;

public interface ProductService {

	List<ProductDto> listProduct();
	ProductDto viewProduct(String code);

}
