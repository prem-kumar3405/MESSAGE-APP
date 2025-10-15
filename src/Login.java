import java.util.Scanner;

public class Login {
    public void login()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("-----Welcome to Login form----");
        System.out.println();
        System.out.println("Enter your name");
        String name = scan.nextLine();

        System.out.println("Enter the password");
        String pass=scan.next();
        boolean logeedin=DatabaseConnection.loginUser(name,pass);

        if(logeedin)
        {
            System.out.println("LOGIN SUCCESSFULLY");
            ChatApp app=new ChatApp();
            app.chatapp();
        }
        else
        {
            System.out.println("Login failed");
        }
    }
}
