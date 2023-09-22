package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.ProductDto;
import com.ssafy.sample.model.dao.ProductDao;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {

	private static ProductService productService = new ProductServiceImpl();
	private ProductDao productDao;
	
	private ProductServiceImpl() {
		productDao = ProductDaoImpl.getProductDao();
	}
	
	public static ProductService getProductService() {
		return productService;
	}

	@Override
	public List<ProductDto> listProduct() {
		return productDao.listProduct();
	}

	@Override
	public ProductDto viewProduct(String code) {
		return productDao.viewProduct(code);
	}
	
}
