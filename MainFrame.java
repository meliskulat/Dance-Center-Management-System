package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SystemClassAndMain.DanceCenterSystem;

public class MainFrame extends JFrame {

    private JPanel contentPane;
    private JTextArea outputArea;

    public MainFrame() {
        setTitle("Dance Center System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 750, 520);

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JButton addBtn = new JButton("Add Dancer");
        addBtn.setBounds(20, 20, 160, 30);
        contentPane.add(addBtn);

        JButton deleteBtn = new JButton("Delete Dancer");
        deleteBtn.setBounds(20, 60, 160, 30);
        contentPane.add(deleteBtn);

        JButton searchBtn = new JButton("Search By Name");
        searchBtn.setBounds(20, 100, 160, 30);
        contentPane.add(searchBtn);

        JButton displayBtn = new JButton("Display All");
        displayBtn.setBounds(20, 140, 160, 30);
        contentPane.add(displayBtn);

        JButton totalExpBtn = new JButton("Total Experience");
        totalExpBtn.setBounds(20, 180, 160, 30);
        contentPane.add(totalExpBtn);

        JButton totalBtn = new JButton("Total Dancers");
        totalBtn.setBounds(20, 220, 160, 30);
        contentPane.add(totalBtn);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(200, 20, 520, 430);
        contentPane.add(scrollPane);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        scrollPane.setViewportView(outputArea);

        // Actions (hocanın stili: ayrı frame aç)
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddDancerFrame af = new AddDancerFrame(MainFrame.this);
                af.setVisible(true);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DeleteDancerFrame df = new DeleteDancerFrame(MainFrame.this);
                df.setVisible(true);
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SearchDancerFrame sf = new SearchDancerFrame();
                sf.setVisible(true);
            }
        });

        displayBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refresh();
            }
        });

        totalExpBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = DanceCenterSystem.calculateTotalExperience();
                JOptionPane.showMessageDialog(null, "Total Experience: " + total);
            }
        });

        totalBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total = DanceCenterSystem.getTotalDancers();
                JOptionPane.showMessageDialog(null, "Total Dancers: " + total);
            }
        });

        // start with current list
        refresh();
    }

    public void refresh() {
        outputArea.setText(DanceCenterSystem.displayAll());
    }
}
