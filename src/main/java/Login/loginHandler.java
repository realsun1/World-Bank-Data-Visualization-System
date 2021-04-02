package Login;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class loginHandler {
    public static void main(String[] args) {
        loginGUI login = new loginGUI();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }


    public int checkUser(String username, String password) throws FileNotFoundException, NoSuchAlgorithmException {
        loginHandler instance=new loginHandler();
        loginProxy users = new loginProxy();
        String encodedpass = instance.encodePass(password);
        int result = users.checkUser(username, encodedpass);
        if (result == 1) {
            System.out.println("User Found");
            return 1;
        }
        if (result == 2) {
            System.out.println("Invalid Password!");
            return 2;
        }
        if (result == 3) {
            return 3;
        }
        return 4;
    }

    public String encodePass(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return new String(digest);
    }

}

