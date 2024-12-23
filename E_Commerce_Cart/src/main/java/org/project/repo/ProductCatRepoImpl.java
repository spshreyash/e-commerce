//
//
//
//package org.project.repo;
//
//



package org.project.repo;

import org.project.models.ProductCatModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


    
    public class ProductCatRepoImpl extends DBState implements ProductCatRepo {

        @Override
        public boolean isProductCat(ProductCatModel procat) {
        	// Query to check the category name and stuff 
            String query = "select  * from productcategories where name = ?";  
            try {
                
                stmt = conn.prepareStatement(query);

                // Set the query para/
                stmt.setString(1, procat.getName());

                
                
                
                
                
                rs = stmt.executeQuery();

                // If the result set contains data, return true (category exists)
                return rs.next(); 

            } catch (SQLException ex) {
                System.out.println("Error in isProductCat: " + ex.getMessage());
                return false; 
            }
        }


        public List<ProductCatModel> getAllProductCats() {
            List<ProductCatModel> categories = new ArrayList<>();
            String query = "select  * from  productcategories";  
            try {
                stmt = conn.prepareStatement(query);
                rs = stmt.executeQuery();
                while (rs.next()) {
                    ProductCatModel category = new ProductCatModel();
                    category.setName(rs.getString("name"));
                    
                    // here we add product cat list in list ok met
                    categories.add(category);
                }
            } catch (SQLException ex) {
                System.out.println("error in product catageries : " + ex.getMessage());
            }
            return categories;
 }
        
        public boolean addProductCat(ProductCatModel procat) {
        	//   only add  new category
            String query = "insert into  productcategories (name) values  (?)";  
            try {
                stmt = conn.prepareStatement(query);
                stmt.setString(1, procat.getName());  // Set the category name
                int values = stmt.executeUpdate();

                return values > 0;  // Return true if the category is added successfully
            } catch (SQLException ex) {
                System.out.println("Error in addProductCat: " + ex.getMessage());
                return false;  // Return false if there's an error
            }
        }
}
