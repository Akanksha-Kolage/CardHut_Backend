package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.lti.dao.ProductDao;
import com.lti.dto.UpdateProductDto;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.exception.ProductIdMissingException;
import com.lti.exception.ProductNotFoundException;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDao productDao;

	public String addProduct(Product product) {
		try {
			Product product2 = productDao.addOrUpdateProduct(product);
			return "Product Added Successfully. Product id is :" + product2.getProductId();
		} catch (Exception e) {
			return "Error Occured While Adding Product";
		}
	}

	public Product findProduct(int productId) {
		try {
			Product product2 = productDao.getProductById(productId);
			return product2;
		} catch (Exception e) {
			return null;
		}
	}

	public List<Product> viewProducts() {
		List<Product> product2 = productDao.viewAllProducts();
		return product2;
	}

	public UpdateProductDto updateProduct(Product product) {
		UpdateProductDto updateProduct = new UpdateProductDto();
		try {
			if (product.getProductId() == 0) {
				throw new ProductIdMissingException("Please mention product id.");
			} else if (productDao.getProductById(product.getProductId()) == null) {
				throw new ProductNotFoundException("Product not found.");
			} else {
				Product product2 = productDao.addOrUpdateProduct(product);
				updateProduct.setMsg("Updated Product Details.");
				updateProduct.setProduct(product2);
			}
		} catch (Exception e) {
			updateProduct.setMsg(e.getMessage());
			return updateProduct;
		}
		return updateProduct;
	}
}
