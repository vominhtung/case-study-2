package product;
import java.util.List;
import java.util.Scanner;

public class ProductManagementMenu {
    ProductManagement productManagement = ProductManagement.getProductManagement();
    public void displayMenu(){
        System.out.println(                   "Menu"             );
        System.out.println("             quản lí sản phẩm      ");
        System.out.println("          1: Thêm sản phẩm       ");
        System.out.println("          2: Xóa sản phẩm       ");
        System.out.println("          3: tìm theo id sản phẩm");
        System.out.println("          4: tìm theo tên sản phẩm");
        System.out.println("          5: cập nhật sản phẩm");
        System.out.println("          6: hiển thị sản phẩm");
        System.out.println("          7: đọc file");
        System.out.println("          0: Thoát");
    }
    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (choose !=0){
            displayMenu();
            System.out.println("Chọn số");
            choose = scanner.nextInt();scanner.nextLine();
            switch (choose){
                case 1 -> add();
                case 2 -> remove();
                case 3 -> searchById();
                case 4 -> searchByName();
                case 5 -> update();
                case 6 -> displayAll();
                case 7 -> readFromFile();
                default -> {}


            }
        }
    }
private void add(){
        Scanner scanner = new Scanner(System.in);
    System.out.println("nhập id sản phẩm");
    String id = scanner.nextLine();
    if(productManagement.checkId(id)){
        System.out.println("id đã tồn tại vui lòng chọn và nhập lại");
        return;
    }
    System.out.println("nhập tên sản phẩm");
    String name = scanner.nextLine();
    System.out.println("nhập chất liệu sản phẩm");
    String material = scanner.nextLine();
    System.out.println("nhập giá sản phẩm");
    double price = scanner.nextDouble();scanner.nextLine();
    System.out.println("nhập số lượng");
    int quantity = scanner.nextInt();scanner.nextLine();
    System.out.println("nhập ngày thàng nằm");
    String limitedDate = scanner.nextLine();
    Product newProduct = new Product(id,name,material,price, quantity,limitedDate);
    productManagement.add(newProduct);
}
private void remove(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập id");
    String id = scanner.nextLine();
    if(productManagement.removeById(id)){
        System.out.println("xóa rồi á");
    }else {
        System.out.println("không xóa dc");
    }
}
private void searchById(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("nhập id");
    String id = scanner.nextLine();
    Product searchById = productManagement.searchById(id);
    if (searchById != null){
        System.out.println(searchById);
    }else {
        System.out.println("không tìm thấy");
    }
}
private void searchByName() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Nhập tên sản phẩm");
    String name =  scanner.nextLine();
    List<Product>products = productManagement.searchByName(name);
    if (products.size() !=0){
        for (Product p : products){
            System.out.println(p);
        }
    } else {
        System.out.println("không tìm thấy");
    }
}



    private void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần cập nhật");
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm mới");
        String name = scanner.nextLine();
        System.out.println("nhập chất liệu sản phẩm");
        String material = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        double price = scanner.nextDouble();scanner.nextLine();
        System.out.println("nhập số lượng");
        int quantity = scanner.nextInt();scanner.nextLine();
        System.out.println("nhập ngày thàng nằm");
        String limitedDate = scanner.nextLine();

        Product newProduct = new Product(id,name,material,price,quantity,limitedDate);
        productManagement.updateProductId(newProduct.getId(),newProduct);

    }
    private void displayAll(){
        List<Product>products= productManagement.displayProduct();
        for(Product p :products){
            System.out.println(p);
        }
    }
    private void readFromFile(){
        productManagement.readFromFile();
    }
}
