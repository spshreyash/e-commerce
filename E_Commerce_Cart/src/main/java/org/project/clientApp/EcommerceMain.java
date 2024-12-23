package org.project.clientApp;

import java.util.Scanner;
import org.project.models.LoginModel;
import org.project.services.LoginService;
import org.project.services.LoginServiceImp;
import org.project.models.ProductCatModel;
import org.project.services.ProductCatService;
import org.project.services.ProductCatServiceImpl;
import java.util.List;

public class EcommerceMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // Scanner for input
        LoginService loginService = new LoginServiceImp(); // Using the interface type for dynamic polymorphism
        LoginModel loginModel = new LoginModel();
        ProductCatService productCatService = new ProductCatServiceImpl(); // ProductCatService for category functionality

        // Product category model to use for checking availability and adding categories
        ProductCatModel productCatModel = new ProductCatModel();
        boolean value = true;

        while (value) {
            System.out.println("Please choose an option:");
            System.out.println("1. Login");
            System.out.println("2. Check Product Category Availability");
            System.out.println("3. Show All Product Categories");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();  // Get user choice
            
            switch (choice) {
                case 1:
                    // Login or Register
                    System.out.println("Do you want to login or register?");
                    System.out.println("1. Login");
                    System.out.println("2. Register");
                    System.out.print("Enter choice: ");
                    int actionChoice = sc.nextInt();

                    switch (actionChoice) {
                        case 1:
                            // Login process
                            System.out.print("Enter email: ");
                            String email = sc.next();  // User input for email
                            System.out.print("Enter password: ");
                            String password = sc.next();  // User input for password

                            // Set the user inputs into the LoginModel
                            loginModel.setUemail(email);
                            loginModel.setPassword(password);

                            // Check if user exists using the service method
                            boolean isUser = loginService.isUser(loginModel);

                            if (isUser) {
                                System.out.println("Login successful");
                                // Check if the user is an admin or regular user
                                if ("admin".equalsIgnoreCase(loginModel.getUsertype())) {
                                    System.out.println("Welcome  admin! You have full access ");
                                    // Admin options for product category management
                                    System.out.println("Would you like to add a new product category  ?");
                                    System.out.println("1. Yes");
                                    System.out.println("2. No");
                                    System.out.print("Enter your choice: ");
                                    int adminChoice = sc.nextInt();

                                    if (adminChoice == 1) {
                                        // Admin adds new category
                                        System.out.print("Enter new product category name: ");
                                        String newCategory = sc.next();  // Admin input for category name
                                        productCatModel.setName(newCategory);

                                        // Call the service method to add the category
                                        boolean categoryAdded = productCatService.addProductCat(productCatModel);
                                        if (categoryAdded) {
                                            System.out.println("Product category \"" + newCategory + "\" has been added successfully ");
                                        } else {
                                            System.out.println("Failed to add product category ");
                                        }
                                    }
                                } else {
                                    System.out.println("Welcome" + loginModel.getUname() + "  You have limited access ");
                                }
                            } else {
                                System.out.println("Invalid information ");
                            }
                            break;

                        case 2:
                            // Registration functionality
                            System.out.print("Enter your name: ");
                            String name = sc.next();  
                            System.out.print("Enter your email: ");
                            String regEmail = sc.next();  
                            System.out.print("Enter your password: ");
                            String regPassword = sc.next();  

                            // Ask the user what ur  usertype
                            System.out.println("Please choose your usertype:");
                            System.out.println("1. Admin");
                            System.out.println("2. User");
                            System.out.print("Enter choice: ");
                            int usertypeChoice = sc.nextInt();
                           String usertype; 
                            if (usertypeChoice == 1) {
                                usertype = "admin";
                            } else {
                                usertype = "user";  
                                // Default evry tm user
                            }

                            // Set the values into the loginModel for registration
                            loginModel.setUname(name);
                            loginModel.setUemail(regEmail);
                            loginModel.setPassword(regPassword);
                            loginModel.setUsertype(usertype);  // Set the usertype based on user choice

                            // Call the service method to register the user
                            boolean registrationSuccessful = loginService.registerUser(loginModel);
                            if (registrationSuccessful) {
                                System.out.println("Registration successful!");
                            } else {
                                System.out.println("Registration failed. Please try again.");
                            }
                            break;

                        default:
                            
                            System.out.println("Invalid choice. Please select a valid option.");
                    }
                    break;

                case 2:
                    // Check if product category is available
                    System.out.print("Enter product category name to check availability: ");
                    String categoryName = sc.next();  
                    

                    // here we set the prcat name 
                    productCatModel.setName(categoryName);

                    // Check if the category is available using the service
                    boolean isCategoryAvailable = productCatService.isProductCat(productCatModel);

                    if (isCategoryAvailable) {
                        System.out.println("The product category \"" + categoryName + "\" is available.");
                    } else {
                        System.out.println("The product category \"" + categoryName + "\" is not available.");
                    }
                    break;

                case 3:
                    // Show all product categories
                    List<ProductCatModel> allCategories = productCatService.getAllProductCats();

                    if (allCategories.isEmpty()) {
                        System.out.println("No product categories are available.");
                    } else {
                        System.out.println("All product categories:");
                        for (ProductCatModel category : allCategories) {
                        	
                        	// Displ    every category name
                            System.out.println(category.getName());  
                        }
                    }
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
