/**
* This class checks the user and encodes the password
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Login;

import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class loginHandler {
	
	/*
	 * this main method creates a new loginGUI object
	 * @param String[] args
	 */
    public static void main(String[] args) {
        loginGUI login = new loginGUI();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }

    /*
     * this method checks the user's username and password
     * @param username contains the user's username
     * @param password contains the user's password
     * @throws FileNotFoundExpception 
     * @throws NoSuchAlgorithmException
     * @return int value , 1 - if user is found, 2 - if password is invalid, 3 - if neither works, or else 4
     */
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

    /*
     * this method encodes the password
     * @param password contains the password
     * @throws NoSuchAlgorithmExcpetion
     * @return the new string
     */
    public String encodePass(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        return new String(digest);
    }

}

