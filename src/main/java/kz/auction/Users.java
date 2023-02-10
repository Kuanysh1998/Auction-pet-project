package kz.auction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class Users {
    private HashMap<String, String> users = new HashMap<String, String>();
    public Users() {
        addUser("kuanysh1998@gmail.com", "Password123");
    }
    public void addUser(String login, String password) {

        if(users.containsKey(login)) System.out.println("Already exists");
        if((login.endsWith("@gmail.com") || login.endsWith("@mail.ru") || login.endsWith("@icloud.com")) && isValidPassword(password) ) {
            try {
                MessageDigest mdAlgorithm = MessageDigest.getInstance("MD5");
                mdAlgorithm.update(password.getBytes());
                byte[] digest = mdAlgorithm.digest();
                StringBuffer hexString = new StringBuffer();

                for (int i = 0; i < digest.length; i++) {
                    String x = Integer.toHexString(0xFF & digest[i]);
                    if (x.length() < 2) x = "0" + x;
                    hexString.append(x);
                }
                String hashesPassword = hexString.toString();


                users.put(login, hashesPassword);
                System.out.println("User added succesfully!");
            }
            catch (NoSuchAlgorithmException e) {}
        }
        else System.out.println("Invalid email or password!");
    }

    public boolean isValidPassword(String password) {
        if(password.length() < 8) return false;
        int upperCaseLetters = 0;
        int lowerCaseLetters = 0;
        int numbers = 0;


        for(int i = 0; i < password.length(); i++) {
            byte currentChar = (byte) password.charAt(i);
            if (currentChar >= 48 && currentChar <= 57) numbers++;
            if (currentChar >= 65 && currentChar <= 90) upperCaseLetters++;
            if (currentChar >= 97 && currentChar <= 122) lowerCaseLetters++;

        }
        if(upperCaseLetters > 0 && lowerCaseLetters > 0 && numbers > 0) return true;
        else {
            System.out.println("Invalid password!");
            return false;
        }

    }

    public void showAllUsers() {
        users.forEach((K, V) -> {
            System.out.println("Login: " + K + " Password: " + V);
        });
    }


}
