package View;

import javax.swing.*;

import Presenter.Presenter_Login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View_Login extends JFrame implements UtilizatoriInterfata {
    private JFrame frame=new JFrame();
    private JButton btnLogin = new JButton("Login");
    private JTextField titlu;
    private JTextField titlu2;
    private Presenter_Login userPresenter;
    public View_Login()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 650, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        titlu = new JTextField();
        titlu.setEditable(true);
        titlu.setText("Username");
        titlu.setBounds(250, 50, 250, 40);
        panel.add(titlu);
        
        titlu2 = new JTextField();
        titlu2.setEditable(true);
        titlu2.setText("Password");
        titlu2.setBounds(250, 100, 250, 40);
        panel.add(titlu2);

        btnLogin.setBounds(250, 150, 150, 40);
        panel.add(btnLogin);

        frame.add(panel);
        frame.setVisible(true);
        this.userPresenter = new Presenter_Login(View_Login.this);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userPresenter.actionLisenerLogin();
            }
        });
    }
	public String getTitlu() {
		return titlu.getText();
	}

	public String getTitlu2() {
		return titlu2.getText();
	}

}
