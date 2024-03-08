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
public class SearchOrder extends JFrame{
    private JLabel lblOrderId;
    private JLabel lblCustomerId;
    private JLabel displayCustomerId;
    private JLabel lblName;
    private JLabel displayName;
    private JLabel lblQty;
    private JLabel displayQty;
    private JLabel lblTotal;
    private JLabel displayTotal;
    private JLabel lblStatus;
    private JLabel displayStatus;
    
    private JTextField txtOrderId;
    
    private JButton btnSearch;
    private JButton backToHome;
    
    public SearchOrder() {
        setTitle("Search Orders");
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("Search Order Details");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        
        JPanel orderPanel = new JPanel();
        //orderPanel.setBackground(Color.yellow);
        orderPanel.setLayout(null);
        
        lblOrderId = new JLabel("Enter Order ID :");
        lblOrderId.setBounds(20,20,150,40);
        lblOrderId.setFont(new Font("",1,15));
        
        txtOrderId = new JTextField();
        txtOrderId.setBounds(150,20,300,40);
        txtOrderId.setFont(new Font("",1,15));
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(500,20,100,40);
        btnSearch.setBackground(Color.blue);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("",1,15));
        btnSearch .setFocusable(false);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchCurrentOrder();
            }
        });
        
        orderPanel.add(lblOrderId);
        orderPanel.add(txtOrderId);
        orderPanel.add(btnSearch);
        
        northPanel.add(titlePanel);
        northPanel.add(orderPanel);
        
        getContentPane().add(northPanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        JPanel centerPanel = new JPanel();
        //centerPanel.setBackground(Color.gray);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        centerPanel.setLayout(null);
        
        lblCustomerId = new JLabel("Customer ID :");
        lblCustomerId.setBounds(100,50,150,50);
        lblCustomerId.setFont(new Font("",1,15));
        
        displayCustomerId = new JLabel("");
        displayCustomerId.setBounds(250,50,150,50);
        displayCustomerId.setFont(new Font("",1,15));
        displayCustomerId.setForeground(Color.blue);
        
        lblName = new JLabel("Name :");
        lblName.setBounds(100,100,150,50);
        lblName.setFont(new Font("",1,15));
        
        displayName = new JLabel("");
        displayName.setBounds(250,100,300,50);
        displayName.setFont(new Font("",1,15));
        displayName.setForeground(Color.blue);
        
        lblQty = new JLabel("QTY :");
        lblQty.setBounds(100,150,150,50);
        lblQty.setFont(new Font("",1,15));
        
        displayQty = new JLabel("");
        displayQty.setBounds(250,150,300,50);
        displayQty.setFont(new Font("",1,15));
        displayQty.setForeground(Color.blue);
        
        lblTotal = new JLabel("Total :");
        lblTotal.setBounds(100,200,150,50);
        lblTotal.setFont(new Font("",1,15));
        
        displayTotal = new JLabel("");
        displayTotal.setBounds(250,200,300,50);
        displayTotal.setFont(new Font("",1,15));
        displayTotal.setForeground(Color.blue);
        
        lblStatus = new JLabel("Order Status :");
        lblStatus.setBounds(100,250,150,50);
        lblStatus.setFont(new Font("",1,15));
        
        displayStatus = new JLabel("");
        displayStatus.setBounds(250,250,300,50);
        displayStatus.setFont(new Font("",1,15));
        displayStatus.setForeground(Color.blue);
        
        centerPanel.add(lblCustomerId);
        centerPanel.add(displayCustomerId);
        centerPanel.add(lblName);
        centerPanel.add(displayName);
        centerPanel.add(lblQty);
        centerPanel.add(displayQty);
        centerPanel.add(lblTotal);
        centerPanel.add(displayTotal);
        centerPanel.add(lblStatus);
        centerPanel.add(displayStatus);
        
        getContentPane().add(centerPanel, BorderLayout.CENTER);
        
        //-----------------------------------------------------------------
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 50));
        southPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
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
        
        southPanel.add(backToHome);
        getContentPane().add(southPanel, BorderLayout.SOUTH);
    }
    
    private void searchCurrentOrder() {
        String orderID = txtOrderId.getText();
        Customer temp = check(orderID);
        
        if (isExist(orderID)) {
            displayCustomerId.setText(temp.getCustomerId());
            displayName.setText(temp.getName());
            displayQty.setText("" + temp.getQty());
            displayTotal.setText("Rs. " + temp.getTotal() + "0");
            displayStatus.setText(temp.getStatus());
        } else {
            displayCustomerId.setText("");
            displayName.setText("");
            displayQty.setText("");
            displayTotal.setText("");
            displayStatus.setText("");
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Invalid Order ID!", "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
    private Customer check(String text) {
        Customer[] temp = CustomerController.getArray();
        for (int i = 0; i < temp.length; i++) {
            if (text.equals(temp[i].getOrderId())) {
                return temp[i];
            }
        }
        return null;
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
}
