import java.io.FileNotFoundException;
import java.sql.*;

import backendInfrastructure.Models.dbHandler;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        dbHandler dbHandler = new dbHandler();
        dbHandler.initialize();
    }
}