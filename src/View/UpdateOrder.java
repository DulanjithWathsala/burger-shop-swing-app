/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CustomerController;
import Model.Customer;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * @author DULA
 */
public class UpdateOrder extends JFrame{
    private JLabel lblStatus;
    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel lblName;
    private JLabel lblQty;
    private JLabel lblTotal;
    private JLabel displayTotal;
    private JLabel displayWarning1;
    private JLabel displayWarning2;
    
    private JTextField txtOrderId;
    private JTextField txtCustomerId;
    private JTextField txtName;
    private JTextField txtQty;
    
    private JComboBox<String> orderStatusComboBox;
    
    private JButton backToHome;
    private JButton updateOrder;
    private JButton btnCheck;
    private JButton btnCheckTotal;
    
    public UpdateOrder() {
        setTitle("Update Order Details");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("Update Order");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        JPanel centerPanel = new JPanel();
        centerPanel.setBackground(Color.white);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        centerPanel.setLayout(null);
        
        lblStatus = new JLabel("Order Status");
        lblStatus.setBounds(100,50,150,50);
        lblStatus.setFont(new Font("",1,15));
        
        String[] orderStatusOptions = {"", "PREPARING", "DELIVERED", "CANCEL"};
        orderStatusComboBox = new JComboBox<>(orderStatusOptions);
        orderStatusComboBox.setBounds(250,60,200,30);
        orderStatusComboBox.setFont(new Font("",4,12));
        orderStatusComboBox.setEnabled(false);
        orderStatusComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) orderStatusComboBox.getSelectedItem();
                System.out.println("Selected option: " + selectedOption);
                //orderStatusComboBox.setEnabled(false);
            }
        });
        
                
        displayWarning1 = new JLabel();
        displayWarning1.setBounds(500,60,300,20);
        displayWarning1.setForeground(Color.red);
        displayWarning2 = new JLabel();
        displayWarning2.setBounds(500,80,300,20);
        displayWarning2.setForeground(Color.red);
        
        btnCheck = new JButton("Check Order");
        btnCheck.setBounds(500,110,200,30);
        btnCheck.setBackground(Color.blue);
        btnCheck.setForeground(Color.white);
        btnCheck.setFont(new Font("",1,15));
        btnCheck .setFocusable(false);
        btnCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayWarning1.setText("");
                displayWarning2.setText("");
                
                if (txtOrderId.getText().isEmpty()) {
                    JFrame frame = new JFrame();
                    JOptionPane.showMessageDialog(frame, "Order Id can't be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    updateOrder.setEnabled(true);
                } else {
                    if (isExist(txtOrderId.getText())) {
                        displayData();
                        int index = checkOrderId(txtOrderId.getText());
                        Customer[] temp = CustomerController.getArray();
                        String status = temp[index].getStatus();
                        
                        if (status.equals(CustomerController.getOrderStatus(0))) {
                            updateOrder.setEnabled(true);
                        }else if (status.equals(CustomerController.getOrderStatus(1))) {
                            orderStatusComboBox.setSelectedIndex(2);
                            orderStatusComboBox.setEnabled(false);
                            txtCustomerId.setText(temp[index].getCustomerId());
                            txtCustomerId.setEditable(false);

                            txtName.setText(temp[index].getName());
                            txtName.setEditable(false);

                            txtQty.setText("" + temp[index].getQty());
                            txtQty.setEditable(false);

                            updateOrder.setEnabled(false);

                            displayWarning1.setText("This order has been Delivered");
                            displayWarning2.setText("Sorry, you can not update this order");
                        } else if (status.equals(CustomerController.getOrderStatus(2))) {
                            orderStatusComboBox.setSelectedIndex(3);
                            orderStatusComboBox.setEnabled(false);
                            txtCustomerId.setText(temp[index].getCustomerId());
                            txtCustomerId.setEditable(false);

                            txtName.setText(temp[index].getName());
                            txtName.setEditable(false);

                            txtQty.setText("" + temp[index].getQty());
                            txtQty.setEditable(false);

                            updateOrder.setEnabled(false);

                            displayWarning1.setText("This order has been Cancelled");
                            displayWarning2.setText("Sorry, you can not update this order");
                        }
                        
                    } else {
                        JFrame frame = new JFrame();
                        JOptionPane.showMessageDialog(frame, "Order Id does not exist!", "Warning", JOptionPane.WARNING_MESSAGE);
                        orderStatusComboBox.setSelectedItem(0);
                        orderStatusComboBox.setEnabled(false);
                        txtCustomerId.setEditable(false);
                        txtCustomerId.setText("");
                        txtName.setEditable(false);
                        txtName.setText("");
                        txtQty.setEditable(false);
                        txtQty.setText("");
                        displayTotal.setText("0.00");
                        displayWarning1.setText("");
                        displayWarning2.setText("");
                    }
                }
                
                
            }
        });

        lblOrderId = new JLabel("Order ID");
        lblOrderId.setBounds(100,100,150,50);
        lblOrderId.setFont(new Font("",1,15));
        
        txtOrderId = new JTextField();
        txtOrderId.setFont(new Font("",4,15));
        txtOrderId.setBounds(250,110,200,30);

        lblCustomerId = new JLabel("Customer ID");
        lblCustomerId.setBounds(100,150,150,50);
        lblCustomerId.setFont(new Font("",1,15));
        
        txtCustomerId = new JTextField();
        txtCustomerId.setFont(new Font("",4,15));
        txtCustomerId.setBounds(250,160,200,30);
        txtCustomerId.setEditable(false);

        lblName = new JLabel("Name");
        lblName.setBounds(100,200,150,50);
        lblName.setFont(new Font("",1,15));
        
        txtName = new JTextField();
        txtName.setFont(new Font("",4,15));
        txtName.setBounds(250,210,200,30);
        txtName.setEditable(false);

        lblQty = new JLabel("Order QTY");
        lblQty.setBounds(100,250,150,50);
        lblQty.setFont(new Font("",1,15));
        
        txtQty = new JTextField();
        txtQty.setFont(new Font("",4,15));
        txtQty.setBounds(250,260,200,30);
        txtQty.setEditable(false);
       
        btnCheckTotal = new JButton("Check Total");
        btnCheckTotal.setBounds(500,260,200,30);
        btnCheckTotal.setBackground(Color.blue);
        btnCheckTotal.setForeground(Color.white);
        btnCheckTotal.setFont(new Font("",1,15));
        btnCheckTotal .setFocusable(false);
        btnCheckTotal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int qty = Integer.parseInt(txtQty.getText());
                double total = qty * CustomerController.getPrice();
                displayTotal.setText("Rs. " + total + "0");
            }
        });

        lblTotal = new JLabel("Total");
        lblTotal.setBounds(100,300,150,50);
        lblTotal.setFont(new Font("",1,15));
        
        displayTotal = new JLabel("0.00");
        displayTotal.setBounds(250,300,300,50);
        displayTotal.setFont(new Font("",1,15));
        displayTotal.setForeground(Color.red);
        
        centerPanel.add(lblStatus);
        centerPanel.add(orderStatusComboBox);
        centerPanel.add(displayWarning1);
        centerPanel.add(displayWarning2);
        centerPanel.add(btnCheck);
        centerPanel.add(lblOrderId);
        centerPanel.add(txtOrderId);
        centerPanel.add(lblCustomerId);
        centerPanel.add(txtCustomerId);
        centerPanel.add(lblName);
        centerPanel.add(txtName);
        centerPanel.add(lblQty);
        centerPanel.add(txtQty);
        centerPanel.add(btnCheckTotal);
        centerPanel.add(lblTotal);
        centerPanel.add(displayTotal);
        
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        //-----------------------------------------------------------------
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 20));
        southPanel.setBackground(Color.white);
        //southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        backToHome = new JButton("Back");
        backToHome.setBackground(Color.red);
        backToHome.setForeground(Color.white);
        backToHome.setFont(new Font("",1,15));
        backToHome .setFocusable(false);
        backToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HomePage().setVisible(true);
            }
        });
        
        updateOrder = new JButton("Update Order");
        updateOrder.setBackground(Color.green);
        updateOrder.setForeground(Color.white);
        updateOrder.setFont(new Font("",1,15));
        updateOrder .setFocusable(false);
        updateOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayWarning1.setText("");
                displayWarning2.setText("");
                updateOrderDetail();
            }
        });
        
        southPanel.add(updateOrder);
        southPanel.add(backToHome);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }
    
    private void displayData() {
        Customer[] temp = CustomerController.getArray();
        String orderId = txtOrderId.getText();
        orderStatusComboBox.setSelectedIndex(1);
        orderStatusComboBox.setEnabled(true);
        for (int i = 0; i < temp.length; i++) {
            if (orderId.equals(temp[i].getOrderId())) {
                txtCustomerId.setText(temp[i].getCustomerId());
                txtName.setText(temp[i].getName());
                txtQty.setText("" + temp[i].getQty());
                txtQty.setEditable(true);
                displayTotal.setText("Rs. " + temp[i].getTotal() + "0");
                break;
            }
        }
    }
    
    private boolean isExist(String text) {
        Customer[] temp = CustomerController.getArray();
        for (int i = 0; i < temp.length; i++) {
            if (text.equals(temp[i].getOrderId())) {
                return true;
            }
        }
        return false;
    }
    
    public void updateOrderDetail() {
        int index = checkOrderId(txtOrderId.getText());
        Customer[] temp = CustomerController.getArray();
        String status = temp[index].getStatus();
        
        if (status.equals(CustomerController.getOrderStatus(0))) {
            update();
            orderStatusComboBox.setSelectedItem(0);
            orderStatusComboBox.setEnabled(false);
            txtCustomerId.setEditable(false);
            txtCustomerId.setText("");
            txtName.setEditable(false);
            txtName.setText("");
            txtQty.setEditable(false);
            txtQty.setText("");
            displayTotal.setText("0.00");
            displayWarning1.setText("");
            displayWarning2.setText("");
        }
    }
    
    private int checkOrderId(String value){
        Customer[] ar = CustomerController.getArray();
        for (int i = 0; i < ar.length; i++){
            if (value.equals(ar[i].getOrderId())){
                    return i;
            }
        }
        return -1;
    }
    
    private void update() {
        int qty = Integer.parseInt(txtQty.getText());
        double total = qty * CustomerController.getPrice();
        String orderId = txtOrderId.getText();
        String selectedOption = (String) orderStatusComboBox.getSelectedItem();
        
        int index = checkOrderId(orderId);
        Customer currentObj = CustomerController.getCustomerObjectByIndex(index);
        currentObj.setQty(qty);
        currentObj.setTotal(total);
        
        if (selectedOption.equals(CustomerController.getOrderStatus(1))) {
            currentObj.setStatus(CustomerController.getOrderStatus(1));
        } else if (selectedOption.equals(CustomerController.getOrderStatus(2))) {
            currentObj.setStatus(CustomerController.getOrderStatus(2));
        }
        
        JFrame frame = new JFrame();
        String text = "Updated Qty: " + currentObj.getQty() + "\nUpdated Total: " + currentObj.getTotal() + "\nUpdated Status: " + currentObj.getStatus();
        JOptionPane.showMessageDialog(frame, "Order is Updated Successfully!\n" + text, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
