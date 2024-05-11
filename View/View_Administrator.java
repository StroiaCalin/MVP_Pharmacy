package View;
import javax.swing.*;

import Model.Utilizatori;
import Presenter.Presenter_Administrator;
import Presenter.Presenter_Angajati;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Administrator extends JFrame implements AdministratorInterfata {
    private JFrame frame = new JFrame();
    private JButton btnViz = new JButton("Vizualizare");
    private JTextField textFUsername = new JTextField("Nume"); // Added JTextField
    private JTextField textFPassword = new JTextField("Password"); // Added JTextField
    private JTextField textFRole = new JTextField("Role"); // Added JTextField
    private JTextField textFFarmacia = new JTextField("Farmacia"); // Added JTextField
    private JButton btnC = new JButton("C"); // Added JButton
    private JButton btnR = new JButton("R"); // Added JButton
    private JButton btnU = new JButton("U"); // Added JButton
    private JButton btnD = new JButton("D"); // Added JButton
    private JButton btnClose = new JButton("Close"); 

    private Presenter_Administrator administratorPresenter;
    
    public View_Administrator() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 450, 300);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        btnViz.setBounds(100, 175, 200, 40);
        panel.add(btnViz);
        
        textFUsername.setBounds(100, 20, 200, 20);
        panel.add(textFUsername);
        textFPassword.setBounds(100, 50, 200, 20);
        panel.add(textFPassword);
        textFRole.setBounds(100, 80, 200, 20);
        panel.add(textFRole);
        textFFarmacia.setBounds(100, 110, 200, 20);
        panel.add(textFFarmacia);
        
        
        btnC.setBounds(100, 135, 50, 40);
        panel.add(btnC);
        btnR.setBounds(150, 135, 50, 40);
        panel.add(btnR);
        btnU.setBounds(200, 135, 50, 40);
        panel.add(btnU);
        btnD.setBounds(250, 135, 50, 40);
        panel.add(btnD);
        btnClose.setBounds(100, 215, 200, 40); // Set position and size of the close button
        panel.add(btnClose); // Add close button to the panel
        
        frame.add(panel);
        frame.setTitle("Administrator View"); // Set title
        frame.setVisible(true);
        this.administratorPresenter = new Presenter_Administrator(this);

        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	administratorPresenter.actionLisenerC();
            }
        });                
 
        btnViz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	administratorPresenter.actionLisenerVizualizare();
            }
        });
        btnR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	administratorPresenter.actionLisenerR();
            }
        });
        btnU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	administratorPresenter.actionLisenerU();
            }
        });
        btnD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	administratorPresenter.actionLisenerD();
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Close the frame when the close button is clicked
            }
        });
        
    }

	public String getTextFUsername() {
		return textFUsername.getText();
	}
	public String getTextFPassword() {
		return textFPassword.getText();
	}

	public String getTextFRole() {
		return textFRole.getText();
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

