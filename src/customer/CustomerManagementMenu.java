package customer;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementMenu {
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    public void displayMenu(){
        System.out.println(                   "Menu"             );
        System.out.println("           quản lí khách hàng      ");
        System.out.println("          1: Thêm khách hàng       ");
        System.out.println("          2: Xóa khách hàng        ");
        System.out.println("          3: tìm theo id khách hàng");
        System.out.println("          4: tìm theo tên khách hàng");
        System.out.println("          5: Tìm theo số điện thoại khách hàng");
        System.out.println("          6: cập nhật khách hàng");
        System.out.println("          7: hiển thị khách hàng");
        System.out.println("          8: đọc file");
        System.out.println("          0: Thoát");
    }
    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (choose != 0){
            displayMenu();
            System.out.println("Chọn số");
            choose = scanner.nextInt();scanner.nextLine();
            switch (choose){
                case 1 -> add();
                case 2 -> remove();
                case 3 -> searchById();
                case 4 -> searchByName();
                case 5 -> searchByPhone();
                case 6 -> update();
                case 7 -> displayAll();
                case 8 -> readFromFile();
                default -> {}


            }
        }
    }
    private void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        String id = scanner.nextLine();
        if(customerManagement.CheckId(id)){
            System.out.println("id đã tồn tại vui lòng chọn và nhập lại");
            return;
        }
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập số dt");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id,name,phone);
        customerManagement.add(newCustomer);
        }

    private void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        String id = scanner.nextLine();
        if(customerManagement.removeById((id))){
            System.out.println("xóa r á");
        }else {
            System.out.println("k xóa dc ");
        }
    }
    private void searchById(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập id");
        String id = scanner.nextLine();
        Customer searchById =customerManagement.searchById((id));
        if(searchById != null){
            System.out.println(searchById);
        }else {
            System.out.println("k tìm thấy");
        }
    }
    private void searchByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên khách hàng");
        String name = scanner.nextLine();
        List<Customer>customers = customerManagement.searchByName(name);
        if(customers.size() !=0){
            for(Customer c : customers){
                System.out.println(c);
            }
        }else {
            System.out.println("k tìm thấy");

        }
    }
    private void searchByPhone(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String phone = scanner.nextLine();
        Customer searchByPhone = customerManagement.searchByPhone((phone));
        if(searchByPhone != null){
            System.out.println(searchByPhone);
        }else {
            System.out.println("k tìm thấy");
        }
    }
    private void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id khách hàng cần cập nhật");
        String id = scanner.nextLine();
        System.out.println("Nhập tên khách hàng mới");
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại mới");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id,name,phone);
        customerManagement.updateCustomerId(id,newCustomer);
    }
    private void displayAll(){
        List<Customer>customers =customerManagement.displayCustomer();
        for (Customer c:customers){
            System.out.println(c);
        }
    }
    private void readFromFile(){
        customerManagement.readFromFile();
    }
}
