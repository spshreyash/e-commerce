package org.project.services;

import java.util.List;

import org.project.models.ProductCatModel;

public interface ProductCatService {

	 boolean isProductCat(ProductCatModel procat);

//	 get all categories  ==>
	 
	 List<ProductCatModel> getAllProductCats();  
	 
	  boolean addProductCat(ProductCatModel procat); 
}
