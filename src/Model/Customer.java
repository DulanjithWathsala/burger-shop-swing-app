/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author DULA
 */
public class Customer {
    private int id;
    private String orderId;
    private String customerId;
    private String name;
    private int qty;
    private double total;
    private String status;

    //--------------Setters---------------------------
    public void setId(int id) {
            this.id = id;
    }
    public void setOrderId(String orderId) {
            this.orderId = orderId;
    }
    public void setCustomerId(String customerId) {
            this.customerId = customerId;
    }
    public void setName(String name) {
            this.name = name;
    }
    public void setQty(int qty) {
            this.qty = qty;
    }
    public void setTotal(double total) {
            this.total = total;
    }
    public void setStatus(String status) {
            this.status = status;
    }

    //--------------Getters---------------------------
    public int getId() {
            return id;
    }
    public String getOrderId() {
            return orderId;
    }
            public String getCustomerId() {
            return customerId;
    }
    public String getName() {
            return name;
    }
    public int getQty() {
            return qty;
    }
    public double getTotal() {
            return total;
    }
    public String getStatus() {
            return status;
    }
}
