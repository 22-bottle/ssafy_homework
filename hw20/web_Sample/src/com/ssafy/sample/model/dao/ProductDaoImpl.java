package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.sample.dto.ProductDto;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {

	private static ProductDao productDao = new ProductDaoImpl();
	private DBUtil dbUtil;
	
	private ProductDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	
	public static ProductDao getProductDao() {
		return productDao;
	}

	@Override
	public List<ProductDto> listProduct() {
		List<ProductDto> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from product \n");
			sql.append("order by code");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductDto productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
				list.add(productDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return list;
	}

	@Override
	public ProductDto viewProduct(String code) {
		ProductDto productDto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select * \n");
			sql.append("from product \n");
			sql.append("where code = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				productDto = new ProductDto();
				productDto.setCode(rs.getString("code"));
				productDto.setModel(rs.getString("model"));
				productDto.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return productDto;
	}
	
}
