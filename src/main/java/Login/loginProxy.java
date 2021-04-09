/**
* This class checks the login information from the user, username and password
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class loginProxy {
	
	/**
	 * this instance variable creates a list
	 */
    Set<user> list = new HashSet<user>();

    /**
     * this is the constructor of the class
     * @throws FileNotFoundException This is thrown if the file is not found 
     */
    public loginProxy() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("usernames"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> userInfo = Arrays.asList(line.split(",", -1));
            user currentUser = new user(userInfo.get(0), userInfo.get(1));
            list.add(currentUser);
        }
    }

    /**
     * this method prints the list that contains the username and passwords
     */
    public void printUserList() {
        for (user user : list) {
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
        }
    }

    /**
     * this method checks the user information
     * @param username This is the username of the user
     * @param pass This is the password of the user
     * @return int value, 1 - if the password and username match, 2 - if only the username matches, 3 - if neither matches
     */
    public int checkUser(String username, String pass) {
        for (user user : list) {
            if (username.equals(user.getUserName()) && (pass.equals(user.getPassword()))) {
                return 1;
            }
            if (username.equals(user.getUserName())) {
                return 2;
            }
        }
        return 3;
    }

    /**
     * this method inserts the user
     * @param newUser contains the new users information
     */
    public void insertUser(user newUser) {
        String newString = "\n" + newUser.getUserName() + "," + newUser.getPassword();
        try {
            FileWriter fw = new FileWriter("usernames", true);
            fw.write(newString);
            fw.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }


}
