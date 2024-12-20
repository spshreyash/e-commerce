package org.project.repo;
import java.util.List;
import org.project.models.ProductCatModel;

public interface ProductCatRepo {
	

	 boolean isProductCat(ProductCatModel procat);
	

	    List<ProductCatModel> getAllProductCats();
	    
	    boolean addProductCat(ProductCatModel procat); 

}
