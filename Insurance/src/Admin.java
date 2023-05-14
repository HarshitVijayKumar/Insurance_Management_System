import java.util.*;
import java.io.*;

class Admin extends Insurance{
    String user = "Manikandan";
    String pass = "bunker";
    int check() {
        String new_user;
        String new_pass;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the admin username : ");
        new_user = sc.next();
        System.out.println("Enter the admin password : ");
        new_pass = sc.next();
        if (new_user.equals(user)&&new_pass.equals(pass)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    void adminread() {
        try{
            File obj=new File("Admin.txt");
            Scanner Reader=new Scanner(obj);
            while(Reader.hasNextLine()){
                String data=Reader.nextLine();
                System.out.println(data);

            }
            Reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("cannot fetch data");
            e.printStackTrace();

        }
    }
}