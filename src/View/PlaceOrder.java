/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CustomerController;
import DB.List;
import Model.Customer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author DULA
 */
public class PlaceOrder extends JFrame{
    private final JLabel lblOrderId;
    private final JLabel lblCustomerId;
    private final JLabel lblName;
    private final JLabel lblQty;
    private final JLabel lblStatus;
    
    private JLabel lblOrderIdGenerated;
    private final JLabel lblStatusGenerated;
    private final JLabel lblTotal;
    private JLabel lblResultTotal;
    
    private JTextField txtCustomerId;
    private JTextField txtName;
    private JTextField txtQty;
    
    private final JButton btnPlaceOrder;
    private final JButton btnBackToHome;
    private final JButton btnCancel;
    private final JButton btnSetTotal;
    private final JButton btnCheck;
    
    public PlaceOrder() {
        setTitle("Place Order");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Place Order");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(5,1,20,20));
        //westPanel.setBackground(Color.green);
        westPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 50));
        
        lblOrderId = new JLabel("Order ID :");
        lblOrderId.setFont(new Font("",1,20));
        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setFont(new Font("",1,20));
        lblName = new JLabel("Customer Name :");
        lblName.setFont(new Font("",1,20));
        lblQty = new JLabel("Order QTY :");
        lblQty.setFont(new Font("",1,20));
        lblStatus = new JLabel("Order Status :");
        lblStatus.setFont(new Font("",1,20));

        westPanel.add(lblOrderId);
        westPanel.add(lblCustomerId);
        westPanel.add(lblName);
        westPanel.add(lblQty);
        westPanel.add(lblStatus);
        getContentPane().add(westPanel, BorderLayout.WEST);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(5,1,20,20));
        //centerPanel.setBackground(Color.yellow);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 50));
        
        lblOrderIdGenerated = new JLabel();
       
        lblOrderIdGenerated.setText(CustomerController.generateOrderID());
        
        lblOrderIdGenerated.setFont(new Font("",1,20));
        
        JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new GridLayout(1,2));
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("",1,20));
        txtCustomerId.setSize(300,50);
        btnCheck = new JButton("Check Customer");
        btnCheck.setFont(new Font("",1,12));
        btnCheck.setBounds(0,0,50,50);
        btnCheck .setFocusable(false);
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtCustomerId.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Customer ID can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String custId = txtCustomerId.getText();
                    char firstDigit = custId.charAt(0);
                    if (firstDigit != '0' || custId.length() != 10){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Invalid Customer ID. Try again!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                    Customer tempCustomer = CustomerController.searchByCustomerId(custId);
                    if (tempCustomer == null){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Customer ID not found. Please Enter!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        String name = tempCustomer.getName();
                        txtName.setText(name);
                        txtName.setEditable(false);
                    }
                }   
            }
        });
        customerPanel.add(txtCustomerId);
        customerPanel.add(btnCheck);
        
        
        txtName = new JTextField();
        txtName.setFont(new Font("",1,20));
        txtName.setSize(300,50);
        
        
        JPanel qtyPanel = new JPanel();
        qtyPanel.setLayout(new GridLayout(1,2));
        txtQty = new JTextField();
        txtQty.setFont(new Font("",1,20));
        txtQty.setSize(300,50);
        btnSetTotal = new JButton("Check Total");
        btnSetTotal.setFont(new Font("",1,12));
        btnSetTotal.setBounds(0,0,50,50);
        btnSetTotal .setFocusable(false);
        btnSetTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtQty.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Quantity can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int qty = Integer.parseInt(txtQty.getText());
                    if (qty <= 0) {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Invalid Quantity. Try again!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        double total = qty * CustomerController.getPrice();
                        lblResultTotal.setText("Rs. "+total+"0");
                    }
                }
            }
        });
        qtyPanel.add(txtQty);
        qtyPanel.add(btnSetTotal);
        
        lblStatusGenerated = new JLabel();
        lblStatusGenerated.setText("Pending...");
        lblStatusGenerated.setFont(new Font("",1,20));
        
        centerPanel.add(lblOrderIdGenerated);
        centerPanel.add(customerPanel);
        centerPanel.add(txtName);
        centerPanel.add(qtyPanel);
        centerPanel.add(lblStatusGenerated);
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(4,1,20,20));
        //eastPanel.setBackground(Color.white);
        eastPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 0, 50));
        
        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBackground(Color.blue);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setFont(new Font("",1,12));
        btnPlaceOrder.setBounds(0,0,150,50);
        btnPlaceOrder .setFocusable(false);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int size = CustomerController.getOrderSize();
                if (txtCustomerId.getText().isEmpty() || txtName.getText().isEmpty() || txtQty.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Text field cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Customer temp = new Customer();
                    temp.setId(size);
                    String generatedId = CustomerController.generateOrderID();
                    temp.setOrderId(generatedId);

                    String custId = txtCustomerId.getText();
                    char firstDigit = custId.charAt(0);
                    if (firstDigit != '0' || custId.length() != 10){
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Invalid Customer ID. Try again!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } 
                    temp.setCustomerId(custId);

                    String name;
                    if (size == 1) {
                        name = txtName.getText();
                        temp.setName(name);
                    } else {
                        Customer tempCustomer = CustomerController.searchByCustomerId(custId);
                        if (tempCustomer == null){
                            name = txtName.getText();
                            temp.setName(name);
                        } else {
                            name = tempCustomer.getName();
                            txtName.setText(name);
                            txtName.setEditable(false);
                            temp.setName(name);
                        }
                    }

                    int qty = Integer.parseInt(txtQty.getText());
                    if (qty <= 0) {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Invalid Quantity. Try again!", "Warning", JOptionPane.WARNING_MESSAGE);
                    } else {
                        temp.setQty(qty);
                    }
                    temp.setTotal(qty * CustomerController.getPrice());

                    temp.setStatus(CustomerController.getOrderStatus(0));

                    CustomerController.addCustomers(temp);
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Order Placed Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    
                    // Clear all text fields
                    txtName.setEditable(true);
                    txtCustomerId.setText("");
                    txtName.setText("");
                    txtQty.setText("");
                    lblResultTotal.setText("Rs. " + "0.00");
                    CustomerController.increaseSize();
                    lblOrderIdGenerated.setText(CustomerController.generateOrderID());
                }
            }
        });

        btnBackToHome = new JButton("Back to home page");
        btnBackToHome.setBackground(Color.red);
        btnBackToHome.setForeground(Color.white);
        btnBackToHome.setFont(new Font("",1,12));
        btnBackToHome.setBounds(0,0,150,50);
        btnBackToHome .setFocusable(false);
        btnBackToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePage().setVisible(true);
            }
        });
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.red);
        btnCancel.setForeground(Color.white);
        btnCancel.setFont(new Font("",1,12));
        btnCancel.setBounds(0,0,150,50);
        btnCancel .setFocusable(false);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        
        eastPanel.add(btnPlaceOrder);
        eastPanel.add(btnBackToHome);
        eastPanel.add(btnCancel);
        
        getContentPane().add(eastPanel, BorderLayout.EAST);
 
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 50));
        //southPanel.setBackground(Color.yellow);
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
        lblTotal= new JLabel("NET Total : ");
        lblTotal.setFont(new Font("",1,17));
        lblResultTotal= new JLabel("0.00");
        lblResultTotal.setForeground(Color.red);
        lblResultTotal.setFont(new Font("",1,17));
        southPanel.add(lblTotal);
        southPanel.add(lblResultTotal);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }
}
