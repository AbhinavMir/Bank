package backendInfrastructure.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {

    private void newCustomer(String username, String firstName, String lastName, String address, String email, String phoneNumber, String password, Statement stmt) throws SQLException {
        // Check if user doesn't exist
        String userExistsSQL = "SELECT * FROM customer WHERE email = " + username;
        String encrypted_password = SHA
        if (!stmt.execute(userExistsSQL)) {
        } else {

        }
    }

}
