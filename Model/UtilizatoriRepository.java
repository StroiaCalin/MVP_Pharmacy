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


public class UtilizatoriRepository {
    private Repository repository;

    public UtilizatoriRepository()
    {
        this.repository = new Repository();
    }
    
    private List<Utilizatori> createObjects(ResultSet resultSet) throws SQLException {
        List<Utilizatori> objects = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String role = resultSet.getString("role");
            Utilizatori utilizatori = new Utilizatori(id, name,password,role);
            objects.add(utilizatori);
        }
        return objects;
    }
    public List<Utilizatori> findAll() {
        String query = "SELECT * FROM utilizatori";
        List<Utilizatori> objects = new ArrayList<>();

        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            objects = createObjects(resultSet);
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING,"DAO:findAll " + e.getMessage());
        }

        return objects;
    }
    ///read
    public Utilizatori read(String name) {
        Utilizatori utilizatori = null;
        String query = "SELECT * FROM utilizatori WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String password = resultSet.getString("password");
                    String role = resultSet.getString("role");
                    // Assuming other fields here...

                    // Create a Utilizatori object
                    utilizatori = new Utilizatori(id, name, password, role);
                }
            }
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:read " + e.getMessage());
        }
        return utilizatori;
    }
    
    // Create method
    public void create(Utilizatori utilizatori) {
        String query = "INSERT INTO utilizatori (name, password, role) VALUES (?, ?, ?)";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utilizatori.getUsername());
            statement.setString(2, utilizatori.getPassword());
            statement.setString(3, utilizatori.getRole());
            // Set other parameters if needed for creation

            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:create " + e.getMessage());
        }
    }


    // Update method
    public void update(Utilizatori utilizatori) {
        String query = "UPDATE utilizatori SET password = ?, role = ? WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, utilizatori.getPassword());
            statement.setString(2, utilizatori.getRole());
            statement.setString(3, utilizatori.getUsername());

            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:update " + e.getMessage());
        }
    }

    // Delete method
    public void delete(String name) {
        String query = "DELETE FROM utilizatori WHERE name = ?";
        try (Connection connection = Repository.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);

            statement.executeUpdate();
        } catch (SQLException e) {
            Repository.getLOGGER().log(Level.WARNING, "DAO:delete " + e.getMessage());
        }
    }
    
    
    public DefaultTableModel createTable(List<Utilizatori> afisare) {
        if (afisare == null || afisare.isEmpty()) {
            return new DefaultTableModel();
        }

        Class<?> type = afisare.get(0).getClass();

        Field[] utilizatoriFields = Utilizatori.class.getDeclaredFields();

        List<String> columnNames = new ArrayList<>();

        for (Field field : utilizatoriFields) {
            columnNames.add(field.getName());
        }

        DefaultTableModel tableModel = new DefaultTableModel(columnNames.toArray(new String[0]), 0);

        for (Utilizatori obj : afisare) {
            Object[] rowData = new Object[columnNames.size()];
            int index = 0;

            for (Field field : utilizatoriFields) {
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
