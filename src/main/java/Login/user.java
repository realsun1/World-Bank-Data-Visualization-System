/**
* This program implements the getter methods to get the user information
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Login;

public class user {
	
	/*
	 * these are the instance variables of the class
	 */
    String userName;
    String password;

    /*
     * constructor of the class
     * @param user This is the first parameter to the constructor method
     * @param pass This is the second parameter to the constructor method
     */
    public user(String user, String pass){
        userName= user;
        password= pass;
    }
    
    /*
     * This method is used to get the password
     * @return password This returns the password
     */
    public String getPassword() {
        return password;
    }
    
    /*
     * This method is used to get the username
     * @return userName This returns the username
     */
    public String getUserName() {
        return userName;
    }

}
