


package org.project.services;

import java.util.List;

import org.project.models.ProductCatModel;
import org.project.repo.ProductCatRepo;
import org.project.repo.ProductCatRepoImpl;

public class ProductCatServiceImpl implements ProductCatService {

    // Declare the repository instance
    ProductCatRepo productrepo = new ProductCatRepoImpl();

    @Override
    public boolean isProductCat(ProductCatModel procat) {
        // Call the repository method to check if the product category exists
        return productrepo.isProductCat(procat); 
    }
    
    
    @Override
    public List<ProductCatModel> getAllProductCats() {
        return productrepo.getAllProductCats();  // Call the repo method to fetch all categories
    }
    
    
    @Override
    public boolean addProductCat(ProductCatModel procat) {
        return productrepo.addProductCat(procat);  // Call the repo method to add category
    }
}
