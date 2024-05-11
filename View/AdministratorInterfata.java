package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface AdministratorInterfata {
    String getTextFUsername();
    
    String getTextFPassword();
    
    String getTextFRole();
    
    String getTextFFarmacia();
    public void Tabelare(StringBuilder sb);
}