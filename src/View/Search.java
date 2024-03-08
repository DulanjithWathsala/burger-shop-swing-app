/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author DULA
 */
public class Search extends JFrame{
    private final JButton searchCustomer;
    private final JButton searchOrder;
    private final JButton searchBestCustomer;
    
    public Search() {
        setTitle("Search");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("Search");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.red);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        titlePanel.add(titleLabel);
        getContentPane().add(titlePanel, BorderLayout.NORTH);
        //-----------------------------------------------------------------
        
        JPanel btnPanel = new JPanel(); 
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBackground(Color.lightGray);
        
        searchCustomer = new JButton("Search Customer");
        searchCustomer.setBackground(Color.red);
        searchCustomer.setForeground(Color.white);
        searchCustomer.setFont(new Font("",1,15));
        searchCustomer .setFocusable(false);
        searchCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SearchCustomer().setVisible(true);
            }
        });
        
        searchOrder = new JButton("search Order");
        searchOrder.setBackground(Color.red);
        searchOrder.setForeground(Color.white);
        searchOrder.setFont(new Font("",1,15));
        searchOrder .setFocusable(false);
        searchOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SearchOrder().setVisible(true);
            }
        });
        
        searchBestCustomer = new JButton("Search Best Customer");
        searchBestCustomer.setBackground(Color.red);
        searchBestCustomer.setForeground(Color.white);
        searchBestCustomer.setFont(new Font("",1,15));
        searchBestCustomer .setFocusable(false);
        searchBestCustomer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new SearchBestCustomer().setVisible(true);
            }
        });
        
        btnPanel.add(Box.createVerticalGlue());
        btnPanel.add(searchCustomer);
        btnPanel.add(Box.createVerticalStrut(30));
        btnPanel.add(searchOrder);
        btnPanel.add(Box.createVerticalStrut(30));
        btnPanel.add(searchBestCustomer);
        btnPanel.add(Box.createVerticalGlue());
        
        searchCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        searchBestCustomer.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        getContentPane().add(btnPanel, BorderLayout.CENTER);
    }
}
