package com.stackroute;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ProductService {

    public void printProductName(){
       for (Product product: ProductRepository.array){
           System.out.println(product.getName());
       }
    }

    public String findNameByCode(int productCode){
        for (Product product: ProductRepository.array){
            if (productCode == product.getProductCode()){
                return product.getName();
            }
        }
        return "No product found";
    }

    public Product findMaxPriceProduct(String category){
        Product[] p = new Product[ProductRepository.array.length];
        int i=0;
        double price = 0;

        for (Product product: ProductRepository.array){
            if (product.getCategory().equals(category)){
                p[i] = product;
            }
            i++;
        }

        for (Product product: p){
            if (p[0] == null){
                System.out.println("no product found");
                return null;
            }
            if (product != null && product.getPrice() > price){
                p[0] = product;
                price = product.getPrice();
            }
        }

        return p[0];
    }

    public String[] getProductsByCategory(String category){
        String name= " ";

        for (Product product: ProductRepository.array){
            if (product.getCategory().equals(category)){
                name+= product.getName() + " ";
            }
        }
        name= name.trim();
        String[] nameArray = name.split(" ");

        return nameArray;
    }


}
