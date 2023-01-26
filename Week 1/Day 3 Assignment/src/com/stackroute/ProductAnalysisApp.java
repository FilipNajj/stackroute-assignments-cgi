package com.stackroute;

import java.util.Arrays;

public class ProductAnalysisApp {
    public static void main(String[] args) {
        //constructors
        ProductRepository repo = new ProductRepository();
        repo.getAllProducts();
        ProductService product = new ProductService();

        //print product names
        System.out.println("Product names: ");
        product.printProductName();

        //find product by code
        System.out.println("\nProduct by code");
        System.out.println(product.findNameByCode(3));

        //find max price
        System.out.println("\nMax price in categ");
        System.out.println(product.findMaxPriceProduct("Furniture"));

        //list product names
        System.out.println("\nProduct by category");
        System.out.println(Arrays.toString(product.getProductsByCategory("Furniture")));
    }
}
