import customer.CustomerManagementMenu;
import order.OrderManagement;
import order.OrderManagementMenu;
import product.ProductManagementMenu;

import java.text.ParseException;
import java.util.Scanner;

//import customer.CustomerManagementMenu;
//import order.OrderManagementMenu;
//import product.ProductManagementMenu;
//
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("1: Quản lý khách hàng ");
//        System.out.println("2: Quản lý sản phẩm");
//        System.out.println("3: Quản lý Hóa Đơn ");
//        System.out.println("Nhập số");
//        int c = scanner.nextInt();
//        scanner.nextLine();
//        if (c == 1) {
//            new CustomerManagementMenu().Menu();
//        } else if (c == 2) {
//            new ProductManagementMenu().Menu();
//        }else if (c==3){
//            new OrderManagementMenu().Menu();
//        }
//    }
//}
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
        ProductManagementMenu productManagementMenu = new ProductManagementMenu();
        OrderManagementMenu orderManagement = new OrderManagementMenu();

        display();
        int choice = sc.nextInt();
        sc.nextLine();
        while (choice != 0) {
            switch (choice) {
                case 1 -> customerManagementMenu.Menu();
                case 2 -> productManagementMenu.Menu();
                case 3 -> orderManagement.Menu();
                default -> System.out.println("Your choice not found!");
            }
            display();
            choice = sc.nextInt();
            sc.nextLine();
        }
    }
    private static void display(){
        System.out.println("Menu");
        System.out.println("1. Customer Menu");
        System.out.println("2. Product Menu");
        System.out.println("3. Invoice Menu");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
    }

}