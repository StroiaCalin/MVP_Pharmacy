package View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Model.Utilizatori;
import Presenter.Presenter_Angajati;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Angajati extends JFrame implements AngajatiInterfata {
    private JFrame frame = new JFrame();
    private JButton btnSort = new JButton("Sort");
    private JButton btnFiltrare = new JButton("Filtrare");
    private JButton btnClose = new JButton("Close"); 

    
    private JLabel titleLabel = new JLabel("Select Options:");
    private JComboBox<String> comboBox = new JComboBox<>();

	private JLabel infoLabel = new JLabel();
    private JLabel infoDisponibilitate = new JLabel("Disponibilitate:");
    private JLabel infoValabilitate = new JLabel("Valabilitate:");
    private JLabel infoPret = new JLabel("Pret:");
    private JLabel infoProducator = new JLabel("Producator:");
    private JLabel infoDenumire = new JLabel("Denumire:");

    private JTextField textFDisponibilitate = new JTextField();
    private JTextField textFValabilitate = new JTextField();
    private JTextField textFPret = new JTextField();
    private JTextField textFProducator = new JTextField();

	private JTextField textFDenumire = new JTextField();
    private JTextField textFValue = new JTextField();
    
    private JButton btnC = new JButton("C");
    private JButton btnR = new JButton("R");
    private JButton btnU = new JButton("U");
    private JButton btnD = new JButton("D"); // Added JButton

    private Presenter_Angajati angajatiPresenter;
    public View_Angajati(String field) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 750, 300);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        titleLabel.setBounds(50, 50, 150, 20);
        panel.add(titleLabel);

        comboBox.addItem("disponibilitate");
        comboBox.addItem("pret");
        comboBox.addItem("valabilitate");
        comboBox.addItem("producator");
        comboBox.setBounds(150, 50, 150, 20);
        panel.add(comboBox);
        textFValue.setBounds(300, 50, 50, 20);
        panel.add(textFValue);
        btnFiltrare.setBounds(100, 135, 150, 40);
        panel.add(btnFiltrare);
        btnSort.setBounds(100, 175, 150, 40);
        panel.add(btnSort);
        infoLabel.setText(field);
        infoLabel.setBounds(280, 20, 150, 20);
        panel.add(infoLabel);
        infoDisponibilitate.setBounds(360, 150, 150, 20);
        panel.add(infoDisponibilitate);
        infoValabilitate.setBounds(360, 125, 150, 20);
        panel.add(infoValabilitate);
        infoPret.setBounds(360, 100, 150, 20);
        panel.add(infoPret);
        infoProducator.setBounds(360, 75, 150, 20);
        panel.add(infoProducator);
        infoDenumire.setBounds(360, 50, 150, 20);
        panel.add(infoDenumire);
        
        textFDisponibilitate.setBounds(450, 150, 200, 20);
        panel.add(textFDisponibilitate);
        textFValabilitate.setBounds(450, 125, 200, 20);
        panel.add(textFValabilitate);
        textFPret.setBounds(450, 100, 200, 20);
        panel.add(textFPret);
        textFProducator.setBounds(450, 75, 200, 20);
        panel.add(textFProducator);
        textFDenumire.setBounds(450, 50, 200, 20);
        panel.add(textFDenumire);

        btnC.setBounds(450, 175, 50, 40);
        panel.add(btnC);
        btnR.setBounds(500, 175, 50, 40);
        panel.add(btnR);
        btnU.setBounds(550, 175, 50, 40);
        panel.add(btnU);
        btnD.setBounds(600, 175, 50, 40);
        panel.add(btnD);
        
        btnClose.setBounds(100, 215, 150, 40); // Set position and size of the close button
        panel.add(btnClose); // Add close button to the panel
        
        frame.add(panel);
        frame.setTitle("Angajati View"); // Set title
        frame.setVisible(true);
        angajatiPresenter = new Presenter_Angajati(this);
        
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.actionLisenerC();
            }
        });        
        btnSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.actionListenerSort();
            }
        });
        btnFiltrare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.actionLisenerFilter();
            }
        });
        btnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.actionLisenerR();
            }
        });
        btnU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.Update();
            }
        });
        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angajatiPresenter.actionLisenerD();
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

	public String getTextFDisponibilitate() {
		return textFDisponibilitate.getText();
	}
	public String getTextFValabilitate() {
		return textFValabilitate.getText();
	}
	public String getTextFPret() {
		return textFPret.getText();
	}
	public String getTextFProducator() {
		return textFProducator.getText();
	}
	public String getTextFDenumire() {
		return textFDenumire.getText();
	}    
	public String getTextFValue() {
		return textFValue.getText();
	}
    public String getInfoLabel() {
		return infoLabel.getText();
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

