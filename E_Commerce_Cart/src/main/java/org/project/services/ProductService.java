package org.project.services;

import org.project.models.ProductsModel;
import java.util.List;

public interface ProductService {

    // Method to create or update a product
    void saveOrUpdateProduct(ProductsModel product);

    // Method to delete a product
    void deleteProduct(int pid);

    // Method to get all products
    List<ProductsModel> getAllProducts();

    // Method to get a product by ID
    ProductsModel getProductById(int pid);

    // Method to filter products by price (max price)
    List<ProductsModel> getProductsByPrice(int maxPrice);

    // Method to filter products by quantity (min quantity)
    List<ProductsModel> getProductsByQuantity(int minQuantity);

    // Method to update product's price and quantity
    void updateProductPriceAndQuantity(int pid, int price, int quantity);
}
