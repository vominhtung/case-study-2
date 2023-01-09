package product;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductManagement {
    public List<Product>products ;
    private static final String FILE_PATH = "product.csv";
    private static ProductManagement productManagement = new ProductManagement();

    public  static  ProductManagement getProductManagement(){

        return productManagement;
    }
    private ProductManagement(){
        products = new ArrayList<>();


    }
    public void add (Product newProductId){
        products.add(newProductId);
        saveFile();
    }
    public Product searchById(String productId){
        for(Product p : products){
            if(p.getId().equals(productId)){
                return p;
            }
        }
        return null;
    }
    public List<Product> searchByName (String productName) {
       List<Product>productArrayList = new ArrayList<>();
       for(Product p : products){
           if(p.getName().contains(productName)){
               productArrayList.add(p);
           }
       }
       return  productArrayList;
    }
    public boolean removeById(String productId){
        Product p = searchById(productId);
        if(p != null){
            products.remove(p);
            saveFile();
            return true;
        }
        return false;
    }
    public List<Product> displayProduct(){
        return new ArrayList<>(products);
    }
    public void updateProductId(String productId,Product newProduct){
        Product p = searchById(productId);
        if(p != null){
            p.setId(newProduct.getId());
            p.setName(newProduct.getName());
            p.setMaterial(newProduct.getMaterial());
            p.setPrice(newProduct.getPrice());
            p.setQuantity(newProduct.getQuantity());
            p.setLimitedDate(newProduct.getLimitedDate());
        }
        saveFile();
    }
    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter   bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : products){
                bufferedWriter.write(p.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void readFromFile() {
        products.clear();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = ",";
            while ((line = bufferedReader.readLine()) != null) {
                Product product = handleline(line);
                products.add(product);
                System.out.println(product);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Product handleline (String line){
        String[] strings = line.split(",");
        return new Product(strings[0],strings[1],strings[2],Double.parseDouble(strings[3]),Integer.parseInt(strings[4]), strings[5]);
    }
    public boolean checkId(String id){
        for (Product p : products){
            if (p.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
