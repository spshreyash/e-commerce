package org.project.clientApp;

import java.util.Scanner;
import org.project.models.LoginModel;
import org.project.services.LoginService;
import org.project.services.LoginServiceImp;
import org.project.models.ProductCatModel;
import org.project.services.ProductCatService;
import org.project.services.ProductCatServiceImpl;
import org.project.models.ProductsModel;
import org.project.services.ProductService;
import org.project.services.ProductServiceImpl;

import java.util.List;

public class EcommerceMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoginService loginService = new LoginServiceImp(); 
        LoginModel loginModel = new LoginModel();
        ProductCatService productCatService = new ProductCatServiceImpl();
        ProductService productService = new ProductServiceImpl(); 
        ProductCatModel productCatModel = new ProductCatModel();
        boolean value = true;

        while (value) {
            System.out.println("Please choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Check Product Category Availability");
            System.out.println("3. Show All Product Categories");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Do you want to login or register?");
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Enter choice: ");
                    int actionChoice = sc.nextInt();

                    switch (actionChoice) {
                        case 1:
                            System.out.print("Enter email: ");
                            String email = sc.next();
                            System.out.print("Enter password: ");
                            String password = sc.next();

                            loginModel.setUemail(email);
                            loginModel.setPassword(password);

                            boolean isUser = loginService.isUser(loginModel);

                            if (isUser) {
                                System.out.println("Login successful");
                                if ("admin".equalsIgnoreCase(loginModel.getUsertype())) {
                                    System.out.println("Welcome admin! You have full access.");
                                    boolean adminActions = true;
                                    while (adminActions) {
                                        System.out.println("1. Add Product");
                                        System.out.println("2. Update Product Price and Quantity");
                                        System.out.println("3. View Products");
                                        System.out.println("4. Logout");
                                        System.out.print("Enter your choice: ");
                                        int adminChoiceOption = sc.nextInt();

                                        switch (adminChoiceOption) {
                                            case 1:
                                                // Collect product details from admin
                                                System.out.print("Enter product name: ");
                                                String productName = sc.next();
                                                System.out.print("Enter product price: ");
                                                int price = sc.nextInt();
                                                System.out.print("Enter product quantity: ");
                                                int quantity = sc.nextInt();
                                                sc.nextLine();  // Consume the newline character
                                                System.out.print("Enter product category: ");
                                                String category = sc.nextLine();

                                                // Create a ProductsModel object and set its fields
                                                ProductsModel product = new ProductsModel();
                                                product.setName(productName);
                                                product.setPrice(price);
                                                product.setQuantity(quantity);
                                                product.setCategory(category);

                                                // Call ProductService to save or update the product
                                                productService.saveOrUpdateProduct(product);

                                                System.out.println("Product added successfully.");
                                                break;

                                            case 2:
                                                System.out.print("Enter product ID to update: ");
                                                int productId = sc.nextInt();
                                                System.out.print("Enter new price: ");
                                                int newPrice = sc.nextInt();
                                                System.out.print("Enter new quantity: ");
                                                int newQuantity = sc.nextInt();

                                                productService.updateProductPriceAndQuantity(productId, newPrice, newQuantity);
                                                System.out.println("Product updated successfully.");
                                                break;

                                            case 3:
                                                List<ProductsModel> allProducts = productService.getAllProducts();
                                                if (allProducts.isEmpty()) {
                                                    System.out.println("No products available.");
                                                } else {
                                                    System.out.println("All Products:");
                                                    for (ProductsModel p : allProducts) {
                                                        System.out.println(p.getName() + " | " + p.getCategory() + " | Price: " + p.getPrice() + " | Quantity: " + p.getQuantity());
                                                    }
                                                }
                                                break;

                                            case 4:
                                                adminActions = false;
                                                break;

                                            default:
                                                System.out.println("Invalid choice.");
                                        }
                                    }

                                } else {
                                    System.out.println("Welcome " + loginModel.getUname() + "! You have limited access.");
                                    // User-specific actions...
                                }
                            } else {
                                System.out.println("Invalid login details.");
                            }
                            break;

                        case 2:
                            // Register user logic...
                            break;

                        default:
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                    break;

                case 2:
                    // Check product category availability...
                    break;

                case 3:
                    // Show all product categories...
                    break;

                case 4:
                    System.out.println("Exiting the application...");
                    value = false;
                    break;

                default:
                    System.out.println("Invalid choice...");
            }
        }
    }
}
