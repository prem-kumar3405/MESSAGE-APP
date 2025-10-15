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
}
