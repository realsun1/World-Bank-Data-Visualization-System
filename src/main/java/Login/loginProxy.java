package Login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class loginProxy {
    Set<user> list = new HashSet<user>();
    public loginProxy() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/Login/usernames"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<String> userInfo = Arrays.asList(line.split(",", -1));
            user currentUser = new user(userInfo.get(0), userInfo.get(1));
            list.add(currentUser);
        }
    }

    public void printUserList(){
        for (user user : list) {
            System.out.println(user.getUserName());
            System.out.println(user.getPassword());
        }
    }

    public int checkUser(String username,String pass){
        for(user user: list){
            if(username.equals(user.getUserName())&&(pass.equals(user.getPassword()))){
                return 1;
            }
            if(username.equals(user.getUserName())){
                return 2;
            }
        }
        return 3;
    }

    public void insertUser(user newUser){
        String newString= "\n"+newUser.getUserName()+","+newUser.getPassword();
        try {
            FileWriter fw = new FileWriter("usernames",true);
            fw.write(newString);
            fw.close();
        }catch (IOException e) {
            System.out.println("File not found!");
        }
    }


}
