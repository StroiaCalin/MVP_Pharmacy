package project;

import java.sql.SQLException;
import java.util.logging.Logger;

import View.View_Login;

public class Main {
    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());
   
    public static void main(String[] args) throws SQLException {
        new View_Login();
    }
}
