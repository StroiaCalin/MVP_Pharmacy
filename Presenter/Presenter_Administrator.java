package Presenter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


import Model.Utilizatori;
import Model.UtilizatoriRepository;
import Model.Angajati;
import Model.AngajatiRepository;
import Model.Medicamente;
import Model.MedicamenteInfo;
import Model.MedicamenteRepository;
import View.AdministratorInterfata;
import View.AngajatiInterfata;
import View.View_Angajati;

public class Presenter_Administrator {
public AdministratorInterfata my_view;
private UtilizatoriRepository utilizatoriRepository;
private AngajatiRepository angajatiRepository;

public Presenter_Administrator(AdministratorInterfata my_view) {
	this.my_view=my_view;
	this.utilizatoriRepository= new UtilizatoriRepository();
	this.angajatiRepository= new AngajatiRepository();

}
public void actionLisenerC() {
    String name = my_view.getTextFUsername();
    String password = my_view.getTextFPassword();
    String role = my_view.getTextFRole();
    String farmacia = my_view.getTextFFarmacia();

    if (!farmacia.equals("Farmacia") && !farmacia.isEmpty()) {
        Angajati angajati = new Angajati(name, farmacia);
        angajatiRepository.create(angajati);
    }

    Utilizatori utilizatori = new Utilizatori(name, password, role);
    utilizatoriRepository.create(utilizatori);
}

public void actionLisenerR() {
    String name = my_view.getTextFUsername();
    Utilizatori utilizatori = utilizatoriRepository.read(name);
    if (utilizatori != null) {
        String message = "ID: " + utilizatori.getIdClienti() + "\n" +
                         "Nume: " + utilizatori.getUsername() + "\n" +
                         "Parolă: " + utilizatori.getPassword() + "\n" +
                         "Rol: " + utilizatori.getRole();

        JOptionPane.showMessageDialog(null, message, "Informații utilizator", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Utilizatorul nu a fost găsit.", "Eroare", JOptionPane.ERROR_MESSAGE);
    }
}
public void actionLisenerVizualizare() {
    List<Utilizatori> utilizatoriList = utilizatoriRepository.findAll();
    List<Angajati> angajatiList = angajatiRepository.findAll();
    DefaultTableModel tableModel = utilizatoriRepository.createTable(utilizatoriList);
    DefaultTableModel tableModel2 = angajatiRepository.createTable(angajatiList);
    StringBuilder sb = new StringBuilder();
    sb.append("                                    Tabel Utilizatori\n");
    for (int i = 0; i < tableModel.getColumnCount(); i++) {
        sb.append(tableModel.getColumnName(i)).append("\t");
    }
    sb.append("\n");

    for (int i = 0; i < tableModel.getRowCount(); i++) {
        for (int j = 0; j < tableModel.getColumnCount(); j++) {
            sb.append(tableModel.getValueAt(i, j)).append("\t");
        }
        sb.append("\n");
    }
    sb.append("\n");
    sb.append("\n");
    sb.append("                                      Tabel Angajati\n");
    for (int i = 0; i < tableModel2.getColumnCount(); i++) {
        sb.append(tableModel2.getColumnName(i)).append("\t");
    }
    sb.append("\n");

    for (int i = 0; i < tableModel2.getRowCount(); i++) {
        for (int j = 0; j < tableModel2.getColumnCount(); j++) {
            sb.append(tableModel2.getValueAt(i, j)).append("\t");
        }
        sb.append("\n");
    }
    my_view.Tabelare(sb);
}
public void actionLisenerU() {

    String name = my_view.getTextFUsername();
    String password = my_view.getTextFPassword();
    String role = my_view.getTextFRole();
    if(my_view.getTextFFarmacia() != null)
    {
    	String farmacia = my_view.getTextFFarmacia();
        Angajati angajati = new Angajati(name,farmacia);
    	angajatiRepository.update(angajati);
    }
    
    Utilizatori utilizatori = new Utilizatori(name, password, role);
    utilizatoriRepository.update(utilizatori);
}

public void actionLisenerD() {
    String nume = my_view.getTextFUsername();
    utilizatoriRepository.delete(nume);
    angajatiRepository.delete(nume);
}

}

