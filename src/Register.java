import java.util.Scanner;

class Register
{
    public void regis()
    {
        Scanner scan=new Scanner(System.in);
        System.out.println("---Enter your name---");
        String name=scan.nextLine();

        System.out.println("---Enter password---");
        String pass=scan.next();
        while (!Authenticator.passwordValidator(pass))
        {
            System.out.println("Enter the valid password");
            pass=scan.next();
        }
        boolean registered=DatabaseConnection.adduser(name,pass);
        if(registered)
        {
            System.out.println("Do you want to login");
            System.out.println("PRESS 1 to login");
            int choice=scan.nextInt();
            if (choice == 1) {
                Login log = new Login();
                log.login();
            } else {
                System.out.println("you entered wrong choice");
            }
        }


    }
}
