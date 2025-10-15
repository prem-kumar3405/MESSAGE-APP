import java.util.HashSet;
public class Authenticator {
    public static boolean passwordValidator(String pass)
    {
        if(pass.length()<6)
        {
            return false;
        }
        int upper=0;
        int lower=0;
        int numbersymb=0;
        HashSet<Character> set=new HashSet<>();
        for(char ch:pass.toCharArray())
        {
            if(ch>='a' && ch<='z')
            {
                lower++;
            }
            else if(ch>='A' && ch<='Z')
            {
                upper++;
            }
            else
            {
                numbersymb++;
            }
            set.add(ch);
        }
        if(lower==0)
        {
            System.out.println("No lower case in  your password");
            return false;
        }
        else if (upper==0)
        {
            System.out.println("No uppercase");
            return false;
        }
        else if(numbersymb==0)
        {
            System.out.println("No symbol and numbers");
            return false;
        }
        return true;
    }
}
