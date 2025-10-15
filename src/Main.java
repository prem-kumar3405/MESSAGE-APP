import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("WELCOME TO THIS APPLICATION");
        boolean flag=true;
        while (flag)
        {
            System.out.println("1 : NEW USER/REGISTER");
            System.out.println("2 : ALREADY HAVE AN ACCOUNT/ LOGIN");
            System.out.println("3 : EXIT INTO THE APPLICATION");
            System.out.println("ENTER YOUR CHOICE");

            int choice =  scan.nextInt();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("register page");
                    Register reg=new Register();
                    reg.regis();
                    break;
                }
                case 2:
                {
                    System.out.println("login page");
                    Login login=new Login();
                    login.login();
                    break;

                }
                case 3:
                {
                    System.out.println("have a nice day byee");
                    flag=false;
                    break;
                }
                default:{
                    System.out.println("enter  the correct choice");
                    break;
                }
            }
        }

    }
}
