package ie.atu.week3.productapp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController //Handles all http requests on the web server and coverts json to jobjects
@RequestMapping("product") //Maps URL or HTTP request to specific controller "product"
public class ProductController {

    private List<Product> productList = new ArrayList<>();
    public ProductController(){
        productList.add (new Product ("100", "TV", "Electric, ",399));
        productList.add (new Product ("101", "Radio", "Electric, ",99));
    }

    @GetMapping("/getProducts")//retrives data using a specific peice in the url
    public List<Product> getProduct()
    {
        return productList;
    }
    @PostMapping("addProduct")//uses the post fuction to add more products
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {//when called in url it activates this loop
       productList.add(product);//uses the add command to add to the product list
       return ResponseEntity.ok(productList);
    }

    @PutMapping("updateProduct/{id}")//used to update product with id assigned
    public ResponseEntity<List> updateProduct(@PathVariable String id, @RequestBody Product product) {
        for (Product p : productList) { //called when update product in the url
            if (product.getId().equals(id)) {
                productList.remove(p); //removes specific piece of info and replaces with updated version
            }
        }
        productList.add(product);//this is where is replaces, once it remove sold it inserts new
        return ResponseEntity.ok(productList);
    }

   @DeleteMapping("/deleteProduct/{id}")//deletes data using the id function
    public ResponseEntity<List> deleteProduct(@PathVariable String id){
        for (Product p : productList) {//once function is called, it runs the code
        if (p.getId().equals(id)) {
            productList.remove(p);//removes product
        }
    }
        return ResponseEntity.ok(productList); //returns list without that piece of data
    }

}

