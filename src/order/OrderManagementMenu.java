package order;

import customer.CustomerManagement;
import product.Product;
import product.ProductManagement;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OrderManagementMenu {
    Scanner scanner = new Scanner(System.in);
    OrderManagement orderManagement = OrderManagement.getOrderManagement();
    ProductManagement productManagement = ProductManagement.getProductManagement();
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();

    public OrderManagementMenu(){}
    public void displayMenu(){
        System.out.println("   Menu Hóa Đơn");
        System.out.println("  1.thêm hóa đơn");
        System.out.println("  2.xóa hóa đơn");
        System.out.println("  3.tìm theo id ");
        System.out.println("  4.hiển thị");
        System.out.println("  5.đọc file");
        System.out.println("  0.thoát");
    }
public void Menu(){
    int choose = -1;
    while (choose != 0){
        displayMenu();
        System.out.println("chọn số");
        choose = scanner.nextInt();scanner.nextLine();
        switch (choose){
            case 1 ->add();
            case 2 -> remove();
            case 3 -> searchById();
            case 4 -> display();
            case 5 -> readFromFile();
            default -> {}
            }
         }
     }
     private void add() {
         System.out.println("Nhập ID hóa đơn: ");
         String id = scanner.nextLine();
         if(orderManagement.checkIdOrder(id)){
             System.out.println("id tồn tại");
             return;
         }
         System.out.println("Nhập ID khách hàng");
         String idCustomer =scanner.nextLine();
         if (!customerManagement.CheckId(idCustomer)){
             System.out.println("id  tồn tại ");
             return;
         }
         Date createdDay = new Date();
         Order newOrder = new Order(createdDay,id,idCustomer);
             System.out.println("Nhập ID sản phẩm");
             String idProduct = scanner.nextLine();
             Product product = productManagement.searchById(idProduct);
             if (!productManagement.checkId(idProduct)){
                 System.out.println("id tồn tại ");
                 return;
             }
             System.out.println("nhập số lượng mua");
             int quantity = scanner.nextInt();scanner.nextLine();
             if (product.getQuantity() - quantity >0 || product.getQuantity() - quantity == 0){
                 product.setQuantity(product.getQuantity()- quantity);
                 newOrder.addProduct(idProduct,product.getName(),quantity);
                 productManagement.saveFile();
             }
         orderManagement.add(newOrder);
         orderManagement.saveFile();
     }
     private void remove(){
        Scanner scanner = new Scanner(System.in);
         System.out.println("nhập id cần xóa");
         String id = scanner.nextLine();
         if(orderManagement.remove(id)){
             System.out.println("xoá rối á");
         }else {
             System.out.println("không xóa được");
         }
     }
     private void searchById(){
        Scanner scanner = new Scanner(System.in);
         System.out.println("nhập id cần tìm");
         String id = scanner.nextLine();
         Order searchById = orderManagement.searchById(id);
         if (searchById != null) {
             System.out.println(searchById);
         }else {
             System.out.println("Không tìm thấy");
         }
     }
     private void display(){
         System.out.println(orderManagement.displayOrder());
     }
     private void readFromFile(){
        orderManagement.readFromFile();

     }
     }



