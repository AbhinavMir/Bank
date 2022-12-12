package backendInfrastructure.Utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
    // Method for SHA256 encryption from String
    public static String getSHA(String input) throws NoSuchAlgorithmException {
        // Static getInstance method is called with hashing SHA
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        // digest() method called
        // to calculate message digest of an input
        // and return array of byte
        byte[] messageDigest = md.digest(input.getBytes());
        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);
        // Convert message digest into hex value
        String hashtext = no.toString(16);
        // Add preceding 0s to make it 32 bit
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        // return the HashText
        return hashtext;
    }

    // Method to match SHA
    public static boolean matchSHA(String input, String hash) throws NoSuchAlgorithmException {
        // call the getSHA method
        String hashInput = getSHA(input);
        // compare the hashInput with the hash
        if (hashInput.equals(hash)) {
            return true;
        } else {
            return false;
        }
    }

}