package org.project.services;

import org.project.models.ProductsModel;
import org.project.repo.ProductsRepo;
import org.project.repo.ProductsRepoImpl;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    // Declare a repository object
    ProductsRepo productrepo = new ProductsRepoImpl();

    @Override
    public void saveOrUpdateProduct(ProductsModel product) {
        productrepo.saveOrUpdateProduct(product);
    }
 
    @Override
    public void deleteProduct(int pid) {
        productrepo.deleteProduct(pid);
    }

    @Override
    public List<ProductsModel> getAllProducts() {
        return productrepo.getAllProducts();
    }

    @Override
    public ProductsModel getProductById(int pid) {
        return productrepo.getProductById(pid);
    }

    @Override
    public List<ProductsModel> getProductsByPrice(int maxPrice) {
        return productrepo.getProductsByPrice(maxPrice);
    }

    @Override
    public List<ProductsModel> getProductsByQuantity(int minQuantity) {
        return productrepo.getProductsByQuantity(minQuantity);
    }

    @Override
    public void updateProductPriceAndQuantity(int pid, int price, int quantity) {
        productrepo.updateProductPriceAndQuantity(pid, price, quantity);
    }
}
