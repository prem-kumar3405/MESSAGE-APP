import java.util.Scanner;

class ChatApp {
    public void chatapp()
    {
        System.out.println("WELCOME TO CHAT APPLICATION");
        Scanner q=new Scanner(System.in);

        boolean flag=true;
        while(flag)
        {
            System.out.println("1 : ADD THE CONTACT");
            System.out.println("2 : SEND MESSAGE");
            System.out.println("3 : UPDATE STATUS");
            System.out.println("4 : VIEW OTHER STATUS");
            System.out.println("5 : LOGOUT/EXIT");

            int choice = q.nextInt();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("Send message");
                    message();
                    break;
                }
                case 2:
                {
                    System.out.println("Update the status");
                    break;
                }
                case 3:
                {
                    System.out.println("view other status");
                    break;
                }
                case 4:
                {
                    System.out.println("logout/exit");
                    flag=false;
                    break;
                }
                default:
                {
                    System.out.println("Enter the valid choice");
                }
            }

        }
    }
    public static  void message()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the sender name");
        String sender=scan.next();

        System.out.println("Enter the receiver name");
        String receiver = scan.next();

        System.out.println("Enter the message you want to send ");
        String message = scan.nextLine();

        boolean ans=DatabaseConnection.sendmessage(sender,receiver,message);
        if(ans)
        {
            System.out.println("if you want to see all the message");
            System.out.println("Enter 1");
            
            int n = scan.nextInt();
            if(n==1)
            {
                DatabaseConnection.viewchat(sender,receiver);
            }
        }
        else {
            System.out.println("Message not send");
        }
    }
}
