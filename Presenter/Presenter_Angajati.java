package Presenter;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Utilizatori;
import Model.AngajatiRepository;
import Model.Medicamente;
import Model.MedicamenteInfo;
import Model.MedicamenteRepository;
import View.AngajatiInterfata;
import View.View_Angajati;

public class Presenter_Angajati {
public AngajatiInterfata my_view;
private MedicamenteRepository medicamenteRepository;
private AngajatiRepository angajatiRepository;
public Presenter_Angajati(AngajatiInterfata my_view) {
	this.my_view=my_view;
	this.medicamenteRepository= new MedicamenteRepository();
	this.angajatiRepository= new AngajatiRepository();
}

public void actionLisenerC() {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(my_view.getTextFValabilitate());

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        int disponibilitate = Integer.parseInt(my_view.getTextFDisponibilitate());
        int pret = Integer.parseInt(my_view.getTextFPret());
        String producator = my_view.getTextFProducator();
        String farmacia = angajatiRepository.findByName(my_view.getInfoLabel());

        System.out.println(sqlDate);
        MedicamenteInfo medicamentInfo = new MedicamenteInfo(disponibilitate, sqlDate, pret, producator, farmacia);

        Medicamente medicament = new Medicamente(my_view.getTextFDenumire(), medicamentInfo);

        medicamenteRepository.insertMedicament(medicament);
    } catch (ParseException e) {
        System.err.println("Error parsing date: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Error parsing integer: " + e.getMessage());
    }
}

public void Update() {
    try {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = dateFormat.parse(my_view.getTextFValabilitate());

        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        int disponibilitate = Integer.parseInt(my_view.getTextFDisponibilitate());
        int pret = Integer.parseInt(my_view.getTextFPret());
        String producator = my_view.getTextFProducator();
        String farmacia = angajatiRepository.findByName(my_view.getInfoLabel());

        System.out.println(sqlDate);
        MedicamenteInfo medicamentInfo = new MedicamenteInfo(disponibilitate, sqlDate, pret, producator, farmacia);
        Medicamente medicament = new Medicamente(my_view.getTextFDenumire(), medicamentInfo);

        medicamenteRepository.updateMedicamentAtPharmacy(medicament,farmacia);
    } catch (ParseException e) {
        System.err.println("Error parsing date: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.err.println("Error parsing integer: " + e.getMessage());
    }
}

public void actionLisenerFilter() {
    List<Medicamente> medicamente = new ArrayList<Medicamente>();
    System.out.println(my_view.getSelectedComboBoxItem());
    medicamente = MedicamenteRepository.filterBy(my_view.getSelectedComboBoxItem(), my_view.getTextFValue());
    System.out.println(medicamente.toString());

    DefaultTableModel tableModel = medicamenteRepository.createTable(medicamente);
    StringBuilder sb = new StringBuilder();
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
    my_view.Tabelare(sb);
}

public void actionLisenerD() {
	String farmacia = angajatiRepository.findByName(my_view.getInfoLabel());
	medicamenteRepository.deleteMedicamentAtPharmacy( my_view.getTextFDenumire(),farmacia);

}

public void actionLisenerR() {
	String farmacia = angajatiRepository.findByName(my_view.getInfoLabel());
	medicamenteRepository.readMedicamentByNameAndFarmacie( my_view.getTextFDenumire(),farmacia);

}
public void actionListenerSort() {
    List<Medicamente> medicamente = new ArrayList<>();
    System.out.println(my_view.getSelectedComboBoxItem());
    medicamente = MedicamenteRepository.sortBy((String) my_view.getSelectedComboBoxItem());
    System.out.println(medicamente.toString());

    DefaultTableModel tableModel = medicamenteRepository.createTable(medicamente);
    StringBuilder sb = new StringBuilder();
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
    my_view.Tabelare(sb);
}
}