package order;
import customer.CustomerManagement;
import product.Product;
import product.ProductManagement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    private String customerID;
    private String productID;
    private String cusName;
    private Date  date;
    private Map<String,Integer> mapOrders;
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    ProductManagement productManagement = ProductManagement.getProductManagement();

    public Order() {
    }

    public Order(Date date, String orderId, String customerID){
        this.orderId = orderId;
        this.customerID = customerID;
        this.date =new Date() ;
        this.mapOrders=new HashMap<>();
    }

    public Order( String orderId,Date date, String customerID, String productID, String cusName) {
        this.orderId = orderId;
        this.customerID = customerID;
        this.productID = productID;
        this.cusName = cusName;
        this.date = date;
        this.mapOrders =new HashMap<>();

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Map<String, Integer> getMapOrders() {
        return mapOrders;
    }

    public void addProduct(String productID, String name, int  quantity) {
        getMapOrders().put(productID, quantity);
    }
    public double getSubTotal(String productID, int quantity) {
        Product product = productManagement.searchById(productID);
        double result;
        double p = product.getPrice();
        result = p * quantity;
        return result;
    }
    public double getTotal() {
        double total = 0;
        for (String key : getMapOrders().keySet()) {
            total += getSubTotal(key, getMapOrders().get(key));
        }
        return total;
    }
    public String getProductInformation() {
        StringBuilder result = new StringBuilder();
        for (String key : mapOrders.keySet()) {
            result.append(ProductManagement.getProductManagement().searchById(key).getName()).append(",").append(ProductManagement.getProductManagement().searchById(key).getPrice());
        }
        return result.toString();
    }
    public String stringCreatedDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(getDate());
    }

    @Override
    public String toString() {
        return "*id hóa đơn: " + orderId + "\n" +
                "*ngày mua: " + stringCreatedDay() + "\n" +
//                "id khách hàng" + customerManagement.searchById(getCustomerID()) + "\n" +
                "*tên khách hàng: " +customerManagement.searchById(getCustomerID()).getName()+"\n"+
                "*số điện thoại khách hàng: " + customerManagement.searchById(getCustomerID()).getPhone() + "\n" +
                "*Tên sản phẩm và giá :" +getProductInformation() + "\n" +
                "       tổng tiền: " + getTotal();
    }

    public String toFile() {
//        return stringCreatedDay() + "," + orderId + "," + customerID +","  + getProductInformation() + "," + getTotal();
        return orderId+","+stringCreatedDay() + "," + customerID + "," + customerManagement.searchById(getCustomerID()).getName() + "," + getProductInformation() + ","+ getTotal() ;
    }

}
