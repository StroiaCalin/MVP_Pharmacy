package Model;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.table.DefaultTableModel;

public class AngajatiRepository {
    private Repository repository;

    public AngajatiRepository() {
        this.repository = new Repository();
    }

    public Angajati createAngajatObject(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String farmacie = resultSet.getString("farmacie");
        // You might have more fields here depending on your database schema
        return new Angajati(id, name, farmacie);
    }

    public List<Angajati> findAll() {
        String query = "SELECT * FROM angajati";
        List<Angajati> angajatiList = new ArrayList<>();

        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Angajati angajat = createAngajatObject(resultSet);
                angajatiList.add(angajat);
            }
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:findAll " + e.getMessage());
        }

        return angajatiList;
    }

    public String findByName(String name) {
        Angajati angajat = null;
        String query = "SELECT * FROM angajati WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    angajat = createAngajatObject(resultSet);
                }
            }
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:findByName " + e.getMessage());
        }
        return angajat.getFarmacie();
    }

    public void create(Angajati angajat) {
        String query = "INSERT INTO angajati (name, farmacie) VALUES (?, ?)";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, angajat.getName());
            statement.setString(2, angajat.getFarmacie());
            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:create " + e.getMessage());
        }
    }

    public void update(Angajati angajat) {
        String query = "UPDATE angajati SET farmacie = ? WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, angajat.getFarmacie());
            statement.setString(2, angajat.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:update " + e.getMessage());
        }
    }

    public void delete(String name) {
        String query = "DELETE FROM angajati WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:delete " + e.getMessage());
        }
    }
    
    
    public DefaultTableModel createTable(List<Angajati> afisare) {
        if (afisare == null || afisare.isEmpty()) {
            return new DefaultTableModel();
        }

        Class<?> type = afisare.get(0).getClass();

        Field[] angajatiFields = Angajati.class.getDeclaredFields();

        List<String> columnNames = new ArrayList<>();

        for (Field field : angajatiFields) {
            columnNames.add(field.getName());
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames.toArray(new String[0]), 0);

        for (Angajati obj : afisare) {
            Object[] rowData = new Object[columnNames.size()];
            int index = 0;

            for (Field field : angajatiFields) {
                field.setAccessible(true);
                try {
                    rowData[index++] = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            tableModel.addRow(rowData);
        }
        return tableModel;
    }
}
