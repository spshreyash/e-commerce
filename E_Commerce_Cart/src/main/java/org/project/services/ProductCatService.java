package org.project.services;

import java.util.List;

import org.project.models.ProductCatModel;

public interface ProductCatService {

	 boolean isProductCat(ProductCatModel procat);
//	 List<ProductCatModel> getAllProductCategories();  // Method to fetch all product categories
	 
	 List<ProductCatModel> getAllProductCats();  // New method to get all categories
	 
	  boolean addProductCat(ProductCatModel procat);  // Add this method
}