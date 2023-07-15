package emailapp;
import java.util.*;
import java.io.*;

public class Email{

public Scanner s = new Scanner(System.in);

private String fname;
private String lname;
private String dept;
private String email;
private String password;
private int mailCapacity = 500;
private String alter_email;


//Constructor for receiving first name and last name
public Email(String fname, String lname){
    this.fname = fname;
    this.lname = lname;
    System.out.println("New Employee: "+this.fname+" "+this.lname);

    //Calling methods
    
    this.dept = this.setDept(); //department
    this.password = this.generate_password(8); //password
    this.email = this.generate_email(); //email generation


}


//Generate mail id

private String generate_email(){
    return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".company.com";
}


//Choosing department

private String setDept(){
    System.out.println("Department codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none");
        boolean flag = false;
        do{
            System.out.print("Enter Department Code: ");
            int choice = s.nextInt();
            switch (choice){
                case 1:
                return "Sales";
                case 2:
                return "Development";
                case 3:
                return "Accounting";
                case 0:
                return "None";
                default:
                System.out.println("Invalid code please choose again");
                
            }
          } while (!flag);
            return null;
        }

        // generate random password

        private String generate_password(int length){
            Random r = new Random();
            String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String Small_chars = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String symbols = "!@#$%&?";
            String values = Capital_chars+Small_chars+numbers+symbols;
            String password ="";
            for(int i = 0; i<length; i++){
                password = password+values.charAt(r.nextInt(values.length()));
            }
            return password;
        }


        //change password

        public void set_password(){
            boolean flag = false;
            do{
                System.out.println("Do you want to change your password! (Y/N)");
                char choice = s.next().charAt(0);
                if(choice == 'Y' || choice == 'y'){
                    flag = true;
                    System.out.print("Enter current password: ");
                    String temp = s.next();
                    if(temp.equals(this.password)){
                        System.out.println("Enter new password: ");
                        this.password = s.next();
                        System.out.println("Password changed successfully");
                    }
                    else {
                        System.out.println("Incorrect Password");
                    }
                }
                    else if(choice == 'N' || choice == 'n'){
                        flag = true;
                        System.out.println("Password unchanged");
                    }
                    else {
                        System.out.println("Enter a valid choice");
                    }
                } while (!flag);
            }
        


        //Changing mail capacity

        public void set_mailCap(){
            System.out.println("Current mail Capacity: "+this.mailCapacity+"mb");
            System.out.print("Enter new mailbox capacity: ");
            this.mailCapacity = s.nextInt();
            System.out.println("Mailbox capacity changed successfully");
        }


        //setting alternate email

        public void alternate_email(){
            System.out.print("Enter an alternate email: ");
            this.alter_email = s.next();
            System.out.println("Alternate email set successfully");
        }


        //Displaying user information

        public void getInfo(){
            System.out.println("New: "+this.fname+" "+this.lname);
            System.out.println("Department: "+this.dept);
            System.out.println("Email: "+this.email);
            System.out.println("Password: "+this.password);
            System.out.println("Mailbox Capacity: "+this.mailCapacity+"mb");
            System.out.println("Alternate email: "+this.alter_email);
        }


        //For storing file

        public void  storefile(){
            try{
                FileWriter in = new FileWriter("C:\\UTKARSH\\Java Project\\Email Application\\info.txt");
                in.write("First Name:"+this.fname);
                in.append("\nLast Name:"+this.lname);
                in.append("\nEmail:"+this.email);
                in.append("\nPassword:"+this.password);
                in.append("\nCapacity:"+this.mailCapacity);
                in.append("\nAlternate Email:"+this.alter_email);
                in.close();
                System.out.println("Data Stored..");

            }catch(Exception e){System.out.println(e);}
        }



        //Reading file method

        public void read_file(){
            try{
                FileReader f1 = new FileReader("C:\\UTKARSH\\Java Project\\Email Application\\info.txt");
                int i;
                while((i=f1.read())!=-1){
                    System.out.print((char)i);
                }
                
                f1.close();

            }catch(Exception e){System.out.println(e);}
        }
}

