import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Insurance i=new Insurance();
        Admin ad=new Admin();
        Scanner sc=new Scanner(System.in);
        i.notARobot();
        System.out.println("-----------ONLINE INSURANCE MANAGEMENT SYSTEM--------------\n");

        System.out.println("Enter 'a' for admin login\nDo you have a policy\t(N/Y)?");
        char b=sc.next().trim().charAt(0);


        if(b=='y' || b=='Y'){
            System.out.println("enter your phone number");

            long ph1=sc.nextLong();
            try{
                i.yes(ph1);
            }
            catch(Exception e){
                System.out.println("No policy with this number exists!");
            }


        }
        else if(b=='n' || b=='N'){
            //System.out.println("false");




            System.out.println("enter phone number");
            long ph=sc.nextLong();
            sc.nextLine();



            System.out.println("enter email id");
            String email=sc.next();
            sc.nextLine();


            System.out.println("dob (yyyy-mm-dd)");

            String date=sc.nextLine();
            LocalDate dob=LocalDate.parse(date);
            int age=i.age(dob);



            System.out.println("enter name");
            String name=sc.nextLine();
            int price=i.price(age);
            if (price>0) {
                System.out.println("do you agree to pay");
                char yn=sc.next().charAt(0);

                if(yn=='y' || yn=='Y') {


                    i.inp(name,ph,email,date,price);
                }

                else if(yn=='n' || yn=='N') {
                    System.out.println(" THANK YOU PLEASE VISIT AGAIN");
                }
                else {
                    System.out.println("invalid");
                }
            }
            else if(price==0) {
                i.price(age);
            }

        }
        else if(b=='a' || b=='A') {
            int checker=ad.check();
            if(checker==1) {
                ad.adminread();
            }
            else {
                System.out.println("Not an admin!!");
            }


        }
        else{
            System.out.println("Invalid");
        }
    }
}