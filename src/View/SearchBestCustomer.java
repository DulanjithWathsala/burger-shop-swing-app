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
public class SearchBestCustomer extends JFrame{
    private DefaultTableModel dtm;
    private JTable tblCustomers;
    private JButton backToHome;
    
    public SearchBestCustomer() {
        setTitle("Best Customers");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("Search Best Customers");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        String[] columnName={"Customer ID", "Name", "Total"};
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
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,50, 15));
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
        
        addBestCustomer();
    }
    
    private void addBestCustomer() {
        if (CustomerController.isListEmpty()) {
            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "There are No orders Yet!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            dtm.setRowCount(0);
            Customer[] customerArray = CustomerController.getArray();
            Customer[] tempCustomer = new Customer[1];
            tempCustomer[0] = new Customer();

            String custId = customerArray[0].getCustomerId();
            String name = customerArray[0].getName();
            tempCustomer[0].setCustomerId(custId);
            tempCustomer[0].setName(name);

            for (int i = 0; i < customerArray.length; i++){
                if (!searchDupplicate(customerArray[i].getCustomerId(), tempCustomer)){
                    Customer[] temp = new Customer[tempCustomer.length + 1];
                    for (int j = 0; j < temp.length - 1; j++){
                            temp[j] = new Customer();
                            temp[j].setCustomerId(tempCustomer[j].getCustomerId());
                            temp[j].setName(tempCustomer[j].getName());
                    }
                    temp[temp.length - 1] = new Customer();
                    temp[temp.length - 1].setCustomerId(customerArray[i].getCustomerId());
                    temp[temp.length - 1].setName(customerArray[i].getName());
                    tempCustomer = temp;
                }
            }

            for (int i = 0; i < tempCustomer.length; i++){
                double tempTotal = 0;
                for (int j = 0; j < customerArray.length; j++){
                    if (tempCustomer[i].getCustomerId().equals(customerArray[j].getCustomerId())){
                            tempTotal += customerArray[j].getTotal();
                    }
                }
                tempCustomer[i].setTotal(tempTotal);
            }

            for (int i = 1; i < tempCustomer.length; i++){
                for (int j = 0; j < i; j++){
                    if (tempCustomer[j].getTotal() < tempCustomer[i].getTotal()){
                        double temp = tempCustomer[j].getTotal();
                        tempCustomer[j].setTotal(tempCustomer[i].getTotal());
                        tempCustomer[i].setTotal(temp);

                        String s1 = tempCustomer[j].getCustomerId();
                        tempCustomer[j].setCustomerId(tempCustomer[i].getCustomerId());
                        tempCustomer[i].setCustomerId(s1);

                        String s2 = tempCustomer[j].getName();
                        tempCustomer[j].setName(tempCustomer[i].getName());
                        tempCustomer[i].setName(s2);
                    }
                }	
            }

            //-----------------------------------------------------------------------
            for (int i = 0; i < tempCustomer.length; i++) {
                Object[] rowData = {
                    tempCustomer[i].getCustomerId(),
                    tempCustomer[i].getName(),
                    tempCustomer[i].getTotal()
                };
                dtm.addRow(rowData);
            }
        }
    }
    
    private boolean searchDupplicate(String value, Customer[] cr){
        for (int i = 0; i < cr.length; i++){
            if (value.equals(cr[i].getCustomerId())){
                    return true;
            }
        }
        return false;
    }
}
