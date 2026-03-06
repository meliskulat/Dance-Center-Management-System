package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Inheritance.BalletDancer;
import Inheritance.Dancer;
import Inheritance.HipHopDancer;
import SystemClassAndMain.DanceCenterSystem;
import SystemClassAndMain.Instructor;

public class AddDancerFrame extends JFrame {

    private JTextField nameTF, ageTF, expTF;
    private JTextField instNameTF, instSpecTF, instPhoneTF;

    private JRadioButton balletRB, hiphopRB;
    private ButtonGroup typeGroup;

    private JLabel extra1Lbl, extra2Lbl;
    private JTextField extra1TF, extra2TF;

    private JLabel msgLbl;

    private MainFrame main;

    public AddDancerFrame(MainFrame mainFrame) {
        this.main = mainFrame;

        setTitle("Add Dancer");
        setBounds(120, 120, 520, 480);
        setLayout(null);

        JLabel lbl;

        lbl = new JLabel("Name:");
        lbl.setBounds(20, 20, 150, 25);
        add(lbl);
        nameTF = new JTextField();
        nameTF.setBounds(180, 20, 280, 25);
        add(nameTF);

        lbl = new JLabel("Age:");
        lbl.setBounds(20, 55, 150, 25);
        add(lbl);
        ageTF = new JTextField();
        ageTF.setBounds(180, 55, 280, 25);
        add(ageTF);

        lbl = new JLabel("Experience Year:");
        lbl.setBounds(20, 90, 150, 25);
        add(lbl);
        expTF = new JTextField();
        expTF.setBounds(180, 90, 280, 25);
        add(expTF);

        lbl = new JLabel("Instructor Name:");
        lbl.setBounds(20, 125, 150, 25);
        add(lbl);
        instNameTF = new JTextField();
        instNameTF.setBounds(180, 125, 280, 25);
        add(instNameTF);

        lbl = new JLabel("Specialization:");
        lbl.setBounds(20, 160, 150, 25);
        add(lbl);
        instSpecTF = new JTextField();
        instSpecTF.setBounds(180, 160, 280, 25);
        add(instSpecTF);

        lbl = new JLabel("Phone:");
        lbl.setBounds(20, 195, 150, 25);
        add(lbl);
        instPhoneTF = new JTextField();
        instPhoneTF.setBounds(180, 195, 280, 25);
        add(instPhoneTF);

        // Type selection
        lbl = new JLabel("Dancer Type:");
        lbl.setBounds(20, 230, 150, 25);
        add(lbl);

        balletRB = new JRadioButton("Ballet");
        balletRB.setBounds(180, 230, 80, 25);
        add(balletRB);

        hiphopRB = new JRadioButton("HipHop");
        hiphopRB.setBounds(270, 230, 90, 25);
        add(hiphopRB);

        typeGroup = new ButtonGroup();
        typeGroup.add(balletRB);
        typeGroup.add(hiphopRB);

        // Extra fields (type-specific)
        extra1Lbl = new JLabel("Extra 1:");
        extra1Lbl.setBounds(20, 270, 150, 25);
        add(extra1Lbl);

        extra1TF = new JTextField();
        extra1TF.setBounds(180, 270, 280, 25);
        add(extra1TF);

        extra2Lbl = new JLabel("Extra 2:");
        extra2Lbl.setBounds(20, 305, 150, 25);
        add(extra2Lbl);

        extra2TF = new JTextField();
        extra2TF.setBounds(180, 305, 280, 25);
        add(extra2TF);

        JButton addBtn = new JButton("Add");
        addBtn.setBounds(180, 355, 120, 30);
        add(addBtn);

        JButton clearBtn = new JButton("Clear");
        clearBtn.setBounds(310, 355, 120, 30);
        add(clearBtn);

        msgLbl = new JLabel("");
        msgLbl.setBounds(20, 400, 460, 25);
        add(msgLbl);

        // Default: nothing selected => extras disabled
        setExtrasDisabled("Select Ballet or HipHop");

        // radio actions
        balletRB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                extra1Lbl.setText("Shoe Type:");
                extra2Lbl.setText("Technique Level:");
                extra1TF.setEnabled(true);
                extra2TF.setEnabled(true);
                msgLbl.setText("Ballet selected.");
            }
        });

        hiphopRB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                extra1Lbl.setText("Style:");
                extra2Lbl.setText("Crew Name:");
                extra1TF.setEnabled(true);
                extra2TF.setEnabled(true);
                msgLbl.setText("HipHop selected.");
            }
        });

        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clean();
            }
        });

        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addDancer();
            }
        });
    } // ✅ constructor bitti

    private void setExtrasDisabled(String message) {
        extra1Lbl.setText("Extra 1:");
        extra2Lbl.setText("Extra 2:");
        extra1TF.setEnabled(false);
        extra2TF.setEnabled(false);
        msgLbl.setText(message);
    }

    private void clean() {
        nameTF.setText("");
        ageTF.setText("");
        expTF.setText("");
        instNameTF.setText("");
        instSpecTF.setText("");
        instPhoneTF.setText("");
        extra1TF.setText("");
        extra2TF.setText("");
        typeGroup.clearSelection();
        setExtrasDisabled("Select Ballet or HipHop");
    }

    private void addDancer() {
        try {
            if (nameTF.getText().trim().isEmpty() ||
                ageTF.getText().trim().isEmpty() ||
                expTF.getText().trim().isEmpty() ||
                instNameTF.getText().trim().isEmpty() ||
                instSpecTF.getText().trim().isEmpty() ||
                instPhoneTF.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please fill all common fields.");
                return;
            }

            if (!balletRB.isSelected() && !hiphopRB.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please select a dancer type (Ballet / HipHop).");
                return;
            }

            if (extra1TF.getText().trim().isEmpty() || extra2TF.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill the type-specific fields.");
                return;
            }

            int age = Integer.parseInt(ageTF.getText().trim());
            int exp = Integer.parseInt(expTF.getText().trim());

            Instructor ins = new Instructor(
                    instNameTF.getText().trim(),
                    instSpecTF.getText().trim(),
                    instPhoneTF.getText().trim()
            );

            Dancer d;
            if (balletRB.isSelected()) {
                d = new BalletDancer(
                        nameTF.getText().trim(),
                        age,
                        exp,
                        ins,
                        extra1TF.getText().trim(),
                        extra2TF.getText().trim()
                );
            } else {
                d = new HipHopDancer(
                        nameTF.getText().trim(),
                        age,
                        exp,
                        ins,
                        extra1TF.getText().trim(),
                        extra2TF.getText().trim()
                );
            }

            DanceCenterSystem.addDancer(d);
            main.refresh();
            JOptionPane.showMessageDialog(null, "Dancer added successfully.");
            dispose();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age and Experience Year must be numbers.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error while adding dancer.");
        }
    }
}
