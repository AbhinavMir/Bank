package backendInfrastructure.Models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class dbHandler {

    public String[] initializationCommands = new String[10];

    public dbHandler() throws FileNotFoundException {
        try {
            String accountTableCreation = readFile(new FileReader("src/SQL/accountTableCreation.sql"));
            String transactionTableCreation = readFile(new FileReader("src/SQL/transactionTableCreation.sql"));
            String customerTableCreation = readFile(new FileReader("src/SQL/customerTableCreation.sql"));
            initializationCommands[0] = accountTableCreation;
            initializationCommands[1] = transactionTableCreation;
            initializationCommands[2] = customerTableCreation;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(FileReader file) {
        String fileContent = "";
        try {
            int i;
            while ((i = file.read()) != -1)
                fileContent += (char) i;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent;
    }

    public static void test() throws IOException {
        dbHandler dbHandler = new dbHandler();
        System.out.println(dbHandler.initializationCommands[0]);
        System.out.println(dbHandler.initializationCommands[1]);
        System.out.println(dbHandler.initializationCommands[2]);
    }

    public static void main(String[] args) {
        try {
            dbHandler.test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void initialize() throws SQLException {
        String elephantHost = "castor.db.elephantsql.com";
        String elephantPassword = System.getenv("ELEPHANT_PASSWORD_BANK");
        String elephantUserName = "slfdaaty";

        try {
            dbHandler dbHandler = new dbHandler();
            Connection db = DriverManager.getConnection("jdbc:postgresql://" + elephantHost + "/" + elephantUserName, elephantUserName, elephantPassword);
            Statement st = db.createStatement();
            for (String command : dbHandler.initializationCommands) {
                st.execute(command);
            }
            st.close();
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
