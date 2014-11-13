package com.scripts.practice;

import org.powerbot.script.Condition;
import org.powerbot.script.rt6.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jeremy on 10/28/2014.
 */
public class BurthorpeGUI extends JFrame {

    private final ClientContext ctx;
    private final Container container;

    private JButton start;

    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem menuItem;

    public BurthorpeGUI(ClientContext ctx) {
        this.ctx = ctx;
        setTitle("Burthorpe AIO");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        container = getContentPane();
        createGUI();
        pack();
        setVisible(true);
        setAlwaysOnTop(true);
        setLocation(500, 500);
    }

    private void createGUI() {
        start = new JButton("Start");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        container.add(start, BorderLayout.PAGE_END);
        menuBar = new JMenuBar();
        menu = new JMenu("Testing");
        menu.getAccessibleContext().setAccessibleDescription("This is just a test.");
        menuBar.add(menu);
        menuItem = new JMenuItem("Testing #1");
        menuItem.getAccessibleContext().setAccessibleDescription("Uh, this is another test.");
        menu.add(menuItem);
        setJMenuBar(menuBar);
    }

}
