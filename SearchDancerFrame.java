package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inheritance.Dancer;
import SystemClassAndMain.DanceCenterSystem;

public class SearchDancerFrame extends JFrame {

    private JTextField nameTF;
    private JLabel msgLbl;

    public SearchDancerFrame() {
        setTitle("Search Dancer");
        setBounds(160, 160, 420, 220);
        setLayout(null);

        JLabel lbl = new JLabel("Name:");
        lbl.setBounds(20, 25, 100, 25);
        add(lbl);

        nameTF = new JTextField();
        nameTF.setBounds(120, 25, 260, 25);
        add(nameTF);

        JButton searchBtn = new JButton("Search");
        searchBtn.setBounds(120, 65, 120, 30);
        add(searchBtn);

        msgLbl = new JLabel("");
        msgLbl.setBounds(20, 115, 360, 25);
        add(msgLbl);

        searchBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                search();
            }
        });
    }

    private void search() {
        String name = nameTF.getText().trim();
        if (name.isEmpty()) {
            msgLbl.setText("Please enter a name.");
            return;
        }

        Dancer d = DanceCenterSystem.searchByName(name);

        if (d == null) {
            msgLbl.setText("Not Found.");
            JOptionPane.showMessageDialog(null, "Dancer not found.");
        } else {
            msgLbl.setText("Found.");
            JOptionPane.showMessageDialog(null, d.toString());
        }
    }
}
