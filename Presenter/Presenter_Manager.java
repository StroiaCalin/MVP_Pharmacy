package Presenter;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import Model.AngajatiRepository;
import Model.Medicamente;
import Model.MedicamenteRepository;
import View.AngajatiInterfata;
import View.ManagerInterfata;

public class Presenter_Manager {
	public ManagerInterfata my_view;
	private MedicamenteRepository medicamenteRepository;
	public Presenter_Manager(ManagerInterfata my_view) {
		this.my_view=my_view;
		this.medicamenteRepository= new MedicamenteRepository();
	}

	public void actionLisenerFilter() {
		List<Medicamente> medicamente=new ArrayList<Medicamente>();
		System.out.println(my_view.getSelectedComboBoxItem());
		medicamente=MedicamenteRepository.filterBy(my_view.getSelectedComboBoxItem(),my_view.getTextFValue());
		System.out.println(medicamente.toString());
		DefaultTableModel tableModel =medicamenteRepository.createTable(medicamente);
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
	public void actionLisenerSort() {
		List<Medicamente> medicamente=new ArrayList<Medicamente>();
		System.out.println(my_view.getSelectedComboBoxItem());
		medicamente=MedicamenteRepository.sortByF(my_view.getSelectedComboBoxItem(),my_view.getTextFFarmacia());
		System.out.println(medicamente.toString());
		DefaultTableModel tableModel =medicamenteRepository.createTable(medicamente);

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
	public void actionLisenerR() {
		medicamenteRepository.readMedicamentByName( my_view.getTextFValue());
	}

	
}
