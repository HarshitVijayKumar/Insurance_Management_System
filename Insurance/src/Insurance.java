import java.util.*;
import java.io.*;
import java.time.*;

class Insurance{
    Scanner sc=new Scanner(System.in);
    void notARobot() { //FUNCTION to check if the user is not a robot :)
        String verify;
        System.out.println("Verify you are not a robot");
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#";
        StringBuilder sb=new StringBuilder();
        Random random=new Random();
        int len=6;
        for(int i = 0; i < len; i++) {

            // generate random index number
            int index = random.nextInt(alphabet.length());

            // get character specified by index
            // from the string
            char randomChar = alphabet.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }
        String randomString = sb.toString();
        System.out.println("Captcha " + randomString);
        System.out.println("enter captcha");



        verify =sc.next();
        if(verify.equals(randomString)) {
            System.out.println("welcome");
        }
        else {
            System.out.println("traitor,you are a robot");
            System.exit(0);
        }
    }
    public static int age(LocalDate dob) {
        LocalDate cur=LocalDate.now();
        if((dob!=null)&&(cur!=null)) {
            return Period.between(dob,cur).getYears();

        }
        else {
            return 0;
        }
    }
    int price(int age) {
        if(age>=18 && age<30) {
            System.out.println("the price to pay is 10000 per year");
            return 10000;

        }
        else if(age>=30 && age<45) {
            System.out.println("the price to pay is 15000 per year");
            return 15000;

        }
        else if(age>=45 && age<60) {
            System.out.println("the price to pay is 20000 per year");
            return 20000;
        }
        else if(age>=60 && age<90) {
            System.out.println("the price to pay is 30000 per year");
            return 30000;
        }
        else {
            System.out.println("not eligible");
            return 0;
        }

    }

    void inp(String name,long ph,String email,String date,int price){
        String phno=String.valueOf(ph);

        if(email.contains(".")&&email.contains("@")&&phno.length()==10&&date.contains("-")) {

            String pno="";
            for(int i=0;i<3;i++){
                pno=pno+email.charAt(i);
            }


            for(int i=0;i<5;i++){
                pno=pno+phno.charAt(i);
            }



            for(int i=0;i<2;i++){

                pno=pno+name.charAt(i);
            }


            System.out.println("Policy number: "+pno);
            LocalDate dob=LocalDate.parse(date);

            int age=age(dob);
            //System.out.println(age(dob));





            try{
                File obj=new File(phno);
                if (obj.createNewFile()){
                    System.out.println("thank you");
                }
                else{
                    System.out.println("user already exists");
                }
            }
            catch(IOException e){
                System.out.println("error");
                e.printStackTrace();
            }



            try{
                FileWriter writer=new FileWriter(phno);
                writer.write("Policy Number "+pno+"\n");
                writer.write("name: "+name+"\n");
                writer.write("email: "+email+"\n");
                writer.write("phone number: "+phno+"\n");
                writer.write("date of birth: "+date+"\n");
                writer.write("age: "+age+"\n");
                writer.write("Policy Premium: "+price);
//	 writer.write("policy bought on: ");
                writer.close();
            }
            catch(IOException e){
                System.out.println("error");
                e.printStackTrace();
            }




            //appending to the main file.
            try {
                File file = new File("Admin.txt");
                FileWriter fr = new FileWriter(file, true);
                BufferedWriter br = new BufferedWriter(fr);
                br.write("\n");
                br.write("Policy Number "+pno+"\n");
                br.write("name: "+name+"\n");
                br.write("email: "+email+"\n");
                br.write("phone number: "+phno+"\n");
                br.write("date of birth: "+date+"\n");
                br.write("age: "+age+"\n");
                br.write("Policy Premium: "+price);
                br.write("\n");
                br.close();
                fr.close();
            }
            catch(IOException e) {
                System.out.println("Errors!");
                e.printStackTrace();
            }



        }
        else {
            System.out.println("please enter correct phone no and email");

        }

    }
    void yes(long ph1) {
        //System.out.println("enter your phone number");
        //long ph1=sc.nextLong();
        String ph1a=String.valueOf(ph1);

        //System.out.println("true");
        try{
            File obj=new File(ph1a);
            Scanner Reader=new Scanner(obj);
            while(Reader.hasNextLine()){
                String data=Reader.nextLine();
                System.out.println(data);

            }
            Reader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("does not exist");
            e.printStackTrace();
        }
    }
}