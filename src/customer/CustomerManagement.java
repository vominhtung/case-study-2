package customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private List<Customer>customers;
    private static final String FILE_PATH ="customer.csv";
    private static CustomerManagement customerManagement =  new CustomerManagement();

    public static CustomerManagement getCustomerManagement(){
        return customerManagement;

    }
    private CustomerManagement(){
        customers =  new ArrayList<>();
    }
    public void add (Customer newCustomerId){
        customers.add(newCustomerId);
        saveFile();
    }
    public Customer searchById(String customerId){
        for(Customer c : customers){
            if(c.getId().equals(customerId)){
                return c;
            }
        }
        return null;
    }

    public List<Customer> searchByName(String customerName) {
        List<Customer>customerArrayList = new ArrayList<>();
        for(Customer c : customers){
            if(c.getName().contains(customerName)){
                customerArrayList.add(c);
            }
        }
        return customerArrayList;
    }
    public Customer searchByPhone (String newPhone){
        for(Customer c : customers){
            if(c.getPhone().equals(newPhone)){
                return c;
            }
        }
        return null;
    }
    public boolean removeById(String customerId){
        Customer c = searchById(customerId);
        if(c != null){
            customers.remove(c);
            saveFile();
            return true;
        }
        return false;
    }
    public boolean CheckId(String newId){
        for (Customer c :customers){
            if (c.getId().equals(newId)){
                return true;
            }
        }
        return false;
    }
    public List<Customer> displayCustomer(){
        return  new ArrayList<>(customers);
    }
    public void updateCustomerId(String customerId, Customer newCustomer){
        Customer c = searchById(customerId);
        if (c != null){
            c.setId(newCustomer.getId());
            c.setName(newCustomer.getName());
            c.setPhone(newCustomer.getPhone());
        }
       saveFile();
    }
    public void saveFile(){
        try {
            FileWriter fileWriter = new FileWriter(FILE_PATH);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Customer c : customers){
                bufferedWriter.write(c.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public void readFromFile(){
        customers.clear();
        try {
            FileReader fileReader = new FileReader(FILE_PATH);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                Customer customer = handleline(line);
                customers.add(customer);
                System.out.println(customer);
            }
            bufferedReader.close();
            fileReader.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
    public Customer handleline(String line){
        String[] strings = line.split(",");
        return new Customer(strings[0] ,strings[1],strings[2]);
    }

}
