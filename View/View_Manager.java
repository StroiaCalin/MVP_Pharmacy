package View;
import javax.swing.*;

import Model.Utilizatori;
import Presenter.Presenter_Angajati;
import Presenter.Presenter_Manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Manager extends JFrame implements ManagerInterfata {
    private JFrame frame = new JFrame();
    private JButton btnSort = new JButton("Sort");
    private JButton btnFiltrare = new JButton("Filtrare"); // Added JButton
    private JButton btnRead = new JButton("Read"); 
    private JButton btnClose = new JButton("Close"); 
    
    private JLabel titleLabel = new JLabel("Select Options:");
    private JComboBox<String> comboBox = new JComboBox<>();
    private JLabel infoLabel = new JLabel();

    private JTextField textFFarmacia = new JTextField(); // Added JTextField
    private JTextField textFValue = new JTextField();
    private Presenter_Manager managerPresenter;
    
    public View_Manager() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 400, 400);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        titleLabel.setBounds(50, 50, 150, 20);
        panel.add(titleLabel);
        // Adding some sample options to the combo box
        comboBox.addItem("disponibilitate");
        comboBox.addItem("pret");
        comboBox.addItem("valabilitate");
        comboBox.addItem("producator");
        comboBox.setBounds(150, 50, 150, 20);
        panel.add(comboBox);
        textFValue.setBounds(300, 50, 50, 20);
        panel.add(textFValue);
        btnFiltrare.setBounds(120, 135, 150, 40);
        panel.add(btnFiltrare);
        btnSort.setBounds(120, 175, 150, 40);
        panel.add(btnSort);
        btnRead.setBounds(120, 215, 150, 40);
        panel.add(btnRead);
        btnClose.setBounds(120, 255, 150, 40); // Set position and size of the close button
        panel.add(btnClose); // Add close button to the panel
        infoLabel.setText("Alege Farmacia:");
        infoLabel.setBounds(50, 20, 150, 20);
        panel.add(infoLabel);
        // Setting bounds for the new components
        textFFarmacia.setBounds(150, 20, 200, 20);
        panel.add(textFFarmacia);

        
        frame.add(panel);
        frame.setTitle("Manager View"); // Set title
        frame.setVisible(true);
        this.managerPresenter = new Presenter_Manager(this);


        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerPresenter.actionLisenerR();
            }
        });        
        
        
        btnSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerPresenter.actionLisenerSort();
            }
        });
        
        btnFiltrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                managerPresenter.actionLisenerFilter();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame when the close button is clicked
            }
        });
        
    }
    public String getSelectedComboBoxItem() {
        Object selectedItem = comboBox.getSelectedItem();
        if (selectedItem != null) {
            return selectedItem.toString();
        } else {
            return null;
        }
    }
	public String getTextFValue() {
		return textFValue.getText();
	}
	public String getTextFFarmacia() {
		return textFFarmacia.getText();
	}
	public void Tabelare(StringBuilder sb)
	{
		  JTextArea textArea = new JTextArea();
		    textArea.setEditable(false);
		    textArea.setText(sb.toString());
		    JScrollPane scrollPane = new JScrollPane(textArea);
		    JFrame frame = new JFrame("Table Data");
		    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		    frame.setSize(400, 300);
		    frame.setVisible(true);
	}
}

