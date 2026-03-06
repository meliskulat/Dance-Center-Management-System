package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import SystemClassAndMain.DanceCenterSystem;

public class DeleteDancerFrame extends JFrame {

    private JTextField idTF;
    private JLabel msgLbl;
    private MainFrame main;

    public DeleteDancerFrame(MainFrame mainFrame) {
        this.main = mainFrame;

        setTitle("Delete Dancer");
        setBounds(150, 150, 360, 200);
        setLayout(null);

        JLabel lbl = new JLabel("Dancer ID:");
        lbl.setBounds(20, 25, 120, 25);
        add(lbl);

        idTF = new JTextField();
        idTF.setBounds(140, 25, 170, 25);
        add(idTF);

        JButton delBtn = new JButton("Delete");
        delBtn.setBounds(140, 65, 100, 30);
        add(delBtn);

        msgLbl = new JLabel("");
        msgLbl.setBounds(20, 110, 300, 25);
        add(msgLbl);

        delBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteDancer();
            }
        });
    }

    private void deleteDancer() {
        try {
            int id = Integer.parseInt(idTF.getText().trim());
            DanceCenterSystem.deleteDancer(id);
            main.refresh();
            JOptionPane.showMessageDialog(null, "Delete operation completed.");
            dispose();
        } catch (NumberFormatException ex) {
            msgLbl.setText("Invalid ID. Please enter a number.");
        } catch (Exception ex) {
            msgLbl.setText("Error while deleting.");
        }
    }
}
