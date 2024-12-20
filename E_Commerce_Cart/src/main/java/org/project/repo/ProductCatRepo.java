package org.project.repo;
import java.util.List;
import org.project.models.ProductCatModel;

public interface ProductCatRepo {
	

	 boolean isProductCat(ProductCatModel procat);
	
//	 List<ProductCatModel> getAllProductCategories();  // Method to get all categories
	    List<ProductCatModel> getAllProductCats();
	    
	    boolean addProductCat(ProductCatModel procat); 

}
