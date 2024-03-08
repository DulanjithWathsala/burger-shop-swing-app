/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DB.List;
import Model.Customer;

/**
 *
 * @author DULA
 */
public class CustomerController {
    private static int size = 1;
    private static final double price = 500.00;
    private static final String[] orderStatus = {"PREPARING","DELIVERED","CANCEL"};
    private static List customerList = new List();
    
    public static String generateOrderID(){
        return String.format("O%03d",size);
    } 
    public static void increaseSize(){
        size++;
    } 
    public static int getOrderSize() {
        return size;
    }
    public static double getPrice() {
        return price;
    }
    public static String getOrderStatus(int index) {
        return orderStatus[index];
    }
    public static Customer searchByCustomerId(String custId) {
        return customerList.get(custId);
    }
    public static void addCustomers(Customer customer) {
        customerList.add(customer);
    }
    public static Customer[] getArray() {
        return customerList.toArray();
    }
    public static boolean isListEmpty() {
        return customerList.isEmpty();
    }
    public static Customer getCustomerObjectByIndex(int index) {
        return customerList.get(index);
    }
}
