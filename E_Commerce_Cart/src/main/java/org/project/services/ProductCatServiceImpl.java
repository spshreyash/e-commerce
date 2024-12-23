


package org.project.services;

import java.util.List;

import org.project.models.ProductCatModel;
import org.project.repo.ProductCatRepo;
import org.project.repo.ProductCatRepoImpl;

public class ProductCatServiceImpl implements ProductCatService {

    //  repository object-> 
    ProductCatRepo productrepo = new ProductCatRepoImpl();

    @Override
    public boolean isProductCat(ProductCatModel procat) {
        // Cal  repository method to check  product category exists
        return productrepo.isProductCat(procat); 
    }
    
    
    @Override
    public List<ProductCatModel> getAllProductCats() {
    	
    	 // cal repo method get all categories
        return productrepo.getAllProductCats(); 
    }
    
    
    @Override
    public boolean addProductCat(ProductCatModel procat) {
    	
    	
//    	Call  repo method fr add category
        return productrepo.addProductCat(procat);  
    }
}
