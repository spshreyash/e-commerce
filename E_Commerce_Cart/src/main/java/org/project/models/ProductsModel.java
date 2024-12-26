package org.project.models;



//	mysql> desc products;
//	+----------+--------------+------+-----+---------+----------------+
//	| Field    | Type         | Null | Key | Default | Extra          |
//	+----------+--------------+------+-----+---------+----------------+
//	| pid      | int          | NO   | PRI | NULL    | auto_increment |
//	| name     | varchar(200) | NO   |     | NULL    |                |
//	| price    | int          | NO   |     | NULL    |                |
//	| quantity | int          | NO   |     | NULL    |                |
//	| cid      | int          | YES  | MUL | NULL    |                |
//	+----------+--------------+------+-----+---------+----------------+
	




public class ProductsModel {
    private int pid;
    private String name;
    private int price;
    private int quantity;
    private int cid;  // Foreign key referencing product category ID
    private String category;  // Category name for displaying purposes

    // Getters and setters
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    public void setCategory(String category) {
        this.category = category;
    }


    public String getCategory() {
        return category;
    }
    
    

	

    
}

