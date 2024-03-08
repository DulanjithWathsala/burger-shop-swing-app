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
public class viewOrders extends JFrame {
    private final JButton deliveredOrders;
    private final JButton processingdOrders;
    private final JButton cancelledOrders;
    
    public viewOrders() {
        setTitle("View Orders");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel titleLabel = new JLabel("View Orders");
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
        
        deliveredOrders = new JButton("Delivered Orders");
        deliveredOrders.setBackground(Color.red);
        deliveredOrders.setForeground(Color.white);
        deliveredOrders.setFont(new Font("",1,15));
        deliveredOrders .setFocusable(false);
        deliveredOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new DeliveredOrders().setVisible(true);
            }
        });
        
        processingdOrders = new JButton("Processing Orders");
        processingdOrders.setBackground(Color.red);
        processingdOrders.setForeground(Color.white);
        processingdOrders.setFont(new Font("",1,15));
        processingdOrders .setFocusable(false);
        processingdOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ProcessingOrders().setVisible(true);
            }
        });
        
        cancelledOrders = new JButton("Cancelled Orders");
        cancelledOrders.setBackground(Color.red);
        cancelledOrders.setForeground(Color.white);
        cancelledOrders.setFont(new Font("",1,15));
        cancelledOrders .setFocusable(false);
        cancelledOrders.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CancelledOrders().setVisible(true);
            }
        });
        
        btnPanel.add(Box.createVerticalGlue());
        btnPanel.add(deliveredOrders);
        btnPanel.add(Box.createVerticalStrut(30));
        btnPanel.add(processingdOrders);
        btnPanel.add(Box.createVerticalStrut(30));
        btnPanel.add(cancelledOrders);
        btnPanel.add(Box.createVerticalGlue());
        
        deliveredOrders.setAlignmentX(Component.CENTER_ALIGNMENT);
        processingdOrders.setAlignmentX(Component.CENTER_ALIGNMENT);
        cancelledOrders.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        getContentPane().add(btnPanel, BorderLayout.CENTER);
    }
}
