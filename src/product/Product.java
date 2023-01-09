package product;

import java.util.Date;

public class Product {
    private String id;
    private String name;
    private String material;
    private int quantity;
    private double price;
    private String limitedDate;


    public Product(String id, String name, String material, double price,int quantity,String limitedDate) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.price = price;
        this.quantity=quantity;
        this.limitedDate=limitedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLimitedDate() {
        return limitedDate;
    }

    public void setLimitedDate(String limitedDate) {
        this.limitedDate = limitedDate;
    }

    @Override
    public String toString() {
        return "............." + '\n'+
                "id sản phẩm:" + id +'\n' +
                "tên sản phẩm:" + name + '\n' +
                "chất liệu sản phẩm:" + material + '\n' +
                "giá sản phẩm:" + price + '\n'+"số lượng sản phẩm:"+ quantity+'\n'+"nhập ngày tháng năm:"+limitedDate+'\n'
                +"--------------";
    }
    public String toFile(){
        return id+","+name+","+material+","+price+","+quantity+","+limitedDate;
    }
}
