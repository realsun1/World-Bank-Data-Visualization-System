package Login;

public class user {
    String userName;
    String password;

    public user(String user, String pass){
        userName= user;
        password= pass;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

}
