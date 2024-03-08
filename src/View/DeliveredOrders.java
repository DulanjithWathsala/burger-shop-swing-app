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
public class DeliveredOrders extends JFrame{
    private final DefaultTableModel dtm;
    private final JTable tblCustomers;
    private final JButton backToHome;
    
    public DeliveredOrders() {
        setTitle("Delivered Order");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("Delivered Orders");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        String[] columnName={"Order ID","Customer ID", "Name", "Order Qty","Total"};
        dtm=new DefaultTableModel(columnName,0);

        tblCustomers=new JTable(dtm);
        //tblCustomers.setBackground(Color.gray);
        JScrollPane tablePane=new JScrollPane(tblCustomers);
        tablePane.setBackground(Color.LIGHT_GRAY);
        tablePane.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        add("Center",tablePane);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columnName.length; i++) {
            tblCustomers.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        //-----------------------------------------------------------------
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 50));
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
        
        addTblData();
    }
    
    private void addTblData() {
        Customer[] temp = CustomerController.getArray();
        for (int i = 0; i < temp.length; i++) {
            Customer obj = temp[i];
            if (obj.getStatus().equals(CustomerController.getOrderStatus(1))) {
                Object[] rowData = {
                obj.getOrderId(),
                obj.getCustomerId(),
                obj.getName(),
                obj.getQty(),
                obj.getTotal()
            };
            
            dtm.addRow(rowData);
            } 
        }
    }
}
