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
import javax.swing.table.*;
/**
 *
 * @author DULA
 */
public class SearchCustomer extends JFrame{
    private JLabel lblCustomerId;
    private JLabel lblName;
    private JLabel displayName;
    
    private JTextField txtCustomerId;
    
    private JButton btnSearch;
    
    private  DefaultTableModel dtm;
    private  JTable tblCustomers;
    private  JButton backToHome;
    
    public SearchCustomer() {
        setTitle("Search Customer");
        setSize(1000, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));

        JLabel titleLabel = new JLabel("Search Customer");
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
        
        lblCustomerId = new JLabel("Enter Customer ID :");
        lblCustomerId.setBounds(20,10,150,40);
        lblCustomerId.setFont(new Font("",1,15));
        
        txtCustomerId = new JTextField();
        txtCustomerId.setBounds(200,10,300,40);
        txtCustomerId.setFont(new Font("",1,15));
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(520,10,100,40);
        btnSearch.setBackground(Color.blue);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("",1,15));
        btnSearch .setFocusable(false);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dtm.setRowCount(0);
                searchCurrentCustomer();
            }
        });
        
        lblName = new JLabel("Name :");
        lblName.setBounds(20,60,100,20);
        lblName.setFont(new Font("",1,15));
        
        displayName = new JLabel();
        displayName.setBounds(100,60,400,20);
        displayName.setFont(new Font("",1,15));
        displayName.setForeground(Color.blue);
        
        orderPanel.add(lblCustomerId);
        orderPanel.add(txtCustomerId);
        orderPanel.add(btnSearch);
        orderPanel.add(lblName);
        orderPanel.add(displayName);

        northPanel.add(titlePanel);
        northPanel.add(orderPanel);
        
        getContentPane().add(northPanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        
        JLabel titleLabel2 = new JLabel("Order Details");
        orderPanel.setLayout(new BorderLayout());
        titleLabel2.setFont(new Font("",1,20));
        titleLabel2.setHorizontalAlignment(JLabel.CENTER);
        titleLabel2.setForeground(Color.white);
        
        JPanel titlePanel2 = new JPanel();
        titlePanel2.setBackground(Color.red);
        //titlePanel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        titlePanel2.add(titleLabel2);
        
        mainPanel.add("North",titlePanel2);
        
        //-----------------------------------------------------------------
        String[] columnName={"Order ID", "Order Qty", "Total"};
        dtm=new DefaultTableModel(columnName,0);

        tblCustomers=new JTable(dtm);
        //tblCustomers.setBackground(Color.LIGHT_GRAY);
        JScrollPane tablePane=new JScrollPane(tblCustomers);
        tablePane.setBackground(Color.LIGHT_GRAY);
        tablePane.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
        mainPanel.add("Center",tablePane);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnName.length; i++) {
            tblCustomers.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        //-----------------------------------------------------------------
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 20));
        southPanel.setBackground(Color.LIGHT_GRAY);
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
    
    private void searchCurrentCustomer() {
        String custId = txtCustomerId.getText();
        char firstDigit = custId.charAt(0);
        if (firstDigit != '0' || custId.length() != 10){
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Invalid Customer ID. Try again!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else if (txtCustomerId.getText().isEmpty()) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Customer Id can't be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String name = isExist(custId);
            if (!name.equals("none")) {
                displayName.setText(name);
                checkAndAddData(custId);  
            } else {
                displayName.setText("");
                txtCustomerId.setText("");
                JFrame frame = new JFrame();
                JOptionPane.showMessageDialog(frame, "Customer ID does not exist!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void checkAndAddData(String text) {
        Customer[] temp = CustomerController.getArray();
        for (int i = 0; i < temp.length; i++) {
            if (text.equals(temp[i].getCustomerId())) {
                Object[] rowData = {
                    temp[i].getOrderId(),
                    temp[i].getQty(),
                    temp[i].getTotal(), 
                };
                dtm.addRow(rowData);
            }
        }
    }
    
    private String isExist(String text) {
        Customer[] temp = CustomerController.getArray();
        for (int i = 0; i < temp.length; i++) {
            if (text.equals(temp[i].getCustomerId())) {
                return temp[i].getName();
            }
        }
        return "none";
    }
}
