


package org.project.repo;

import org.project.models.ProductsModel;
import java.util.List;

public interface ProductsRepo {
    void saveOrUpdateProduct(ProductsModel product);
    void deleteProduct(int pid);
    List<ProductsModel> getAllProducts();
    ProductsModel getProductById(int pid);
    
    // New methods for filtering and updating products
    List<ProductsModel> getProductsByPrice(int maxPrice);
    List<ProductsModel> getProductsByQuantity(int minQuantity);
    void updateProductPriceAndQuantity(int pid, int price, int quantity);
}
