package ie.atu.week3.productapp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //generates getters and setters
@AllArgsConstructor //makes a constructor for all the classes
@NoArgsConstructor //default constructor
public class Product {
    private String id;
    private String name;
    private String category;
    private double price;
}
