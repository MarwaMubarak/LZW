package com.company;

import javax.print.attribute.standard.Compression;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Function;

public class Form {
    String name;
    Form(String name, Function<Void,Void> fun1 , Function<Void,Void> fun2){
        this.name=name;
        JFrame frame_ = new JFrame(name+" App");
        JLabel label_1, label_2;
        label_1 = new JLabel("Enter Input File Name");
        label_1.setBounds(50, 20, 300, 25);
        final JTextField input1 = new JTextField();
        input1.setBounds(190, 25, 150, 25);

        label_2 = new JLabel("Enter Output File Name");
        label_2.setBounds(50, 70, 300, 25);
        final JTextField input2 = new JTextField();
        input2.setBounds(190, 70, 150, 25);

        JButton button1 = new JButton("Compression");
        button1.setBounds(350, 150, 100, 30);
        JButton button2 = new JButton("Decompression");
        button2.setBounds(150, 150, 100, 30);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {




            }
        });
        frame_.add(label_1);
        frame_.add(label_2);
        frame_.add(button1);
        frame_.add(button2);
        frame_.add(input1);
        frame_.add(input2);
        frame_.setSize(600, 250);
        frame_.setLayout(null);
        frame_.setVisible(true);

    }


}
