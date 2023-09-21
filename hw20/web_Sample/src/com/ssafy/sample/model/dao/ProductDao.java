package com.ssafy.sample.model.dao;

import java.util.List;

import com.ssafy.sample.dto.ProductDto;

public interface ProductDao {

	List<ProductDto> listProduct();
	ProductDto viewProduct(String code);

}
