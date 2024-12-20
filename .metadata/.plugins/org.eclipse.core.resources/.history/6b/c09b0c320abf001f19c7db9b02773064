//
//
//
//package org.project.repo;
//
//import org.project.models.ProductCatModel;
//import java.sql.*;
//
//public class ProductCatRepoImpl extends DBState implements ProductCatRepo {
//
//    @Override
//    public boolean isProductCat(ProductCatModel procat) {
//        String query = "select  * from  productcategories where name = ?";
//
//        try {
//            // Prepare the statement with the query
//            stmt = conn.prepareStatement(query);
//
//            // Set the parameter for the query (category name)
//            stmt.setString(1, procat.getName());
//
//            // Execute the query
//            rs = stmt.executeQuery();
//
//            // If the result set contains data, return true (category exists)
//            return rs.next(); 
//
//        } catch (SQLException ex) {
//            System.out.println("Error in isProductCat: " + ex.getMessage());
//            return false; // Return false if there's an error or category doesn't exist
//        }
//    }
//}



package org.project.repo;

import org.project.models.ProductCatModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


    
    public class ProductCatRepoImpl extends DBState implements ProductCatRepo {

        @Override
        public boolean isProductCat(ProductCatModel procat) {
            String query = "SELECT * FROM productcategories WHERE name = ?";  // Query to check the category name
            try {
                // Prepare the statement with the query
                stmt = conn.prepareStatement(query);

                // Set the parameter for the query (category name)
                stmt.setString(1, procat.getName());

                // Execute the query
                rs = stmt.executeQuery();

                // If the result set contains data, return true (category exists)
                return rs.next(); 

            } catch (SQLException ex) {
                System.out.println("Error in isProductCat: " + ex.getMessage());
                return false;  // Return false if there's an error or category doesn't exist
            }
        }


        public List<ProductCatModel> getAllProductCats() {
            List<ProductCatModel> categories = new ArrayList<>();
            String query = "SELECT * FROM productcategories";  // Query to fetch all categories
            try {
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    ProductCatModel category = new ProductCatModel();
                    category.setName(rs.getString("name"));
                    // You can add more attributes to the ProductCatModel if needed
                    categories.add(category);
                }
            } catch (SQLException ex) {
                System.out.println("Error in getAllProductCats: " + ex.getMessage());
            }
            return categories;
 }
        
        public boolean addProductCat(ProductCatModel procat) {
            String query = "INSERT INTO productcategories (name) VALUES (?)";  // SQL to add a new category
            try {
                stmt = conn.prepareStatement(query);
                stmt.setString(1, procat.getName());  // Set the category name
                int rowsAffected = stmt.executeUpdate();

                return rowsAffected > 0;  // Return true if the category is added successfully
            } catch (SQLException ex) {
                System.out.println("Error in addProductCat: " + ex.getMessage());
                return false;  // Return false if there's an error
            }
        }
}
