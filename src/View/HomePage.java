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
public class HomePage extends JFrame{
    private final JButton btnPlaceOrder;
    private final JButton btnSearch;
    private final JButton btnViewOrders;
    private final JButton btnUpdateOrder;
    private final JButton btnExit;

    public HomePage() {
        setTitle("Burger Shop");
        setSize(1000, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 2));

        ImageIcon icon = new ImageIcon("C:\\Users\\DULA\\Desktop\\BurgerShop Project\\Burger Shop\\src\\View\\burger.jpg");
        JLabel imageLabel = new JLabel(icon);
        getContentPane().add(imageLabel);

        JPanel btnPanel = new JPanel(); 
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.setBackground(Color.lightGray);

        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setBackground(Color.red);
        btnPlaceOrder.setForeground(Color.white);
        btnPlaceOrder.setFont(new Font("",1,12));
        btnPlaceOrder.setBounds(100,50,150,50);
        btnPlaceOrder .setFocusable(false);
        btnPlaceOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new PlaceOrder().setVisible(true);
            }
        });

        btnSearch = new JButton("Search");
        btnSearch.setBackground(Color.red);
        btnSearch.setForeground(Color.white);
        btnSearch.setFont(new Font("",1,12));
        btnSearch.setBounds(100,120,150,50);
        btnSearch .setFocusable(false);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Search().setVisible(true);
            }
        });

        btnViewOrders = new JButton("View Orders");
        btnViewOrders.setBackground(Color.red);
        btnViewOrders.setForeground(Color.white);
        btnViewOrders.setFont(new Font("",1,12));
        btnViewOrders.setBounds(100,190,150,50);
        btnViewOrders .setFocusable(false);
        btnViewOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new viewOrders().setVisible(true);
            }
        });

        btnUpdateOrder = new JButton("Update Order Details");
        btnUpdateOrder.setBackground(Color.red);
        btnUpdateOrder.setForeground(Color.white);
        btnUpdateOrder.setFont(new Font("",1,12));
        btnUpdateOrder.setBounds(100,260,150,50);
        btnUpdateOrder .setFocusable(false);
        btnUpdateOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new UpdateOrder().setVisible(true);
            }
        });

        btnExit = new JButton("Exit");
        btnExit.setBackground(Color.red);
        btnExit.setForeground(Color.white);
        btnExit.setFont(new Font("",1,12));
        btnExit.setBounds(100,330,150,50);
        btnExit .setFocusable(false);

        btnPanel.add(Box.createVerticalGlue());
        btnPanel.add(btnPlaceOrder);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(btnSearch);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(btnViewOrders);
        btnPanel.add(Box.createVerticalStrut(10));
        btnPanel.add(btnUpdateOrder);
        btnPanel.add(Box.createVerticalGlue());
        
        btnPlaceOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearch.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewOrders.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnUpdateOrder.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        btnPanel.add(btnExit);
        btnPanel.add(Box.createVerticalStrut(10));
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        getContentPane().add(btnPanel); 
    }
}
