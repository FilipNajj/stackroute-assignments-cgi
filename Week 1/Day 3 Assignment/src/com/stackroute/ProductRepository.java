package com.stackroute;

public class ProductRepository {
    static Product[] array = new Product[5];

    public  Product[] getAllProducts(){
        array[0] = new Product(1, "Chair", 199.99, "Furniture");
        array[1] = new Product(2, "Desk", 180.00, "Furniture");
        array[2] = new Product(3, "Table", 457.89, "Furniture");
        array[3] = new Product(4, "PC", 379.99, "Gaming");
        array[4] = new Product(5, "Monitor", 299.99, "Gaming");

        return array;
    }
}
